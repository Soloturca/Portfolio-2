Feature: DXLApi

  @DXLApi
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
  Scenario Outline: Musteriye teslim edildi statusundeki urune yorum yapma
    Given createVfMallToken "POST" request'i ile token olusturulur
    And createSessionId "POST" request'i ve "5467023357" ile sessionId alınır.
    And createVfMallOffering "POST" requesti "<barcode>", "<maxSaleCount>" ve "<cargoCompanyID>" ile tetiklenir
    Then Response Bodyde "<expectedResultCode>", "<expectedErrorMessage>","<expectedResult>" alanlari kontrol edilir
    And  cleanShoppingCart "GET" requesti ve "cleanShoppingCart" metodu aracılıgıyla sepetin temiz olduğuna bakılır.
    And addVFMallCustomerProfile "POST" requestine "5467023357" msisdn degeri kullanılarak sessionId atılır.
    And customerProfileID parametresi "saveShoppingCartAddress" metoduyla "POST" requestine eklenir.
    And "addCartItems" metodu ve ürünün uuidsi ile "POST" requseti atılır.
    And payShoppingCart "POST" requesti ve "payShoppingCart" metodu aracılıgıyla sepetteki ürünler satılır.
    And createVfMallToken "POST" request'i ile token olusturulur
    And getVfMallOrders "GET" requestine Authkey girilir ve status PENDING olacak şekilde istek gönderilir.
    And updateSalesOrderStatus "POST" requesti ile status değeri "DELIVERED_TO_CUSTOMER" ile değiştirilir.
    And insertVfMallRateAndComment "POST" requestine sessionId girilir.
    Then "SUCCESS" ve "<expectedResultMessage>" geldiği görülür.
    Examples:
      | barcode | maxSaleCount | cargoCompanyID           | expectedResultCode | expectedErrorMessage            | expectedResult | expectedResultMessage      |
      |         | 110          | 60e80fd0026e19ca7d1fe005 | 0                  | İşleminiz başarıyla tamamlandı. | SUCCESS        | Yorumunuz onaya gönderildi |

  #2
  #@DXLApi
  Scenario Outline: Daha önce yorum yapılmış veya onayda bekleyen yorumu olan urune yorum yapma
    Given createSessionId "POST" request'i ve "5467023357" ile sessionId alınır.
    And "addCartItems" metodu ve ürünün uuidsi ile "POST" requseti atılır.
    And insertVfMallRateAndComment "POST" requestine sessionId girilir.
    Then "<expectedResult>" ve "<expectedResultMessage>" geldiği görülür.
    Examples:
      | expectedResult | expectedResultMessage        |
      | FAIL           | Daha önce kayıt oluşturulmuş |

  #3
  #@DXLApi
  Scenario Outline: Satın alınmamış urune yorum yapma
    Given createSessionId "POST" request'i ve "5467023357" ile sessionId alınır.
    And addVFMallCustomerProfile "POST" requestine "5467023357" msisdn degeri kullanılarak sessionId atılır.
    And customerProfileID parametresi "saveShoppingCartAddress" metoduyla "POST" requestine eklenir.
    And "addCartItems" metodu ve ürünün uuidsi ile "POST" requseti atılır.
    #And addVFMallCustomerProfile "POST" requestine "5467028988" msisdn degeri kullanılarak sessionId atılır.
    #And customerProfileID parametresi "saveShoppingCartAddress" metoduyla "POST" requestine eklenir.
    And insertVfMallRateAndComment "POST" requestine sessionId girilir.
    Then "<expectedResult>" ve "<expectedResultMessage>" geldiği görülür.
    Examples:
      | expectedResult | expectedResultMessage                                           |
      | FAIL           | Değerlendirme yapabilmek için bu ürünü teslim almış olmalısınız |

  #4
  #@DXLApi
  Scenario Outline: Beklemede statusundeki urune yorum yapma
    Given createVfMallToken "POST" request'i ile token olusturulur
    And createSessionId "POST" request'i ve "5467023357" ile sessionId alınır.
    And createVfMallOffering "POST" requesti "<barcode>", "<maxSaleCount>" ve "<cargoCompanyID>" ile tetiklenir
    Then Response Bodyde "<expectedResultCode>", "<expectedErrorMessage>","<expectedResult>" alanlari kontrol edilir
    And  cleanShoppingCart "GET" requesti ve "cleanShoppingCart" metodu aracılıgıyla sepetin temiz olduğuna bakılır.
    And addVFMallCustomerProfile "POST" requestine "5467023357" msisdn degeri kullanılarak sessionId atılır.
    And customerProfileID parametresi "saveShoppingCartAddress" metoduyla "POST" requestine eklenir.
    And "addCartItems" metodu ve ürünün uuidsi ile "POST" requseti atılır.
    And payShoppingCart "POST" requesti ve "payShoppingCart" metodu aracılıgıyla sepetteki ürünler satılır.
    And createVfMallToken "POST" request'i ile token olusturulur
    And getVfMallOrders "GET" requestine Authkey girilir ve status PENDING olacak şekilde istek gönderilir.
   # And updateSalesOrderStatus "POST" requesti ile status değeri "PENDING" ile değiştirilir.
    And insertVfMallRateAndComment "POST" requestine sessionId girilir.
    Then "FAIL" ve "<expectedResultMessage>" geldiği görülür.
    Examples:
      | barcode | maxSaleCount | cargoCompanyID           | expectedResultCode | expectedErrorMessage            | expectedResult | expectedResultMessage                                           |
      |         | 110          | 60e80fd0026e19ca7d1fe005 | 0                  | İşleminiz başarıyla tamamlandı. | SUCCESS        | Değerlendirme yapabilmek için bu ürünü teslim almış olmalısınız |


  #5
  Scenario Outline: Hazırlanıyor statusundeki urune yorum yapma
    Given createVfMallToken "POST" request'i ile token olusturulur
    And createSessionId "POST" request'i ve "5467023357" ile sessionId alınır.
    And createVfMallOffering "POST" requesti "<barcode>", "<maxSaleCount>" ve "<cargoCompanyID>" ile tetiklenir
    Then Response Bodyde "<expectedResultCode>", "<expectedErrorMessage>","<expectedResult>" alanlari kontrol edilir
    And  cleanShoppingCart "GET" requesti ve "cleanShoppingCart" metodu aracılıgıyla sepetin temiz olduğuna bakılır.
    And addVFMallCustomerProfile "POST" requestine "5467023357" msisdn degeri kullanılarak sessionId atılır.
    And customerProfileID parametresi "saveShoppingCartAddress" metoduyla "POST" requestine eklenir.
    And "addCartItems" metodu ve ürünün uuidsi ile "POST" requseti atılır.
    And payShoppingCart "POST" requesti ve "payShoppingCart" metodu aracılıgıyla sepetteki ürünler satılır.
    And createVfMallToken "POST" request'i ile token olusturulur
    And getVfMallOrders "GET" requestine Authkey girilir ve status PENDING olacak şekilde istek gönderilir.
    And updateSalesOrderStatus "POST" requesti ile status değeri "PREPARING" ile değiştirilir.
    And insertVfMallRateAndComment "POST" requestine sessionId girilir.
    Then "FAIL" ve "<expectedResultMessage>" geldiği görülür.
    Examples:
      | barcode | maxSaleCount | cargoCompanyID           | expectedResultCode | expectedErrorMessage            | expectedResult | expectedResultMessage                                           |
      |         | 110          | 60e80fd0026e19ca7d1fe005 | 0                  | İşleminiz başarıyla tamamlandı. | SUCCESS        | Değerlendirme yapabilmek için bu ürünü teslim almış olmalısınız |

  #6
  Scenario Outline: Kargoya verildi statusundeki urune yorum yapma
    Given createVfMallToken "POST" request'i ile token olusturulur
    And createSessionId "POST" request'i ve "5467023357" ile sessionId alınır.
    And createVfMallOffering "POST" requesti "<barcode>", "<maxSaleCount>" ve "<cargoCompanyID>" ile tetiklenir
    Then Response Bodyde "<expectedResultCode>", "<expectedErrorMessage>","<expectedResult>" alanlari kontrol edilir
    And  cleanShoppingCart "GET" requesti ve "cleanShoppingCart" metodu aracılıgıyla sepetin temiz olduğuna bakılır.
    And addVFMallCustomerProfile "POST" requestine "5467023357" msisdn degeri kullanılarak sessionId atılır.
    And customerProfileID parametresi "saveShoppingCartAddress" metoduyla "POST" requestine eklenir.
    And "addCartItems" metodu ve ürünün uuidsi ile "POST" requseti atılır.
    And payShoppingCart "POST" requesti ve "payShoppingCart" metodu aracılıgıyla sepetteki ürünler satılır.
    And createVfMallToken "POST" request'i ile token olusturulur
    And getVfMallOrders "GET" requestine Authkey girilir ve status PENDING olacak şekilde istek gönderilir.
    And updateSalesOrderStatus "POST" requesti ile status değeri "SHIPPED_TO_CUSTOMER" ile değiştirilir.
    And insertVfMallRateAndComment "POST" requestine sessionId girilir.
    Then "FAIL" ve "<expectedResultMessage>" geldiği görülür.
    Examples:
      | barcode | maxSaleCount | cargoCompanyID           | expectedResultCode | expectedErrorMessage            | expectedResult | expectedResultMessage                                           |
      |         | 110          | 60e80fd0026e19ca7d1fe005 | 0                  | İşleminiz başarıyla tamamlandı. | SUCCESS        | Değerlendirme yapabilmek için bu ürünü teslim almış olmalısınız |

  #7
 # @DXLApi
  Scenario Outline: Daha önce yorum yapılmış ürünün yorumunu guncelleme
    Given createSessionId "POST" request'i ve "5467023357" ile sessionId alınır.
    And addVFMallCustomerProfile "POST" requestine "5467023357" msisdn degeri kullanılarak sessionId atılır.
    And customerProfileID parametresi "saveShoppingCartAddress" metoduyla "POST" requestine eklenir.
    And "addCartItems" metodu ve ürünün uuidsi ile "POST" requseti atılır.
    And updateRateAndComment "POST" requestine yeni rate ve comment bilgileri girilerek güncellenir.
    Then "<expectedResult>" ve "<expectedResultMessage>" geldiği görülür.
    Examples:
      | expectedResult | expectedResultMessage                        |
      | SUCCESS        | Yorumunuz onaya gönderildi. Onay statusu = 0 |


  #8
  Scenario: Daha önce yorum yapılmamış ürünün yorumunu guncelleme
    Given createSessionId "POST" request'i ve "5467023357" ile sessionId alınır.
