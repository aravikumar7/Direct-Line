@CoverCheck
Feature: To check if Coverage is valid or not

  @Functional
  Scenario Outline: Check Vehicle with valid cover
    Given User is in Insurance Portal
    When the user enters "<registration>" and tries to Find vehicle
    Then Results show the result for "<registration>"
    And Cover end is greater than current date and time
    And end date is greater than the start date

    Examples:
      | registration |
      | OV12UYY |

  @Functional
  Scenario Outline: Check Vehicle with invalid cover
    Given User is in Insurance Portal
    When the user enters "<registration>" and tries to Find vehicle
    Then Results show no coverage

    Examples:
      | registration |
      | OV12UYX |

  @Functional
  Scenario: Check Vehicle insurance without entering Registration number
    Given User is in Insurance Portal
    When the user tries to Find vehicle without entering registration number
    Then error message "Please enter a valid car registration" should be displayed
