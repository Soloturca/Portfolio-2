Feature: CBU_C2D

  @TEST-952954
  Scenario: Welcomepage
    Given Open the https://efes.vodafone.com.tr/clicktodoor-mobil-dxl/ URL
    Then I see welcomePage page
    Then I need to just wait
    
    
  #Beyza
  @TEST-953020
  Scenario: Rastgele Numarayla Farklı Adrese Teslim NL Başvuru
    Given Open the https://efes.vodafone.com.tr/clicktodoor-mobil-dxl/ URL
    Then I see welcomePage page
    Then I need to just wait
    And I wait yeni faturali hat element 30 seconds at index 1
    Then I click element: yeni faturali hat at index 1
    Then I see tariffSelectionPage page
    And I wait tarife sec button element 30 seconds at index 1
    Then I click element: tarife sec button at index 1
    Then I see lineProcessesPage page
    Then I need to just wait
    Then I click element: random no radio button at index 1
    And I wait random telephone no element 30 seconds at index 1
    Then I click element: random telephone no at index 1
    Then I click element: continue button at index 1
    And I wait telephone number element 30 seconds at index 1
    Then I click element: telephone number at index 1
    Then I enter telephone number random telephone number to at index 1
    Then I click element: send confirmation code button at index 1
    And I wait confirmation code text element 30 seconds at index 1
    Then I click element: confirmation code text at index 1
    Then I enter "1111" text to confirmation code text at index 1
    And I wait confirm ve continue button element 30 seconds at index 1
    Then I click element: confirm ve continue button at index 1
    Then I need to just wait
    Then I see idInfoPage page
    Then I click element: name at index 1
    Then I enter "ALİ" text to name at index 1
    Then I click element: surname at index 1
    Then I enter "ALİ" text to surname at index 1
    Then I click element: ID at index 1
    Then I enter "58919081214" text to ID at index 1
    Then I click element: father name at index 1
    Then I enter "ALİ" text to father name at index 1
    Then I click element: date of birth at index 1
    Then I enter "03031998" text to date of birth at index 1
    And I wait id information continue button element 30 seconds at index 1
    Then I click element: id information continue button at index 1
    Then I need to just wait
    Then I see addressInfoPage page
    And I wait delivery address element 15 seconds at index 1
    And I wait city element 15 seconds at index 1
    Then I enter "İSTANBUL" text to city at index 1
    Then I enter "ADALAR" text to district at index 1
    Then I need to just wait
    Then I enter "BURGAZADA" text to neighborhood at index 1
    Then I click element: address input at index 1
    Then I enter "TEST" text to address input at index 1
    And I wait same address checkbox element 30 seconds at index 1
    Then I click element: same address checkbox at index 1
    Then I need to just wait
    And I wait bill city element 15 seconds at index 1
    Then I enter "İSTANBUL" text to bill city at index 1
    Then I enter "ADALAR" text to bill district at index 1
    Then I need to just wait
    Then I enter "BÜYÜKADA" text to bill neighborhood at index 1
    And I wait bill address input element 30 seconds at index 1
    Then I click element: bill address input at index 1
    Then I enter "BILL TEST" text to bill address input at index 1
    And I wait mail input element 30 seconds at index 1
    Then I click element: mail input at index 1
    Then I enter "test@hotmail.com" text to mail input at index 1
    Then I click element: address continue button at index 1
    Then I need to just wait
    And I wait Edevlet button element 30 seconds at index 1
    Then I click element: Edevlet button at index 1
    And I wait continue with Edevlet element 30 seconds at index 1
    Then I go back previous page
    Then I need to just wait
    Then I see addressInfoPage page
    And I wait delivery address element 15 seconds at index 1
    And I wait city element 15 seconds at index 1
    Then I enter "İSTANBUL" text to city at index 1
    Then I enter "ADALAR" text to district at index 1
    Then I need to just wait
    Then I enter "BURGAZADA" text to neighborhood at index 1
    Then I click element: address input at index 1
    Then I enter "TEST" text to address input at index 1
    And I wait same address checkbox element 30 seconds at index 1
    Then I click element: same address checkbox at index 1
    Then I need to just wait
    And I wait bill city element 15 seconds at index 1
    Then I enter "İSTANBUL" text to bill city at index 1
    Then I enter "ADALAR" text to bill district at index 1
    Then I need to just wait
    Then I enter "BÜYÜKADA" text to bill neighborhood at index 1
    And I wait bill address input element 30 seconds at index 1
    Then I click element: bill address input at index 1
    Then I enter "BILL TEST" text to bill address input at index 1
    And I wait mail input element 30 seconds at index 1
    Then I click element: mail input at index 1
    Then I enter "test@hotmail.com" text to mail input at index 1
    Then I click element: address continue button at index 1
    Then I need to just wait
    And I wait courier button element 30 seconds at index 1
    Then I click element: courier button at index 1
    And I wait continue with courier element 30 seconds at index 1

    #Beyza
  @TEST-953021
  Scenario: Rastgele Numarayla Mağazaya Teslim NL Başvuru
    Given Open the https://efes.vodafone.com.tr/clicktodoor-mobil-dxl/ URL
    Then I see welcomePage page
    Then I need to just wait
    And I wait yeni faturali hat element 30 seconds at index 1
    Then I click element: yeni faturali hat at index 1
    Then I see tariffSelectionPage page
    And I wait tarife sec button element 30 seconds at index 1
    Then I click element: tarife sec button at index 1
    Then I see lineProcessesPage page
    Then I need to just wait
    Then I click element: random no radio button at index 1
    And I wait random telephone no element 30 seconds at index 1
    Then I click element: random telephone no at index 1
    Then I click element: continue button at index 1
    And I wait telephone number element 30 seconds at index 1
    Then I click element: telephone number at index 1
    Then I enter telephone number random telephone number to at index 1
    Then I click element: send confirmation code button at index 1
    And I wait confirmation code text element 30 seconds at index 1
    Then I click element: confirmation code text at index 1
    Then I enter "1111" text to confirmation code text at index 1
    And I wait confirm ve continue button element 30 seconds at index 1
    Then I click element: confirm ve continue button at index 1
    Then I need to just wait
    Then I see idInfoPage page
    Then I click element: name at index 1
    Then I enter "ALİ" text to name at index 1
    Then I click element: surname at index 1
    Then I enter "ALİ" text to surname at index 1
    Then I click element: ID at index 1
    Then I enter "58919081214" text to ID at index 1
    Then I click element: father name at index 1
    Then I enter "ALİ" text to father name at index 1
    Then I click element: date of birth at index 1
    Then I enter "03031998" text to date of birth at index 1
    And I wait id information continue button element 30 seconds at index 1
    Then I click element: id information continue button at index 1
    Then I need to just wait
    Then I see addressInfoPage page
    And I wait bill address element 15 seconds at index 1
    And I wait buy in store button element 30 seconds at index 1
    Then I click element: buy in store button at index 1
    And I wait city element 15 seconds at index 1
    Then I enter "İSTANBUL" text to city at index 1
    Then I enter "ADALAR" text to district at index 1
    Then I need to just wait
    Then I enter "BURGAZADA" text to neighborhood at index 1
    Then I click element: address input at index 1
    Then I enter "TEST" text to address input at index 1
    And I wait mail input element 30 seconds at index 1
    Then I click element: mail input at index 1
    Then I enter "test@hotmail.com" text to mail input at index 1
    Then I click element: address continue button at index 1
    Then I need to just wait
    And I wait continue with courier element 30 seconds at index 1

  #Beyza
  @TEST-953022
  Scenario: İstenen Numarayla Adrese Teslim NL Başvuru
    Given Open the https://efes.vodafone.com.tr/clicktodoor-mobil-dxl/ URL
    Then I see welcomePage page
    Then I need to just wait
    And I wait yeni faturali hat element 30 seconds at index 1
    Then I click element: yeni faturali hat at index 1
    Then I see tariffSelectionPage page
    And I wait tarife sec button element 30 seconds at index 1
    Then I click element: tarife sec button at index 1
    Then I see lineProcessesPage page
    Then I need to just wait
    Then I click element: search no radio button at index 1
    And I wait last seven digits element 30 seconds at index 1
    Then I click element: last seven digits at index 1
    Then I enter last seven digits random seven digits to at index 1
    Then I click element: search button at index 1
    And I wait select telephone no element 30 seconds at index 1
    Then I click element: select telephone no at index 1
    Then I click element: continue button at index 1
    And I wait telephone number element 30 seconds at index 1
    Then I click element: telephone number at index 1
    Then I enter telephone number random telephone number to at index 1
    Then I click element: send confirmation code button at index 1
    And I wait confirmation code text element 30 seconds at index 1
    Then I click element: confirmation code text at index 1
    Then I enter "1111" text to confirmation code text at index 1
    And I wait confirm ve continue button element 30 seconds at index 1
    Then I click element: confirm ve continue button at index 1
    Then I need to just wait
    Then I see idInfoPage page
    Then I click element: name at index 1
    Then I enter "ALİ" text to name at index 1
    Then I click element: surname at index 1
    Then I enter "ALİ" text to surname at index 1
    Then I click element: ID at index 1
    Then I enter "58919081214" text to ID at index 1
    Then I click element: father name at index 1
    Then I enter "ALİ" text to father name at index 1
    Then I click element: date of birth at index 1
    Then I enter "03031998" text to date of birth at index 1
    And I wait id information continue button element 30 seconds at index 1
    Then I click element: id information continue button at index 1
    Then I need to just wait
    Then I see addressInfoPage page
    And I wait delivery address element 15 seconds at index 1
    And I wait city element 15 seconds at index 1
    Then I enter "İSTANBUL" text to city at index 1
    Then I enter "ADALAR" text to district at index 1
    Then I need to just wait
    Then I enter "BURGAZADA" text to neighborhood at index 1
    Then I click element: address input at index 1
    Then I enter "TEST" text to address input at index 1
    And I wait mail input element 30 seconds at index 1
    Then I click element: mail input at index 1
    Then I enter "test@hotmail.com" text to mail input at index 1
    Then I click element: address continue button at index 1
    Then I need to just wait
    And I wait Edevlet button element 30 seconds at index 1
    Then I click element: Edevlet button at index 1
    And I wait continue with Edevlet element 30 seconds at index 1
    Then I go back previous page
    Then I need to just wait
    Then I see addressInfoPage page
    And I wait delivery address element 15 seconds at index 1
    And I wait city element 15 seconds at index 1
    Then I enter "İSTANBUL" text to city at index 1
    Then I enter "ADALAR" text to district at index 1
    Then I need to just wait
    Then I enter "BURGAZADA" text to neighborhood at index 1
    Then I click element: address input at index 1
    Then I enter "TEST" text to address input at index 1
    And I wait mail input element 30 seconds at index 1
    Then I click element: mail input at index 1
    Then I enter "test@hotmail.com" text to mail input at index 1
    Then I click element: address continue button at index 1
    Then I need to just wait
    And I wait courier button element 30 seconds at index 1
    Then I click element: courier button at index 1
    And I wait continue with courier element 30 seconds at index 1