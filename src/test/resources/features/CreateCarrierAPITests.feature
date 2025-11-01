@regression @createCarrierAPI @api
Feature: Validating Post Carrier API for Name, Company type, and Abbreviation

  @smoke @TC34 @TC35 @TC36
  Scenario Outline: Validate Post Driver API call with valid name and abbreviation and 3 Carrier Types
    Given user sends Post Driver API call with valid name and abbreviation and 3 carrier types "<carrier_type>"
    Then user validates Post Carrier status code 200
    Then user validates response body has data matched with request data
    Examples:
      | carrier_type           |
      | Broker company         |
      | Carrier company        |
      | Broker+carrier company |

  @TC35 @TC36 @TC37
  Scenario Outline: Validate Post Driver API call with invalid carrier name field
    Given user sends Post Driver API call with "<carrier_name>" carrier_name field
    Then user validates Post Carrier status code <status_code>
    Then user validates Post Carrier API call response body error message "<error_message>"
    Examples:
      | carrier_name                                              | status_code | error_message                            |
      |                                                           | 422         | String should have at least 1 character  |
      | Thisisacarriernamethatislongerthanfiftycharactersinlength | 422         | String should have at most 50 characters |
      | null                                                      | 422         | Input should be a valid string           |

  @TC38 @TC39 @TC40
  Scenario Outline: Validate Post Driver API call with invalid abbreviation field
    Given user sends Post Driver API call with "<abbreviation>" abbreviation field
    Then user validates Post Carrier status code <status_code>
    Then user validates Post Carrier API call response body error message "<error_message>"
    Examples:
      | abbreviation | status_code | error_message                           |
      |              | 422         | String should have at least 1 character |
      | FOUR         | 422         | String should have at most 3 characters |
      | null         | 422         | Input should be a valid string          |

  @TC41 @TC42 @TC43
  Scenario Outline: Validate Post Driver API call with invalid carrier type field
    Given user sends Post Driver API call with "<carrier_type>" carrier_type field
    Then user validates Post Carrier status code <status_code>
    Then user validates Post Carrier API call response body error message "<error_message>"
    Examples:
      | carrier_type | status_code | error_message                                                                   |
      |              | 422         | Input should be 'Broker company', 'Carrier company' or 'Broker+carrier company' |
      | randomString | 422         | Input should be 'Broker company', 'Carrier company' or 'Broker+carrier company' |
      | null         | 422         | Input should be 'Broker company', 'Carrier company' or 'Broker+carrier company' |

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

  @TC46 @TC47 @TC48 @TC49
  Scenario Outline: Validate Post Carrier API call with invalid MC# field
    Given user sends Post Carrier API call with "<mc_number>" MC# field
    Then user validates Post Carrier status code <status_code>
    Then user validates Post Carrier API call response body error message "<error_message>"
    Examples:
      | mc_number                                                | status_code | error_message                            |
      |                                                          | 422         | String should have at least 4 character  |
      | Thisisacarriermcnumthatislongerthantencharactersinlength | 422         | String should have at most 10 characters |
      | null                                                     | 422         | Input should be a valid string           |

  @TC50 @TC51 @TC52 @TC53
  Scenario Outline: Validate Post Carrier API call with no characters in DOT# field
    Given user sends Post Carrier API call with "<dot_number>" DOT# field
    Then user validates Post Carrier status code <status_code>
    Then user validates Post Carrier API call response body error message "<error_message>"
    Examples:
      | dot_number                                                | status_code | error_message                            |
      |                                                           | 422         | String should have at least 4 character  |
      | Thisisacarrierdotnumthatislongerthantencharactersinlength | 422         | String should have at most 10 characters |
      | null                                                      | 422         | Input should be a valid string           |