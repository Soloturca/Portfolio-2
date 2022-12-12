Feature: CBU_C2D

  #Laman
  @TEST-952954
  Scenario: Welcomepage
    Given Open the https://efes.vodafone.com.tr/clicktodoor-mobil-dxl/ URL
    Then I see welcomePage page
    #Then I have to verify the text for: welcome page text area at index 1
    Then I wait welcome page text area element 20 seconds at index 1

    #verify
    And I wait campaign with countdown element 20 seconds at index 1

    When I wait numarani tasi button element 20 seconds at index 1
    And I click element: numarani tasi button at index 1

    Then I see tariffSelectionPage page
    When I wait select tariff buttons element 20 seconds at index 1
    Then I click element: select tariff buttons at index 1
    Then I see lineProcessesPage page
    #verify
    Then I wait hattimi vodafonea tasi tab element 20 seconds at index 1
    When I go back
    Then I go back

    Then I see welcomePage page
    When I wait yeni faturali hat al button element 20 seconds at index 1
    Then I click element: yeni faturali hat al button at index 1
    Then I see tariffSelectionPage page
    When I wait select tariff buttons element 20 seconds at index 1
    Then I click element: select tariff buttons at index 1
    Then I see lineProcessesPage page
    #verify
    Then I wait yeni hat satin al tab element 20 seconds at index 1
    When I go back
    Then I go back

    When I see welcomePage page
    Then I wait campaigns in campaigns area element 20 seconds at index 1
    When I wait campaigns detaylari goster gizle button element 20 seconds at index 1
    Then I click element: campaigns detaylari goster gizle button at index 1
    Then I verify campaigns detaylari goster area exists at index 1
    Then I click element: campaigns detaylari goster gizle button at index 1
    Then I verify campaigns detaylari goster area notExists at index 1

    When I wait tarifeleri incele button element 20 seconds at index 1
    Then I click element: tarifeleri incele button at index 1
    Then I see tariffSelectionPage page
    #verify
    And I wait tarifeler area element 20 seconds at index 1
    When I go back

    Then I see welcomePage page
    Then I check number of elements for: SSS headers is 4
    Then I check dijitalden basvuru avantajlari sss and dijitalden basvuru avantajlari sss answer at SSS headers at index 1
    Then I check yeni numara almak sss and yeni numara almak sss answer at SSS headers at index 2
    Then I check numara tasimak sss and numara tasimak sss answer at SSS headers at index 3
    Then I check genel sss and genel sss answer at SSS headers at index 4

    When I wait star rating area element 20 seconds at index 1
    #verify
    Then I wait tariff in star rating area element 20 seconds at index 1
    When I wait sec button in star rating area element 20 seconds at index 1
    Then I click element: sec button in star rating area at index 1
    Then I see lineProcessesPage page
    #verify
    Then I wait hattimi vodafonea tasi tab element 20 seconds at index 1
    Then I go back
    When I see welcomePage page
    And I wait tarifeyi degerlendir button element 20 seconds at index 1
    Then I click element with action: tarifeyi degerlendir button at index 1
    When I wait stars in rating popup element 20 seconds at index 1
    Then I click element: stars in rating popup at index 1
    Then I need to just wait
    #verify
    Then I get the value of rating text area at index 1

    Then I need to just wait

  @TEST-952981
  Scenario: Tarifeler
    Given Open the https://efes.vodafone.com.tr/clicktodoor-mobil-dxl/ URL
    Then I see welcomePage page
    When I wait tarifeleri incele button element 20 seconds at index 1
    Then I click element: tarifeleri incele button at index 1
    Then I see tariffSelectionPage page
    #verify
    And I wait active road map element 20 seconds at index 1

    Then I wait vodafone logo element 20 seconds at index 1
    And I click element: vodafone logo at index 1
    Then I see welcomePage page
    #Then I have to verify the text for: welcome page text area at index 1
    Then I wait welcome page text area element 20 seconds at index 1

    #verify
    And I wait campaign with countdown element 20 seconds at index 1

    Then I click element: tarifeleri incele button at index 1
    Then I see tariffSelectionPage page
    #verify
    Then I wait tarifeler and 26 yas altina ozel tarifeler tabs element 20 seconds at index 1
    And I wait tarifeler and 26 yas altina ozel tarifeler tabs element 20 seconds at index 2
    #verify
    Then I wait tarifeler tabs element 20 seconds at index 2
    Then I wait tarifeler tabs element 20 seconds at index 3
    Then I wait tarifeler tabs element 20 seconds at index 4
    Then I check "tariffs" contains "RED" or "Red" in "tarifeler tabs" at index 2 for "tarifeler and 26 yas altina ozel tarifeler tabs" at index 1
    Then I check "tariffs" contains "UYUM" or "Uyum" in "tarifeler tabs" at index 3 for "tarifeler and 26 yas altina ozel tarifeler tabs" at index 1
    Then I check "tariffs" contains "SIMPLE" or "Simple" in "tarifeler tabs" at index 4 for "tarifeler and 26 yas altina ozel tarifeler tabs" at index 1
    Then I check "tariffs" contains "RED" or "Red" in "tarifeler tabs" at index 2 for "tarifeler and 26 yas altina ozel tarifeler tabs" at index 2
    Then I check "tariffs" contains "UYUM" or "Uyum" in "tarifeler tabs" at index 3 for "tarifeler and 26 yas altina ozel tarifeler tabs" at index 2
    Then I check "tariffs" contains "SIMPLE" or "Simple" in "tarifeler tabs" at index 4 for "tarifeler and 26 yas altina ozel tarifeler tabs" at index 2
    And I click element: tarifeler tabs at index 1
    Then I check tariffs in tarifeler tabs at index 1

    Then I click element: tarifeler tabs at index 2
    Then I click tariff tags at index 3 and check tariffs

    Then I click element: tarifeler tabs at index 1
    When I click element: detaylari goster button at index 1
    Then I wait details popup area element 20 seconds at index 1
    And I click element: kapat button at index 1
    When I click element: detaylari goster button at index 1
    Then I click element: tarifeyi sec button at index 1
    When I go back
    Then I click element: detaylari goster button at index 1
    Then I click element: popup close button at index 1

    When I click element: select tariff buttons at index 1
    Then I see lineProcessesPage page
    And I wait hattimi vodafonea tasi tab element 20 seconds at index 1

    When I go back
    Then I see tariffSelectionPage page
    When I click daha fazla goster button and check 6 tariffs added to tariffs


    Then I check number of elements for: SSS headers is 4
    Then I check dijitalden basvuru avantajlari sss and dijitalden basvuru avantajlari sss answer at SSS headers at index 1
    Then I check yeni numara almak sss and yeni numara almak sss answer at SSS headers at index 2
    Then I check numara tasimak sss and numara tasimak sss answer at SSS headers at index 3
    Then I check genel sss and genel sss answer at SSS headers at index 4

    When I click element: kullanim esaslari button at index 1
    Then I click element kullanim esaslari tariffs header and check kullanim esaslari tariffs details

    #Tobi adımı daha sonra eklenecek


    Then I need to just wait


  #Laman
  @TEST-953003
  Scenario: OTP Adımı
    Given Open the https://efes.vodafone.com.tr/clicktodoor-mobil-dxl/ URL
    Then I see welcomePage page
    When I wait numarani tasi button element 20 seconds at index 1
    And I click element: numarani tasi button at index 1
    Then I see tariffSelectionPage page
    When I wait select tariff buttons element 20 seconds at index 1
    Then I click element: select tariff buttons at index 1
    Then I see lineProcessesPage page
    Then I wait active road map element 20 seconds at index 1

    Then I wait vodafone logo element 20 seconds at index 1
    And I click element: vodafone logo at index 1
    Then I see welcomePage page
    Then I wait welcome page text area element 20 seconds at index 1
    Then I go back
    Then I see lineProcessesPage page

    When I wait number entry area element 20 seconds at index 1
    Then I check element: onay kodu gonder button is disabled
    And I enter "6577777778" text to number entry area at index 1
    Then I wait alert text area element 20 seconds at index 1
    Then I enter number entry area random telephone number to at index 1
    Then I check element: onay kodu gonder button is enabled

    When I click element: onay kodu gonder button at index 1
   #verify
    Then I wait kodu giriniz text area element 20 seconds at index 1
    Then I wait wrong number text area element 20 seconds at index 1
    And I click element: wrong number text area at index 1
    Then I enter number entry area random telephone number to at index 1
    When I click element: onay kodu gonder button at index 1
   #Then I need to wait for 180 seconds
   #Then I click element: tekrar gonder button at index 1
   #And I check element: onayla ve devam et button is disabled
    Then I need to just wait
    Then I enter "1111" text to onay kodu input area at index 1
    And I check element: onayla ve devam et button is enabled
    Then I click element: onayla ve devam et button at index 1
    Then I see idInfoPage page

    When I go back
    Then I see lineProcessesPage page
    And I click element: yeni hat satin al tab at index 1
    Then I wait yeni hat satin al options element 20 seconds at index 1
    Then I wait yeni hat satin al options element 20 seconds at index 2
    #When I click element: yeni hat satin al options at index 1
    Then I enter "1234567" text to 7 hane text area at index 1
    And I click element: ara button at index 1
    Then I wait active number area element 20 seconds at index 1
    Then I check number of elements for: numbers is 8
    And I check element: devam et button is enabled
    Then I click element: yeni hat satin al options at index 2
    Then I wait active number area element 20 seconds at index 1
    Then I check number of elements for: numbers is 8
    And I check element: devam et button is enabled
    Then I click element: devam et button at index 1
    Then I see lineProcessesPage page

    When I wait number entry area element 20 seconds at index 1
    Then I check element: onay kodu gonder button is disabled
    And I enter "6577777778" text to number entry area at index 1
  #Then I wait alert text area element 20 seconds at index 1
    Then I enter number entry area random telephone number to at index 1
    Then I check element: onay kodu gonder button is enabled
    When I click element: onay kodu gonder button at index 1
 #verify
    Then I wait kodu giriniz text area element 20 seconds at index 1
    Then I wait wrong number text area element 20 seconds at index 1
    And I click element: wrong number text area at index 1
    Then I enter number entry area random telephone number to at index 1
    When I click element: onay kodu gonder button at index 1
  #Then I need to wait for 180 seconds
  #Then I click element: tekrar gonder button at index 1
  #And I check element: onayla ve devam et button is disabled
    Then I need to just wait
    Then I enter "1111" text to onay kodu input area at index 1
    And I check element: onayla ve devam et button is enabled
    #Then I click element: onayla ve devam et button at index 1
    Then I see idInfoPage page

    When I go back
    Then I see lineProcessesPage page
    When I check number of elements for: basvuru ozeti areas is 3
    Then I wait tariff name text area element 20 seconds at index 2
    Then I wait tariff details text area element 20 seconds at index 1
    Then I wait degistir button element 20 seconds at index 1
    And I click element: degistir button at index 1
    Then I see tariffSelectionPage page
    Then I click element: select tariff buttons at index 2
    And I see lineProcessesPage page
    Then I wait tariff pay text area element 20 seconds at index 1
    Then I wait number text area element 20 seconds at index 2
    Then I wait degistir button element 20 seconds at index 2
    And I click element: degisir button at index 2
    Then I see lineProcessesPage page

    Then I need to just wait

  #Laman
  @TEST-953004
  Scenario: Kişisel Bilgiler
    Given Open the https://efes.vodafone.com.tr/clicktodoor-mobil-dxl/ URL
    Then I see welcomePage page
    When I wait numarani tasi button element 20 seconds at index 1
    And I click element: numarani tasi button at index 1
    Then I see tariffSelectionPage page
    When I wait select tariff buttons element 20 seconds at index 1
    Then I click element: select tariff buttons at index 1
    Then I see lineProcessesPage page
    Then I enter number entry area random telephone number to at index 1
    Then I get the text area information: number entry area at index 1
    When I click element: onay kodu gonder button at index 1
    Then I need to just wait
    Then I enter "1111" text to onay kodu input area at index 1
    Then I click element: onayla ve devam et button at index 1


    Then I wait active road map element 20 seconds at index 1

    Then I wait vodafone logo element 20 seconds at index 1
    And I click element: vodafone logo at index 1
    Then I see welcomePage page
    Then I go back

    When I see idInfoPage page
    Then I wait name input area element 20 seconds at index 1
    Then I wait surname input area element 20 seconds at index 1
    Then I wait tc input area element 20 seconds at index 1
    Then I wait father name input area element 20 seconds at index 1
    Then I wait birth date input area element 20 seconds at index 1
    Then I check element: devam et button is disabled
    Then I enter "Ali" text to name input area at index 1
    Then I enter "Ali" text to surname input area at index 1
    Then I enter "58919081214" text to tc input area at index 1
    Then I enter "Ali" text to father name input area at index 1
    Then I enter "03031998" text to birth date input area at index 1
    Then I check element: devam et button is enabled
    Then I enter "Ahmet" text to name input area at index 1
    And I click element: devam et button at index 1
    Then I wait error text area element 20 seconds at index 1
    Then I enter "Ali" text to name input area at index 1
    Then I enter "Ahmet" text to surname input area at index 1
    And I click element: devam et button at index 1
    Then I wait error text area element 20 seconds at index 1
    Then I enter "Ali" text to name input area at index 1
    Then I enter "Ali" text to surname input area at index 1
    Then I enter "Ahmet" text to father name input area at index 1
    And I click element: devam et button at index 1
    Then I wait error text area element 20 seconds at index 1
    Then I enter "Ali" text to name input area at index 1
    Then I enter "Ali" text to surname input area at index 1
    Then I enter "Ali" text to father name input area at index 1
    Then I enter "58919081212" text to tc input area at index 1
    And I click element: devam et button at index 1
    Then I wait alert text area element 20 seconds at index 1
    Then I enter "58919081214" text to tc input area at index 1
    Then I enter "03031999" text to birth date input area at index 1
    And I click element: devam et button at index 1
    Then I wait alert text area element 20 seconds at index 1
    Then I enter "03031998" text to birth date input area at index 1
    And I click element: devam et button at index 1

    Then I need to just wait
    When I go back
   #Then I enter value text to number entry area at index 1
   # When I click element: onay kodu gonder button at index 1
    Then I see idInfoPage page
    Then I wait line owner warning area element 20 seconds at index 1
    Then I wait no button element 20 seconds at index 1
    And I wait yes button element 20 seconds at index 1
    When I click element: yes button at index 1
    Then I see addressInfoPage page
    Then I go back
    Then I see idInfoPage page
    When I click element: no button at index 1
    Then I enter "Ali" text to name input area at index 1
    Then I enter "Ali" text to surname input area at index 1
    Then I enter "58919081214" text to tc input area at index 1
    Then I enter "Ali" text to father name input area at index 1
    Then I enter "03031998" text to birth date input area at index 1
    Then I click element: devam et button at index 1
    Then I need to just wait

    Then I go back
    When I see idInfoPage page
    And I click element: yes button at index 1
    When I check number of elements for: basvuru ozeti areas is 3
    Then I wait tariff name text area element 20 seconds at index 2
    Then I wait tariff details text area element 20 seconds at index 1
    Then I wait degistir button element 20 seconds at index 1
    And I click element: degistir button at index 1
    Then I see tariffSelectionPage page
    Then I click element: select tariff buttons at index 2
    And I see lineProcessesPage page
    Then I wait tariff pay text area element 20 seconds at index 1
    Then I wait number text area element 20 seconds at index 2
    Then I wait degistir button element 20 seconds at index 2
    And I click element: degisir button at index 2
    Then I see lineProcessesPage page

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
    Then I enter onaykodunumara text area random telephone number to at index 1
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
    Then I enter tasimak istediginiz numara text area random telephone number to at index 1
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
    Then I enter tasimak istediginiz numara text area random telephone number to at index 1
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
    Then I enter tasimak istediginiz numara text area random telephone number to at index 1
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



