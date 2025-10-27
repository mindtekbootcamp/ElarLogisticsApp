@regression @createCarrierAPI1 @api
Feature: Validating Post Carrier API for Name, Company type, and Abbreviation

  @tc34 @smoke
  Scenario Outline: Validate Post Driver API call with valid name and abbreviation and 3 Carrier Types
    Given user sends Post Driver API call with valid name and abbreviation and 3 carrier types "<carrier_type>"
    Then user validates Post Carrier status code 200
    Then user validates response body has data matched with request data
    Examples:
      | carrier_type           |
      | Broker company         |
      | Carrier company        |
      | Broker+carrier company |

  @tc35
  Scenario: Validate Post Driver API call with no carrier name field
    Given user sends Post Driver API call with "" carrier_name field
    Then user validates Post Carrier status code 422
    Then user validates Post Carrier API call response body error message "String should have at least 1 character"

  @tc36
  Scenario: Validate Post Driver API call with longer than 50 characters carrier name field
    Given user sends Post Driver API call with "Thisisacarriernamethatislongerthanfiftycharactersinlength" carrier_name field
    Then user validates Post Carrier status code 422
    Then user validates Post Carrier API call response body error message "String should have at most 50 characters"

  @tc37
  Scenario: Validate Post Driver API call with null carrier name field
    Given user sends Post Driver API call with null carrier_name field
    Then user validates Post Carrier status code 422
    Then user validates Post Carrier API call response body error message "Input should be a valid string"

  @tc38
  Scenario: Validate Post Driver API call with no abbreviation field
    Given user sends Post Driver API call with "" abbreviation field
    Then user validates Post Carrier status code 422
    Then user validates Post Carrier API call response body error message "String should have at least 1 character"

  @tc39
  Scenario: Validate Post Driver API call with longer than 3 characters abbreviation field
    Given user sends Post Driver API call with longer than 3 characters abbreviation field
    Then user validates Post Carrier status code 422
    Then user validates Post Carrier API call response body error message "String should have at most 3 characters"

  @tc40
  Scenario: Validate Post Driver API call with null abbreviation field
    Given user sends Post Driver API call with null abbreviation field
    Then user validates Post Carrier status code 422
    Then user validates Post Carrier API call response body error message "Input should be a valid string"

  @tc41
  Scenario: Validate Post Driver API call with no carrier type field
    Given user sends Post Driver API call with "" carrier_type field
    Then user validates Post Carrier status code 422
    Then user validates Post Carrier API call response body error message "Input should be 'Broker company', 'Carrier company' or 'Broker+carrier company'"

  @tc42
  Scenario: Validate Post Driver API call with random string carrier type field
    Given user sends Post Driver API call with random string carrier_type field
    Then user validates Post Carrier status code 422
    Then user validates Post Carrier API call response body error message "Input should be 'Broker company', 'Carrier company' or 'Broker+carrier company'"

  @tc43
  Scenario: Validate Post Driver API call with null carrier type field
    Given user sends Post Driver API call with null carrier_type field
    Then user validates Post Carrier status code 422
    Then user validates Post Carrier API call response body error message "Input should be 'Broker company', 'Carrier company' or 'Broker+carrier company'"