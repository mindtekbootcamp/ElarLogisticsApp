@createAddressAPI
Feature: Validating create address API

  Scenario: Validating Create Address API call with valid data
    Given user sends create address post api call with data
      | address  | 123 Test Ave |
      | city     | Chicago      |
      | state    | IL           |
      | zip_code | 60656        |
      | name     | Tom Jerry    |
    Then user validates create address status code 200
    When user gets created address with get call
    Then user validates created address data in get call response

  Scenario: Validate Create Address API call with invalid empty "state"
    Given user sends create address post api call with data
      | address  | 123 Test Ave |
      | city     | Chicago      |
      | state    |              |
      | zip_code | 60656        |
      | name     | Tom Jerry    |
    Then user validates create address status code 422
    Then user validates create address response body error message "Input should be 'AL', 'AZ', 'AR', 'CA', 'CO', 'CT', 'DE', 'DC', 'FL', 'GA', 'HI', 'ID', 'IL', 'IN', 'IA', 'KS', 'KY', 'LA', 'ME', 'MD', 'MA', 'MI', 'MN', 'MS', 'MO', 'MT', 'NE', 'NV', 'NH', 'NJ', 'NM', 'NY', 'NC', 'ND', 'OH', 'OK', 'OR', 'PA', 'RI', 'SC', 'SD', 'TN', 'TX', 'UT', 'VT', 'VA', 'WA', 'WV', 'WI', 'WY', 'FL Central', 'FL Eastern', 'ID Mountain', 'ID Pacific', 'IN Central', 'IN Eastern', 'KS Central', 'KS Mountain', 'KS Standard', 'KY Central', 'KY Eastern', 'KY Standard', 'MI Central', 'MI Eastern', 'ND Central', 'ND Mountain', 'NE Central', 'NE Mountain', 'OR Mountain', 'OR Pacific', 'SD Central', 'SD Mountain', 'TN Central', 'TN Eastern', 'TX Central', 'TX Mountain' or 'TX Standard'"

  Scenario: Validate Create Address API call with invalid "city" 29 characters
    Given user sends create address post api call with data
      | address  | 123 Test Ave                  |
      | city     | ChicagoChicagoChicagoChicagoo |
      | state    | IL                            |
      | zip_code | 60656                         |
      | name     | Tom Jerry                     |
    Then user validates create address status code 422
    Then user validates create address response body error message "String should have at most 28 characters"

  Scenario: Validate Create Address API call with invalid "name" 51 characters
    Given user sends create address post api call with data
      | address  | 123 Test Ave                                        |
      | city     | Chicago                                             |
      | state    | IL                                                  |
      | zip_code | 60656                                               |
      | name     | aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa |
    Then user validates create address status code 422
    Then user validates create address response body error message "String should have at most 50 characters"

  Scenario: Validate Create Address API call with invalid "address" 51 characters
    Given user sends create address post api call with data
      | address  | aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa |
      | city     | Chicago                                             |
      | state    | IL                                                  |
      | zip_code | 60656                                               |
      | name     | Tom Jerry                                           |
    Then user validates create address status code 422
    Then user validates create address response body error message "String should have at most 50 characters"

  Scenario: Validate Create Address API call with invalid "zip_code" 6 characters
    Given user sends create address post api call with data
      | address  | 123 Test Ave |
      | city     | Chicago      |
      | state    | IL           |
      | zip_code | 606561       |
      | name     | Tom Jerry    |
    Then user validates create address status code 422
    Then user validates create address response body error message "String should have at most 5 characters"