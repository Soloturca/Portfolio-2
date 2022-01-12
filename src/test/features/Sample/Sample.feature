Feature: Sample Feature

  @Character
  Scenario: Get All Character

    Given Bring all the characters from the Rick & Morty cartoon through the "character".
    Then It is checked that there is "Rick Sanchez" on the incoming data.

  Scenario Outline: Filter Desired Character
    Given According to "character", filtering is done according to the "<name>","<status>","<species>","<type>" and "<gender>" fields.
    Then Use Soap

    Examples:
      | name | status | species | type | gender |
      | rick | alive  |         |      |        |