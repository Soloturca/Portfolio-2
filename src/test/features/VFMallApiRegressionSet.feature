@VFMallApi
Feature: VFMallApi

  @TC001
  Scenario: Take the token service
    Given createVfMallToken "POST" service is sent and take the token

  @TC002
  Scenario: Sent the createVfMallOffering service
    Given createVfMallOffering "POST" is sent with token

  #Batu: Ürünün teslimat süresi boş geçildiğinde hata vermesi kontrol edilir
  @TC009
  Scenario: Sent the createVfMallOffering service without delivery duration
    Given createVfMallToken "POST" service is sent and take the token
    Given createVFMallOfferingWithoutDeliveryDuration "POST" is sent with token

  #Batu: Ürünün detay açıklamasıdır boş geçilemez.
  @TC010
  Scenario: Sent the createVfMallOffering service without description
    Given createVfMallToken "POST" service is sent and take the token
    Given createVFMallOfferingWithoutDescription "POST" is sent with token

  #Batu: Ürünün panel ekranlarında görünecek adıdır. Boş geçilemez
  @TC011
  Scenario: Sent the createVfMallOffering service without displayname
    Given createVfMallToken "POST" service is sent and take the token
    Given createVFMallOfferingWithoutDisplayName "POST" is sent with token



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