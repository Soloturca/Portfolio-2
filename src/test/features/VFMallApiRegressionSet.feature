@VFMallApi
Feature: VFMallApi

  @TC001
  Scenario: Take the token service
    Given createVfMallToken "POST" service is sent and take the token


  @TC002
  Scenario: Sent the createVfMallOffering service
    Given createVfMallOffering "POST" is sent with token

  @TC003
  Scenario Outline: Check the product is created
    Given I go to "https://vfmallpanel-gui-secure-marketplace.apps.mbt.vodafone.local/" with this username: "<username>" and this password:"<password>"
    And I wait product button element 50 seconds at index 1
    When I click element: product button at index 1
    And I wait list product button element 50 seconds at index 1
    When I click element: list product button at index 1
    Then I see productList page

    When I wait product code input element 50 seconds at index 1
    Then I enter OFRCode text to product code input at index 1
    And I wait search button element 50 seconds at index 1
    Then I click element: search button at index 1
    Then I need to just wait
    Then I need to check if record is equal to 1 for Record Count


    Examples:
      | username           | password       |
      | otomasyon@test.com | Test123456789. |



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