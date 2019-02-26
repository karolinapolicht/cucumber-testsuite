Feature: Searching and adding to a shopping cart
  User should be able to
                        search for item,
                        add item to the cart

  Background:
  Given User goes to the e-shop home page

  Scenario: User can add item to the cart
    When User adds item to the cart
    And User clicks the basket icon
    Then The shopping cart summary is displayed
    And User sees the product in cart

  Scenario: User can search an item and add it to the cart
    When User enters a "dress" in a search box
    And User picks "Printed Summer"
    And User adds item to cart
    And User proceeds to checkout
    Then User cart should display with added item

   Scenario: User adds a product to cart twice
      When User adds item "blouse" to cart with price "$27.00"
      And User increases quantity of the product
      Then The total price is increased to "$54.00"
      And The number of items in the basket should be "2"





