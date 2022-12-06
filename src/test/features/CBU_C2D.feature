Feature: CBU_C2D

  @TEST-952954
  Scenario: Welcomepage
   Given Open the https://efes.vodafone.com.tr/clicktodoor-mobil-dxl/ URL
    Then I see welcomePage page
    Then I need to just wait





#Akif's Cases
  @TEST-953024
  Scenario: Istenen Numarayla Magazaya Teslim NL Basvuru
    Given Open the https://efes.vodafone.com.tr/clicktodoor-mobil-dxl/ URL
    Then I see welcomePage page
    And I wait Yeni Faturali Hat Al element 10 seconds at index 1
    When I click element: Yeni Faturali Hat Al at index 1
    Then I see tariffSelectionPage page
    And I wait tarife sec button element 10 seconds at index 1
    When I click element: tarife sec button at index 1
    And I need to just wait
    Then I see lineProcessesPage page
    And I wait son7 hane text area element 10 seconds at index 1
    When I click element: son7 hane text area at index 1
    Then I enter "3333333" text to son7 hane text area at index 1
    And I wait arabutton element 10 seconds at index 1
    When I click element: arabutton at index 1
    And I wait ilknumarabox element 10 seconds at index 1
    When I click element: ilknumarabox at index 1
    And I wait devametbutton element 10 seconds at index 1
    When I click element: devametbutton at index 1
    And I wait onaykodunumara text area element 10 seconds at index 1
    Then I enter random telephone number to onaykodunumara text area at index 1
    And I wait onaykodugonderbutton element 10 seconds at index 1
    When I click element: onaykodugonderbutton at index 1
    And I wait otp text area element 10 seconds at index 1
    Then I enter "1111" text to otp text area at index 1
    And I wait onayla ve devam et button element 10 seconds at index 1
    When I click element: onayla ve devam et button at index 1
    Then I see idInfoPage page
    #And I wait bu kisi ile devam et button element 10 seconds at index 1
    #When I click element: bu kisi ile devam et button at index 1
#    Kimlik bilgileri sistemde kayıtlı. Kayıtlı kişi kullanılsın seçilip devam edildi. Kullanılan bilgiler aşağıdaki bilgilerdir.
    And I wait ad element 10 seconds at index 1
    Then I enter "ALİ" text to ad at index 1
    And I wait soyad element 10 seconds at index 1
    Then I enter "ALİ" text to soyad at index 1
    And I wait tckn element 10 seconds at index 1
    Then I enter "58919081214" text to tckn at index 1
    And I wait babaadi element 10 seconds at index 1
    Then I enter "ALİ" text to babaadi at index 1
    And I wait dogum tarihi element 10 seconds at index 1
    Then I enter "03/03/1998" text to dogum tarihi at index 1
    And I wait kimlikbilgisidevametbutton element 10 seconds at index 1
    When I click element: kimlikbilgisidevametbutton at index 1
    Then I see addressInfoPage page
    And I wait il element 10 seconds at index 1
    When I click element: il at index 1
    And I wait istanbul element 10 seconds at index 1
    When I click element: istanbul at index 1
    And I wait fatih element 10 seconds at index 1
    When I click element: fatih at index 1
    And I wait topkapi element 10 seconds at index 1
    When I click element: topkapi at index 1
    And I wait adres element 10 seconds at index 1
    Then I enter "Topkapı Sarayı, Has Oda Topkapı/Fatih/İstanbul" text to adres at index 1
    And I wait eposta element 10 seconds at index 1
    Then I enter "muhibbi@yahoo.com" text to eposta at index 1
    And I wait adresdevametbutton element 10 seconds at index 1
    When I click element: adresdevametbutton at index 1
    And I wait kuryebutton element 10 seconds at index 1
    When I click element: kuryebutton at index 1
    And I need to just wait


  @TEST-953025
  Scenario: Yarım Basvuru 1
    Given Open the https://efes.vodafone.com.tr/clicktodoor-mobil-dxl/ URL
    Then I see welcomePage page
    And I need to just wait
    And I wait Numarani Tasi element 10 seconds at index 1
    When I click element: Numarani Tasi at index 1
    Then I see tariffSelectionPage page
    And I wait tarife sec button element 10 seconds at index 1
    When I click element: tarife sec button at index 1
    And I need to just wait
    Then I see lineProcessesPage page
    And I wait tasimak istediginiz numara text area element 10 seconds at index 1
    Then I enter random telephone number to tasimak istediginiz numara text area at index 1
    And I wait tasinan numara gonder button element 10 seconds at index 1
    When I click element: tasinan numara gonder button at index 1
    And I wait tasima otp kod gonder button element 10 seconds at index 1
    Then I enter "1111" text to tasima otp kod gonder button at index 1
    And I wait tasima onayla ve devam et button element 10 seconds at index 1
    When I click element: tasima onayla ve devam et button at index 1
    And I need to just wait


  @TEST-953026
  Scenario: Yarım Basvuru 2
    Given Open the https://efes.vodafone.com.tr/clicktodoor-mobil-dxl/ URL
    Then I see welcomePage page
    And I need to just wait
    And I wait Numarani Tasi element 10 seconds at index 1
    When I click element: Numarani Tasi at index 1
    Then I see tariffSelectionPage page
    And I wait tarife sec button element 10 seconds at index 1
    When I click element: tarife sec button at index 1
    And I need to just wait
    Then I see lineProcessesPage page
    And I wait tasimak istediginiz numara text area element 10 seconds at index 1
    Then I enter random telephone number to tasimak istediginiz numara text area at index 1
    And I wait tasinan numara gonder button element 10 seconds at index 1
    When I click element: tasinan numara gonder button at index 1
    And I wait tasima otp kod gonder button element 10 seconds at index 1
    Then I enter "1111" text to tasima otp kod gonder button at index 1
    And I wait tasima onayla ve devam et button element 10 seconds at index 1
    When I click element: tasima onayla ve devam et button at index 1
    Then I see idInfoPage page
    And I wait ad element 10 seconds at index 1
    Then I enter "ALİ" text to ad at index 1
    And I wait soyad element 10 seconds at index 1
    Then I enter "ALİ" text to soyad at index 1
    And I wait tckn element 10 seconds at index 1
    Then I enter "58919081214" text to tckn at index 1
    And I wait babaadi element 10 seconds at index 1
    Then I enter "ALİ" text to babaadi at index 1
    And I wait dogum tarihi element 10 seconds at index 1
    Then I enter "03/03/1998" text to dogum tarihi at index 1
    And I wait kimlikbilgisidevametbutton element 10 seconds at index 1
    When I click element: kimlikbilgisidevametbutton at index 1


  @TEST-953027
  Scenario: Yarım Basvuru 2
    Given Open the https://efes.vodafone.com.tr/clicktodoor-mobil-dxl/ URL
    Then I see welcomePage page
    And I need to just wait
    And I wait Numarani Tasi element 10 seconds at index 1
    When I click element: Numarani Tasi at index 1
    Then I see tariffSelectionPage page
    And I wait tarife sec button element 10 seconds at index 1
    When I click element: tarife sec button at index 1
    And I need to just wait
    Then I see lineProcessesPage page
    And I wait tasimak istediginiz numara text area element 10 seconds at index 1
    Then I enter random telephone number to tasimak istediginiz numara text area at index 1
    And I wait tasinan numara gonder button element 10 seconds at index 1
    When I click element: tasinan numara gonder button at index 1
    And I wait tasima otp kod gonder button element 10 seconds at index 1
    Then I enter "1111" text to tasima otp kod gonder button at index 1
    And I wait tasima onayla ve devam et button element 10 seconds at index 1
    When I click element: tasima onayla ve devam et button at index 1
    Then I see idInfoPage page
    And I wait ad element 10 seconds at index 1
    Then I enter "ALİ" text to ad at index 1
    And I wait soyad element 10 seconds at index 1
    Then I enter "ALİ" text to soyad at index 1
    And I wait tckn element 10 seconds at index 1
    Then I enter "58919081214" text to tckn at index 1
    And I wait babaadi element 10 seconds at index 1
    Then I enter "ALİ" text to babaadi at index 1
    And I wait dogum tarihi element 10 seconds at index 1
    Then I enter "03/03/1998" text to dogum tarihi at index 1
    And I wait kimlikbilgisidevametbutton element 10 seconds at index 1
    When I click element: kimlikbilgisidevametbutton at index 1
    Then I see addressInfoPage page
    And I wait il element 10 seconds at index 1
    When I click element: il at index 1
    And I wait istanbul element 10 seconds at index 1
    When I click element: istanbul at index 1
    And I wait fatih element 10 seconds at index 1
    When I click element: fatih at index 1
    And I wait topkapi element 10 seconds at index 1
    When I click element: topkapi at index 1
    And I wait adres element 10 seconds at index 1
    Then I enter "Topkapı Sarayı, Has Oda Topkapı/Fatih/İstanbul" text to adres at index 1
    And I wait eposta element 10 seconds at index 1
    Then I enter "muhibbi@yahoo.com" text to eposta at index 1
    And I wait adresdevametbutton element 10 seconds at index 1
    When I click element: adresdevametbutton at index 1



