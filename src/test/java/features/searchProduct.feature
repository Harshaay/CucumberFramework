Feature: Search and Place the order for products
@OffersPage
Scenario Outline: Search Experience for product search in both home and Offers page

Given User is on GreenCart Landing page
When user searched with Shortname <Name> and extracted actual name of product
Then user searched for <Name> shortname in offers page 
And validate product name in offers page matches with Landing page
Examples:
| Name |
| Tom  |
| Beet |