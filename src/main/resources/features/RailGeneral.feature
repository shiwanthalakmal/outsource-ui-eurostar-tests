Feature: As a guest user of the railplus.com site
  I want to access railplus index page with ticketing search panel
  So i can update, delete and insert new booking details details

  Background:
    Given I am on the railplus home page

  @Regression @RP-21
  Scenario: Verify the initial page navigation behaviours
    Then I should see page header title as "Welcome to Rail Plus"
    And I should see home tab as a default selected option

  @Regression @RP-36,60
  Scenario: Verify the home page banner sliders availability
    When I choose specific banner indexes randomly
    And I click info button in that particular slider
    Then I should navigate to the relevant page and verify page header

  @Regression @RP-61
  Scenario: Verify the home page banner movements using arrows
    When I choose left arrow in main banner
    And I click info button in that particular slider
    Then I should navigate to the relevant page and verify page header

  @Regression
  Scenario: Verify back to top link functionality
    Then I should see page header title as "Welcome to Rail Plus"
    And I click on the back to top link to move top of the page

  @Regression
  Scenario Outline: Verify the home page footer link navigation
    When I click on the home page <link> link
    Then I should navigate to the <link> site and verify the header title as <title>

    Examples:
    |link    |title|
    |Site    |Site map|
    |Privacy |Privacy policy|

  @Regression
  Scenario Outline: Verify the home page social media link navigation
    When I click on the home page link <link> icon
    Then I should navigate to the particular site as a new window and verify the url as <title>

    Examples:
      |link    |title|
      |facebook|Facebook|
      |twitter |Share a link on Twitter|

  @Regression
  Scenario: Verify the cancellation policy pdf download flow
    When I click on the home page "cancellation policy" link
    Then I should able to download cancellation policy pdf file

  @Regression
  Scenario Outline: Verify the home page header quick links navigation flows
    When I click on the home page <link> link
    Then I should navigate to the <link> site and verify the header title as <title>

    Examples:
    |link       |title|
    |About      |About us|
    |Contact    |Contact us|
    |Maps       |Rail maps|
    |Timetables |Rail timetables|
    |Subscribe  |Subscribe to the Rail Plus Newsletter|

  @Regression
  Scenario Outline: Verify the home page modal window tab navigation
    When I click on the home page <tab> modal tab button
    Then I should navigate to the particular modal view and verify the header title as <title>

    Examples:
    |tab    |title                  |
    |Train  |Train Ticket Search    |
    |Rail   |Rail Passes            |
    |Travel |Sightseeing & Transport|
    |Ferry  |Ferry Tickets          |