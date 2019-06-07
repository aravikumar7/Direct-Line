@VehicleCheck
Feature: To check if a Vehicle exists or not

  Background: User is in Insurance Portal
    Given User is in Insurance Portal


  Scenario Outline: Check Vehicle with valid cover
    When the user enters "<registration>" and tries to Find vehicle
    Then Results show the result for "<registration>"
    And Cover end is greater than current date and time
    And end date is greater than the start date

    Examples:
      | registration |
      | OV12UYY |


  Scenario Outline: Check Vehicle with invalid cover
    When the user enters "<registration>" and tries to Find vehicle
    Then Results show no coverage

    Examples:
      | registration |
      | OV12UYX |


  Scenario: Check Vehicle insurance without entering Registration number
    When the user tries to Find vehicle without entering registration number
    Then error message "Please enter a valid car registration" should be displayed
