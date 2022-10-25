@VFMallApi
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

  #Laman: Ürünün oluştuğu panelden kontrol edilir
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

  #Laman:  "barcode" çakışması kontrol edilir
  @TC004
  Scenario Outline: Sent the createVfMallOffering service with barcode conflict
    Given createVfMallToken "POST" service is sent and take the token
    Given createVfMallOffering "POST" is sent with "<barcode>", "<brand>", "<cargoCompID>", "<catID>", "<deliveryDuration>", "<desc>", "<displayName>", "<images>", "<listPrice>", "<salePrice>", "<quantity>" and token
    Then check the "<exceptedResult>" and "<exceptedResultDesc>" fields
    Examples:
      | barcode                              | brand                    | cargoCompID              | catID                                | deliveryDuration | desc                        | displayName     | images                                                                          | listPrice | salePrice | quantity | exceptedResult | exceptedResultDesc                                                                           |
      | aaf338bf-8a70-4dec-9be1-ced24647c448 | 5fc8de0c72fb11234c3c5e26 | 60d44700026e19ca7dfc0155 | 83f2e6e7-7959-441f-8779-1838a51f4c2a | 4                | <html>Urun aciklama </html> | testDisplayName | https://ligarbatravel.com/wp-content/uploads/2020/06/kahve-one-cikan-gorsel.jpg | 100       | 80        | 40       | FAIL           | Ürünün barkodu bu satıcı için daha önce tanımlanmış. Lüften başka bir barkod değeri giriniz. |

  #Laman: Ürünün brand alanı boş geçildiğinde hata vermesi kontrol edilir
  @TC005
  Scenario Outline: Sent the createVfMallOffering service without brand
    Given createVfMallToken "POST" service is sent and take the token
    Given createVfMallOffering "POST" is sent with "<barcode>", "<brand>", "<cargoCompID>", "<catID>", "<deliveryDuration>", "<desc>", "<displayName>", "<images>", "<listPrice>", "<salePrice>", "<quantity>" and token
    Then check the "<exceptedResult>" and "<exceptedResultDesc>" fields
    Examples:
      | barcode | brand | cargoCompID              | catID                                | deliveryDuration | desc                        | displayName     | images                                                                          | listPrice | salePrice | quantity | exceptedResult | exceptedResultDesc         |
      |         |       | 60d44700026e19ca7dfc0155 | 83f2e6e7-7959-441f-8779-1838a51f4c2a | 4                | <html>Urun aciklama </html> | testDisplayName | https://ligarbatravel.com/wp-content/uploads/2020/06/kahve-one-cikan-gorsel.jpg | 100       | 80        | 40       | FAIL           | brand alanı boş geçilemez. |

  #Laman: Ürünün cagoCompanyID alanı boş geçildiğinde hata vermesi kontrol edilir
  @TC006
  Scenario Outline: Sent the createVfMallOffering service without cargoCompanyID
    Given createVfMallToken "POST" service is sent and take the token
    Given createVfMallOffering "POST" is sent with "<barcode>", "<brand>", "<cargoCompID>", "<catID>", "<deliveryDuration>", "<desc>", "<displayName>", "<images>", "<listPrice>", "<salePrice>", "<quantity>" and token
    Then check the "<exceptedResult>" and "<exceptedResultDesc>" fields
    Examples:
      | barcode | brand                    | cargoCompID | catID                                | deliveryDuration | desc                        | displayName     | images                                                                          | listPrice | salePrice | quantity | exceptedResult | exceptedResultDesc                  |
      |         | 5fc8de0c72fb11234c3c5e26 |             | 83f2e6e7-7959-441f-8779-1838a51f4c2a | 4                | <html>Urun aciklama </html> | testDisplayName | https://ligarbatravel.com/wp-content/uploads/2020/06/kahve-one-cikan-gorsel.jpg | 100       | 80        | 40       | FAIL           | cargoCompanyId alanı boş geçilemez. |


     #Beyza: Ürünün category id alanı boş geçildiğinde hata vermesi kontrol edilir
  @TC007
  Scenario Outline: Sent the createVfMallOffering service without categoryID
    Given createVfMallToken "POST" service is sent and take the token
    Given createVfMallOffering "POST" is sent with "<barcode>", "<brand>", "<cargoCompID>", "<catID>", "<deliveryDuration>", "<desc>", "<displayName>", "<images>", "<listPrice>", "<salePrice>", "<quantity>" and token
    Then check the "<exceptedResult>" and "<exceptedResultDesc>" fields
    Examples:
      | barcode | brand                    | cargoCompID              | catID | deliveryDuration | desc                        | displayName     | images                                                                          | listPrice | salePrice | quantity | exceptedResult | exceptedResultDesc              |
      |         | 5fc8de0c72fb11234c3c5e26 | 60d44700026e19ca7dfc0155 |       | 4                | <html>Urun aciklama </html> | testDisplayName | https://ligarbatravel.com/wp-content/uploads/2020/06/kahve-one-cikan-gorsel.jpg | 100       | 80        | 40       | FAIL           | categoryId alanı boş geçilemez. |

    #Beyza: Ürünün alt category id si giirilmediğinde hata vermesi kontrol edilir
  @TC008
  Scenario Outline: Sent the createVfMallOffering service when subcategory id is not entered
    Given createVfMallToken "POST" service is sent and take the token
    Given createVfMallOffering "POST" is sent with "<barcode>", "<brand>", "<cargoCompID>", "<catID>", "<deliveryDuration>", "<desc>", "<displayName>", "<images>", "<listPrice>", "<salePrice>", "<quantity>" and token
    Then check the "<exceptedResult>" and "<exceptedResultDesc>" fields
    Examples:
      | barcode | brand                    | cargoCompID              | catID                                | deliveryDuration | desc                        | displayName     | images                                                                          | listPrice | salePrice | quantity | exceptedResult | exceptedResultDesc                           |
      |         | 5fc8de0c72fb11234c3c5e26 | 60d44700026e19ca7dfc0155 | 7ffefe31-adfd-4f4a-a189-47697a24e474 | 4                | <html>Urun aciklama </html> | testDisplayName | https://ligarbatravel.com/wp-content/uploads/2020/06/kahve-one-cikan-gorsel.jpg | 100       | 80        | 40       | FAIL           | Seçtiğiniz kategori, alt kategori olmalıdır. |


    #Batu: Ürünün teslimat süresi boş geçildiğinde hata vermesi kontrol edilir
  @TC009
  Scenario Outline: Sent the createVfMallOffering service without delivery duration
    Given createVfMallToken "POST" service is sent and take the token
    Given createVfMallOffering "POST" is sent with "<barcode>", "<brand>", "<cargoCompID>", "<catID>", "<deliveryDuration>", "<desc>", "<displayName>", "<images>", "<listPrice>", "<salePrice>", "<quantity>" and token
    Then check the "<exceptedResult>" and "<exceptedResultDesc>" fields
    Examples:
      | barcode | brand                    | cargoCompID              | catID                                | deliveryDuration | desc                        | displayName     | images                                                                          | listPrice | salePrice | quantity | exceptedResult | exceptedResultDesc                    |
      |         | 5fc8de0c72fb11234c3c5e26 | 60d44700026e19ca7dfc0155 | 83f2e6e7-7959-441f-8779-1838a51f4c2a |                  | <html>Urun aciklama </html> | testDisplayName | https://ligarbatravel.com/wp-content/uploads/2020/06/kahve-one-cikan-gorsel.jpg | 100       | 80        | 40       | FAIL           | deliveryDuration alanı boş geçilemez. |

  #Batu: Ürünün detay açıklamasıdır boş geçilemez.
  @TC010
  Scenario Outline: Sent the createVfMallOffering service without description
    Given createVfMallToken "POST" service is sent and take the token
    Given createVfMallOffering "POST" is sent with "<barcode>", "<brand>", "<cargoCompID>", "<catID>", "<deliveryDuration>", "<desc>", "<displayName>", "<images>", "<listPrice>", "<salePrice>", "<quantity>" and token
    Then check the "<exceptedResult>" and "<exceptedResultDesc>" fields
    Examples:
      | barcode | brand                    | cargoCompID              | catID                                | deliveryDuration | desc | displayName     | images                                                                          | listPrice | salePrice | quantity | exceptedResult | exceptedResultDesc               |
      |         | 5fc8de0c72fb11234c3c5e26 | 60d44700026e19ca7dfc0155 | 83f2e6e7-7959-441f-8779-1838a51f4c2a | 4                |      | testDisplayName | https://ligarbatravel.com/wp-content/uploads/2020/06/kahve-one-cikan-gorsel.jpg | 100       | 80        | 40       | FAIL           | description alanı boş geçilemez. |

  #Batu: Ürünün panel ekranlarında görünecek adıdır. Boş geçilemez
  @TC011
  Scenario Outline: Sent the createVfMallOffering service without displayname
    Given createVfMallToken "POST" service is sent and take the token
    Given createVfMallOffering "POST" is sent with "<barcode>", "<brand>", "<cargoCompID>", "<catID>", "<deliveryDuration>", "<desc>", "<displayName>", "<images>", "<listPrice>", "<salePrice>", "<quantity>" and token
    Then check the "<exceptedResult>" and "<exceptedResultDesc>" fields
    Examples:
      | barcode | brand                    | cargoCompID              | catID                                | deliveryDuration | desc                        | displayName | images                                                                          | listPrice | salePrice | quantity | exceptedResult | exceptedResultDesc               |
      |         | 5fc8de0c72fb11234c3c5e26 | 60d44700026e19ca7dfc0155 | 83f2e6e7-7959-441f-8779-1838a51f4c2a | 4                | <html>Urun aciklama </html> |             | https://ligarbatravel.com/wp-content/uploads/2020/06/kahve-one-cikan-gorsel.jpg | 100       | 80        | 40       | FAIL           | displayName alanı boş geçilemez. |


  #Beyza: Ürünün images alanı boş geçildiğinde hata vermesi kontrol edilir
  @TC0012
  Scenario Outline: Sent the createVfMallOffering service without images
    Given createVfMallToken "POST" service is sent and take the token
    Given createVfMallOffering "POST" is sent with "<barcode>", "<brand>", "<catID>", "<deliveryDuration>", "<desc>", "<displayName>", "<listPrice>", "<salePrice>", "<quantity>" and token
    Then check the "<exceptedResult>" and "<exceptedResultDesc>" fields
    Examples:
      | barcode | brand                    | catID                                | deliveryDuration | desc                        | displayName     | listPrice | salePrice | quantity | exceptedResult | exceptedResultDesc          |
      |         | 5fc8de0c72fb11234c3c5e26 | 83f2e6e7-7959-441f-8779-1838a51f4c2a | 4                | <html>Urun aciklama </html> | testDisplayName | 100       | 80        | 40       | FAIL           | images alanı boş geçilemez. |

  #Laman: Ürünün listPrice ve salePrice alanı boş geçildiğinde hata vermesi kontrol edilir
  @TC0013
  Scenario Outline: Sent the createVfMallOffering service without listPrice and salePrice
    Given createVfMallToken "POST" service is sent and take the token
    Given createVfMallOffering "POST" is sent with "<barcode>", "<brand>", "<cargoCompID>", "<catID>", "<deliveryDuration>", "<desc>", "<displayName>", "<images>", "<listPrice>", "<salePrice>", "<quantity>" and token
    Then check the "<exceptedResult>" and "<exceptedResultDesc>" fields
    Examples:
      | barcode | brand                    | cargoCompID              | catID                                | deliveryDuration | desc                        | displayName     | images                                                                          | listPrice | salePrice | quantity | exceptedResult | exceptedResultDesc             |
      |         | 5fc8de0c72fb11234c3c5e26 | 60d44700026e19ca7dfc0155 | 83f2e6e7-7959-441f-8779-1838a51f4c2a | 4                | <html>Urun aciklama </html> | testDisplayName | https://ligarbatravel.com/wp-content/uploads/2020/06/kahve-one-cikan-gorsel.jpg |           |           | 40       | FAIL           | listPrice alanı boş geçilemez. |

  #Laman: Ürünün quantity alanı boş geçildiğinde hata vermesi kontrol edilir
  @TC0014
  Scenario Outline: Sent the createVfMallOffering service without quantity
    Given createVfMallToken "POST" service is sent and take the token
    Given createVfMallOffering "POST" is sent with "<barcode>", "<brand>", "<cargoCompID>", "<catID>", "<deliveryDuration>", "<desc>", "<displayName>", "<images>", "<listPrice>", "<salePrice>", "<quantity>" and token
    Then check the "<exceptedResult>" and "<exceptedResultDesc>" fields
    Examples:
      | barcode | brand                    | cargoCompID              | catID                                | deliveryDuration | desc                        | displayName     | images                                                                          | listPrice | salePrice | quantity | exceptedResult | exceptedResultDesc            |
      |         | 5fc8de0c72fb11234c3c5e26 | 60d44700026e19ca7dfc0155 | 83f2e6e7-7959-441f-8779-1838a51f4c2a | 4                | <html>Urun aciklama </html> | testDisplayName | https://ligarbatravel.com/wp-content/uploads/2020/06/kahve-one-cikan-gorsel.jpg | 100       | 80        |          | FAIL           | quantity alanı boş geçilemez. |


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
