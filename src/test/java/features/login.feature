Feature: Application Login functionality

Scenario Outline: Successful login with valid credentials

Given User is on login page
When User enters "<username>" and "<password>"
Then User should be able to login

Examples:
|username  |password|
|friend	   |mellon  |