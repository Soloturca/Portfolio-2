@Akif'sCases
Feature: Akif's Cases


  @Test953024
  Scenario: Istenen Numarayla Magazaya Teslim NL Basvuru
    Given Open the https://efes.vodafone.com.tr/clicktodoor-mobil-dxl/ URL
    Then I see HatAlPage page
    And I wait Yeni Faturalı Hat Al element 10 seconds at index 1
    When I click element: Yeni Faturalı Hat Al at index 1
