@regression @editDriverAPI @api
Feature: Validating edit driver API

  Scenario: Validating Edit Driver API call with valid data
    Given user sends post api call with data
      | full_name                 | John Doe   |
      | is_staff                  | false      |
      | driving_license_exp       | 2025-08-21 |
      | medical_certification_exp | 2025-08-29 |
    And user sends put API call with data
    Then user validates put API status code 200
    When user gets updated driver with get call
    Then user validates updated driver data in get call response
    And user validates updated_at field having the correct date


  Scenario: Validating Edit Driver API call invalid full_name no characters
    Given user sends post api call with data
      | full_name                 | John Doe   |
      | is_staff                  | false      |
      | driving_license_exp       | 2025-08-21 |
      | medical_certification_exp | 2025-08-29 |
    And user sends put API call with data with no full_name
    Then user validates Edit Driver full_name response status code 422
    Then user validates Edit Driver full_name response body error message "String should have at least 1 character"


  Scenario: Validating Edit Driver API call invalid full_name 51 characters
    Given user sends post api call with data
      | full_name                 | John Doe   |
      | is_staff                  | false      |
      | driving_license_exp       | 2025-08-21 |
      | medical_certification_exp | 2025-08-29 |
    And user sends put API call with data with "Thisisafullnamethatislongerthanfiftycharactersinlength" full_name
    Then user validates Edit Driver full_name response status code 422
    Then user validates Edit Driver full_name response body error message "String should have at most 50 characters"


  Scenario Outline: Validating Edit Driver API call with is_staff false
    Given user sends post api call with data
      | full_name                 | John Doe   |
      | is_staff                  | false      |
      | driving_license_exp       | 2025-08-21 |
      | medical_certification_exp | 2025-08-29 |
    And user sends put API call with data with is_staff status is "<is_staff>"
    Then user validates Edit Driver is_staff status code 200
    When user gets updated driver with get call
    Then user validates updated driver data is_staff is "<is_staff>" in get call response
    Examples:
      | is_staff |
      | true     |
      | false    |
