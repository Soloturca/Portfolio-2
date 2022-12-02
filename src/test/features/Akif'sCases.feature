@Akif'sCases
Feature: Akif's Cases
#mvn clean -Dtestname="Test953024" test

  @Test953024
  Scenario: Istenen Numarayla Magazaya Teslim NL Basvuru
    Given Open the https://efes.vodafone.com.tr/clicktodoor-mobil-dxl/ URL
    Then I see HatAlPage page
    And I wait Yeni Faturali Hat Al element 10 seconds at index 1
    When I click element: Yeni Faturali Hat Al at index 1
    And I wait tarife sec button element 10 seconds at index 1
    When I click element: tarife sec button at index 1
    And I wait son7 hane text area element 10 seconds at index 1
    When I click element: son7 hane text area at index 1
    Then I enter "3333333" text to son7 hane text area at index 1
    And I wait ilknumarabox element 10 seconds at index 1
    When I click element: ilknumarabox at index 1
    And I wait devametbutton element 10 seconds at index 1
    When I click element: devametbutton at index 1

