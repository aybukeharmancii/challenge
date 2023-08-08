Feature: Product


  @test1
  Scenario: Valid Add to Cart and Checkout
    Given User logs in with "testAutomationAH@gmail.com" email and "Test123." password.
    And Empty the shopping cart
    And User searchs "laptop"
    And User adds 1. product to basket and checks correct product and price is correct
    And Go to laptop search results
    And User adds 3. product to basket and checks correct product and price is correct
    When The quantity of the first item in the cart is increased by one
    Then Check that the quantity of the first item in the cart is increased by one
    And Go to home page
    And Signout

  @test2
  Scenario: Change Account Information
    Given User logs in with "testAutomationAH@gmail.com" email and "Test123." password.
    And Hover on account on home page and click account
    When Change account name
    Then Save account name changes
    And Signout





