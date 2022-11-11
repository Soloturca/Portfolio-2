@AllTests
Feature: VFMallApi

  @TC001
  Scenario: Take the token service
    Given createVfMallToken "POST" service is sent and take the token

  @TC002
  Scenario Outline: Sent the createVfMallOffering service
    Given createVfMallOffering "POST" is sent with "<barcode>", "<brand>", "<cargoCompID>", "<catID>", "<deliveryDuration>", "<desc>", "<displayName>", "<images>", "<listPrice>", "<salePrice>", "<quantity>" and token
    Examples:
      | barcode | brand                    | cargoCompID              | catID                                | deliveryDuration | desc                        | displayName     | images                                                                          | listPrice | salePrice | quantity |
      |         | 5fc8de0c72fb11234c3c5e26 | 60d44700026e19ca7dfc0155 | 83f2e6e7-7959-441f-8779-1838a51f4c2a | 4                | <html>Urun aciklama </html> | testDisplayName | https://ligarbatravel.com/wp-content/uploads/2020/06/kahve-one-cikan-gorsel.jpg | 100.12    | 80.46     | 40       |

  @TC003
  Scenario Outline: Check the product is created
    Given createVfMallToken "POST" service is sent and take the token
    Given createVfMallOffering "POST" is sent with "<barcode>", "<brand>", "<cargoCompID>", "<catID>", "<deliveryDuration>", "<desc>", "<displayName>", "<images>", "<listPrice>", "<salePrice>", "<quantity>" and token
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
    When I double click element: products in table at index 1
    Then I need to just wait
    When I switch to child window
    Then I see product page
    When I click element: feature list from list at index 1
    And I confirm if element: list price text area equals to value from API Response
    Then I confirm if element: sale price text area equals to value from API Response
    And I wait stock update element 10 seconds at index 1
    Then I click element: stock update at index 1
    Then I confirm if element: stock quantity equals to value from API Response
    Then I need to just wait

    Examples:
      | barcode | brand                    | cargoCompID              | catID                                | deliveryDuration | desc                        | displayName     | images                                                                          | listPrice | salePrice | quantity | username           | password       |
      |         | 5fc8de0c72fb11234c3c5e26 | 60d44700026e19ca7dfc0155 | 83f2e6e7-7959-441f-8779-1838a51f4c2a | 4                | <html>Urun aciklama </html> | testDisplayName | https://ligarbatravel.com/wp-content/uploads/2020/06/kahve-one-cikan-gorsel.jpg | 100.12    | 80.46     | 40       | otomasyon@test.com | Test123456789. |

