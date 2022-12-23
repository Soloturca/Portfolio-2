Feature: CBU_C2D
@web
  #Laman
  @web
  Scenario: Welcomepage
    Given Open the https://efes.vodafone.com.tr/clicktodoor-mobil-dxl/ URL
    Then I see welcomePage page
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
    When I go back previous page
    Then I go back previous page

    Then I see welcomePage page
    When I wait yeni faturali hat al button element 20 seconds at index 1
    Then I click element: yeni faturali hat al button at index 1
    Then I see tariffSelectionPage page
    When I wait select tariff buttons element 20 seconds at index 1
    Then I click element: select tariff buttons at index 1
    Then I see lineProcessesPage page
  #verify
    Then I wait yeni hat satin al tab element 20 seconds at index 1
    When I go back previous page
    Then I go back previous page

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
    When I go back previous page

    Then I see welcomePage page
    Then I check number of elements for: SSS headers is 4
    Then I click element: SSS headers at index 1
    Then I check dijitalden basvuru avantajlari sss and dijitalden basvuru avantajlari sss answer
    Then I click element: SSS headers at index 2
    Then I check yeni numara almak sss and yeni numara almak sss answer
    Then I click element: SSS headers at index 3
    Then I check numara tasimak sss and numara tasimak sss answer
    Then I click element: SSS headers at index 4
    Then I check genel sss and genel sss answer


    When I wait star rating area element 20 seconds at index 1
    #verify
    Then I wait tariff in star rating area element 20 seconds at index 1
    When I wait sec button in star rating area element 20 seconds at index 1
    Then I click element: sec button in star rating area at index 1
    Then I see lineProcessesPage page
    #verify
    Then I wait hattimi vodafonea tasi tab element 20 seconds at index 1
    Then I go back previous page
    When I see welcomePage page
    And I wait tarifeyi degerlendir button element 20 seconds at index 1
    Then I click element: tarifeyi degerlendir button at index 1
    When I wait stars in rating popup element 20 seconds at index 1
    Then I click element: stars in rating popup at index 1
    Then I need to just wait
    #verify
    Then I get the value of rating text area at index 1

    Then I need to just wait

  @web
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
   #verify
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
    When I go back previous page
    Then I click element: detaylari goster button at index 1
    Then I click element: popup close button at index 1

    When I click element: select tariff buttons at index 1
    Then I see lineProcessesPage page
    And I wait hattimi vodafonea tasi tab element 20 seconds at index 1

    When I go back previous page
    Then I see tariffSelectionPage page
    When I click daha fazla goster button and check 6 tariffs added to tariffs

    Then I check number of elements for: SSS headers is 4
    Then I click element: SSS headers at index 1
    Then I check dijitalden basvuru avantajlari sss and dijitalden basvuru avantajlari sss answer
    Then I click element: SSS headers at index 2
    Then I check yeni numara almak sss and yeni numara almak sss answer
    Then I click element: SSS headers at index 3
    Then I check numara tasimak sss and numara tasimak sss answer
    Then I click element: SSS headers at index 4
    Then I check genel sss and genel sss answer

    When I click element with action: kullanim esaslari button at index 1
    Then I click element kullanim esaslari tariffs header and check kullanim esaslari tariffs details

    #Tobi adımı daha sonra eklenecek

    Then I need to just wait
    When I wait tarifeler and 26 yas altina ozel tarifeler tabs element 20 seconds at index 2
    Then I click element: tarifeler and 26 yas altina ozel tarifeler tabs at index 2
    When I wait select tariff buttons element 20 seconds at index 1
    Then I click element: select tariff buttons at index 1
    Then I see lineProcessesPage page
    Then I enter number entry area random telephone number to at index 1
    When I click element: onay kodu gonder button at index 1
    Then I wait onay kodu input area element 20 seconds at index 1
    Then I enter "1111" text to onay kodu input area at index 1
    Then I click element: onayla ve devam et button at index 1
    Then I see idInfoPage page
    Then I enter "Ali" text to name input area at index 1
    Then I enter "Ali" text to surname input area at index 1
    Then I enter "93122191176" text to tc input area at index 1
    Then I enter "Ali" text to father name input area at index 1
    Then I enter "16061991" text to birth date input area at index 1
    Then I click element: devam et button at index 1
    Then I need to just wait
    Then I wait warning text area element 20 seconds at index 1
    When I click element: gecebilecegim tarifeleri incele button at index 1
    Then I need to just wait
    Then I see tariffSelectionPage page
    Then I need to just wait
    Then I go back previous page
    Then I need to just wait
    Then I see idInfoPage page
    Then I enter "Ali" text to name input area at index 1
    Then I enter "Ali" text to surname input area at index 1
    Then I enter "93122191176" text to tc input area at index 1
    Then I enter "Ali" text to father name input area at index 1
    Then I enter "16061991" text to birth date input area at index 1
    Then I click element: devam et button at index 1
    Then I need to just wait
    When I click element: yeni hat sahibi tanimla button at index 1
    Then I wait yeni hat sahibi tanimla text area element 20 seconds at index 1
    And I wait yeni hat sahibi tanimla details text area element 20 seconds at index 1
    Then I enter "Ali" text to name input area at index 2
    Then I enter "Ali" text to surname input area at index 2
    Then I enter "58919081214" text to tc input area at index 2
    Then I enter "Ali" text to father name input area at index 2
    Then I enter "03031998" text to birth date input area at index 2
    Then I click element: devam et button at index 1
    Then I need to just wait
    Then I see deliveryPage page

    Then I need to just wait


  #Laman
  @web
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
    Then I go back previous page
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
    Then I need to wait for 180 seconds
    Then I click element: tekrar gonder button at index 1
    And I check element: onayla ve devam et button is disabled
    Then I need to just wait
    Then I enter "1111" text to onay kodu input area at index 1
    And I check element: onayla ve devam et button is enabled
    Then I click element: onayla ve devam et button at index 1
    Then I see idInfoPage page

    When I go back previous page
    Then I see lineProcessesPage page
    Then I wait yeni hat satin al tab element 20 seconds at index 1
    And I click element: yeni hat satin al tab at index 1
    Then I wait yeni hat satin al options element 20 seconds at index 1
    Then I wait yeni hat satin al options element 20 seconds at index 2
    When I click element: yeni hat satin al options at index 1
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
    Then I need to wait for 180 seconds
    Then I click element: tekrar gonder button at index 1
    And I check element: onayla ve devam et button is disabled
    Then I need to just wait
    Then I enter "1111" text to onay kodu input area at index 1
    And I check element: onayla ve devam et button is enabled

    When I check number of elements for: basvuru ozeti areas is 4
    Then I wait tariff name text area element 20 seconds at index 2
    Then I wait tariff details text area element 20 seconds at index 1
    Then I wait degistir button element 50 seconds at index 2
    And I click element: degistir button at index 2
    Then I see lineProcessesPage page
    Then I click element: numbers at index 2
    Then I click element: devam et button at index 1
    Then I wait tariff pay text area element 20 seconds at index 1
    Then I wait number text area element 20 seconds at index 2
    Then I wait basvuruya ozel text area element 20 seconds at index 1
    Then I wait degistir button element 20 seconds at index 1
    And I click element: degistir button at index 1
    Then I see tariffSelectionPage page
    Then I click element: select tariff buttons at index 2
    And I see lineProcessesPage page

    Then I need to just wait

  #Laman
  @web
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
    Then I go back previous page

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
    When I go back previous page
    Then I see idInfoPage page
    Then I wait line owner warning area element 20 seconds at index 1
    Then I wait no button element 20 seconds at index 1
    And I wait yes button element 20 seconds at index 1
    When I click element: yes button at index 1
    Then I see addressInfoPage page
    Then I go back previous page
    Then I see idInfoPage page
    When I click element: no button at index 1
    Then I enter "Ali" text to name input area at index 1
    Then I enter "Ali" text to surname input area at index 1
    Then I enter "58919081214" text to tc input area at index 1
    Then I enter "Ali" text to father name input area at index 1
    Then I enter "03031998" text to birth date input area at index 1

    When I check number of elements for: basvuru ozeti areas is 4
    Then I wait tariff name text area element 20 seconds at index 2
    Then I wait tariff details text area element 20 seconds at index 1
    Then I wait tariff pay text area element 20 seconds at index 1
    Then I wait number text area element 20 seconds at index 2
    Then I wait basvuruya ozel text area element 20 seconds at index 1
    Then I wait degistir button element 20 seconds at index 1
    And I click element: degistir button at index 1
    Then I see tariffSelectionPage page
    Then I click element: select tariff buttons at index 2
    And I see lineProcessesPage page

    #indirim kodu stepi daha sonra eklenecek

    Then I need to just wait




#Akif's Cases
  @web
  Scenario: Istenen Numarayla Magazaya Teslim NL Basvuru
    Given Open the https://efes.vodafone.com.tr/clicktodoor-mobil-dxl/ URL
    Then I see welcomePage page
    And I wait yeni faturali hat al button element 10 seconds at index 1
    When I click element: yeni faturali hat al button at index 1
    Then I see tariffSelectionPage page
    And I wait select tariff buttons element 10 seconds at index 1
    When I click element: select tariff buttons at index 1
    And I need to just wait
    Then I see lineProcessesPage page
    And I wait 7 hane text area element 10 seconds at index 1
    When I click element: 7 hane text area at index 1
    Then I enter "3333333" text to 7 hane text area at index 1
    And I wait ara button element 10 seconds at index 1
    When I click element: ara button at index 1
    And I wait devam et button element 10 seconds at index 1
    When I click element: devam et button at index 1
    And I wait number entry area element 10 seconds at index 1
    Then I enter number entry area random telephone number to at index 1
    And I wait onay kodu gonder button element 10 seconds at index 1
    When I click element: onay kodu gonder button at index 1
    And I wait onay kodu input area element 10 seconds at index 1
    Then I enter "1111" text to onay kodu input area at index 1
    And I wait onayla ve devam et button element 10 seconds at index 1
    When I click element: onayla ve devam et button at index 1
    Then I see idInfoPage page
#   And I wait bu kisi ile devam et button element 10 seconds at index 1
#   When I click element: bu kisi ile devam et button at index 1
#   Kimlik bilgileri sistemde kayıtlı. Kayıtlı kişi kullanılsın seçilip devam edildi. Kullanılan bilgiler aşağıdaki bilgilerdir.
    And I wait name input area element 10 seconds at index 1
    Then I enter "ALİ" text to name input area at index 1
    And I wait surname input area element 10 seconds at index 1
    Then I enter "ALİ" text to surname input area at index 1
    And I wait tc input area element 10 seconds at index 1
    Then I enter "58919081214" text to tc input area at index 1
    And I wait father name input area element 10 seconds at index 1
    Then I enter "ALİ" text to father name input area at index 1
    And I wait birth date input area element 10 seconds at index 1
    Then I enter "03/03/1998" text to birth date input area at index 1
    And I wait devam et button element 10 seconds at index 1
    When I click element: devam et button at index 1
    Then I see deliveryPage page
#   Dynamic il, ilce and mahalle selections from index numbers.
    And I wait il select area element 10 seconds at index 1
    When I click element: il select area at index 1
    And I wait all il selections element 10 seconds at index 81
    When I click element: all il selections at index 81
    And I wait ilce element 10 seconds at index 1
    When I click element: ilce at index 1
    And I wait all ilce selections element 10 seconds at index 1
    When I click element: all ilce selections at index 1
    And I wait mahalle element 10 seconds at index 1
    When I click element: mahalle at index 1
    And I wait all mahalle selections element 10 seconds at index 1
    When I click element: all mahalle selections at index 1
    And I wait adres element 10 seconds at index 1
    Then I enter "Topkapı Sarayı" text to adres at index 1
    And I wait eposta element 10 seconds at index 1
    Then I enter "muhibbi@yahoo.com" text to eposta at index 1
    And I wait adresdevametbutton element 10 seconds at index 1
    When I click element: adresdevametbutton at index 1
    And I wait kuryebutton element 10 seconds at index 1
    When I click element: kuryebutton at index 1
    And I need to just wait


  @web
  Scenario: Yarım Basvuru 1
    Given Open the https://efes.vodafone.com.tr/clicktodoor-mobil-dxl/ URL
    Then I see welcomePage page
    And I need to just wait
    And I wait numarani tasi button element 10 seconds at index 1
    When I click element: numarani tasi button at index 1
    Then I see tariffSelectionPage page
    And I wait select tariff buttons element 10 seconds at index 1
    When I click element: select tariff buttons at index 1
    And I need to just wait
    Then I see lineProcessesPage page
    And I wait number entry area element 10 seconds at index 1
    Then I enter number entry area random telephone number to at index 1
    And I wait onay kodu gonder button element 10 seconds at index 1
    When I click element: onay kodu gonder button at index 1
    And I wait onay kodu input area element 10 seconds at index 1
    Then I enter "1111" text to onay kodu input area at index 1
    And I wait onayla ve devam et button element 10 seconds at index 1
    When I click element: onayla ve devam et button at index 1
    And I need to just wait


  @web
  Scenario: Yarım Basvuru 2
    Given Open the https://efes.vodafone.com.tr/clicktodoor-mobil-dxl/ URL
    Then I see welcomePage page
    And I need to just wait
    And I wait numarani tasi button element 10 seconds at index 1
    When I click element: numarani tasi button at index 1
    Then I see tariffSelectionPage page
    And I wait select tariff buttons element 10 seconds at index 1
    When I click element: select tariff buttons at index 1
    And I need to just wait
    Then I see lineProcessesPage page
    And I wait number entry area element 10 seconds at index 1
    Then I enter number entry area random telephone number to at index 1
    And I wait onay kodu gonder button element 10 seconds at index 1
    When I click element: onay kodu gonder button at index 1
    And I wait onay kodu input area element 10 seconds at index 1
    Then I enter "1111" text to onay kodu input area at index 1
    And I wait onayla ve devam et button element 10 seconds at index 1
    When I click element: onayla ve devam et button at index 1
    Then I see idInfoPage page
    And I wait name input area element 10 seconds at index 1
    Then I enter "ALİ" text to name input area at index 1
    And I wait surname input area element 10 seconds at index 1
    Then I enter "ALİ" text to surname input area at index 1
    And I wait tc input area element 10 seconds at index 1
    Then I enter "58919081214" text to tc input area at index 1
    And I wait father name input area element 10 seconds at index 1
    Then I enter "ALİ" text to father name input area at index 1
    And I wait birth date input area element 10 seconds at index 1
    Then I enter "03/03/1998" text to birth date input area at index 1
    And I wait devam et button element 10 seconds at index 1
    When I click element: devam et button at index 1


  @web
  Scenario: Yarım Basvuru 3
    Given Open the https://efes.vodafone.com.tr/clicktodoor-mobil-dxl/ URL
    Then I see welcomePage page
    And I need to just wait
    And I wait numarani tasi button element 10 seconds at index 1
    When I click element: numarani tasi button at index 1
    Then I see tariffSelectionPage page
    And I wait select tariff buttons element 10 seconds at index 1
    When I click element: select tariff buttons at index 1
    And I need to just wait
    Then I see lineProcessesPage page
    And I wait number entry area element 10 seconds at index 1
    Then I enter number entry area random telephone number to at index 1
    And I wait onay kodu gonder button element 10 seconds at index 1
    When I click element: onay kodu gonder button at index 1
    And I wait onay kodu input area element 10 seconds at index 1
    Then I enter "1111" text to onay kodu input area at index 1
    And I wait onayla ve devam et button element 10 seconds at index 1
    When I click element: onayla ve devam et button at index 1
    Then I see idInfoPage page
    And I wait name input area element 10 seconds at index 1
    Then I enter "ALİ" text to name input area at index 1
    And I wait surname input area element 10 seconds at index 1
    Then I enter "ALİ" text to surname input area at index 1
    And I wait tc input area element 10 seconds at index 1
    Then I enter "58919081214" text to tc input area at index 1
    And I wait father name input area element 10 seconds at index 1
    Then I enter "ALİ" text to father name input area at index 1
    And I wait birth date input area element 10 seconds at index 1
    Then I enter "03/03/1998" text to birth date input area at index 1
    And I wait devam et button element 10 seconds at index 1
    When I click element: devam et button at index 1
    Then I see deliveryPage page
#   Dynamic il, ilce and mahalle selections from index numbers.
    And I wait il select area element 10 seconds at index 1
    When I click element: il select area at index 1
    And I wait all il selections element 10 seconds at index 81
    When I click element: all il selections at index 81
    And I wait ilce element 10 seconds at index 1
    When I click element: ilce at index 1
    And I wait all ilce selections element 10 seconds at index 1
    When I click element: all ilce selections at index 1
    And I wait mahalle element 10 seconds at index 1
    When I click element: mahalle at index 1
    And I wait all mahalle selections element 10 seconds at index 1
    When I click element: all mahalle selections at index 1
    And I wait adres element 10 seconds at index 1
    Then I enter "Topkapı Sarayı" text to adres at index 1
    And I wait eposta element 10 seconds at index 1
    Then I enter "muhibbi@yahoo.com" text to eposta at index 1
    And I wait adresdevametbutton element 10 seconds at index 1
    When I click element: adresdevametbutton at index 1


    #Batu
  @web
  Scenario: Ayni Adres MNP Basvuru
    Given Open the https://efes.vodafone.com.tr/clicktodoor-mobil-dxl/ URL
    Then I see welcomePage page
    And I wait numarani tasi button element 30 seconds at index 1
    Then I click element: numarani tasi button at index 1
    Then I see tariffSelectionPage page
    And I wait select tariff buttons element 30 seconds at index 1
    Then I click element: select tariff buttons at index 1

    Then I see lineProcessesPage page
    Then I need to just wait
    Then I enter number entry area random telephone number to at index 1
    Then I click element: onay kodu gonder button at index 1
    And I wait onay kodu input area element 30 seconds at index 1
    Then I click element: onay kodu input area at index 1
    Then I enter "1111" text to onay kodu input area at index 1
    And I wait onayla ve devam et button element 30 seconds at index 1
    Then I click element: onayla ve devam et button at index 1
    Then I need to just wait

    Then I see idInfoPage page
    Then I click element: name input area at index 1
    Then I enter "ALİ" text to name input area at index 1
    Then I click element: surname input area at index 1
    Then I enter "ALİ" text to surname input area at index 1
    Then I click element: tc input area at index 1
    Then I enter "58919081214" text to tc input area at index 1
    Then I click element: father name input area at index 1
    Then I enter "ALİ" text to father name input area at index 1
    Then I click element: birth date input area at index 1
    Then I enter "03031998" text to birth date input area at index 1
    And I wait devam et button element 30 seconds at index 1
    Then I click element: devam et button at index 1
    Then I need to just wait

    Then I see addressInfoPage page
    And I wait delivery selection element 15 seconds at index 1
    #deliveryAddress
#   Dynamic il, ilce and mahalle selections from index numbers.
    And I wait il select area element 10 seconds at index 1
    When I click element: il select area at index 1
    And I wait all il selections element 10 seconds at index 81
    When I click element: all il selections at index 81
    And I wait ilce element 10 seconds at index 1
    When I click element: ilce at index 1
    And I wait all ilce selections element 10 seconds at index 1
    When I click element: all ilce selections at index 1
    And I wait mahalle element 10 seconds at index 1
    When I click element: mahalle at index 1
    And I wait all mahalle selections element 10 seconds at index 1
    When I click element: all mahalle selections at index 1
    Then I enter "AddressDelivery" text to deliveryaddressTextArea at index 1
    Then I enter "vf@vf.com" text to emailTextArea at index 1
    And I wait address information continue button element 30 seconds at index 1
    Then I click element: address information continue button at index 1

    Then I see deliveryPage page
    And I wait confirmationQuestionTextArea element 30 seconds at index 1

  #Batu
  @web
  Scenario: Farkli Adres MNP Basvuru
    Given Open the https://efes.vodafone.com.tr/clicktodoor-mobil-dxl/ URL
    Then I see welcomePage page
    And I wait numarani tasi button element 30 seconds at index 1
    Then I click element: numarani tasi button at index 1
    Then I see tariffSelectionPage page
    And I wait select tariff buttons element 30 seconds at index 1
    Then I click element: select tariff buttons at index 1

    Then I see lineProcessesPage page
    Then I need to just wait
    Then I enter number entry area random telephone number to at index 1
    Then I click element: onay kodu gonder button at index 1
    And I wait onay kodu input area element 30 seconds at index 1
    Then I click element: onay kodu input area at index 1
    Then I enter "1111" text to onay kodu input area at index 1
    And I wait onayla ve devam et button element 30 seconds at index 1
    Then I click element: onayla ve devam et button at index 1
    Then I need to just wait

    Then I see idInfoPage page
    Then I click element: name input area at index 1
    Then I enter "ALİ" text to name input area at index 1
    Then I click element: surname input area at index 1
    Then I enter "ALİ" text to surname input area at index 1
    Then I click element: tc input area at index 1
    Then I enter "58919081214" text to tc input area at index 1
    Then I click element: father name input area at index 1
    Then I enter "ALİ" text to father name input area at index 1
    Then I click element: birth date input area at index 1
    Then I enter "03031998" text to birth date input area at index 1
    And I wait devam et button element 30 seconds at index 1
    Then I click element: devam et button at index 1
    Then I need to just wait

    Then I see addressInfoPage page
    And I wait delivery selection element 15 seconds at index 1
    Then I click element: different address checkbox at index 1

    #deliveryAddress
#   Dynamic il, ilce and mahalle selections from index numbers.
    And I wait il select area element 10 seconds at index 1
    When I click element: il select area at index 1
    And I wait all il selections element 10 seconds at index 81
    When I click element: all il selections at index 81
    And I wait ilce element 10 seconds at index 1
    When I click element: ilce at index 1
    And I wait all ilce selections element 10 seconds at index 1
    When I click element: all ilce selections at index 1
    And I wait mahalle element 10 seconds at index 1
    When I click element: mahalle at index 1
    And I wait all mahalle selections element 10 seconds at index 1
    When I click element: all mahalle selections at index 1
    Then I enter "AddressDelivery" text to deliveryaddressTextArea at index 1
    #BillingAddress
#   Dynamic il, ilce and mahalle selections from index numbers.
    And I wait bill il select area element 10 seconds at index 1
    When I click element: bill il select area at index 1
    And I wait bill all il selections element 10 seconds at index 81
    When I click element: bill all il selections at index 81
    And I wait bill ilce element 10 seconds at index 1
    When I click element: bill ilce at index 1
    And I wait bill all ilce selections element 10 seconds at index 1
    When I click element: bill all ilce selections at index 1
    And I wait bill mahalle element 10 seconds at index 1
    When I click element: bill mahalle at index 1
    And I wait bill all mahalle selections element 10 seconds at index 1
    When I click element: bill all mahalle selections at index 1
    Then I enter "AddressBilling" text to billingaddressTextArea at index 1
    Then I enter "vf@vf.com" text to emailTextArea at index 1
    And I wait address information continue button element 30 seconds at index 1
    Then I click element: address information continue button at index 1

    Then I see deliveryPage page
    And I wait confirmationQuestionTextArea element 30 seconds at index 1


  #Batu
  @web
  Scenario: Magazadan Al MNP Basvuru
    Given Open the https://efes.vodafone.com.tr/clicktodoor-mobil-dxl/ URL
    Then I see welcomePage page
    And I wait numarani tasi button element 30 seconds at index 1
    Then I click element: numarani tasi button at index 1
    Then I see tariffSelectionPage page
    And I wait select tariff buttons element 30 seconds at index 1
    Then I click element: select tariff buttons at index 1

    Then I see lineProcessesPage page
    Then I need to just wait
    Then I enter number entry area random telephone number to at index 1
    Then I click element: onay kodu gonder button at index 1
    And I wait onay kodu input area element 30 seconds at index 1
    Then I click element: onay kodu input area at index 1
    Then I enter "1111" text to onay kodu input area at index 1
    And I wait onayla ve devam et button element 30 seconds at index 1
    Then I click element: onayla ve devam et button at index 1
    Then I need to just wait

    Then I see idInfoPage page
    Then I click element: name input area at index 1
    Then I enter "ALİ" text to name input area at index 1
    Then I click element: surname input area at index 1
    Then I enter "ALİ" text to surname input area at index 1
    Then I click element: tc input area at index 1
    Then I enter "58919081214" text to tc input area at index 1
    Then I click element: father name input area at index 1
    Then I enter "ALİ" text to father name input area at index 1
    Then I click element: birth date input area at index 1
    Then I enter "03031998" text to birth date input area at index 1
    And I wait devam et button element 30 seconds at index 1
    Then I click element: devam et button at index 1
    Then I need to just wait

    Then I see addressInfoPage page
    And I wait delivery selection element 15 seconds at index 1
    Then I click element: buy from shopping center area at index 1
    #BillingAddress
#   Dynamic il, ilce and mahalle selections from index numbers.
    And I wait bill il select area element 10 seconds at index 1
    When I click element: bill il select area at index 1
    And I wait bill all il selections element 10 seconds at index 81
    When I click element: bill all il selections at index 81
    And I wait bill ilce element 10 seconds at index 1
    When I click element: bill ilce at index 1
    And I wait bill all ilce selections element 10 seconds at index 1
    When I click element: bill all ilce selections at index 1
    And I wait bill mahalle element 10 seconds at index 1
    When I click element: bill mahalle at index 1
    And I wait bill all mahalle selections element 10 seconds at index 1
    When I click element: bill all mahalle selections at index 1
    Then I enter "AddressBilling" text to billingaddressTextArea at index 1
    Then I enter "vf@vf.com" text to emailTextArea at index 1
    And I wait address information continue button element 30 seconds at index 1
    Then I click element: address information continue button at index 1

    Then I see deliveryPage page
    And I wait confirmationSuccessfullyTextArea element 30 seconds at index 1

  #Batu
  @web
  Scenario: Rastgele Numarayla Adrese Teslim NL Basvuru
    Given Open the https://efes.vodafone.com.tr/clicktodoor-mobil-dxl/ URL
    Then I see welcomePage page
    Then I need to just wait
    And I wait yeni faturali hat al button element 30 seconds at index 1
    Then I click element: yeni faturali hat al button at index 1
    Then I see tariffSelectionPage page
    And I wait select tariff buttons element 30 seconds at index 1
    Then I click element: select tariff buttons at index 1
    Then I see lineProcessesPage page
    Then I need to just wait
    Then I click element: yeni hat satin al options at index 2
    Then I click element: continue button at index 1
    Then I enter number entry area random telephone number to at index 1
    Then I click element: onay kodu gonder button at index 1
    And I wait onay kodu input area element 30 seconds at index 1
    Then I click element: onay kodu input area at index 1
    Then I enter "1111" text to onay kodu input area at index 1
    And I wait onayla ve devam et button element 30 seconds at index 1
    Then I click element: onayla ve devam et button at index 1
    Then I need to just wait

    Then I see idInfoPage page
    Then I click element: name input area at index 1
    Then I enter "ALİ" text to name input area at index 1
    Then I click element: surname input area at index 1
    Then I enter "ALİ" text to surname input area at index 1
    Then I click element: tc input area at index 1
    Then I enter "58919081214" text to tc input area at index 1
    Then I click element: father name input area at index 1
    Then I enter "ALİ" text to father name input area at index 1
    Then I click element: birth date input area at index 1
    Then I enter "03031998" text to birth date input area at index 1
    And I wait devam et button element 30 seconds at index 1
    Then I click element: devam et button at index 1
    Then I need to just wait

    Then I see addressInfoPage page
    And I wait delivery selection element 15 seconds at index 1
    #deliveryAddress
#   Dynamic il, ilce and mahalle selections from index numbers.
    And I wait il select area element 10 seconds at index 1
    When I click element: il select area at index 1
    And I wait all il selections element 10 seconds at index 81
    When I click element: all il selections at index 81
    And I wait ilce element 10 seconds at index 1
    When I click element: ilce at index 1
    And I wait all ilce selections element 10 seconds at index 1
    When I click element: all ilce selections at index 1
    And I wait mahalle element 10 seconds at index 1
    When I click element: mahalle at index 1
    And I wait all mahalle selections element 10 seconds at index 1
    When I click element: all mahalle selections at index 1
    Then I enter "AddressDelivery" text to deliveryaddressTextArea at index 1
    Then I enter "vf@vf.com" text to emailTextArea at index 1
    And I wait address information continue button element 30 seconds at index 1
    Then I click element: address information continue button at index 1

    Then I see deliveryPage page
    And I wait confirmationQuestionTextArea element 30 seconds at index 1


     #Beyza
  @web
  Scenario: Rastgele Numarayla Farklı Adrese Teslim NL Başvuru
    Given Open the https://efes.vodafone.com.tr/clicktodoor-mobil-dxl/ URL
    Then I see welcomePage page
    Then I need to just wait
    And I wait yeni faturali hat al button element 30 seconds at index 1
    Then I click element: yeni faturali hat al button at index 1
    Then I see tariffSelectionPage page
    And I wait select tariff buttons element 30 seconds at index 1
    Then I click element: select tariff buttons at index 1
    Then I see lineProcessesPage page
    Then I need to just wait
    Then I click element: yeni hat satin al options at index 2
    Then I click element: continue button at index 1
    And I wait number entry area element 30 seconds at index 1
    Then I click element: number entry area at index 1
    Then I enter number entry area random telephone number to at index 1
    Then I click element: onay kodu gonder button at index 1
    And I wait onay kodu input area element 30 seconds at index 1
    Then I click element: onay kodu input area at index 1
    Then I enter "1111" text to onay kodu input area at index 1
    And I wait onayla ve devam et button element 30 seconds at index 1
    Then I click element: onayla ve devam et button at index 1
    Then I need to just wait
    Then I see idInfoPage page
    Then I click element: name input area at index 1
    Then I enter "ALİ" text to name input area at index 1
    Then I click element: surname input area at index 1
    Then I enter "ALİ" text to surname input area at index 1
    Then I click element: tc input area at index 1
    Then I enter "58919081214" text to tc input area at index 1
    Then I click element: father name input area at index 1
    Then I enter "ALİ" text to father name input area at index 1
    Then I click element: birth date input area at index 1
    Then I enter "03031998" text to birth date input area at index 1
    And I wait devam et button element 30 seconds at index 1
    Then I click element: devam et button at index 1
    Then I need to just wait
    Then I see addressInfoPage page
    And I wait delivery address element 15 seconds at index 1
#   Dynamic il, ilce and mahalle selections from index numbers.
    And I wait il select area element 10 seconds at index 1
    When I click element: il select area at index 1
    And I wait all il selections element 10 seconds at index 81
    When I click element: all il selections at index 81
    And I wait ilce element 10 seconds at index 1
    When I click element: ilce at index 1
    And I wait all ilce selections element 10 seconds at index 1
    When I click element: all ilce selections at index 1
    And I wait mahalle element 10 seconds at index 1
    When I click element: mahalle at index 1
    And I wait all mahalle selections element 10 seconds at index 1
    When I click element: all mahalle selections at index 1
    Then I click element: address input at index 1
    Then I enter "TEST" text to address input at index 1
    And I wait same address checkbox element 30 seconds at index 1
    Then I click element: same address checkbox at index 1
    Then I need to just wait
#   Dynamic il, ilce and mahalle selections from index numbers.
    And I wait bill il select area element 10 seconds at index 1
    When I click element: bill il select area at index 1
    And I wait bill all il selections element 10 seconds at index 81
    When I click element: bill all il selections at index 81
    And I wait bill ilce element 10 seconds at index 1
    When I click element: bill ilce at index 1
    And I wait bill all ilce selections element 10 seconds at index 1
    When I click element: bill all ilce selections at index 1
    And I wait bill mahalle element 10 seconds at index 1
    When I click element: bill mahalle at index 1
    And I wait bill all mahalle selections element 10 seconds at index 1
    When I click element: bill all mahalle selections at index 1
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
    #   Dynamic il, ilce and mahalle selections from index numbers.
    And I wait il select area element 10 seconds at index 1
    When I click element: il select area at index 1
    And I wait all il selections element 10 seconds at index 81
    When I click element: all il selections at index 81
    And I wait ilce element 10 seconds at index 1
    When I click element: ilce at index 1
    And I wait all ilce selections element 10 seconds at index 1
    When I click element: all ilce selections at index 1
    And I wait mahalle element 10 seconds at index 1
    When I click element: mahalle at index 1
    And I wait all mahalle selections element 10 seconds at index 1
    When I click element: all mahalle selections at index 1
    Then I click element: address input at index 1
    Then I enter "TEST" text to address input at index 1
    And I wait same address checkbox element 30 seconds at index 1
    Then I click element: same address checkbox at index 1
    Then I need to just wait
    #   Dynamic il, ilce and mahalle selections from index numbers.
    And I wait bill il select area element 10 seconds at index 1
    When I click element: bill il select area at index 1
    And I wait bill all il selections element 10 seconds at index 81
    When I click element: bill all il selections at index 81
    And I wait bill ilce element 10 seconds at index 1
    When I click element: bill ilce at index 1
    And I wait bill all ilce selections element 10 seconds at index 1
    When I click element: bill all ilce selections at index 1
    And I wait bill mahalle element 10 seconds at index 1
    When I click element: bill mahalle at index 1
    And I wait bill all mahalle selections element 10 seconds at index 1
    When I click element: bill all mahalle selections at index 1
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
  @web
  Scenario: Rastgele Numarayla Mağazaya Teslim NL Başvuru
    Given Open the https://efes.vodafone.com.tr/clicktodoor-mobil-dxl/ URL
    Then I see welcomePage page
    Then I need to just wait
    And I wait yeni faturali hat al button element 30 seconds at index 1
    Then I click element: yeni faturali hat al button at index 1
    Then I see tariffSelectionPage page
    And I wait select tariff buttons element 30 seconds at index 1
    Then I click element: select tariff buttons at index 1
    Then I see lineProcessesPage page
    Then I need to just wait
    Then I click element: yeni hat satin al options at index 2
    Then I click element: devam et button at index 1
    And I wait number entry area element 30 seconds at index 1
    Then I click element: number entry area at index 1
    Then I enter number entry area random telephone number to at index 1
    Then I click element: onay kodu gonder button at index 1
    And I wait onay kodu input area element 30 seconds at index 1
    Then I click element: onay kodu input area at index 1
    Then I enter "1111" text to onay kodu input area at index 1
    And I wait onayla ve devam et button element 30 seconds at index 1
    Then I click element: onayla ve devam et button at index 1
    Then I need to just wait
    Then I see idInfoPage page
    Then I click element: name input area at index 1
    Then I enter "ALİ" text to name input area at index 1
    Then I click element: surname input area at index 1
    Then I enter "ALİ" text to surname input area at index 1
    Then I click element: tc input area at index 1
    Then I enter "58919081214" text to tc input area at index 1
    Then I click element: father name input area at index 1
    Then I enter "ALİ" text to father name input area at index 1
    Then I click element: birth date input area at index 1
    Then I enter "03031998" text to birth date input area at index 1
    And I wait devam et button element 30 seconds at index 1
    Then I click element: devam et button at index 1
    Then I need to just wait
    Then I see addressInfoPage page
    And I wait delivery selection element 15 seconds at index 1
    And I wait buy in store button element 30 seconds at index 1
    Then I click element: buy in store button at index 1
    And I wait bill address element 30 seconds at index 1
     #   Dynamic il, ilce and mahalle selections from index numbers.
    And I wait bill il select area element 10 seconds at index 1
    When I click element: bill il select area at index 1
    And I wait bill all il selections element 10 seconds at index 81
    When I click element: bill all il selections at index 81
    And I wait bill ilce element 10 seconds at index 1
    When I click element: bill ilce at index 1
    And I wait bill all ilce selections element 10 seconds at index 1
    When I click element: bill all ilce selections at index 1
    And I wait bill mahalle element 10 seconds at index 1
    When I click element: bill mahalle at index 1
    And I wait bill all mahalle selections element 10 seconds at index 1
    When I click element: bill all mahalle selections at index 1
    And I wait bill address input element 30 seconds at index 1
    Then I enter "BILL TEST" text to bill address input at index 1
    And I wait mail input element 30 seconds at index 1
    Then I click element: mail input at index 1
    Then I enter "test@hotmail.com" text to mail input at index 1
    Then I click element: address continue button at index 1
    Then I need to just wait
    And I wait continue with courier element 30 seconds at index 1

  #Beyza
  @web
  Scenario: İstenen Numarayla Adrese Teslim NL Başvuru
    Given Open the https://efes.vodafone.com.tr/clicktodoor-mobil-dxl/ URL
    Then I see welcomePage page
    Then I need to just wait
    And I wait yeni faturali hat al button element 30 seconds at index 1
    Then I click element: yeni faturali hat al button at index 1
    Then I see tariffSelectionPage page
    And I wait select tariff buttons element 30 seconds at index 1
    Then I click element: select tariff buttons at index 1
    Then I see lineProcessesPage page
    Then I need to just wait
    Then I click element: yeni hat satin al options at index 1
    And I wait 7 hane text area element 30 seconds at index 1
    Then I click element: 7 hane text area at index 1
    Then I enter 7 hane text area random seven digits to at index 1
    Then I click element: ara button at index 1
    Then I click element: devam et button at index 1
    And I wait number entry area element 30 seconds at index 1
    Then I click element: number entry area at index 1
    Then I enter number entry area random telephone number to at index 1
    Then I click element: onay kodu gonder button at index 1
    And I wait onay kodu input area element 30 seconds at index 1
    Then I click element: onay kodu input area at index 1
    Then I enter "1111" text to onay kodu input area at index 1
    And I wait onayla ve devam et button element 30 seconds at index 1
    Then I click element: onayla ve devam et button at index 1
    Then I need to just wait
    Then I see idInfoPage page
    Then I click element: name input area at index 1
    Then I enter "ALİ" text to name input area at index 1
    Then I click element: surname input area at index 1
    Then I enter "ALİ" text to surname input area at index 1
    Then I click element: tc input area at index 1
    Then I enter "58919081214" text to tc input area at index 1
    Then I click element: father name input area at index 1
    Then I enter "ALİ" text to father name input area at index 1
    Then I click element: birth date input area at index 1
    Then I enter "03031998" text to birth date input area at index 1
    And I wait devam et button element 30 seconds at index 1
    Then I click element: devam et button at index 1
    Then I need to just wait
    Then I see addressInfoPage page
    And I wait delivery address element 15 seconds at index 1
    #   Dynamic il, ilce and mahalle selections from index numbers.
    And I wait il select area element 10 seconds at index 1
    When I click element: il select area at index 1
    And I wait all il selections element 10 seconds at index 81
    When I click element: all il selections at index 81
    And I wait ilce element 10 seconds at index 1
    When I click element: ilce at index 1
    And I wait all ilce selections element 10 seconds at index 1
    When I click element: all ilce selections at index 1
    And I wait mahalle element 10 seconds at index 1
    When I click element: mahalle at index 1
    And I wait all mahalle selections element 10 seconds at index 1
    When I click element: all mahalle selections at index 1
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
    #   Dynamic il, ilce and mahalle selections from index numbers.
    And I wait il select area element 10 seconds at index 1
    When I click element: il select area at index 1
    And I wait all il selections element 10 seconds at index 81
    When I click element: all il selections at index 81
    And I wait ilce element 10 seconds at index 1
    When I click element: ilce at index 1
    And I wait all ilce selections element 10 seconds at index 1
    When I click element: all ilce selections at index 1
    And I wait mahalle element 10 seconds at index 1
    When I click element: mahalle at index 1
    And I wait all mahalle selections element 10 seconds at index 1
    When I click element: all mahalle selections at index 1
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

     #Beyza
  @web
  Scenario: İstenen Numarayla Farklı Adrese Teslim NL Başvuru
    Given Open the https://efes.vodafone.com.tr/clicktodoor-mobil-dxl/ URL
    Then I see welcomePage page
    Then I need to just wait
    And I wait yeni faturali hat al button element 30 seconds at index 1
    Then I click element: yeni faturali hat al button at index 1
    Then I see tariffSelectionPage page
    And I wait select tariff buttons element 30 seconds at index 1
    Then I click element: select tariff buttons at index 1
    Then I see lineProcessesPage page
    Then I need to just wait
    Then I click element: yeni hat satin al options at index 1
    And I wait 7 hane text area element 30 seconds at index 1
    Then I click element: 7 hane text area at index 1
    Then I enter 7 hane text area random seven digits to at index 1
    Then I click element: ara button at index 1
    Then I click element: devam et button at index 1
    And I wait number entry area element 30 seconds at index 1
    Then I click element: number entry area at index 1
    Then I enter number entry area random telephone number to at index 1
    Then I click element: onay kodu gonder button at index 1
    And I wait onay kodu input area element 30 seconds at index 1
    Then I click element: onay kodu input area at index 1
    Then I enter "1111" text to onay kodu input area at index 1
    And I wait onayla ve devam et button element 30 seconds at index 1
    Then I click element: onayla ve devam et button at index 1
    Then I need to just wait
    Then I see idInfoPage page
    Then I click element: name input area at index 1
    Then I enter "ALİ" text to name input area at index 1
    Then I click element: surname input area at index 1
    Then I enter "ALİ" text to surname input area at index 1
    Then I click element: tc input area at index 1
    Then I enter "58919081214" text to tc input area at index 1
    Then I click element: father name input area at index 1
    Then I enter "ALİ" text to father name input area at index 1
    Then I click element: birth date input area at index 1
    Then I enter "03031998" text to birth date input area at index 1
    And I wait devam et button element 30 seconds at index 1
    Then I click element: devam et button at index 1
    Then I need to just wait
    Then I see addressInfoPage page
    And I wait delivery address element 15 seconds at index 1
    #   Dynamic il, ilce and mahalle selections from index numbers.
    And I wait il select area element 10 seconds at index 1
    When I click element: il select area at index 1
    And I wait all il selections element 10 seconds at index 81
    When I click element: all il selections at index 81
    And I wait ilce element 10 seconds at index 1
    When I click element: ilce at index 1
    And I wait all ilce selections element 10 seconds at index 1
    When I click element: all ilce selections at index 1
    And I wait mahalle element 10 seconds at index 1
    When I click element: mahalle at index 1
    And I wait all mahalle selections element 10 seconds at index 1
    When I click element: all mahalle selections at index 1
    Then I click element: address input at index 1
    Then I enter "TEST" text to address input at index 1
    And I wait same address checkbox element 30 seconds at index 1
    Then I click element: same address checkbox at index 1
    Then I need to just wait
    #   Dynamic il, ilce and mahalle selections from index numbers.
    And I wait bill il select area element 10 seconds at index 1
    When I click element: bill il select area at index 1
    And I wait bill all il selections element 10 seconds at index 81
    When I click element: bill all il selections at index 81
    And I wait bill ilce element 10 seconds at index 1
    When I click element: bill ilce at index 1
    And I wait bill all ilce selections element 10 seconds at index 1
    When I click element: bill all ilce selections at index 1
    And I wait bill mahalle element 10 seconds at index 1
    When I click element: bill mahalle at index 1
    And I wait bill all mahalle selections element 10 seconds at index 1
    When I click element: bill all mahalle selections at index 1
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
    #   Dynamic il, ilce and mahalle selections from index numbers.
    And I wait il select area element 10 seconds at index 1
    When I click element: il select area at index 1
    And I wait all il selections element 10 seconds at index 81
    When I click element: all il selections at index 81
    And I wait ilce element 10 seconds at index 1
    When I click element: ilce at index 1
    And I wait all ilce selections element 10 seconds at index 1
    When I click element: all ilce selections at index 1
    And I wait mahalle element 10 seconds at index 1
    When I click element: mahalle at index 1
    And I wait all mahalle selections element 10 seconds at index 1
    When I click element: all mahalle selections at index 1
    Then I click element: address input at index 1
    Then I enter "TEST" text to address input at index 1
    And I wait same address checkbox element 30 seconds at index 1
    Then I click element: same address checkbox at index 1
    Then I need to just wait
    #   Dynamic il, ilce and mahalle selections from index numbers.
    And I wait bill il select area element 10 seconds at index 1
    When I click element: bill il select area at index 1
    And I wait bill all il selections element 10 seconds at index 81
    When I click element: bill all il selections at index 81
    And I wait bill ilce element 10 seconds at index 1
    When I click element: bill ilce at index 1
    And I wait bill all ilce selections element 10 seconds at index 1
    When I click element: bill all ilce selections at index 1
    And I wait bill mahalle element 10 seconds at index 1
    When I click element: bill mahalle at index 1
    And I wait bill all mahalle selections element 10 seconds at index 1
    When I click element: bill all mahalle selections at index 1
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

#  mvn clean -Dtestname="web" test
  @web
  Scenario: Adres Bilgisi
    Given Open the https://efes.vodafone.com.tr/clicktodoor-mobil-dxl/ URL
    Then I see welcomePage page
    And I wait yeni faturali hat al button element 10 seconds at index 1
    When I click element: yeni faturali hat al button at index 1
    Then I see tariffSelectionPage page
    And I wait select tariff buttons element 10 seconds at index 1
    When I click element: select tariff buttons at index 1
    And I need to just wait
    Then I see lineProcessesPage page
    And I wait number entry area element 10 seconds at index 1
    When I click element: number entry area at index 1
    Then I enter "3333333" text to number entry area at index 1
    And I wait ara button element 10 seconds at index 1
    When I click element: ara button at index 1
    And I wait devam et button element 10 seconds at index 1
    When I click element: devam et button at index 1
    And I wait onay kodu input area element 10 seconds at index 1
    Then I enter onay kodu input area random telephone number to at index 1
    And I wait onay kodu gonder button element 10 seconds at index 1
    When I click element: onay kodu gonder button at index 1
    And I wait onay kodu input area element 10 seconds at index 1
    Then I enter "1111" text to onay kodu input area at index 1
    And I wait onayla ve devam et button element 10 seconds at index 1
    When I click element: onayla ve devam et button at index 1
    Then I need to just wait
    Then I see idInfoPage page
    And I wait name input area element 10 seconds at index 1
    Then I need to just wait
    Then I enter "ALİ" text to name input area at index 1
    And I wait surname input area element 10 seconds at index 1
    Then I enter "ALİ" text to surname input area at index 1
    And I wait tc input area element 10 seconds at index 1
    Then I enter "58919081214" text to tc input area at index 1
    And I wait father name input area element 10 seconds at index 1
    Then I enter "ALİ" text to father name input area at index 1
    And I wait birth date input area element 10 seconds at index 1
    Then I enter "03/03/1998" text to birth date input area at index 1
    And I wait devam et button element 10 seconds at index 1
    When I click element: devam et button at index 1
    And I need to just wait
    Then I see deliveryPage page
    Then I wait active road map element 20 seconds at index 1
    Then I wait vodafone logo element 20 seconds at index 1
    And I wait Adresime gelsin button active element 10 seconds at index 1
    And I wait Adres text area element 10 seconds at index 1
    And I wait il select area element 10 seconds at index 1
    And I wait ilce element 10 seconds at index 1
    And I wait mahalle element 10 seconds at index 1
    And I wait eposta element 10 seconds at index 1
    Then I check element: Devam et button is disabled
#   Dynamic il, ilce and mahalle selections from index numbers.
    And I wait il select area element 10 seconds at index 1
    When I click element: il select area at index 1
    And I wait all il selections element 10 seconds at index 81
    When I click element: all il selections at index 81
    And I wait ilce element 10 seconds at index 1
    When I click element: ilce at index 1
    And I wait all ilce selections element 10 seconds at index 1
    When I click element: all ilce selections at index 1
    And I wait mahalle element 10 seconds at index 1
    When I click element: mahalle at index 1
    And I wait all mahalle selections element 10 seconds at index 1
    When I click element: all mahalle selections at index 1
    And I wait adres element 10 seconds at index 1
    Then I enter "Topkapı Sarayı" text to adres at index 1
    And I wait eposta element 10 seconds at index 1
    Then I enter "muhibbi@yahoo.com" text to eposta at index 1
    And I wait adresdevametbutton element 10 seconds at index 1
    When I click element: adresdevametbutton at index 1
    Then I wait active road map element 20 seconds at index 1
    Then I see confirmationPage page
    And I wait basvuru ozeti element 10 seconds at index 1
    And I wait basvuru ozeti i button element 10 seconds at index 1
    When I click element: basvuru ozeti i button at index 1
    And I wait kapat button element 10 seconds at index 1
    And I wait cross button element 10 seconds at index 1
    When I click element: cross button at index 1
    And I wait Hayir kurye element 10 seconds at index 1
    And I wait edevlete git element 10 seconds at index 1
    When I click element: edevlete git at index 1
    And I wait edevlet loading message element 10 seconds at index 1
    Then I go back previous page
    Then I see deliveryPage page
    And I wait degistir button element 10 seconds at index 1
    When I click element: degistir button at index 1
    Then I see tariffSelectionPage page
    And I wait select tariff buttons element 10 seconds at index 1
    When I click element: select tariff buttons at index 1
    Then I see idInfoPage page
    And I wait bu kisi ile devam et button element 10 seconds at index 1
    When I click element: bu kisi ile devam et button at index 1
    Then I see deliveryPage page
#   Dynamic il, ilce and mahalle selections from index numbers.
    And I wait il select area element 10 seconds at index 1
    When I click element: il select area at index 1
    And I wait all il selections element 10 seconds at index 81
    When I click element: all il selections at index 81
    And I wait ilce element 10 seconds at index 1
    When I click element: ilce at index 1
    And I wait all ilce selections element 10 seconds at index 1
    When I click element: all ilce selections at index 1
    And I wait mahalle element 10 seconds at index 1
    When I click element: mahalle at index 1
    And I wait all mahalle selections element 10 seconds at index 1
    When I click element: all mahalle selections at index 1
    And I wait adres element 10 seconds at index 1
    Then I enter "Topkapı Sarayı" text to adres at index 1
    And I wait eposta element 10 seconds at index 1
    Then I enter "muhibbi@yahoo.com" text to eposta at index 1
    And I wait adresdevametbutton element 10 seconds at index 1
    When I click element: adresdevametbutton at index 1
    Then I see confirmationPage page
    And I wait Hayir kurye element 10 seconds at index 1
    When I click element: Hayir kurye at index 1
    And I wait Basvuru alindi element 10 seconds at index 1
    And I wait basvuru ozeti i button element 10 seconds at index 1
    When I click element: basvuru ozeti i button at index 1
    And I wait kapat button element 10 seconds at index 1
    And I wait cross button element 10 seconds at index 1
    When I click element: cross button at index 1
    Then I need to just wait



