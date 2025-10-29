@regression @editCarrierAPI @api @regression
Feature: Validating Edit Carriers API

  Background:
    Given user sends Post Driver API call with valid name and abbreviation and 3 carrier types "Broker company"

  @TC54 @smoke
  Scenario: Validate Put Carriers API call
    And user sends put carrier API call with valid data
    Then user validates Put Carrier status code 200
    Then user validates Put response body has data matched with request data

  @TC55 @TC56 @TC57
  Scenario Outline: Validate Put Carriers API call with invalid carrier name field
    And user sends Put Carrier API call with "<carrier_name>" carrier_name field
    Then user validates Put Carrier status code <status_code>
    Then user validates Put Carrier API call response body error message "<error_message>"
    Examples:
      | carrier_name                                              | status_code | error_message                            |
      |                                                           | 422         | String should have at least 1 character  |
      | Thisisacarriernamethatislongerthanfiftycharactersinlength | 422         | String should have at most 50 characters |
      | null                                                      | 422         | Input should be a valid string           |

  @TC58 @TC59 @TC60
  Scenario Outline: Validate Put Carriers API call with invalid MC# field
    And user sends Put Carriers API call with "<mc_number>" mc_number field
    Then user validates Put Carrier status code <status_code>
    Then user validates Put Carrier API call response body error message "<error_message>"
    Examples:
      | mc_number                                                  | status_code | error_message                            |
      |                                                            | 422         | String should have at least 1 character  |
      | Thisisacarriermcnumthatislongerthanfiftycharactersinlength | 422         | String should have at most 10 characters |
      | null                                                       | 422         | Input should be a valid string           |

  @TC61 @TC62 @TC63
  Scenario Outline: Validate Put Carriers API call with invalid DOT# field
    And user sends Put Carriers API call with "<dot_number>" dot_number field
    Then user validates Put Carrier status code <status_code>
    Then user validates Put Carrier API call response body error message "<error_message>"
    Examples:
      | dot_number                                                  | status_code | error_message                            |
      |                                                             | 422         | String should have at least 1 character  |
      | Thisisacarrierdotnumthatislongerthanfiftycharactersinlength | 422         | String should have at most 10 characters |
      | null                                                        | 422         | Input should be a valid string           |