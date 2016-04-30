Feature: As a guest user of the railplus.com site
  I want to access railplus eurostar page with ticketing search panel
  So i can find by searching train ticket details under search modal view

  Background:
    Given I am on the railplus home page
    And Click on the "Eurostar" tab under main menu

  @Regression
  Scenario: Verify the argent sign in page navigation flow
    When Click on the "my signin" top navigation link
    Then I am on the manage booking page and verify the header title as "Agent Area"

  #@Regression
  #Scenario: Registered user should able to login successfully using quick link pop up
    #When I mouse hover top of the "my signin" link and press login with out details
    #And I set quick popup sign in user "username" text feild
    #And I set quick popup sign in user "password" text feild
    #Then I press the quick popup sign in login button

  @Regression
  Scenario: Registered user should able to login successfully
    When Click on the "my signin" top navigation link
    Then I am on the manage booking page and verify the header title as "Agent Area"
    And I set sign in user "username" text feild
    And I set sign in user "password" text feild
    Then I press the sign in login button

  @Regression
  Scenario: Verify the my sign in quick link navigation
    When I mouse hover top of the "my signin" link and press login with out details
    Then I am on the manage booking page and verify the header title as "Agent Area"

  @Regression
  Scenario: Verify the my sign in forgot password link navigation

  @Regression
  Scenario: Verify the my sign on create new user link navigation

  @Regression
  Scenario: Verify the create new argent user

  @Regression
  Scenario: Provide invalid email id for the forgot password

  @Regression
  Scenario: Verify the error validation when create new user without mandatory feilds

  @Regression
  Scenario: Verify the create new user flow with invalid email address

  @Regression
  Scenario: Reset forgot password

  @Regression
  Scenario: Verify the agent page ui availability

  @Regression
  Scenario: Verify the user logout flow

