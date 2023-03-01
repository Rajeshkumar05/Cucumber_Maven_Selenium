Feature: Conversion of currency

Scenario: API calls to double convert currencies
Given I set the base URI
When I convert the price of Guatemalan Quetzal to British Pound
Then I convert the Received British Pound to doge coin
And I validated the status code