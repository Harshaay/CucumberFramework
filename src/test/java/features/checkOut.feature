
Feature: Search and Add product to the Kart

@PlaceOrder
  Scenario: Search the product in home page and add the product to Kart
    Given User is on greenKart Landing page
    When user searched product with shortname for <name> and extract actual name of product
    And  Add <number> items of same product to Kart and proceed to check out
    Then validate product name in appeared in checkout
    And verify user has the ability to enter promo code and place the order
    
    Examples:
    | name | number |
    | Tom  |	2 		|
