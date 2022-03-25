@DXLApi
Feature: DXLApi

  @API-TC0017
  Scenario: getVFMallOfferingDetails stok miktarı, satış fiyatı ve liste fiyatı kontrolü
    Given createSessionId "POST" request'i ve "5467023333" ile sessionId alınır.
    And getVFMallOfferingDetails "POST" requestine sessionId parametresi eklenir ve servis tetiklenir
    Then "VFMallOffering" Response Body icin kontrol edilir

  @API-TC0018
  Scenario: getVFMallHomePageResponseValidation
    Given createSessionId "POST" request'i ve "5467023333" ile sessionId alınır.
    And getVFMallHomePage requestine sessionId parametresi eklenir ve servis "GET" olarak tetiklenir

  @API-TC0019
  Scenario Outline: createVfMallOfferingOfferOlusturma
    Given createVfMallToken "POST" request'i ile token olusturulur
    And createVfMallOffering "POST" requesti "<barcode>", "<maxSaleCount>" ve "<cargoCompanyID>" ile tetiklenir
    Then Response Bodyde "<expectedResultCode>", "<expectedErrorMessage>","<expectedResult>" alanlari kontrol edilir
    Examples:
      | barcode | maxSaleCount | cargoCompanyID           | expectedResultCode | expectedErrorMessage            | expectedResult |
      |         | 110          | 60e80fd0026e19ca7d1fe005 | 0                  | İşleminiz başarıyla tamamlandı. | SUCCESS        |

  @API-TC0020
  Scenario Outline: createVfMallOfferingBarkodCakismasiKontrolu
    Given createVfMallToken "POST" request'i ile token olusturulur
    And createVfMallOffering "POST" requesti "<barcode>", "<maxSaleCount>" ve "<cargoCompanyID>" ile tetiklenir
    Then Response Bodyde "<expectedResultCode>", "<expectedErrorMessage>","<expectedResult>" alanlari kontrol edilir
    Examples:
      | barcode                              | maxSaleCount | cargoCompanyID           | expectedResultCode | expectedErrorMessage                                                                         | expectedResult |
      | c8249cb5-0848-4cdc-9c91-1e7a576860d7 | 110          | 60e80fd0026e19ca7d1fe005 | 38                 | Ürünün barkodu bu satıcı için daha önce tanımlanmış. Lüften başka bir barkod değeri giriniz. | FAIL           |

  @API-TC0022
  Scenario Outline: createVfMallOfferingMaxSaleCountOGirilmesi
    Given createVfMallToken "POST" request'i ile token olusturulur
    And createVfMallOffering "POST" requesti "<barcode>", "<maxSaleCount>" ve "<cargoCompanyID>" ile tetiklenir
    Then Response Bodyde "<expectedResultCode>", "<expectedErrorMessage>","<expectedResult>" alanlari kontrol edilir

    Examples:
      | barcode | maxSaleCount | cargoCompanyID           | expectedResultCode | expectedErrorMessage                                                         | expectedResult |
      |         | 0            | 60e80fd0026e19ca7d1fe005 | 35                 | Girilen sayısal değer sıfırdan büyük olmalıdır. Parametre ismi: maxSaleCount | FAIL           |

  @API-TC0021
  Scenario Outline: createVfMallOfferingCargoCompanyIDYanlışGirilmesi
    Given createVfMallToken "POST" request'i ile token olusturulur
    And createVfMallOffering "POST" requesti "<barcode>", "<maxSaleCount>" ve "<cargoCompanyID>" ile tetiklenir
    Then Response Bodyde "<expectedResultCode>", "<expectedErrorMessage>","<expectedResult>" alanlari kontrol edilir

    Examples:
      | barcode | maxSaleCount | cargoCompanyID           | expectedResultCode | expectedErrorMessage                              | expectedResult |
      |         | 110          | 601be73da23ffc44f4864242 | 43                 | Kargo kodu Partner'e ait bir kargo kodu olmalıdır | FAIL           |

  @API-TC0001
  Scenario Outline: Müşteriye Teslim Edildi Statusundeki ürüne yorum yapma
    Given createVfMallToken "POST" request'i ile token olusturulur
    And createSessionId "POST" request'i ve "5467022872" ile sessionId alınır.
    And getVfMallCustomerProfileList "POST" requesti atılır ve customerProfileId değeri çekilir.
    And customerProfileID parametresi "removeVFMallCustomerProfile" metoduyla "POST" isteği atılarak silinir.
    And createVfMallOffering "POST" requesti "<barcode>", "<maxSaleCount>" ve "<cargoCompanyID>" ile tetiklenir
    Then Response Bodyde "<expectedResultCode>", "<expectedErrorMessage>","<expectedResult>" alanlari kontrol edilir
    And cleanShoppingCart "GET" requesti ve "cleanShoppingCart" metodu aracılıgıyla sepetin temiz olduğuna bakılır.
    And addVFMallCustomerProfile "POST" requestine "5467022872" msisdn degeri kullanılarak sessionId atılır.
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

  @API-TC0008
  Scenario: Daha önce yorum yapılmamış ürünün yorumunu guncelleme
    Given createSessionId "POST" request'i ve "5467022872" ile sessionId alınır.
    And getVFMallRateAndComment "POST" requesti ile rastgele bir yorumun id alınır.
    And updateRateAndComment "POST" requestine hideMyName "false" girilir ve yeni rate, comment bilgileri girilerek güncellenir.
    Then "FAIL" ve "Kayıt bulunamadı" geldiği görülür.

  @API-TC0002
  Scenario Outline: Daha Önce yorum yapılmış veya onayda bekleyen yorumu olan ürüne yorum yapma
    Given createSessionId "POST" request'i ve "5467022872" ile sessionId alınır.
    And "addCartItems" metodu ve ürünün uuidsi ile "POST" requseti atılır.
    And insertVfMallRateAndComment "POST" requestine hideMyName "false" girilir ve sessionId girilir.
    Then "<expectedResult>" ve "<expectedResultMessage>" geldiği görülür.
    Examples:
      | expectedResult | expectedResultMessage        |
      | FAIL           | Daha önce kayıt oluşturulmuş |

  @API-TC0007
  Scenario: Daha önce yorum yapılmış ürünün yorumunu guncelleme
    Given createSessionId "POST" request'i ve "5467022872" ile sessionId alınır.
    And getVFMallRateAndComment "POST" requesti ile yorumun idsi alınır.
    And updateRateAndComment "POST" requestine hideMyName "false" girilir ve yeni rate, comment bilgileri girilerek güncellenir.
    Then "SUCCESS" ve "Yorumunuz onaya gönderildi." geldiği görülür.


  @API-TC0003
  Scenario Outline: Satın alınmamış Ürüne Yorum yapma
    Given createVfMallToken "POST" request'i ile token olusturulur
    And createSessionId "POST" request'i ve "5467022872" ile sessionId alınır.
    And getVfMallCustomerProfileList "POST" requesti atılır ve customerProfileId değeri çekilir.
    And customerProfileID parametresi "removeVFMallCustomerProfile" metoduyla "POST" isteği atılarak silinir.
    And createVfMallOffering "POST" requesti "<barcode>", "<maxSaleCount>" ve "<cargoCompanyID>" ile tetiklenir
    Then Response Bodyde "<expectedResultCode>", "<expectedErrorMessage>","<expectedResult>" alanlari kontrol edilir
    And  cleanShoppingCart "GET" requesti ve "cleanShoppingCart" metodu aracılıgıyla sepetin temiz olduğuna bakılır.
    And addVFMallCustomerProfile "POST" requestine "5467022872" msisdn degeri kullanılarak sessionId atılır.
    And customerProfileID parametresi "saveShoppingCartAddress" metoduyla "POST" requestine eklenir.
    And "addCartItems" metodu ve ürünün uuidsi ile "POST" requseti atılır.
    And insertVfMallRateAndComment "POST" requestine hideMyName "false" girilir ve sessionId girilir.
    Then "FAIL" ve "<expectedResultMessage>" geldiği görülür.
    Examples:
      | barcode | maxSaleCount | cargoCompanyID           | expectedResultCode | expectedErrorMessage            | expectedResult | expectedResultMessage                                           |
      |         | 110          | 60e80fd0026e19ca7d1fe005 | 0                  | İşleminiz başarıyla tamamlandı. | SUCCESS        | Değerlendirme yapabilmek için bu ürünü teslim almış olmalısınız |

  @API-TC0004
  Scenario Outline: Beklemede statusundeki Ürüne Yorum yapma
    Given createVfMallToken "POST" request'i ile token olusturulur
    And createSessionId "POST" request'i ve "5467022872" ile sessionId alınır.
   # And getVfMallCustomerProfileList "POST" requesti atılır ve customerProfileId değeri çekilir.
  #  And customerProfileID parametresi "removeVFMallCustomerProfile" metoduyla "POST" isteği atılarak silinir.
    And createVfMallOffering "POST" requesti "<barcode>", "<maxSaleCount>" ve "<cargoCompanyID>" ile tetiklenir
    Then Response Bodyde "<expectedResultCode>", "<expectedErrorMessage>","<expectedResult>" alanlari kontrol edilir
    And  cleanShoppingCart "GET" requesti ve "cleanShoppingCart" metodu aracılıgıyla sepetin temiz olduğuna bakılır.
    And addVFMallCustomerProfile "POST" requestine "5467022872" msisdn degeri kullanılarak sessionId atılır.
    And "addCartItems" metodu ve ürünün uuidsi ile "POST" requseti atılır.
    And customerProfileID parametresi "saveShoppingCartAddress" metoduyla "POST" requestine eklenir.
    And payShoppingCart "POST" requesti ve "payShoppingCart" metodu aracılıgıyla sepetteki ürünler satılır.
    And createVfMallToken "POST" request'i ile token olusturulur
    And getVfMallOrders "GET" requestine Authkey girilir ve status PENDING olacak şekilde istek gönderilir.
    And insertVfMallRateAndComment "POST" requestine hideMyName "false" girilir ve sessionId girilir.
    Then "FAIL" ve "<expectedResultMessage>" geldiği görülür.
    Examples:
      | barcode | maxSaleCount | cargoCompanyID           | expectedResultCode | expectedErrorMessage            | expectedResult | expectedResultMessage                                           |
      |         | 110          | 60e80fd0026e19ca7d1fe005 | 0                  | İşleminiz başarıyla tamamlandı. | SUCCESS        | Değerlendirme yapabilmek için bu ürünü teslim almış olmalısınız |

  @API-TC0005
  Scenario Outline: Hazırlanıyor Statusundeki Ürüne Yorum yapma
    Given createVfMallToken "POST" request'i ile token olusturulur
    And createSessionId "POST" request'i ve "5467022872" ile sessionId alınır.
    And getVfMallCustomerProfileList "POST" requesti atılır ve customerProfileId değeri çekilir.
    And customerProfileID parametresi "removeVFMallCustomerProfile" metoduyla "POST" isteği atılarak silinir.
    And createVfMallOffering "POST" requesti "<barcode>", "<maxSaleCount>" ve "<cargoCompanyID>" ile tetiklenir
    Then Response Bodyde "<expectedResultCode>", "<expectedErrorMessage>","<expectedResult>" alanlari kontrol edilir
    And  cleanShoppingCart "GET" requesti ve "cleanShoppingCart" metodu aracılıgıyla sepetin temiz olduğuna bakılır.
    And addVFMallCustomerProfile "POST" requestine "5467022872" msisdn degeri kullanılarak sessionId atılır.
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


  @API-TC0006
  Scenario Outline: Kargoya Verildi Statusundeki Ürüne Yorum yapma
    Given createVfMallToken "POST" request'i ile token olusturulur
    And createSessionId "POST" request'i ve "5467022872" ile sessionId alınır.
    And getVfMallCustomerProfileList "POST" requesti atılır ve customerProfileId değeri çekilir.
    And customerProfileID parametresi "removeVFMallCustomerProfile" metoduyla "POST" isteği atılarak silinir.
    And createVfMallOffering "POST" requesti "<barcode>", "<maxSaleCount>" ve "<cargoCompanyID>" ile tetiklenir
    Then Response Bodyde "<expectedResultCode>", "<expectedErrorMessage>","<expectedResult>" alanlari kontrol edilir
    And  cleanShoppingCart "GET" requesti ve "cleanShoppingCart" metodu aracılıgıyla sepetin temiz olduğuna bakılır.
    And addVFMallCustomerProfile "POST" requestine "5467022872" msisdn degeri kullanılarak sessionId atılır.
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


# #9
# Scenario: Onayda Bekleyen bir Yorumu çekme
#   Given createSessionId "POST" request'i ve "5467028866" ile sessionId alınır.
#   And getVFMallRateAndComment "POST" requesti ile yorumun idsi alınır.
#   #devamı MONGO
#
# #10
# Scenario: Onayı geçmiş bir Yorumu çekme
#   Given createSessionId "POST" request'i ve "5467028866" ile sessionId alınır.
#   And getVFMallRateAndComment "POST" requesti ile yorumun idsi alınır.
#   #devamı MONGO
#
#
# #11
# Scenario: Reddedilmiş bir yorumu çekme
#   Given createSessionId "POST" request'i ve "5467028866" ile sessionId alınır.
#   And getVFMallRateAndComment "POST" requesti ile yorumun idsi alınır.
#   #devamı MONGO
#
# #12
# Scenario: Onayı geçmiş bütün yorumları çekme
#   Given createSessionId "POST" request'i ve "5467028866" ile sessionId alınır.
#   And getVFMallRateAndComment "POST" requesti ile yorumun idsi alınır.
#   #response ta gösterme kısmı kaldı

  @API-TC0013
  Scenario Outline: İsim gizlenmeden satın alınmış ürüne yorum yapılması
    Given createVfMallToken "POST" request'i ile token olusturulur
    And createSessionId "POST" request'i ve "5467022872" ile sessionId alınır.
    And getVfMallCustomerProfileList "POST" requesti atılır ve customerProfileId değeri çekilir.
    And customerProfileID parametresi "removeVFMallCustomerProfile" metoduyla "POST" isteği atılarak silinir.
    And createVfMallOffering "POST" requesti "<barcode>", "<maxSaleCount>" ve "<cargoCompanyID>" ile tetiklenir
    Then Response Bodyde "<expectedResultCode>", "<expectedErrorMessage>","<expectedResult>" alanlari kontrol edilir
    And  cleanShoppingCart "GET" requesti ve "cleanShoppingCart" metodu aracılıgıyla sepetin temiz olduğuna bakılır.
    And addVFMallCustomerProfile "POST" requestine "5467022872" msisdn degeri kullanılarak sessionId atılır.
    And "addCartItems" metodu ve ürünün uuidsi ile "POST" requseti atılır.
    And customerProfileID parametresi "saveShoppingCartAddress" metoduyla "POST" requestine eklenir.
    And payShoppingCart "POST" requesti ve "payShoppingCart" metodu aracılıgıyla sepetteki ürünler satılır.
    And createVfMallToken "POST" request'i ile token olusturulur
    And getVfMallOrders "GET" requestine Authkey girilir ve status PENDING olacak şekilde istek gönderilir.
    And updateSalesOrderStatus "POST" requesti ile status değeri "DELIVERED_TO_CUSTOMER" ile değiştirilir.
    Then createSessionId "POST" request'i ve "5467022872" ile sessionId alınır.
    And insertVfMallRateAndComment "POST" requestine hideMyName "false" girilir ve sessionId girilir.
    And "POST" requesti ile HideMyName "false" olduğundan isim ve soyisim buna göre gözükür.
    Examples:
      | barcode | maxSaleCount | cargoCompanyID           | expectedResultCode | expectedErrorMessage            | expectedResult |
      |         | 110          | 60e80fd0026e19ca7d1fe005 | 0                  | İşleminiz başarıyla tamamlandı. | SUCCESS        |

  @API-TC0015
  Scenario: İsim Gizlenmeden yapılan yorumun güncellenmesi
    Given createSessionId "POST" request'i ve "5467022872" ile sessionId alınır.
    And getVFMallRateAndComment "POST" requesti ile yorumun idsi alınır.
    And updateRateAndComment "POST" requestine hideMyName "false" girilir ve yeni rate, comment bilgileri girilerek güncellenir.
    And "POST" requesti ile HideMyName "false" olduğundan isim ve soyisim buna göre gözükür.


  @API-TC0014
  Scenario Outline: İsim gizlenerek satın alınmış ürüne yorum yapılması
    Given createVfMallToken "POST" request'i ile token olusturulur
    And createSessionId "POST" request'i ve "5467022872" ile sessionId alınır.
    And getVfMallCustomerProfileList "POST" requesti atılır ve customerProfileId değeri çekilir.
    And customerProfileID parametresi "removeVFMallCustomerProfile" metoduyla "POST" isteği atılarak silinir.
    And createVfMallOffering "POST" requesti "<barcode>", "<maxSaleCount>" ve "<cargoCompanyID>" ile tetiklenir
    Then Response Bodyde "<expectedResultCode>", "<expectedErrorMessage>","<expectedResult>" alanlari kontrol edilir
    And  cleanShoppingCart "GET" requesti ve "cleanShoppingCart" metodu aracılıgıyla sepetin temiz olduğuna bakılır.
    And addVFMallCustomerProfile "POST" requestine "5467022872" msisdn degeri kullanılarak sessionId atılır.
    And "addCartItems" metodu ve ürünün uuidsi ile "POST" requseti atılır.
    And customerProfileID parametresi "saveShoppingCartAddress" metoduyla "POST" requestine eklenir.
    And payShoppingCart "POST" requesti ve "payShoppingCart" metodu aracılıgıyla sepetteki ürünler satılır.
    And createVfMallToken "POST" request'i ile token olusturulur
    And getVfMallOrders "GET" requestine Authkey girilir ve status PENDING olacak şekilde istek gönderilir.
    And updateSalesOrderStatus "POST" requesti ile status değeri "DELIVERED_TO_CUSTOMER" ile değiştirilir.
    Then createSessionId "POST" request'i ve "5467022872" ile sessionId alınır.
    And insertVfMallRateAndComment "POST" requestine hideMyName "true" girilir ve sessionId girilir.
    And "POST" requesti ile HideMyName "true" olduğundan isim ve soyisim buna göre gözükür.
    Examples:
      | barcode | maxSaleCount | cargoCompanyID           | expectedResultCode | expectedErrorMessage            | expectedResult |
      |         | 110          | 60e80fd0026e19ca7d1fe005 | 0                  | İşleminiz başarıyla tamamlandı. | SUCCESS        |


  @API-TC0016
  Scenario: İsim gizlenerek yapılan yorumun güncellenmesi
    Given createSessionId "POST" request'i ve "5467022872" ile sessionId alınır.
    And getVFMallRateAndComment "POST" requesti ile yorumun idsi alınır.
    And updateRateAndComment "POST" requestine hideMyName "true" girilir ve yeni rate, comment bilgileri girilerek güncellenir.
    And "POST" requesti ile HideMyName "true" olduğundan isim ve soyisim buna göre gözükür.

