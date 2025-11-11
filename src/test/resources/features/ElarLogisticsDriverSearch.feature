@regression @searchDriverUI @api @ui
Feature: Validations for Elar Logistics Search Driver functionality

  Background: Setup
    Given user logs in to to elar logistics app
    When user navigates to the Drivers page
    And user clicks on Search field

  @TC16 @smoke
  Scenario: Validating Search with Valid ID
    And user clicks ID button
    And user enters ID from get call response
    Then user validates only drivers with provided ID search criteria should be shown

#  @searchInvalidIDWithLessThanFourChar @smoke
#  Scenario: Validating Search with invalid ID with less than 4 characters
#    And user clicks ID button
#    And user enters ID "999"
#    Then user validates only drivers with provided ID search criteria should be shown

  @TC19 @TC20
  Scenario Outline: Validating Search with invalid ID with alphabetic characters
    And user clicks ID button
    And user enters ID "<id>"
    Then user validates that no drivers should be shown
    Examples:
      | id   |
      |      |
      | asdf |
      | !@#$ |

  @TC22
  Scenario: Validating Search with valid full name
    And user clicks NAME button
    And user searches full name from get call response
    Then user validates only drivers with provided Full Name search criteria should be shown

  @TC24
  Scenario: Validating Search with invalid full name with special characters
    And user clicks NAME button
    And user searches full name "!@#$%"
    Then user validates that no drivers should be shown

  @TC25 @smoke
  Scenario: Validating Search with valid email
    And user clicks EMAIL or PHONE button
    And user searches email address from get call response
    Then user validates only drivers with provided Email search criteria should be shown

  @TC27
  Scenario: Validating Search with invalid email with special characters
    And user clicks EMAIL or PHONE button
    And user searches email address "!@#$@gmail.com"
    Then user validates that no drivers should be shown

  Scenario: Validating Search with valid email
    And user clicks EMAIL or PHONE button
    And user searches phone number from get call response
    Then user validates only drivers with provided Phone search criteria should be shown

  Scenario Outline: Validating Search with valid phone number
    And user clicks EMAIL or PHONE button
    And user searches phone number "<contacts_phone>"
    Then user validates only drivers with provided Phone search criteria should be shown
    Examples:
      | contacts_phone    |
      | +1 (234) 567-8900 |
      | (234) 567-8900    |
      | 2345678900        |

  Scenario Outline: Validating Search with invalid Phone number
    And user clicks EMAIL or PHONE button
    And user searches phone number "<contacts_phone>"
    Then user validates only drivers with provided Phone search criteria should be shown
    Examples:
      | contacts_phone |
      | (234) 567      |
      | 56789          |

  @searchInvalidPhoneWithMoreThanTenNum
  Scenario: Validating Search with invalid phone number with greater than ten numbers
    And user clicks EMAIL or PHONE button
    And user searches phone number "23456789001"
    Then user validates that no drivers should be shown
