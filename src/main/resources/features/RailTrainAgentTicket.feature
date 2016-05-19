Feature: As a Registered agent user of the railplus.com site
  I want to access railplus eurostar page with ticketing search panel
  So i can find by searching train ticket details under search modal view

  Background:
    Given I am successfully login railplus site

  @Regression @RP-73,74
  Scenario: Registered agent verify the availability of the train ticket modal view at the first navigation
    Then I should see "One Way" option as the default enabled traveling type option and "Return" option will set as disable
    And I should see "Cheapest Fares" option as default fares type option
    And I should see seat reservation check box as by default unchecked

  @Regression
  Scenario: Registered agent verify the seat reservation flow and fare category availability
    Then I should see "seat" reservation option as the un-selected option and "fare" option will set as "cheapest" Fares
    And I check "seat" reservation option
    And I verify the current availability of the seat reservation

  @Regression @RP-75
  Scenario Outline: Registered agent verify the one way type user shopping cart execution flow
    When I click on the select the <type> search option
    And i set <departure> as departure station and <arrival> as arrival station
    Then Appear return date and time dynamically
    And I press the "search" for train button
    And I can see train availability details page with title as <departure> to <arrival>
    And I select "first" class traveling plan and verify the condition overlay
    And I perform shopping cart function
    And I am on the passenger details page
    And I set passenger details title as <title>, name as <fullname> and age as <age>
    And I continue passenger details flow by checking apply conditions

  Examples:
  |type    |departure|arrival|title|fullname    |age|
  |oneway  |London   |Paris  |Mrs  |Mala Kumari |25 |

  @Regression @RP-108
  Scenario Outline: Registered agent try to continue passenger details flow without apply condition
    When I click on the select the <type> search option
    And i set <departure> as departure station and <arrival> as arrival station
    Then Appear return date and time dynamically
    And I press the "search" for train button
    And I can see train availability details page with title as <departure> to <arrival>
    And I select "first" class traveling plan and verify the condition overlay
    And I perform shopping cart function
    And I am on the passenger details page
    And I set passenger details title as <title>, name as <fullname> and age as <age>
    And I continue passenger details flow without apply conditions
    And I verify the alert message "You must agree to the passenger conditions to continue." and accept it

    Examples:
      |type    |departure|arrival|title|fullname    |age|
      |oneway  |London   |Paris  |Mrs  |Mala Kumari |25 |

  @Regression @RP-85
  Scenario Outline: Registered agent successfully navigate to confirm itinerary level
    When I click on the select the <type> search option
    And i set <departure> as departure station and <arrival> as arrival station
    Then Appear return date and time dynamically
    And I press the "search" for train button
    And I can see train availability details page with title as <departure> to <arrival>
    And I select "first" class traveling plan and verify the condition overlay
    And I perform shopping cart function
    And I am on the passenger details page
    And I set passenger details title as <title>, name as <fullname> and age as <age>
    And I continue passenger details flow by checking apply conditions
    And I am on the confirm itinerary page

    Examples:
      |type    |departure|arrival|title|fullname    |age|
      |oneway  |London   |Paris  |Mrs  |Mala Kumari |25 |

  @Regression @RP-87
  Scenario Outline: Guest user successfully navigate to confirm itinerary level and continue shopping again
    When I click on the select the <type> search option
    And i set <departure> as departure station and <arrival> as arrival station
    Then Appear return date and time dynamically
    And I press the "search" for train button
    And I can see train availability details page with title as <departure> to <arrival>
    And I select "first" class traveling plan and verify the condition overlay
    And I perform shopping cart function
    And I am on the passenger details page
    And I set passenger details title as <title>, name as <fullname> and age as <age>
    And I continue passenger details flow by checking apply conditions
    And I am on the confirm itinerary page
    And I continue shopping again by clicking continue button
    And I should see page header title as "Welcome to Rail Plus".


    Examples:
      |type    |departure|arrival|title|fullname    |age|
      |oneway  |London   |Paris  |Mrs  |Mala Kumari |25 |

  @Regression @RP-109
  Scenario Outline: Guest user try to continue passenger details flow without giving country details
    When I click on the select the <type> search option
    And i set <departure> as departure station and <arrival> as arrival station
    Then Appear return date and time dynamically
    And I press the "search" for train button
    And I can see train availability details page with title as <departure> to <arrival>
    And I select "first" class traveling plan and verify the condition overlay
    And I perform shopping cart function
    And I am on the passenger details page
    And I set passenger details title as <title>, name as <fullname> and age as <age>
    And I clear default allocated country
    And I continue passenger details flow by checking apply conditions
    And I can see inline validation error message as  "Please enter a country of origin for passenger 1."

    Examples:
      |type    |departure|arrival|title|fullname    |age|
      |oneway  |London   |Paris  |Mrs  |Mala Kumari |25 |

  @Regression @RP-86
  Scenario Outline: Registered agent successfully navigate to confirm itinerary level and verify shopping basket
    When I click on the select the <type> search option
    And i set <departure> as departure station and <arrival> as arrival station
    Then Appear return date and time dynamically
    And I press the "search" for train button
    And I can see train availability details page with title as <departure> to <arrival>
    And I select "first" class traveling plan and verify the condition overlay
    And I perform shopping cart function
    And I am on the passenger details page
    And I set passenger details title as <title>, name as <fullname> and age as <age>
    And I continue passenger details flow by checking apply conditions
    And I am on the confirm itinerary page
    And I can see shopping basket items as "1 Item"

    Examples:
      |type    |departure|arrival|title|fullname    |age|
      |oneway  |London   |Paris  |Mrs  |Mala Kumari |25 |

  @Regression @RP-92
  Scenario Outline: Registered agent successfully navigate to delivery payment page
    When I click on the select the <type> search option
    And i set <departure> as departure station and <arrival> as arrival station
    Then Appear return date and time dynamically
    And I press the "search" for train button
    And I can see train availability details page with title as <departure> to <arrival>
    And I select "first" class traveling plan and verify the condition overlay
    And I perform shopping cart function
    And I am on the passenger details page
    And I set passenger details title as <title>, name as <fullname> and age as <age>
    And I continue passenger details flow by checking apply conditions
    And I am on the confirm itinerary page
    And I perform checkout upto delivery page
    And I should see page header title as "Payment and delivery details".

    Examples:
      |type    |departure|arrival|title|fullname    |age|
      |oneway  |London   |Paris  |Mrs  |Mala Kumari |25 |

  @Regression @RP-113
  Scenario Outline: Registered agent successfully navigate to delivery payment page and verify page title
    When I click on the select the <type> search option
    And i set <departure> as departure station and <arrival> as arrival station
    Then Appear return date and time dynamically
    And I press the "search" for train button
    And I can see train availability details page with title as <departure> to <arrival>
    And I select "first" class traveling plan and verify the condition overlay
    And I perform shopping cart function
    And I am on the passenger details page
    And I set passenger details title as <title>, name as <fullname> and age as <age>
    And I continue passenger details flow by checking apply conditions
    And I am on the confirm itinerary page
    And I perform checkout upto delivery page
    And I should see page header title as "Payment and delivery details".

    Examples:
      |type    |departure|arrival|title|fullname    |age|
      |oneway  |London   |Paris  |Mrs  |Mala Kumari |25 |


  @Regression @RP-88
  Scenario Outline: Registered agent successfully navigate to confirm itinerary level and remove existing cart item
    When I click on the select the <type> search option
    And i set <departure> as departure station and <arrival> as arrival station
    Then Appear return date and time dynamically
    And I press the "search" for train button
    And I can see train availability details page with title as <departure> to <arrival>
    And I select "first" class traveling plan and verify the condition overlay
    And I perform shopping cart function
    And I am on the passenger details page
    And I set passenger details title as <title>, name as <fullname> and age as <age>
    And I continue passenger details flow by checking apply conditions
    And I am on the confirm itinerary page
    And I remove existing shopping cart item and accept confirmation
    And I should see page header title as "Welcome to Rail Plus" for search

    Examples:
      |type    |departure|arrival|title|fullname    |age|
      |oneway  |London   |Paris  |Mrs  |Mala Kumari |25 |

  @Regression @RP-107
  Scenario Outline: Registered agent provide non-integer value for the passenger age detail
    When I click on the select the <type> search option
    And i set <departure> as departure station and <arrival> as arrival station
    Then Appear return date and time dynamically
    And I press the "search" for train button
    And I can see train availability details page with title as <departure> to <arrival>
    And I select "first" class traveling plan and verify the condition overlay
    And I perform shopping cart function
    And I am on the passenger details page
    And I set passenger details title as <title>, name as <fullname> and age as <age>
    And I verify the alert message "Please enter a correct age for Traveller 1" and accept it

    Examples:
      |type    |departure|arrival|title|fullname    |age|
      |oneway  |London   |Paris  |Mrs  |Mala Kumari |A |

  @Regression @RP-95
  Scenario Outline: Guest user verify the search item in-progress state
    When I click on the select the <type> search option
    And i set <departure> as departure station and <arrival> as arrival station
    Then Appear return date and time dynamically
    And I press the "search" for train button
    And I can see train search in-progress state

    Examples:
      |type    |departure|arrival|
      |oneway  |London   |Paris  |

  @Regression @RP-26
  Scenario: Guest user Verify the return type user shopping cart execution flow

  @Regression @RP-77
  Scenario: Guest user Perform train search feature without applying departure station

  @Regression @RP-78
  Scenario: Guest user Perform train search feature without applying arrival station

  @Regression @RP-79
  Scenario: Guest user Perform train search feature without both applying arrival and departure stations

  @Regression
  Scenario: Registered agent verify the Age Rule modal dialog navigation flow
    When I click "Age Rule" link under train ticket modal view
    Then I should see "Age Rules" overlay with country specific age rules
    And I close "Age Rule" modal dialog
    And I should see page header title as "Welcome to Rail Plus" for search

  @Regression
  Scenario: Registered agent verify the Rail Pass link modal dialog navigation flow
    When I click "Rail Pass" link under train ticket modal view
    Then I should see "Passholder Rules" overlay with country specific age rules
    And I close "Rail Pass" modal dialog
    And I should see page header title as "Welcome to Rail Plus" for search

  @Regression
  Scenario: Registered agent verify the can i book train ticket link navigation
    When I click "Can I Book" link under train ticket modal view
    Then I should navigate to the "Destination" site and verify the header title as "Seat & Sleeper Reservations : How far in advance can I book?" for search

  @Regression
  Scenario Outline: Registered agent verify the return search functionality
    When I click on the select the <type> search option
    And i set <departure> as departure station and <arrival> as arrival station
    Then Appear return date and time dynamically
    And I press the "search" for train button
    Then I can see train availability details page with title as <departure> to <arrival>

    Examples:
      |type    |departure|arrival|
      |return  |London   |Paris  |
      |oneway  |London   |Paris  |

  @Regression
  Scenario Outline: Registered agent verify the condition overlay availability when select traveling plan
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
  Scenario Outline: Registered agent verify the journey details overlay availability when select detail plan
    When I click on the select the <type> search option
    And i set <departure> as departure station and <arrival> as arrival station
    Then Appear return date and time dynamically
    And I press the "search" for train button
    And I can see train availability details page with title as <departure> to <arrival>
    And I select "first" class traveling plan and verify the journey details overlay

    Examples:
      |type    |departure|arrival|
      |oneway  |London   |Paris  |

  @Regression @RP-82
  Scenario Outline: Registered agent verify the earlier train sort functionality
    When I click on the select the <type> search option
    And i set <departure> as departure station and <arrival> as arrival station
    Then Appear return date and time dynamically
    And I press the "search" for train button
    And I can see train availability details page with title as <departure> to <arrival>

    Examples:
      |type    |departure|arrival|
      |oneway  |London   |Paris  |

  @Regression @RP-82,83
  Scenario Outline: Registered agent verify the later train sort functionality
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

  @Regression @RP-84
  Scenario Outline: Registered agent verify the modify search functionality
    When I click on the select the <type> search option
    And i set <departure> as departure station and <arrival> as arrival station
    Then Appear return date and time dynamically
    And I press the "search" for train button
    And I can see train availability details page with title as <departure> to <arrival>
    And I click on the modify search button
    And And i set <modi departure> as departure station and <modi arrival> as arrival station in modify search
    And I press the "search" for train button in modify search
    And I can see train availability details page with title as <modi departure> to <modi arrival>

    Examples:
      |type    |departure|arrival|modi departure|modi arrival         |
      |oneway  |London   |Paris  |London        |Waterloo (Merseyside)|

  @Regression @RP-127
  Scenario Outline: Registered agent verify the train ticket search not found error messages flows
    When I click on the select the <type> search option
    And i set <departure> as departure station and <arrival> as arrival station
    Then Appear return date and time dynamically
    And I press the "search" for train button
    And I can see error message like <error>

    Examples:
      |type    |departure|arrival   |error|
      |oneway  |London   |Parikkala |We have not been able to find a match for your search. It may be a result of one of the following:|

  @Regression @RP-121
  Scenario Outline: Registered agent verify the modify search button availability
    When I click on the select the <type> search option
    And i set <departure> as departure station and <arrival> as arrival station
    Then Appear return date and time dynamically
    And I press the "search" for train button
    And I can see train availability details page with title as <departure> to <arrival>
    And I click on the modify search button
    And And i set <modi departure> as departure station and <modi arrival> as arrival station in modify search
    And I press the "search" for train button in modify search
    And I can see train availability details page with title as <modi departure> to <modi arrival>

    Examples:
      |type    |departure|arrival|modi departure|modi arrival         |
      |oneway  |London   |Paris  |London        |Waterloo (Merseyside)|

  @Regression @RP-105
  Scenario Outline: Registered agent enter passenger details to confirm order
    When I click on the select the <type> search option
    And i set <departure> as departure station and <arrival> as arrival station
    Then Appear return date and time dynamically
    And I press the "search" for train button
    And I can see train availability details page with title as <departure> to <arrival>
    And I select "first" class traveling plan and verify the condition overlay
    And I perform shopping cart function
    And I am on the passenger details page
    And I set passenger details title as <title>, name as <fullname> and age as <age>
    And I continue passenger details flow by checking apply conditions

    Examples:
      |type    |departure|arrival|title|fullname    |age|
      |oneway  |London   |Paris  |Mrs  |Mala Kumari |25 |

  @Regression @RP-106
  Scenario Outline: Registered agent enter passenger details by selecting apply condition
    When I click on the select the <type> search option
    And i set <departure> as departure station and <arrival> as arrival station
    Then Appear return date and time dynamically
    And I press the "search" for train button
    And I can see train availability details page with title as <departure> to <arrival>
    And I select "first" class traveling plan and verify the condition overlay
    And I perform shopping cart function
    And I am on the passenger details page
    And I set passenger details title as <title>, name as <fullname> and age as <age>
    And I continue passenger details flow by checking apply conditions

    Examples:
      |type    |departure|arrival|title|fullname    |age|
      |oneway  |London   |Paris  |Mrs  |Mala Kumari |25 |