Feature: DXLApi

  Scenario: getVFMallOfferingDetails stok miktarı, satış fiyatı ve liste fiyatı kontrolü
    Given createSessionId "POST" request'i ve "5467028995" ile sessionId alınır.
    And getVFMallOfferingDetails "POST" requestine sessionId parametresi eklenir ve servis tetiklenir
    Then "VFMallOffering" Response Body icin kontrol edilir

  Scenario: getVFMallHomePageResponseValidation
    Given createSessionId "POST" request'i ve "5467028995" ile sessionId alınır.
    And getVFMallHomePage requestine sessionId parametresi eklenir ve servis "GET" olarak tetiklenir


  Scenario Outline: createVfMallOfferingOfferOlusturma
    Given createVfMallToken "POST" request'i ile token olusturulur
    And createVfMallOffering "POST" requesti "<barcode>", "<maxSaleCount>" ve "<cargoCompanyID>" ile tetiklenir
    Then Response Bodyde "<expectedResultCode>", "<expectedErrorMessage>","<expectedResult>" alanlari kontrol edilir
    Examples:
      | barcode | maxSaleCount | cargoCompanyID           | expectedResultCode | expectedErrorMessage            | expectedResult |
      |         | 110          | 60e80fd0026e19ca7d1fe005 | 0                  | İşleminiz başarıyla tamamlandı. | SUCCESS        |

  Scenario Outline: createVfMallOfferingBarkodCakismasiKontrolu
    Given createVfMallToken "POST" request'i ile token olusturulur
    And createVfMallOffering "POST" requesti "<barcode>", "<maxSaleCount>" ve "<cargoCompanyID>" ile tetiklenir
    Then Response Bodyde "<expectedResultCode>", "<expectedErrorMessage>","<expectedResult>" alanlari kontrol edilir
    Examples:
      | barcode                              | maxSaleCount | cargoCompanyID           | expectedResultCode | expectedErrorMessage                                                                         | expectedResult |
      | c8249cb5-0848-4cdc-9c91-1e7a576860d7 | 110          | 60e80fd0026e19ca7d1fe005 | 38                 | Ürünün barkodu bu satıcı için daha önce tanımlanmış. Lüften başka bir barkod değeri giriniz. | FAIL           |
      | barcode                              | maxSaleCount | cargoCompanyID           | expectedResultCode | expectedErrorMessage                                                                         | expectedResult |
      |                                      | 0            | 60e80fd0026e19ca7d1fe005 | 35                 | Girilen sayısal değer sıfırdan büyük olmalıdır. Parametre ismi: maxSaleCount                 | FAIL           |


  Scenario Outline: createVfMallOfferingCargoCompanyIDYanlışGirilmesi
    Given createVfMallToken "POST" request'i ile token olusturulur
    And createVfMallOffering "POST" requesti "<barcode>", "<maxSaleCount>" ve "<cargoCompanyID>" ile tetiklenir
    Then Response Bodyde "<expectedResultCode>", "<expectedErrorMessage>","<expectedResult>" alanlari kontrol edilir

    Examples:
      | barcode | maxSaleCount | cargoCompanyID           | expectedResultCode | expectedErrorMessage                              | expectedResult |
      |         | 110          | 601be73da23ffc44f4864242 | 43                 | Kargo kodu Partner'e ait bir kargo kodu olmalıdır | FAIL           |


  Scenario Outline: createVfMallOfferingCargoCompanyIDYanlışGirilmesi
    Given createVfMallToken "POST" request'i ile token olusturulur
    And createVfMallOffering "POST" requesti "<barcode>", "<maxSaleCount>" ve "<cargoCompanyID>" ile tetiklenir
    Then Response Bodyde "<expectedResultCode>", "<expectedErrorMessage>","<expectedResult>" alanlari kontrol edilir
    Examples:
      | barcode | maxSaleCount | cargoCompanyID           | expectedResultCode | expectedErrorMessage                              | expectedResult |
      |         | 110          | 601be73da23ffc44f4864242 | 43                 | Kargo kodu Partner'e ait bir kargo kodu olmalıdır | FAIL           |

  #1
  @DXLApi
  Scenario Outline: Musteriye teslim edildi statusundeki urune yorum yapma
    Given createVfMallToken "POST" request'i ile token olusturulur
    And createSessionId "POST" request'i ve "5467028866" ile sessionId alınır.
    And createVfMallOffering "POST" requesti "<barcode>", "<maxSaleCount>" ve "<cargoCompanyID>" ile tetiklenir
    Then Response Bodyde "<expectedResultCode>", "<expectedErrorMessage>","<expectedResult>" alanlari kontrol edilir
    And  cleanShoppingCart "GET" requesti ve "cleanShoppingCart" metodu aracılıgıyla sepetin temiz olduğuna bakılır.
    And addVFMallCustomerProfile "POST" requestine "5467028866" msisdn degeri kullanılarak sessionId atılır.
    And "addCartItems" metodu ve ürünün uuidsi ile "POST" requseti atılır.
    And customerProfileID parametresi "saveShoppingCartAddress" metoduyla "POST" requestine eklenir.
    And payShoppingCart "POST" requesti ve "payShoppingCart" metodu aracılıgıyla sepetteki ürünler satılır.
    And createVfMallToken "POST" request'i ile token olusturulur
    And getVfMallOrders "GET" requestine Authkey girilir ve status PENDING olacak şekilde istek gönderilir.
    And updateSalesOrderStatus "POST" requesti ile status değeri "DELIVERED_TO_CUSTOMER" ile değiştirilir.
    And insertVfMallRateAndComment "POST" requestine hideMyName "false" girilir ve sessionId girilir.
    Then "SUCCESS" ve "<expectedResultMessage>" geldiği görülür.
    Examples:
      | barcode | maxSaleCount | cargoCompanyID           | expectedResultCode | expectedErrorMessage            | expectedResult | expectedResultMessage      |
      |         | 110          | 60e80fd0026e19ca7d1fe005 | 0                  | İşleminiz başarıyla tamamlandı. | SUCCESS        | Yorumunuz onaya gönderildi |

  #2
  #@DXLApi
  Scenario Outline: Daha önce yorum yapılmış veya onayda bekleyen yorumu olan urune yorum yapma
    Given createSessionId "POST" request'i ve "5467028866" ile sessionId alınır.
    And "addCartItems" metodu ve ürünün uuidsi ile "POST" requseti atılır.
    And insertVfMallRateAndComment "POST" requestine hideMyName "false" girilir ve sessionId girilir.
    Then "<expectedResult>" ve "<expectedResultMessage>" geldiği görülür.
    Examples:
      | expectedResult | expectedResultMessage        |
      | FAIL           | Daha önce kayıt oluşturulmuş |

  #3
  #@DXLApi
  Scenario Outline: Satın alınmamış urune yorum yapma
    Given createVfMallToken "POST" request'i ile token olusturulur
    And createSessionId "POST" request'i ve "5467028866" ile sessionId alınır.
    And createVfMallOffering "POST" requesti "<barcode>", "<maxSaleCount>" ve "<cargoCompanyID>" ile tetiklenir
    Then Response Bodyde "<expectedResultCode>", "<expectedErrorMessage>","<expectedResult>" alanlari kontrol edilir
    And  cleanShoppingCart "GET" requesti ve "cleanShoppingCart" metodu aracılıgıyla sepetin temiz olduğuna bakılır.
    And addVFMallCustomerProfile "POST" requestine "5467028866" msisdn degeri kullanılarak sessionId atılır.
    And customerProfileID parametresi "saveShoppingCartAddress" metoduyla "POST" requestine eklenir.
    And "addCartItems" metodu ve ürünün uuidsi ile "POST" requseti atılır.
    And insertVfMallRateAndComment "POST" requestine hideMyName "false" girilir ve sessionId girilir.
    Then "FAIL" ve "<expectedResultMessage>" geldiği görülür.
    Examples:
      | barcode | maxSaleCount | cargoCompanyID           | expectedResultCode | expectedErrorMessage            | expectedResult | expectedResultMessage                                           |
      |         | 110          | 60e80fd0026e19ca7d1fe005 | 0                  | İşleminiz başarıyla tamamlandı. | SUCCESS        | Değerlendirme yapabilmek için bu ürünü teslim almış olmalısınız |


  #4
  #@DXLApi
  Scenario Outline: Beklemede statusundeki urune yorum yapma
    Given createVfMallToken "POST" request'i ile token olusturulur
    And createSessionId "POST" request'i ve "5467028866" ile sessionId alınır.
    And createVfMallOffering "POST" requesti "<barcode>", "<maxSaleCount>" ve "<cargoCompanyID>" ile tetiklenir
    Then Response Bodyde "<expectedResultCode>", "<expectedErrorMessage>","<expectedResult>" alanlari kontrol edilir
    And  cleanShoppingCart "GET" requesti ve "cleanShoppingCart" metodu aracılıgıyla sepetin temiz olduğuna bakılır.
    And addVFMallCustomerProfile "POST" requestine "5467028866" msisdn degeri kullanılarak sessionId atılır.
    And "addCartItems" metodu ve ürünün uuidsi ile "POST" requseti atılır.
    And customerProfileID parametresi "saveShoppingCartAddress" metoduyla "POST" requestine eklenir.
    And payShoppingCart "POST" requesti ve "payShoppingCart" metodu aracılıgıyla sepetteki ürünler satılır.
    And createVfMallToken "POST" request'i ile token olusturulur
    And getVfMallOrders "GET" requestine Authkey girilir ve status PENDING olacak şekilde istek gönderilir.
   # And updateSalesOrderStatus "POST" requesti ile status değeri "PENDING" ile değiştirilir.
    And insertVfMallRateAndComment "POST" requestine hideMyName "false" girilir ve sessionId girilir.
    Then "FAIL" ve "<expectedResultMessage>" geldiği görülür.
    Examples:
      | barcode | maxSaleCount | cargoCompanyID           | expectedResultCode | expectedErrorMessage            | expectedResult | expectedResultMessage                                           |
      |         | 110          | 60e80fd0026e19ca7d1fe005 | 0                  | İşleminiz başarıyla tamamlandı. | SUCCESS        | Değerlendirme yapabilmek için bu ürünü teslim almış olmalısınız |


  #5
  #@DXLApi
  Scenario Outline: Hazırlanıyor statusundeki urune yorum yapma
    Given createVfMallToken "POST" request'i ile token olusturulur
    And createSessionId "POST" request'i ve "5467028866" ile sessionId alınır.
    And createVfMallOffering "POST" requesti "<barcode>", "<maxSaleCount>" ve "<cargoCompanyID>" ile tetiklenir
    Then Response Bodyde "<expectedResultCode>", "<expectedErrorMessage>","<expectedResult>" alanlari kontrol edilir
    And  cleanShoppingCart "GET" requesti ve "cleanShoppingCart" metodu aracılıgıyla sepetin temiz olduğuna bakılır.
    And addVFMallCustomerProfile "POST" requestine "5467028866" msisdn degeri kullanılarak sessionId atılır.
    And "addCartItems" metodu ve ürünün uuidsi ile "POST" requseti atılır.
    And customerProfileID parametresi "saveShoppingCartAddress" metoduyla "POST" requestine eklenir.
    And payShoppingCart "POST" requesti ve "payShoppingCart" metodu aracılıgıyla sepetteki ürünler satılır.
    And createVfMallToken "POST" request'i ile token olusturulur
    And getVfMallOrders "GET" requestine Authkey girilir ve status PENDING olacak şekilde istek gönderilir.
    And updateSalesOrderStatus "POST" requesti ile status değeri "PREPARING" ile değiştirilir.
    And insertVfMallRateAndComment "POST" requestine hideMyName "false" girilir ve sessionId girilir.
    Then "FAIL" ve "<expectedResultMessage>" geldiği görülür.
    Examples:
      | barcode | maxSaleCount | cargoCompanyID           | expectedResultCode | expectedErrorMessage            | expectedResult | expectedResultMessage                                           |
      |         | 110          | 60e80fd0026e19ca7d1fe005 | 0                  | İşleminiz başarıyla tamamlandı. | SUCCESS        | Değerlendirme yapabilmek için bu ürünü teslim almış olmalısınız |

  #6
  #@DXLApi
  Scenario Outline: Kargoya verildi statusundeki urune yorum yapma
    Given createVfMallToken "POST" request'i ile token olusturulur
    And createSessionId "POST" request'i ve "5467028866" ile sessionId alınır.
    And createVfMallOffering "POST" requesti "<barcode>", "<maxSaleCount>" ve "<cargoCompanyID>" ile tetiklenir
    Then Response Bodyde "<expectedResultCode>", "<expectedErrorMessage>","<expectedResult>" alanlari kontrol edilir
    And  cleanShoppingCart "GET" requesti ve "cleanShoppingCart" metodu aracılıgıyla sepetin temiz olduğuna bakılır.
    And addVFMallCustomerProfile "POST" requestine "5467028866" msisdn degeri kullanılarak sessionId atılır.
    And "addCartItems" metodu ve ürünün uuidsi ile "POST" requseti atılır.
    And customerProfileID parametresi "saveShoppingCartAddress" metoduyla "POST" requestine eklenir.
    And payShoppingCart "POST" requesti ve "payShoppingCart" metodu aracılıgıyla sepetteki ürünler satılır.
    And createVfMallToken "POST" request'i ile token olusturulur
    And getVfMallOrders "GET" requestine Authkey girilir ve status PENDING olacak şekilde istek gönderilir.
    And updateSalesOrderStatus "POST" requesti ile status değeri "SHIPPED_TO_CUSTOMER" ile değiştirilir.
    And insertVfMallRateAndComment "POST" requestine hideMyName "false" girilir ve sessionId girilir.
    Then "FAIL" ve "<expectedResultMessage>" geldiği görülür.
    Examples:
      | barcode | maxSaleCount | cargoCompanyID           | expectedResultCode | expectedErrorMessage            | expectedResult | expectedResultMessage                                           |
      |         | 110          | 60e80fd0026e19ca7d1fe005 | 0                  | İşleminiz başarıyla tamamlandı. | SUCCESS        | Değerlendirme yapabilmek için bu ürünü teslim almış olmalısınız |

  #7
  #@DXLApi
  Scenario Outline: Daha önce yorum yapılmış ürünün yorumunu guncelleme
    Given createSessionId "POST" request'i ve "5467028866" ile sessionId alınır.
    And getVFMallRateAndComment "POST" requesti ile yorumun idsi alınır.
    And updateRateAndComment "POST" requestine hideMyName "false" girilir ve yeni rate, comment bilgileri girilerek güncellenir.
    Then "<expectedResult>" ve "<expectedResultMessage>" geldiği görülür.
    Examples:
      | expectedResult | expectedResultMessage       |
      | SUCCESS        | Yorumunuz onaya gönderildi. |

  #8
  #@DXLApi
  Scenario Outline: Daha önce yorum yapılmamış ürünün yorumunu guncelleme
    Given createSessionId "POST" request'i ve "5467028866" ile sessionId alınır.
    And getVFMallRateAndComment "POST" requesti ile rastgele bir yorumun id alınır.
    And updateRateAndComment "POST" requestine hideMyName "false" girilir ve yeni rate, comment bilgileri girilerek güncellenir.
    Then "<expectedResult>" ve "<expectedResultMessage>" geldiği görülür.
    Examples:
      | expectedResult | expectedResultMessage |
      | FAIL           | Kayıt bulunamadı      |

  #9
  Scenario: Onayda Bekleyen bir Yorumu çekme
    Given createSessionId "POST" request'i ve "5467028866" ile sessionId alınır.
    And getVFMallRateAndComment "POST" requesti ile yorumun idsi alınır.
    #devamı MONGO

  #10
  Scenario: Onayı geçmiş bir Yorumu çekme
    Given createSessionId "POST" request'i ve "5467028866" ile sessionId alınır.
    And getVFMallRateAndComment "POST" requesti ile yorumun idsi alınır.
    #devamı MONGO


  #11
  Scenario: Reddedilmiş bir yorumu çekme
    Given createSessionId "POST" request'i ve "5467028866" ile sessionId alınır.
    And getVFMallRateAndComment "POST" requesti ile yorumun idsi alınır.
    #devamı MONGO

  #12
  #@DXLApi
  Scenario: Onayı geçmiş bütün yorumları çekme
    Given createSessionId "POST" request'i ve "5467028866" ile sessionId alınır.
    And getVFMallRateAndComment "POST" requesti ile yorumun idsi alınır.
    #response ta gösterme kısmı kaldı

  #13
  #@DXLApi
  Scenario: İsim gizlenmeden satın alınmış ürüne yorum yapılması
    Given createSessionId "POST" request'i ve "5467028866" ile sessionId alınır.
    And insertVfMallRateAndComment "POST" requestine hideMyName "false" girilir ve sessionId girilir.
    And getVFMallRateAndComment "POST" requesti ile yorumun idsi alınır.

  #14
  @DXLApi
  Scenario: İsim gizlenerek satın alınmış ürüne yorum yapılması
    Given createSessionId "POST" request'i ve "5467028866" ile sessionId alınır.
    #1.case de false giriyorum burda true ya dönmüyor neden?? 1.case çalışmazsa bu çalışıyor
    And insertVfMallRateAndComment "POST" requestine hideMyName "true" girilir ve sessionId girilir.
    And getVFMallRateAndComment "POST" requesti ile yorumun idsi alınır.

  #15
  #@DXLApi
  Scenario: İsim Gizlenmeden yapılan yorumun güncellenmesi
    Given createSessionId "POST" request'i ve "5467028866" ile sessionId alınır.
    And getVFMallRateAndComment "POST" requesti ile yorumun idsi alınır.
    And updateRateAndComment "POST" requestine hideMyName "false" girilir ve yeni rate, comment bilgileri girilerek güncellenir.


  #16
  Scenario: İsim gizlenerek yapılan yorumun güncellenmesi
    Given createSessionId "POST" request'i ve "5467028866" ile sessionId alınır.
    And getVFMallRateAndComment "POST" requesti ile yorumun idsi alınır.
    #1.case de false giriyorum burda true ya dönmüyor neden?? 1.case çalışmazsa bu çalışıyor
    And updateRateAndComment "POST" requestine hideMyName "true" girilir ve yeni rate, comment bilgileri girilerek güncellenir.








