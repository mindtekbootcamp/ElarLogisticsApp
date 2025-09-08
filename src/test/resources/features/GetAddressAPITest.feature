@getAddressAPI
Feature: Validating Get Address API

  Scenario Outline: Validate Get Address API call with valid order_by and size parameters
    Given user sends Address Get API call with valid order_by "<order_by>" parameters and size 50
    Then user validates get address status code 200
    Examples:
      | order_by |
      | id       |
      | address  |
      | city     |
      | zip_code |
      | name     |

  Scenario: Validate Get Address API call with invalid order_by parameter and size 50
    Given user sends Address Get API call with invalid "null" order_by parameter and size 50
    Then user validates get address status code 422
    Then user validates get address response body error message "Value error, null is not a valid ordering field."

  Scenario: Validate Get Address API call with valid order_by parameter and valid minimum size
    Given user sends Address Get API call with valid order_by parameter id and valid size 1
    Then user validates get address status code 200

  Scenario: Validate Get Address API call with valid order_by parameter and valid maximum size
    Given user sends Address Get API call with valid order_by parameter id and valid size 100
    Then user validates get address status code 200

  Scenario: Validate Get Address API call with valid order_by parameter and invalid size 0
    Given user sends Address Get API call with valid order_by parameter id and invalid size 0
    Then user validates get address status code 422
    Then user validates get address response body error message "Input should be greater than or equal to 1"

  Scenario: Validate Get Address API call with valid order_by parameter and invalid size -1
    Given user sends Address Get API call with valid order_by parameter id and invalid size -1
    Then user validates get address status code 422
    Then user validates get address response body error message "Input should be greater than or equal to 1"

  Scenario: Validate Get Address API call with valid order_by parameter and invalid size 101
    Given user sends Address Get API call with valid order_by parameter id and invalid size 101
    Then user validates get address status code 422
    Then user validates get address response body error message "Input should be less than or equal to 100"