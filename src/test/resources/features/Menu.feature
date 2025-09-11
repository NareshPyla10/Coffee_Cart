Feature: Validating coffee cart website

  Scenario: Validating menu functionalities
    Given Launching the website
    When  click the menu link
    And Adding item to the cart
    And navigating to the cart link
    Then the cart should contain one item

  Scenario: Adding multiple items to the cart
    Given Launching the website
    When click the menu link
    And Adding multiple items to the cart
    And navigating to the cart link
    Then the cart should contain one item

#  Scenario: Adding one item after that clicking plus symbol
#    Given Launching the website
#    When  click the menu link
#    And Adding item to the cart
#    And navigating to the cart link
#    Then the cart should contain one item
#    Then adding same item second time


  Scenario: Getting total from the added items
    Given Launching the website
    When click the menu link
    And Adding multiple items to the cart
    And navigating to the cart link
    Then the cart should contain one item
    Then adding items each one is two items

    Scenario: Adding multiple items and clicking plus button for each and every one
        Given Launching the website
        When click the menu link
        And Adding multiple items to the cart
        And navigating to the cart link
        Then the cart should contain multiple items
        And adding same items to the cart second time


    Scenario: Adding multiple items and clicking plus button for each and every one and pay the money
        Given Launching the website
        When click the menu link
        And Adding multiple items to the cart
        And navigating to the cart link
        Then the cart should contain multiple items
        And adding same items to the cart second time
        Then pay the money for the items

  Scenario: Printing all the item names
    Given Launching the website
    When click the menu link
    And priniting all the item names