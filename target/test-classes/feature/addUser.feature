Feature: Add a new user By Post Request

Scenario: Add a new user 
Given user can access to url 
When send post request to create user and status code is 201
And print id
And send get request to get the created user by id
Then Assert on First Name the same as sent in the post request

