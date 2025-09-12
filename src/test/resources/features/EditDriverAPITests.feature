@regression @editDriverAPI
Feature: Validating edit driver API

  Scenario: Validating Edit Driver API call with valid data
    Given User sends put API call with data
    Then User validates status code 200
    When User gets updated driver with get call
    Then User validates updated driver data in get call response
    And User validates updated_at field having the correct date


  Scenario: Validating Edit Driver API call invalid full_name no characters
    Given User sends put API call with data
      | full_name                  |      |
    Then User validates Edit Driver full_name response status code 422
    Then User validates Edit Driver full_name response body error message "String should have at least 1 character"


  Scenario: Validating Edit Driver API call invalid full_name 51 characters
    Given User sends put API call with data
      | full_name                 | Thisisafullnamethatislongerthanfiftycharactersinlength |
    Then User validates Edit Driver full_name response status code 422
    Then User validates Edit Driver full_name response body error message "String should have at most 50 characters"


  Scenario: Validating Edit Driver API call with is_staff false
    Given User sends put API call with data
      | is_staff                  | false |
    Then User validates Edit Driver is_staff status code 200
    When User gets updated driver with get call
    Then User validates updated driver data in get call response
