Feature: As a user I would like to login to my giftrete page and upload items


  Scenario: Valid Login
    Given I navigate to "https://dev.giftrt.com/"
    And I click on Login "Login"
    When I enter email "tupsyn2000@yahoo.com"
    And I enter password "Testing123"
    And I click on "Secure Sign In"
    Then I should be signed in

    Scenario: Invalid Login
      Given I navigate to "https://dev.giftrt.com/"
      And I click on Login "Login"
      When I enter email "tupsyn2000@yahoo.com"
      And I enter invalid password "testing123"
      And I click on "Secure Sign In"
      Then error "Your login credentials are invalid. Please try again." is diplayed

      Scenario Outline:
    Given I navigate to "https://dev.giftrt.com/"
        And I click on Login "Login"
        When I enter email "<email>"
        And I enter password "<password>"
        And I click on "Secure Sign In"
        Then I should be signed in



  Examples:
        |email|password|
        |tupsyn2000@yahoo.com|Testing123|
        |tupsyn2000@yahoo.com|testing123|


