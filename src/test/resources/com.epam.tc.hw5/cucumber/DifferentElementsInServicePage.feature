Feature: Service elements

  Scenario: Select service elements
    Given I open Jdi test site
    When I login as user "Roman Iovlev"
    And I click on "Service" button in Header
    And I click on "Different Elements Page" button in Service dropdown
    And I select "water" checkbox
    And I select "wind" checkbox
    And I select "selen" radiobutton
    And I select "yellow" in color dropdown menu
    Then Log rows are displayed
    And there is an individual log row and value is corresponded to the status of checkbox
    And there is a log row and value is corresponded to the status of radio button
    And there is a log row and value is corresponded to the selected value of dropdown
