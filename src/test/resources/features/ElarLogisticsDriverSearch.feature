@regression @elar @searchDriver
Feature: Validations for Elar Logistics Search Driver functionality

  Background: Setup
    Given user logs in to to elar logistics app
    When user navigates to the Drivers page
    And user clicks on Search field

  @searchValidID
  Scenario: Validating Search with Valid ID
    And user clicks ID button
    And user enters ID "1234"
    Then user validates only drivers with provided ID search criteria should be shown

  @searchInvalidIDWithLessThanFourChar
  Scenario: Validating Search with invalid ID with less than 4 characters
    And user clicks ID button
    And user enters ID "999"
    Then user validates only drivers with provided ID search criteria should be shown

  @searchInvalidIDWithAlphabeticChar
  Scenario: Validating Search with invalid ID with alphabetic characters
    And user clicks ID button
    And user enters ID "asdf"
    Then user validates that no drivers should be shown

  @searchInvalidIDWithSpecialChar
  Scenario: Validating Search with invalid ID with special characters
    And user clicks ID button
    And user enters ID "!@#$"
    Then user validates that no drivers should be shown

  @searchInvalidIDWithNoInput
  Scenario: Validating Search with ID with no input
    And user clicks ID button
    And user enters ID ""
    Then user validates that all drivers should be shown

  @searchValidFullName
  Scenario: Validating Search with valid full name
    And user clicks NAME button
    And user searches full name "Kyle Smith"
    Then user validates only drivers with provided Full Name search criteria should be shown

  @searchInvalidNameWithSpecialChar
  Scenario: Validating Search with invalid full name with special characters
    And user clicks NAME button
    And user searches full name "!@#$%"
    Then user validates that no drivers should be shown

  @searchValidEmail
  Scenario: Validating Search with valid email
    And user clicks EMAIL or PHONE button
    And user searches email address "abc@gmail.com"
    Then user validates only drivers with provided Email search criteria should be shown

  @searchInvalidEmailWithSpecialChar
  Scenario: Validating Search with invalid email with special characters
    And user clicks EMAIL or PHONE button
    And user searches email address "!@#$@gmail.com"
    Then user validates that no drivers should be shown

  @searchValidPhoneWithSpecPunctuationChar
  Scenario: Validating Search with valid phone number with specific punctuation
    And user clicks EMAIL or PHONE button
    And user searches phone number "(123) 456-7890"
    Then user validates only drivers with provided Phone search criteria should be shown

  @searchValidPhoneWithoutSpecPunctuationChar
  Scenario: Validating Search with valid phone number without specific punctuation
    And user clicks EMAIL or PHONE button
    And user searches phone number "1234567890"
    Then user validates only drivers with provided Phone search criteria should be shown

  @searchValidPhoneWithPlusOne
  Scenario: Validating Search with valid phone number with +1 in front
    And user clicks EMAIL or PHONE button
    And user searches phone number "+1 (123) 456-7890"
    Then user validates only drivers with provided Phone search criteria should be shown

  @searchInvalidPhoneWithMoreThanTenNum
  Scenario: Validating Search with invalid phone number with greater than ten numbers
    And user clicks EMAIL or PHONE button
    And user searches phone number "12345678901"
    Then user validates that no drivers should be shown

  @searchInvalidPhoneWithLessThanTenNumWithSpecPunctuationChar
  Scenario: Validating Search with invalid Phone number with less than 10 numbers with specific punctuation characters
    And user clicks EMAIL or PHONE button
    And user searches phone number "(123) 456"
    Then user validates only drivers with provided Phone search criteria should be shown

  @searchInvalidPhoneWithLessThanTenNumWithoutSpecPunctuationChar
  Scenario: Validating Search with invalid Phone number with less than 10 numbers with specific punctuation characters
    And user clicks EMAIL or PHONE button
    And user searches phone number "123456"
    Then user validates only drivers with provided Phone search criteria should be shown