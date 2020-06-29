Feature: LoginPage into actiTIME Application

Scenario Outline: Positive Test cases steps
Given Intialize the browser with chrome
And Navigate to "http://localhost:8080/login.do" site
When user enters <username> and <password> and logs in
Then verify the user is successfully logged into "actiTIME - Enter Time-Track"
And click on settings
When click on licensce
And verify the user is successfully logged into the title "actiTIME - Licenses"
And verify the date <date>
And verify the edition <edition>

Examples:
|username	|password	|date			|edition		|
|admin		|manager	|Jul 14, 2017	|actiTIME 2017.4|