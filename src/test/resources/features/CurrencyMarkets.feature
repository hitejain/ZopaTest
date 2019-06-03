Feature: API Currency Markets

  @GetCurrencies @sanityTest
  Scenario: verify that fixer API site is up and running
    Given fixer site url and API key is available
    When  make a GET call to fixer api
    Then  success code 200 is returned

  @GetCurrencies @sanityTest
  Scenario: test to fetch the 10 random currencies from all currencies
    Given fixer site url and API key is available
    When  make a GET call to fixer api
    Then  success code 200 is returned
    And  10 random currencies are stored from the result






