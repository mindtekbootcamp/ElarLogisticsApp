@regression @elar @addDriver
Feature: Validations for Elar Logistics Add Driver functionality

  Background: Setup
    Given user logs in to to elar logistics app
    When user navigates to the Add Driver page

  @createMinimumRequirements
  Scenario: Validating Create Button Minimum Requirements
    And user clicks on Create button
    Then user validates error message is shown "Required"

  @validFullName
  Scenario: Validating valid Full Name input
    And user enters valid full name "John Doe"
    And user selects valid driving license expiration date
    And user selects valid medical license expiration date
    And user enters valid input into Logbook# field
    And user enters valid input into Logbookemail field
    And user clicks on Create button
    Then user validates success message is displayed "Driver Created Successfully"

  @invalidFullName
  Scenario: Validating invalid Full Name with more than 50 characters
    And user enters name with more than fifty characters
    And user selects valid driving license expiration date
    And user selects valid medical license expiration date
    And user enters valid input into Logbook# field
    And user enters valid input into Logbookemail field
    And user clicks on Create button
    Then user validates error message is displayed "String must contain at most 50 character(s)"

  @invalidFullName
  Scenario: Validating invalid Full Name with special characters
    And user enters name with special characters
    And user selects valid driving license expiration date
    And user selects valid medical license expiration date
    And user enters valid input into Logbook# field
    And user enters valid input into Logbookemail field
    And user clicks on Create button
    Then user validates error message is displayed "Input must contain only alphanumeric and specific punctuation characters"

  @validDrivingLicenseExp
  Scenario: Validating valid Driving License Expiration date with future date
    And user enter valid full name
    And user selects any future date for Driving License Expiration date
    And user selects valid medical license expiration date
    And user enters valid input into Logbook# field
    And user enters valid input into Logbookemail field
    And user clicks on Create button
    Then user validates success message is displayed "Driver Created Successfully"

  @invalidDrivingLicenseExp
  Scenario: Validating invalid Driving License Expiration date with past date
    And user enter valid full name
    And user selects any past date for Driving License Expiration date
    And user selects valid medical license expiration date
    And user enters valid input into Logbook# field
    And user enters valid input into Logbookemail field
    And user clicks on Create button
    Then user validates error message is displayed "Only future dates can be select"

  @invalidDrivingLicenseExp
  Scenario: Validating invalid Driving License Expiration date with current date
    And user enter valid full name
    And user selects current date for Driving License Expiration date
    And user selects valid medical license expiration date
    And user enters valid input into Logbook# field
    And user enters valid input into Logbookemail field
    And user clicks on Create button
    Then user validates error message is displayed "Only future dates can be select"

  @validMedicalLicenseExp
  Scenario: Validating valid Medical License Expiration date with future date
    And user enter valid full name
    And user selects valid driver license expiration date
    And user selects any future date for Medical License Expiration date
    And user enters valid input into Logbook# field
    And user enters valid input into Logbookemail field
    And user clicks on Create button
    Then user validates success message is displayed "Driver Created Successfully"

  @invalidMedicalLicenseExp
  Scenario: Validating invalid Medical License Expiration date with past date
    And user enter valid full name
    And user selects valid driver license expiration date
    And user selects any past date for Medical License Expiration date
    And user enters valid input into Logbook# field
    And user enters valid input into Logbookemail field
    And user clicks on Create button
    Then user validates error message is displayed "Only future dates can be select"

  @invalidMedicalLicenseExp
  Scenario: Validating invalid Medical License Expiration date with current date
    And user enter valid full name
    And user selects valid driver license expiration date
    And user selects current date for Medical License Expiration date
    And user enters valid input into Logbook# field
    And user enters valid input into Logbookemail field
    And user clicks on Create button
    Then user validates error message is displayed "Only future dates can be select"

  @staffCheckBox
  Scenario: Validating Staff checkbox functionality
    And user enters valid full name
    And user selects valid driving license expiration date
    And user selects valid medical license expiration date
    And user enters valid input into Logbook# field
    And user enters valid input into Logbookemail field
    And user clicks Staff checkbox
    Then user validates checkmark is shown
    When user clicks Staff checkbox
    Then user validates checkbox is unchecked

  @otherLocation
  Scenario: Validating Other Location Field functionality
    And user enters valid full name
    And user selects valid driving license expiration date
    And user selects valid medical license expiration date
    And user enters valid input into Logbook# field
    And user enters valid input into Logbookemail field
    And user clicks the Other Location search button
    And user clicks the Create New button
    And user clicks the Create button
    Then user validates created location is selected
    When user clicks the trash can button
    Then user validates created location is deleted

  @localField
  Scenario: Validating Local Field functionality with valid email
    And user enters valid full name
    And user selects valid driving license expiration date
    And user selects valid medical license expiration date
    And user enters valid input into Logbook# field
    And user enters valid input into Logbookemail field
    And user clicks on Local checkbox
    Then user validates checkmark is shown
    When user clicks on Local State dropdown
    And user selects the local state "IL"
    Then user validates "IL" is shown in the Local State field
    When user clicks on Local checkbox
    Then user validates checkbox is unchecked
    And Local State field is empty

  @validPhoneNumber
  Scenario: Validating Phone Number entry functionality with 11 numbers
    And user enters valid full name
    And user selects valid driving license expiration date
    And user selects valid medical license expiration date
    And user enters valid input into Logbook# field
    And user enters valid input into Logbookemail field
    And user clicks the plus icon
    And user enters valid phone number
    And user clicks on Create button
    Then user validates success message is displayed "Driver Created Successfully"

  @invalidPhoneNumber
  Scenario: Validating Phone Number entry functionality with less than 11 numbers
    And user enters valid full name
    And user selects valid driving license expiration date
    And user selects valid medical license expiration date
    And user enters valid input into Logbook# field
    And user enters valid input into Logbookemail field
    And user clicks the plus icon
    And user enters 7 numbers
    And user clicks on Create button
    Then user validates error message is displayed "Valid phone number required"

  @validEmail
  Scenario: Validating valid Email entry functionality
    And user enters valid full name
    And user selects valid driving license expiration date
    And user selects valid medical license expiration date
    And user enters valid input into Logbook# field
    And user enters valid input into Logbookemail field
    And user enters email address "John.Doe@Mindtek.io"
    And user clicks on Create button
    Then user validates success message is displayed "Driver Created Successfully"

  @invalidEmail
  Scenario: Validating invalid Email entry with more than 50 characters
    And user enters valid full name
    And user selects valid driving license expiration date
    And user selects valid medical license expiration date
    And user enters valid input into Logbook# field
    And user enters valid input into Logbookemail field
    And user enters name with more than 50 characters
    Then user validates error message is displayed "String must contain at most 50 character(s)"

  @invalidEmail
  Scenario: Validating invalid Email entry with special characters
    And user enters valid full name
    And user selects valid driving license expiration date
    And user selects valid medical license expiration date
    And user enters valid input into Logbook# field
    And user enters valid input into Logbookemail field
    And user enters name with special characters
    Then user validates error message is displayed "Enter the correct email address"