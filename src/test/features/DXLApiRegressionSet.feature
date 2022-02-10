Feature: DXLApi

  Scenario: getVFMallOfferingDetailsResponseValidation
    Given createSessionId "POST" request'i ile sessionId olusturulur
    And getVFMallOfferingDetails "POST" requestine sessionId parametresi eklenir ve servis tetiklenir
    Then "VFMallOffering" Response Body icin kontrol edilir
    #And mongodbde "vfProductGroup" filtresiyle kontrol saglanir

  Scenario: getVFMallHomePageResponseValidation
    Given createSessionID URL'i "POST" edilerek sessionID elde edilir.
    And getVFMallHomePage requestine sessionId parametresi eklenir ve servis "GET" olarak tetiklenir


  Scenario Outline: createVfMallOfferingOfferOlusturma
    Given createVfMallToken "POST" request'i ile token olusturulur
    And createVfMallOffering "POST" requesti "<barcode>", "<maxSaleCount>" ile tetiklenir
    Then Response Bodyde "<expectedResultCode>", "<expectedErrorMessage>","<expectedResult>" alanlari kontrol edilir
    #And mongodbde "code" filtresiyle kontrol saglanir
    Examples:
      | barcode | maxSaleCount | expectedResultCode | expectedErrorMessage            | expectedResult |
      |         | 110          | 0                  | İşleminiz başarıyla tamamlandı. | SUCCESS        |


  Scenario Outline: createVfMallOfferingMaxSaleCountOGirilmesi
    Given createVfMallToken "POST" request'i ile token olusturulur
    And createVfMallOffering "POST" requesti "<barcode>", "<maxSaleCount>" ile tetiklenir
    Then Response Bodyde "<expectedResultCode>", "<expectedErrorMessage>","<expectedResult>" alanlari kontrol edilir

    Examples:
      | barcode                              | maxSaleCount | expectedResultCode | expectedErrorMessage                                                                         | expectedResult |
      | c8249cb5-0848-4cdc-9c91-1e7a576860d7 | 110          | 38                 | Ürünün barkodu bu satıcı için daha önce tanımlanmış. Lüften başka bir barkod değeri giriniz. | FAIL           |

  Scenario Outline: createVfMallOfferingBarkodCakismasiKontrolu
    Given createVfMallToken "POST" request'i ile token olusturulur
    And createVfMallOffering "POST" requesti "<barcode>", "<maxSaleCount>" ile tetiklenir
    Then Response Bodyde "<expectedResultCode>", "<expectedErrorMessage>","<expectedResult>" alanlari kontrol edilir

    Examples:
      | barcode | maxSaleCount | expectedResultCode | expectedErrorMessage                                                         | expectedResult |
      |         | 0            | 35                 | Girilen sayısal değer sıfırdan büyük olmalıdır. Parametre ismi: maxSaleCount | FAIL           |


  Scenario: updateVfMallStockAndPriceIleGuncelleme
    Given createVfMallToken "POST" request'i ile token olusturulur
    And createSessionId "POST" request'i ile sessionId olusturulur
    And getVFMallOfferingDetails "POST" requestine sessionId parametresi eklenir ve servis tetiklenir
    #And mongodbde "vfProductGroup" filtresiyle kontrol saglanir
    And updateVfMallStockAndPrice "POST" requesti tetiklenir
    #And mongodbde "vfProductGroup" filtresiyle kontrol saglanir

  #1
  @DXLApi
  Scenario: commenting on a product with delivered to customer status
    Given createSessionId "POST" request'i ile sessionId alınır.
    And  cleanShoppingCart "GET" requesti ile sepetin temiz olduğuna bakılır.
    And addVFMallCustomerProfile "POST" requestine sessionId atılır.
    And customerProfileID parametresi saveShoppingCartAddress "POST" requestine eklenir.
    And addCartItems "POST" requseti atılır.
    And payShoppingCart "POST" requesti ile sepetteki ürünler satılır.
    And createVfMallToken "POST" request'i ile token olusturulur
    And getVfMallOrders "GET" requestine Authkey girilir ve status PENDING olacak şekilde istek gönderilir.
    And updateSalesOrderStatus "POST" requesti ile status değeri değiştirilir.
    And insertVfMallRateAndComment "POST" requestine sessionId girilir.


  #2
  Scenario: do not comment on a product that has already commented or has a review pending approval

  #3
  Scenario: commenting on unpurchased product
    Given createSessionId "POST" request'i ile sessionId alınır.


  #12
  Scenario: pull all approved comments
    Given createSessionId "POST" request'i ile sessionId alınır.