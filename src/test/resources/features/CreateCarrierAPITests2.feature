@regression @createCarrierAPI2
Feature: Validating Post Carrier API for Status, MC#, and DOT#

  @TC45 @smoke
  Scenario Outline: Validate Post Carrier API call with 3 Statuses and valid MC# and valid DOT#
    Given user sends Post Carrier API call with 3 Statuses "<status>" and valid MC# and DOT#
    Then user validates Post Carrier status code 200
    Then user validates response body has data matched with request data
    Examples:
      | status     |
      | Active     |
      | Non-active |
      | Preclosure |

  @TC46
  Scenario: Validate Post Carrier API call with no MC# field
    Given user sends Post Carrier API call with "" characters in MC# field
    Then user validates Post Carrier status code 422
    Then user validates Post Carrier API call response body error message "String should have at least 4 character"

  @TC47
  Scenario: Validate Post Carrier API call with less than 4 characters in MC# field
    Given user sends Post Carrier API call with less than 4 characters in MC# field
    Then user validates Post Carrier status code 422
    Then user validates Post Carrier API call response body error message "String should have at least 4 character"

  @TC48
  Scenario: Validate Post Carrier API call with more than 10 characters in MC# field
    Given user sends Post Carrier API call with more than 10 characters in MC# field
    Then user validates Post Carrier status code 422
    Then user validates Post Carrier API call response body error message "String should have at most 10 characters"

  @TC49
  Scenario: Validate Post Carrier API call with null in MC# field
    Given user sends Post Carrier API call with null in MC# field
    Then user validates Post Carrier status code 422
    Then user validates Post Carrier API call response body error message "Input should be a valid string"

  @TC50
  Scenario: Validate Post Carrier API call with no characters in DOT# field
    Given user sends Post Carrier API call with "" characters in DOT# field
    Then user validates Post Carrier status code 422
    Then user validates Post Carrier API call response body error message "String should have at least 4 character"

  @TC51
  Scenario: Validate Post Carrier API call with less than 4 characters in DOT# field
    Given user sends Post Carrier API call with less than 4 characters in DOT# field
    Then user validates Post Carrier status code 422
    Then user validates Post Carrier API call response body error message "String should have at least 4 character"

  @TC52
  Scenario: Validate Post Carrier API call with more than 10 characters in DOT# field
    Given user sends Post Carrier API call with more than 10 characters in DOT# field
    Then user validates Post Carrier status code 422
    Then user validates Post Carrier API call response body error message "String should have at most 10 characters"

  @TC53
  Scenario: Validate Post Carrier API call with null in DOT# field
    Given user sends Post Carrier API call with null in DOT# field
    Then user validates Post Carrier status code 422
    Then user validates Post Carrier API call response body error message "Input should be a valid string"