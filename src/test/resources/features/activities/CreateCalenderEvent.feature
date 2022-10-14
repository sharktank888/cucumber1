Feature: As user, I want to be able to create calendar events
 @calendar_events
  Scenario: Create calendar event with default time
    Given user is on the login page
    And user logs in as a "store manager"
    And user navigates to "Activities" and "Calendar Events"
    And user clicks on create calendar event button
    When user adds new calendar event information
      |Title      | Graduation party                       |
      |Description | All friends are invited for this party|
    And user clicks on save and close button
   Then user verifies that new calendar event is displayed:
     |Title       | Graduation party                      |
     |Description | All friends are invited for this party|
