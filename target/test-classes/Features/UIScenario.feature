Feature: Filtering UI

Scenario: Filtering UI and extracting data for comparison    
Given I open the coin market application 
When I select 20 row 
Then I capture required page content
When I set filter on the page by Algorithm as PoW 
And I add more filters 
Then I capture filter content and compare with previous content 