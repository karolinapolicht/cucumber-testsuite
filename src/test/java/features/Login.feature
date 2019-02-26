Feature: Test Login
  Verify if the user is able to logging in to the website

  Scenario: Logging in as valid user
    Given user is on login page
    When user logs in with valid email "o12992804@nwytg.net" and password "test1"
    Then user sees Sign out at the top right hand corner of the screen

  Scenario Outline: Logging in as invalid user
    Given user is on login page
    When user logs in with invalid e-mail "<e-mail>" and password "<password>"
    Then user sees a message "<error-m>"
    Examples:
      | e-mail              | password | error-m                    |
      | o12992804           | test1    | Invalid email address.     |
      | o12992804@nwytg.net | aaaa     | Invalid password.          |
      | mkkk@yahoo.com      |          | Password is required.      |
      |                     | asd      | An email address required. |

