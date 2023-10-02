Feature: Login Functionality

@Login
Scenario Outline: Login with valid credentials
Given User navigates to login page
When User has enters email address <username>
And User has enters password <password>
And User clicks on login button
Then User should get succesfully logged in 

Examples:
| username | password |
| abhinav.khadatkar9@gmail.com | qwert12345 |
#| FirstNametest23.test3@gmail.com | qwert12345 |
#|Testme.test23@gmail.com|qwert12345|
#|FirstNametest22.test3@gmail.com|qwert12345|

@Login
Scenario Outline: Login with Invalid credentials
Given User navigates to login page
When User has enters email address <username>
And User has enters password <password>
And User clicks on login button
Then User should not get logged in 

Examples:
|username|password|
|abhinav.@gmail.com|erye5|
#|efqef.@gmail.com|efqe|

@Login
Scenario: Login with valid email and invalid password credentials
Given User navigates to login page
When User has enters email address "abhinav.khadatkar9@gmail.com" 
And User has enters password "qwerwrtw345"
And User clicks on login button
Then User should not get logged in 

Scenario: Login with Invalid email and valid password credentials
Given User navigates to login page
When User has enters email address "abhinav.ajdbci@gamil.com" 
And User has enters password "qwert12345"
And User clicks on login button
Then User should not get logged in 

Scenario: Login without any  credentials
Given User navigates to login page
And User clicks on login button
Then User should not get logged in 