Feature: Contact with Customer Service
  Check if the user can send a message to contact Customer Service

  Scenario: User can navigate to a Contact us page
    Given User goes to the e-shop home page
    When User selects Contact us from the menu
    Then Contact us page is displayed

    Scenario: User can send a feedback message
      Given User is on the Contact us page
      And User enters valid data
      And User writes "asd" in message field
      When User clicks Send button
      Then User receives feedback that message was sent
