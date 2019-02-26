Feature:Newsletter Test
  Check if the user can sign up for a newsletter
  to receive information about new products and sales.

  Scenario Outline: User can sign up to newsletter with valid data
    Given User goes to the e-shop home page
    When User enters valid e-mail "<e-mail>"
    Then User receives feedback that the newsletter is already subscribed
    Examples: E-mails
      | e-mail             |
      | jsimss@yahoo.com   |
      | alsexaaa@gmail.com |

