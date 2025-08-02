@regression @elar
Feature: Validations for Elar Logistics Login Functionalities

  Background: Setup
    Given user navigates to elar logistics app

  @LoginPositive @smoke
  Scenario: Validating login functionality with positive scenario
    When user enters username "student@mindtek" and password "collaboration900"
    Then user validates successful login with home page message "Access denied!"

  @LoginNegative @smoke
  Scenario: Validating login fucntionality with negative scenario
    When user enters username "adskdjfskfjsfsd" and password "collaboration900"
    Then user validates error message is displayed "Invalid username or password"

  @showPassword
  Scenario: Validating Show Password Functionality
    When user enters username "student@mindtek" and password "collaboration900"
    And user clicks on show password button
    Then user validates password is shown with type attribute "text"
    When user clicks on hide password button
    Then user validates password is hidden with type attribute "password"