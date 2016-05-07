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
  Scenario: Registered user should not able to login successfully with invalid credentials
    When Click on the "my signin" top navigation link
    Then I am on the manage booking page and verify the header title as "Agent Area"
    And I set sign in user "username" text feild
    And I set sign in user "password" text feild
    Then I press the sign in login button
    And Ican see login error message as "LOGIN FAILED"

  @Regression
  Scenario: Verify the my sign in quick link navigation
    When I mouse hover top of the "my signin" link and press login with out details
    Then I am on the manage booking page and verify the header title as "Agent Area"

  @Regression
  Scenario: Verify the my sign in forgot password link navigation
    When Click on the "my signin" top navigation link
    Then I am on the manage booking page and verify the header title as "Agent Area"
    And I click on the "forgot password" link
    And I navigate to the "Forgot Your Password?" page

  @Regression
  Scenario: Verify the my sign on create new user link navigation
    When Click on the "my signin" top navigation link
    Then I am on the manage booking page and verify the header title as "Agent Area"
    And I click on the "new argent" link
    Then I navigate to the "New Travel Agent?" page

  @Regression
  Scenario: Verify the create new argent user

  @Regression
  Scenario: Provide invalid email id for the forgot password
    When Click on the "my signin" top navigation link
    Then I am on the manage booking page and verify the header title as "Agent Area"
    And I click on the "forgot password" link
    And I provide recovery mail as "invalid@gmail.com"
    Then I press the recovery submit button
    And I can see recovery error msg as ""

  @Regression
  Scenario: Verify the error validation when create new user without mandatory feilds
    When Click on the "my signin" top navigation link
    Then I am on the manage booking page and verify the header title as "Agent Area"
    And I click on the "new argent" link
    Then I navigate to the "New Travel Agent?" page
    And I press the registration submit button
    And I  can see compulsory fields validation error message as "INCOMPLETE"

  @Regression
  Scenario: Verify the create new user flow with invalid email address

  @Regression
  Scenario: Reset forgot password

  @Regression
  Scenario: Verify the agent page ui availability
    When Click on the "my signin" top navigation link
    Then I am on the manage booking page and verify the header title as "Agent Area"
    And I can see "username" and "password" text boxes
    And I can see "login" button and login panel
    And I can see "forgot password" and 'new argent" links

  @Regression
  Scenario: Verify the user logout flow
    When Click on the "my signin" top navigation link
    Then I am on the manage booking page and verify the header title as "Agent Area"
    And I set sign in user "username" text feild
    And I set sign in user "password" text feild
    Then I press the sign in login button
    And I can see profile page and verify it
    Then I click the "sign out" link

