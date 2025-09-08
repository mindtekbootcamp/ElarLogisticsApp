@regression @createDriverAPI
Feature: Validating create driver API

  @smoke
  Scenario: Validating Create Driver API call with valid data
    Given user sends post api call with data
      | full_name                 | John Doe   |
      | is_staff                  | false      |
      | driving_license_exp       | 2025-08-21 |
      | medical_certification_exp | 2025-08-29 |
    Then user validates status code 200
    When user gets created driver with get call
    Then user validates created driver data in get call response

  @smoke
  Scenario: Validating Create Driver API call invalid full_name no characters
    Given user sends post api call with data
      | full_name                 |            |
      | is_staff                  | false      |
      | driving_license_exp       | 2025-08-21 |
      | medical_certification_exp | 2025-08-29 |
    Then user validates status code 422
    Then user validates response body error message "String should have at least 1 character"

  Scenario: Validating Create Driver API call invalid full_name null
    Given user sends post api call with data
      | full_name                 | null       |
      | is_staff                  | false      |
      | driving_license_exp       | 2025-08-21 |
      | medical_certification_exp | 2025-08-29 |
    Then user validates status code 422
    Then user validates response body error message "Input should be a valid string"

  Scenario: Validating Create Driver API call with invalid driving_license_exp empty
    Given user sends post api call with data
      | full_name                 | John Doe   |
      | is_staff                  | false      |
      | driving_license_exp       |            |
      | medical_certification_exp | 2025-08-29 |
    Then user validates status code 422
    Then user validates response body error message "Input should be a valid date or datetime, input is too short"

  Scenario: Validating Create Driver API call with invalid medical_certification_exp empty
    Given user sends post api call with data
      | full_name                 | John Doe   |
      | is_staff                  | false      |
      | driving_license_exp       | 2025-08-21 |
      | medical_certification_exp |            |
    Then user validates status code 422
    Then user validates response body error message "Input should be a valid date or datetime, input is too short"

  Scenario: Validating Create Driver API call with invalid driving_license_exp expired date
    Given user sends post api call with data
      | full_name                 | John Doe   |
      | is_staff                  | false      |
      | driving_license_exp       | 2024-08-21 |
      | medical_certification_exp | 2025-08-29 |
    Then user validates status code 400
    Then user validates response body error message "Select a valid date"

  @smoke
  Scenario: Validating Create Driver API call with invalid medical_certification_exp expired date
    Given user sends post api call with data
      | full_name                 | John Doe   |
      | is_staff                  | false      |
      | driving_license_exp       | 2025-08-21 |
      | medical_certification_exp | 2024-08-29 |
    Then user validates status code 400
    Then user validates response body error message "Select a valid date"

  Scenario: Validating Create Driver API call with invalid first_name 1 character
    Given user sends post api call with data
      | full_name                 | J          |
      | is_staff                  | false      |
      | driving_license_exp       | 2025-08-21 |
      | medical_certification_exp | 2025-08-29 |
    Then user validates status code 200
    When user gets created driver with get call
    Then user validates created driver data in get call response
