Feature: Registration Functionality	

Scenario:  User creates an account only with mandatory fields
Given User navigates to register account page
When user enters the belwo details
|firstname|FirstNametest110|
|lastname			|LastNametest01|
|email|FirstNametest999.test71@gmail.com|
|telephone|1234567890|
|password|qwert12345|
|confirm |qwert12345|
And user select privacy Policy
And user clicks on Continue button
Then user account should get created successfull

Scenario:  User creates an account only with all fields
Given User navigates to register account page
When user enters the belwo details
|firstname|Test1|
|lastname			|Test2|
|email|FirstNametest111.test71@gmail.com|
|telephone|1234567890|
|password|qwert12345|
|confirm |qwert12345|
And User select Yes for newsletter
And user select privacy Policy
And user clicks on Continue button
Then user account should get created successfull

Scenario:  User creates an duplicate account
Given User navigates to register account page
When user enters the belwo details
|firstname|Test1|
|lastname			|Test2|
|email|FirstNametest111.test3@gmail.com|
|telephone|1234567890|
|password|qwert12345|
|confirm |qwert12345|
And User select Yes for newsletter
And user select privacy Policy
And user clicks on Continue button
Then user account should get warning message for duplicate email

Scenario: user create an account without filling any details
Given User navigates to register account page
When user clicks on Continue button
Then user account should get warning message for every mandatory field