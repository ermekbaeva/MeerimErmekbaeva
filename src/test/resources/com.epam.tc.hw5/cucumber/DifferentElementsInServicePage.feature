Feature: Service elements

  Scenario: Select service elements
    Given I open Jdi test site
    And I login as user "Roman Iovlev"
    And I click on "Service" button in Header
    And I click on "Different Elements Page" button in Service dropdown
    When I select 'water' checkbox
    And I select 'wind' checkbox
    And I select 'selen' radiobutton
    And I select 'yellow' in color dropdown menu
    Then Log rows are displayed
    And checkbox name and its status are corresponding to selected
    And radio button name and it status is corresponding to selected
    And dropdown name and selected value is corresponding to selected
