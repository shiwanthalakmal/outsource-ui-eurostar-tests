Feature: As a administrator of the puppy adoption site
  I want to access demo admin panel
  So i can update, delete and insert new puppy details

  Background:
    Given I am on the puppy adoption home page

  @Regression
  Scenario: Basic ui verification of the homepage
    Given I am on the puppy adoption home page
    Then I should see page header title
    And I should see puppy view page button

  @Regression
  Scenario: Basic ui verification of the homepages
    Given I am on the puppy adoption home page
    Then I should see page header title
    And I should see puppy view page button
