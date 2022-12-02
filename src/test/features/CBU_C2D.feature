Feature: CBU_C2D

  @leman
  Scenario: Welcomepage
   Given Open the https://efes.vodafone.com.tr/clicktodoor-mobil-dxl/ URL
    Then I see welcomePage page
    Then I wait example element 50 seconds at index 1
    Then I wait example2 element 50 seconds at index 1
    Then I click element: example2 at index 1
    Then I need to just wait
