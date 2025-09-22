@regression @getDriverAPI
Feature: Validating Get Driver API

  @tc26 @smoke
  Scenario Outline: Validate Get Driver API call with valid is_staff parameters and valid order_by and size parameters
    Given user sends Get Driver API call with valid is_staff "<is_staff>" parameters and valid order_by "id" and size 5 parameters
    Then user validates Get Driver status code 200
    Examples:
      | is_staff |
      | true     |
      | false    |

  @tc27
  Scenario: Validate Get Driver API call with null is_staff parameter and valid order_by id and size 5 parameters
    Given user sends Get Driver API call with "null" is_staff parameter and valid order_by "id" and size 5 parameters
    Then user validates Get Driver status code 422
    Then user validates Get Driver response body error message "Input should be a valid boolean, unable to interpret input"

  @tc28
  Scenario: Validate Get Driver API call with valid is_staff parameter and invalid full_name order_by parameter and valid size 5 parameter
    Given user sends Get Driver API call with valid is_staff parameter and invalid order_by "full_name" parameter and valid size 5 parameter
    Then user validates Get Driver status code 422
    Then user validates Get Driver response body error message "Input should be a valid order_by, unable to interpret input"

  @tc29
  Scenario: Validate Get Driver API call with valid is_staff parameter and null order_by parameter and valid size 5 parameter
    Given user sends Get Driver API call with valid is_staff parameter and "null" order_by parameter and valid size 5 parameter
    Then user validates Get Driver status code 422
    Then user validates Get Driver response body error message "Value error, null is not a valid ordering field."

  @tc30 @smoke
  Scenario Outline: Validate Get Driver API call with valid is_staff and valid order_by id parameters and min and max size parameters
    Given user sends Get Driver API call with valid is_staff and valid order_by "id" parameters and min and max sizes <size>
    Then user validates Get Driver status code 200
    Examples:
      | size |
      | 1    |
      | 100  |

  @tc31
  Scenario: Validate Get Driver API call with valid is_staff and valid order_by id parameters and null size parameter
    Given user sends Get Driver API call with valid is_staff and valid order_by "id" parameters and "null" size parameter
    Then user validates Get Driver status code 422
    Then user validates Get Driver response body error message "Input should be a valid integer, unable to parse string as an integer"

  @tc32
  Scenario Outline: Validate Get Driver API call with valid is_staff and valid order_by id parameters and smaller size parameters
    Given user sends Get Driver API call with valid is_staff and valid order_by "id" parameters and smaller sizes <size>
    Then user validates Get Driver status code 422
    Then user validates Get Driver response body error message "Input should be greater than or equal to 1"
    Examples:
      | size |
      | 0    |
      | -1   |

  @tc33
  Scenario: Validate Get Driver API call with valid is_staff and valid order_by id parameters and invalid larger size parameters
    Given user sends Get Driver API call with valid is_staff and valid order_by "id" parameters and invalid larger size 101
    Then user validates Get Driver status code 422
    Then user validates Get Driver response body error message "Input should be less than or equal to 100"