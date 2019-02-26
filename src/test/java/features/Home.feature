Feature: Homepage Test
  Check if all components of the home page are working correctly.

  Scenario: User goes to homepage and successfully picks category from menu
    Given User goes to the e-shop home page
    Then Page should display 3 categories in  menu
    When The second category is chosen
    Then The page from that category should display as expected

