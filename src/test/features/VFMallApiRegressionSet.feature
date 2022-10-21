@VFMallApi
Feature: VFMallApi

  @TC001
  Scenario: Take the token service
    Given createVfMallToken "POST" service is sent and take the token


  @TC002
  Scenario Outline: Sent the createVfMallOffering service
    Given createVfMallOffering "POST" is sent with "<brand>", "<catID>", "<deliveryDuration>", "<desc>", "<displayName>", "<images>", "<listPrice>", "<salePrice>", "<quantity>" and token
    Examples:
      | brand                    | catID                                | deliveryDuration | desc                        | displayName     | images                                                                          | listPrice | salePrice | quantity |
      | 5fc8de0c72fb11234c3c5e26 | 83f2e6e7-7959-441f-8779-1838a51f4c2a | 4                | <html>Urun aciklama </html> | testDisplayName | https://ligarbatravel.com/wp-content/uploads/2020/06/kahve-one-cikan-gorsel.jpg | 100       | 80        | 40       |


  #Beyza: Ürünün images alanı boş geçildiğinde hata vermesi kontrol edilir
  @TC0012
  Scenario Outline: Sent the createVfMallOffering service without images
    Given createVfMallToken "POST" service is sent and take the token
    Given createVfMallOffering "POST" is sent with "<brand>", "<catID>", "<deliveryDuration>", "<desc>", "<displayName>", "<images>", "<listPrice>", "<salePrice>", "<quantity>" and token
    Then check the "<exceptedResult>" and "<exceptedResultDesc>" fields
    Examples:
      | brand                    | catID                                | deliveryDuration | desc                        | displayName     | images | listPrice | salePrice | quantity | exceptedResult | exceptedResultDesc                                                            |
      | 5fc8de0c72fb11234c3c5e26 | 83f2e6e7-7959-441f-8779-1838a51f4c2a | 4                | <html>Urun aciklama </html> | testDisplayName |        | 100       | 80        | 40       | FAIL           | Ürün resimleri yüklenirken hata oluştu. Hata listesi: : Geçersiz resim url'i. |



  #Beyza: Ürünün listPrice ve salePrice alanı boş geçildiğinde hata vermesi kontrol edilir
  @TC0013
  Scenario Outline: Sent the createVfMallOffering service without listPrice and salePrice
    Given createVfMallToken "POST" service is sent and take the token
    Given createVfMallOffering "POST" is sent with "<brand>", "<catID>", "<deliveryDuration>", "<desc>", "<displayName>", "<images>", "<listPrice>", "<salePrice>", "<quantity>" and token
    Then check the "<exceptedResult>" and "<exceptedResultDesc>" fields
    Examples:
      | brand                    | catID                                | deliveryDuration | desc                        | displayName     | images                                                                          | listPrice | salePrice | quantity | exceptedResult | exceptedResultDesc             |
      | 5fc8de0c72fb11234c3c5e26 | 83f2e6e7-7959-441f-8779-1838a51f4c2a | 4                | <html>Urun aciklama </html> | testDisplayName | https://ligarbatravel.com/wp-content/uploads/2020/06/kahve-one-cikan-gorsel.jpg |           |           | 40       | FAIL           | listPrice alanı boş geçilemez. |


  #Beyza: Ürünün quantity alanı boş geçildiğinde hata vermesi kontrol edilir
  @TC0014
  Scenario Outline: Sent the createVfMallOffering service without quantity
    Given createVfMallToken "POST" service is sent and take the token
    Given createVfMallOffering "POST" is sent with "<brand>", "<catID>", "<deliveryDuration>", "<desc>", "<displayName>", "<images>", "<listPrice>", "<salePrice>", "<quantity>" and token
    Then check the "<exceptedResult>" and "<exceptedResultDesc>" fields
    Examples:
      | brand                    | catID                                | deliveryDuration | desc                        | displayName     | images                                                                          | listPrice | salePrice | quantity | exceptedResult | exceptedResultDesc            |
      | 5fc8de0c72fb11234c3c5e26 | 83f2e6e7-7959-441f-8779-1838a51f4c2a | 4                | <html>Urun aciklama </html> | testDisplayName | https://ligarbatravel.com/wp-content/uploads/2020/06/kahve-one-cikan-gorsel.jpg | 100       | 80        |          | FAIL           | quantity alanı boş geçilemez. |




 #@API-TC0020
 #Scenario Outline: createVfMallOfferingBarkodCakismasiKontrolu
 #  Given createVfMallToken "POST" request'i ile token olusturulur
 #  And createVfMallOffering "POST" requesti "<barcode>", "<maxSaleCount>" ve "<cargoCompanyID>" ile tetiklenir
 #  Then Response Bodyde "<expectedResultCode>", "<expectedErrorMessage>","<expectedResult>" alanlari kontrol edilir
 #  Examples:
 #    | barcode                              | maxSaleCount | cargoCompanyID           | expectedResultCode | expectedErrorMessage                                                                         | expectedResult |
 #    | c8249cb5-0848-4cdc-9c91-1e7a576860d7 | 110          | 60e80fd0026e19ca7d1fe005 | 38                 | Ürünün barkodu bu satıcı için daha önce tanımlanmış. Lüften başka bir barkod değeri giriniz. | FAIL           |
 #
 #@API-TC0022
 #Scenario Outline: createVfMallOfferingMaxSaleCountOGirilmesi
 #  Given createVfMallToken "POST" request'i ile token olusturulur
 #  And createVfMallOffering "POST" requesti "<barcode>", "<maxSaleCount>" ve "<cargoCompanyID>" ile tetiklenir
 #  Then Response Bodyde "<expectedResultCode>", "<expectedErrorMessage>","<expectedResult>" alanlari kontrol edilir
 #
 #  Examples:
 #    | barcode | maxSaleCount | cargoCompanyID           | expectedResultCode | expectedErrorMessage                                                         | expectedResult |
 #    |         | 0            | 60e80fd0026e19ca7d1fe005 | 35                 | Girilen sayısal değer sıfırdan büyük olmalıdır. Parametre ismi: maxSaleCount | FAIL           |
 #
 #@API-TC0021
 #Scenario Outline: createVfMallOfferingCargoCompanyIDYanlışGirilmesi
 #  Given createVfMallToken "POST" request'i ile token olusturulur
 #  And createVfMallOffering "POST" requesti "<barcode>", "<maxSaleCount>" ve "<cargoCompanyID>" ile tetiklenir
 #  Then Response Bodyde "<expectedResultCode>", "<expectedErrorMessage>","<expectedResult>" alanlari kontrol edilir
 #
 #  Examples:
 #    | barcode | maxSaleCount | cargoCompanyID           | expectedResultCode | expectedErrorMessage                              | expectedResult |
 #    |         | 110          | 601be73da23ffc44f4864242 | 43                 | Kargo kodu Partner'e ait bir kargo kodu olmalıdır | FAIL           |