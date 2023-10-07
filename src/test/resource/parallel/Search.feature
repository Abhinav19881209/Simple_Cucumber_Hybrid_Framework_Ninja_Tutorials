Feature: Search Functionality

Scenario: User searches for valid products
Given User opens the application
When user enters product "HP" in serach box
And User clicks on search button
Then User should get valid product dispalyed in serch result

Scenario: User searches for invalid products
Given User opens the application
When user enters product "Honda" in serach box
And User clicks on search button
Then User should get message about no product matching

Scenario: User searches for without any product
Given User opens the application
When User clicks on search button
Then User should get message about no product matching