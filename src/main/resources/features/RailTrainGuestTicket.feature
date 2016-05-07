Feature: As a guest user of the railplus.com site
  I want to access railplus eurostar page with ticketing search panel
  So i can find by searching train ticket details under search modal view

  Background:
    Given I am on the railplus home page for search
    And Click on the "Eurostar" tab under main menu for search

  @Regression @RP-62,14
  Scenario: Verify the availability of the train ticket modal view at the first navigation
    Then I should see "One Way" option as the default enabled traveling type option and "Return" option will set as disable
    And I should see "Cheapest Fares" option as default fares type option
    And I should see seat reservation check box as by default unchecked

  @Regression @RP-19
  Scenario: Verify the seat reservation flow and fare category availability
    Then I should see "seat" reservation option as the un-selected option and "fare" option will set as "cheapest" Fares
    And I check "seat" reservation option
    And I verify the current availability of the seat reservation

  @Regression
  Scenario: Verify the Age Rule modal dialog navigation flow
    When I click "Age Rule" link under train ticket modal view
    Then I should see "Age Rules" overlay with country specific age rules
    And I close "Age Rule" modal dialog
    And I should see page header title as "Welcome to Rail Plus" for search

  @Regression
  Scenario: Verify the can i book train ticket link navigation
    When I click "Can I Book" link under train ticket modal view
    Then I should navigate to the "Destination" site and verify the header title as "Seat & Sleeper Reservations : How far in advance can I book?" for search

  @Regression @RP-20
  Scenario Outline: Verify the return search functionality
    When I click on the select the <type> search option
    And i set <departure> as departure station and <arrival> as arrival station
    Then Appear return date and time dynamically
    And I press the "search" for train button
    Then I can see train availability details page with title as <departure> to <arrival>

    Examples:
      |type    |departure|arrival|
      |return  |London   |Paris  |
      |oneway  |London   |Paris  |

  @Regression @RP-25
  Scenario: Verify the return type user shopping cart execution flow

  @Regression @RP-24
  Scenario: Verify the one way type user shopping cart execution flow

  @Regression @RP-27
  Scenario: Perform train search feature without applying departure station

  @Regression @RP-28
  Scenario: Perform train search feature without applying arrival station

  @Regression @RP-29
  Scenario: Perform train search feature without both applying arrival and departure stations

  @Regression
  Scenario Outline: Verify the condition overlay availability when select traveling plan
    When I click on the select the <type> search option
    And i set <departure> as departure station and <arrival> as arrival station
    Then Appear return date and time dynamically
    And I press the "search" for train button
    And I can see train availability details page with title as <departure> to <arrival>
    And I select "first" class traveling plan and verify the condition overlay

    Examples:
      |type    |departure|arrival|
      |oneway  |London   |Paris  |

  @Regression
  Scenario Outline: Verify the journey details overlay availability when select detail plan
    When I click on the select the <type> search option
    And i set <departure> as departure station and <arrival> as arrival station
    Then Appear return date and time dynamically
    And I press the "search" for train button
    And I can see train availability details page with title as <departure> to <arrival>
    And I select "first" class traveling plan and verify the journey details overlay

    Examples:
      |type    |departure|arrival|
      |oneway  |London   |Paris  |

  @Regression @RP-32
  Scenario Outline: Verify the earlier train sort functionality
    When I click on the select the <type> search option
    And i set <departure> as departure station and <arrival> as arrival station
    Then Appear return date and time dynamically
    And I press the "search" for train button
    And I can see train availability details page with title as <departure> to <arrival>

    Examples:
      |type    |departure|arrival|
      |oneway  |London   |Paris  |

  @Regression @RP-32,33
  Scenario Outline: Verify the later train sort functionality
    When I click on the select the <type> search option
    And i set <departure> as departure station and <arrival> as arrival station
    Then Appear return date and time dynamically
    And I press the "search" for train button
    And I can see train availability details page with title as <departure> to <arrival>
    And I verify the <sort> sort functionality

    Examples:
      |type    |departure|arrival|sort    |
      |oneway  |London   |Paris  |earlier |
      |oneway  |London   |Paris  |later   |



