@regression @getAddressAPI @api
Feature: Validating Get Address API

  @smoke
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

@smoke
  Scenario Outline: Validate Get Address API call with valid order_by parameter id and valid min and max sizes
    Given user sends Address Get API call with valid order_by parameter id and valid sizes <size>
    Then user validates get address status code 200
    Examples:
      | size |
      | 1    |
      | 100  |

  Scenario Outline: Validate Get Address API call with valid order_by parameter id and invalid smaller sizes
    Given user sends Address Get API call with valid order_by parameter id and invalid smaller sizes <size>
    Then user validates get address status code 422
    Then user validates get address response body error message "Input should be greater than or equal to 1"
    Examples:
      | size |
      | 0    |
      | -1   |

  Scenario: Validate Get Address API call with valid order_by parameter id and invalid larger sizes
    Given user sends Address Get API call with valid order_by parameter id and invalid larger size 101
    Then user validates get address status code 422
    Then user validates get address response body error message "Input should be less than or equal to 100"
