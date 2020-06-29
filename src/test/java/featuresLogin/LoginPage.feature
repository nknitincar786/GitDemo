Feature: LoginPage into actiTIME Application

Scenario Outline: Positive Test cases steps
Given Intialize the browser with chrome
And Navigate to "http://localhost:8080/login.do" site
When user enters <username> and <password> and logs in
Then verify the user is successfully logged into "actiTIME - Enter Time-Track"

Examples:
|username	|password	|
|admin		|manager	|