Feature: As a guest user of the railplus.com site
  I want to access railplus eurostar page with ticketing search panel
  So i can find by searching train ticket details under search modal view

  Background:
    Given I am on the railplus home page
    And Click on the "Eurostar" tab under main menu

  @Regression
  Scenario: Verify the availability of the train ticket modal view at the first navigation
    Then I should see "One Way" option as the default enabled traveling type option and "Return" option will set as disable
    And I should see "Cheapest Fares" option as default fares type option
    And I should see seat reservation check box as by default unchecked

  @Regression
  Scenario: Verify the Age Rule modal dialog navigation flow
    When I click "Age Rule" link under train ticket modal view
    Then I should see "Age Rules" overlay with country specific age rules
    And I close "Age Rule" modal dialog
    And I should see page header title as "Welcome to Rail Plus"

  @Regression
  Scenario: Verify the can i book train ticket link navigation
    When I click "Can I Book" link under train ticket modal view
    Then I should navigate to the "Destination" site and verify the header title as "Seat & Sleeper Reservations : How far in advance can I book?"