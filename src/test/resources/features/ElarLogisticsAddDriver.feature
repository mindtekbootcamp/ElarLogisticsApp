@regression @addDriverUI @ui @regression
Feature: Validations for Elar Logistics Add Driver functionality

  Background: Setup
    Given user logs in to to elar logistics app
    When user navigates to the Drivers page
    And user clicks on Add Driver button

  @createMinimumRequirements @smoke
  Scenario: Validating Create Button Minimum Requirements
    And user clicks on Create button
    Then user validates error message above Create button is shown "Required"

  @validFullName
  Scenario: Validating valid Full Name input
    And user enters full name "John Doe"
    And user selects driving license expiration date "09/01/2025"
    And user selects medical license expiration date "09/01/2025"
    And user enters input into Logbook# field
    And user enters input into Logbook email field "test@test.com"
    And user enters input into Logbook password field "testpassword"
    And user clicks on Create button
    Then user validates success message is displayed "Driver Created Successfully"

  @invalidFullNameMoreThanMax @smoke
  Scenario: Validating invalid Full Name with more than 50 characters
    And user enters full name "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa"
    And user selects driving license expiration date "09/01/2025"
    And user selects medical license expiration date "09/01/2025"
    And user enters input into Logbook# field
    And user enters input into Logbook email field "test@test.com"
    And user enters input into Logbook password field "testpassword"
    And user clicks on Create button
    Then user validates error message for name with more than 50 characters is displayed "String must contain at most 50 character(s)"

  @invalidFullNameSpecialChar
  Scenario: Validating invalid Full Name with special characters
    And user enters full name "!@#$%"
    And user selects driving license expiration date "09/01/2025"
    And user selects medical license expiration date "09/01/2025"
    And user enters input into Logbook# field
    And user enters input into Logbook email field "test@test.com"
    And user enters input into Logbook password field "testpassword"
    And user clicks on Create button
    Then user validates error message for name with special characters is displayed "Input must contain only alphanumeric and specific punctuation characters"

  @validDrivingLicenseExp
  Scenario: Validating valid Driving License Expiration date with future date
    And user enters full name "John Doe"
    And user selects driving license expiration date "09/01/2027"
    And user selects medical license expiration date "09/01/2027"
    And user enters input into Logbook# field
    And user enters input into Logbook email field "test@test.com"
    And user enters input into Logbook password field "testpassword"
    And user clicks on Create button
    Then user validates success message is displayed "Driver Created Successfully"

  @invalidDrivingLicenseExpPast
  Scenario: Validating invalid Driving License Expiration date with past date
    And user enters full name "John Doe"
    And user selects driving license expiration date "07/01/2025"
    And user selects medical license expiration date "09/01/2025"
    And user enters input into Logbook# field
    And user enters input into Logbook email field "test@test.com"
    And user enters input into Logbook password field "testpassword"
    And user clicks on Create button
    Then user validates error message for driving license past date is displayed "Only future dates can be select"

  @invalidDrivingLicenseExpCurrent
  Scenario: Validating invalid Driving License Expiration date with current date
    And user enters full name "John Doe"
    And user selects driving license expiration date "08/09/2025"
    And user selects medical license expiration date "09/01/2025"
    And user enters input into Logbook# field
    And user enters input into Logbook email field "test@test.com"
    And user enters input into Logbook password field "testpassword"
    And user clicks on Create button
    Then user validates error message for driving license current date is displayed "Only future dates can be select"

  @validMedicalLicenseExp
  Scenario: Validating valid Medical License Expiration date with future date
    And user enters full name "John Doe"
    And user selects driving license expiration date "09/01/2025"
    And user selects medical license expiration date "09/01/2025"
    And user enters input into Logbook# field
    And user enters input into Logbook email field "test@test.com"
    And user enters input into Logbook password field "testpassword"
    And user clicks on Create button
    Then user validates success message is displayed "Driver Created Successfully"

  @invalidMedicalLicenseExpPast
  Scenario: Validating invalid Medical License Expiration date with past date
    And user enters full name "John Doe"
    And user selects driving license expiration date "09/01/2025"
    And user selects medical license expiration date "07/01/2025"
    And user enters input into Logbook# field
    And user enters input into Logbook email field "test@test.com"
    And user enters input into Logbook password field "testpassword"
    And user clicks on Create button
    Then user validates error message for medical license past date is displayed "Only future dates can be select"

  @invalidMedicalLicenseExpCurrent
  Scenario: Validating invalid Medical License Expiration date with current date
    And user enters full name "John Doe"
    And user selects driving license expiration date "09/01/2025"
    And user selects medical license expiration date "08/09/2025"
    And user enters input into Logbook# field
    And user enters input into Logbook email field "test@test.com"
    And user enters input into Logbook password field "testpassword"
    And user clicks on Create button
    Then user validates error message for medical license current date is displayed "Only future dates can be select"

  @staffCheckBox
  Scenario: Validating Staff checkbox functionality
    And user enters full name "John Doe"
    And user selects driving license expiration date "09/01/2025"
    And user selects medical license expiration date "09/01/2025"
    And user enters input into Logbook# field
    And user enters input into Logbook email field "test@test.com"
    And user enters input into Logbook password field "testpassword"
    And user clicks Staff checkbox
    Then user validates Staff checkmark is checked
    When user clicks Staff checkbox
    Then user validates Staff checkbox is unchecked

  @otherLocation
  Scenario: Validating Other Location Field functionality
    And user enters full name "John Doe"
    And user selects driving license expiration date "09/01/2025"
    And user selects medical license expiration date "09/01/2025"
    And user enters input into Logbook# field
    And user enters input into Logbook email field "test@test.com"
    And user enters input into Logbook password field "testpassword"
    And user clicks the Other Location search button
    And user clicks c
    And user double clicks the first address available
    Then user validates created location is selected
    When user clicks the trash can button
    Then user validates created location is deleted

  @localField
  Scenario: Validating Local Checkmark and Dropdown functionality
    And user enters full name "John Doe"
    And user selects driving license expiration date "09/01/2025"
    And user selects medical license expiration date "09/01/2025"
    And user enters input into Logbook# field
    And user enters input into Logbook email field "test@test.com"
    And user enters input into Logbook password field "testpassword"
    And user clicks on Local checkbox
    Then user validates Local checkmark is shown
    When user selects from "IL" from the Local State dropdown
    When user clicks on Local checkbox
    Then user validates Local checkbox is unchecked
    And Local State field is empty

  @validPhoneNumber
  Scenario: Validating Phone Number entry functionality with 11 numbers
    And user enters full name "John Doe"
    And user selects driving license expiration date "09/01/2025"
    And user selects medical license expiration date "09/01/2025"
    And user enters input into Logbook# field
    And user enters input into Logbook email field "test@test.com"
    And user enters input into Logbook password field "testpassword"
    And user enters phone number "1234567890"
    And user clicks on Create button
    Then user validates success message is displayed "Driver Created Successfully"

  @invalidPhoneNumber
  Scenario: Validating Phone Number entry functionality with less than 11 numbers
    And user enters full name "John Doe"
    And user selects driving license expiration date "09/01/2025"
    And user selects medical license expiration date "09/01/2025"
    And user enters input into Logbook# field
    And user enters input into Logbook email field "test@test.com"
    And user enters input into Logbook password field "testpassword"
    And user enters phone number "123456789"
    And user clicks on Create button
    Then user validates error message for phone number is displayed "Valid phone number required"

  @validEmail
  Scenario: Validating valid Email entry functionality
    And user enters full name "John Doe"
    And user selects driving license expiration date "09/01/2025"
    And user selects medical license expiration date "09/01/2025"
    And user enters input into Logbook# field
    And user enters input into Logbook email field "test@test.com"
    And user enters input into Logbook password field "testpassword"
    And user enters email address "John.Doe@Mindtek.io"
    And user clicks on Create button
    Then user validates success message is displayed "Driver Created Successfully"

  @invalidEmailMoreThanMax
  Scenario: Validating invalid Email entry with more than 50 characters
    And user enters full name "John Doe"
    And user selects driving license expiration date "09/01/2025"
    And user selects medical license expiration date "09/01/2025"
    And user enters input into Logbook# field
    And user enters input into Logbook email field "test@test.com"
    And user enters input into Logbook password field "testpassword"
    And user enters email address "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa@test.com"
    And user clicks on Create button
    Then user validates error message for email with more than 50 characters is displayed "String must contain at most 50 character(s)"

  @invalidEmailSpecialChar
  Scenario: Validating invalid Email entry with special characters
    And user enters full name "John Doe"
    And user selects driving license expiration date "09/01/2025"
    And user selects medical license expiration date "09/01/2025"
    And user enters input into Logbook# field
    And user enters input into Logbook email field "test@test.com"
    And user enters input into Logbook password field "testpassword"
    And user enters email address "!@#$%@test.com"
    And user clicks on Create button
    Then user validates error message for email with special characters is displayed "Enter the correct email address"