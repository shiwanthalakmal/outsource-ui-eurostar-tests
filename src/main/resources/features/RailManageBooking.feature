Feature: As a guest user of the railplus.com site
  I want to access railplus eurostar page with ticketing search panel
  So i can find by searching train ticket details under search modal view

  Background:
    Given I am on the railplus home page
    And Click on the "Eurostar" tab under main menu

  @Regression @RP-58
  Scenario: Verify the manage booking navigation flow
    When Click on the "manage booking" top navigation link
    Then I am on the manage booking page and verify the header title as "Manage booking"

  @Regression @RP-59
  Scenario: Verify the manage  booking quick link navigation
    When I mouse hover top of the "manage booking" link and press login with out details
    Then I am on the manage booking page and verify the header title as "Manage booking"