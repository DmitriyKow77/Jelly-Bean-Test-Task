Feature: Jelly Button test task

  @all
  Scenario: I search at google for Jelly Bean
    Given I open page "https://www.google.com"
    When I search for text "Jelly Button Games"
    Then I print number of search results
    And I click on first search result

  @all
  Scenario: Making screenshots of jelly bean site
    Given I open page "https://www.jellybtn.com"
    And I print current url
    And I save screenshot with name "JellyHomePage.png"
    Then I Print out all of the upper menu elements names
    When I open "Careers" page
    Then I save screenshot with name "JellyCareersPage.png"

