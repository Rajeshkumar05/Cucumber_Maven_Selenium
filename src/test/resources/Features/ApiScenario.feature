Feature: Currency Conversion 

Scenario: API calls to convert currencies
Given I set the API key and header values
When I parse JSON array for fetching price value
Then Price is convert to British Pound
Then Received GBP to doge coin