Feature: TsystemHome

  Scenario: Search on Tsystem Webpage
    Given User Launch the Chrome browser
    When User opens TSystems URL
    And Click on SearchButton
    Then User can view SearchPage
