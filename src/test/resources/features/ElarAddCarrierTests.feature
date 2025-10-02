@regression @addCarrierUI
Feature: Validate Add Carrier UI Functionality

  Background: Setup
    Given user logs in to to elar logistics app
    When user navigates to the Carriers page
    And user clicks on Add Carrier button

  @TC34
  Scenario: Validating valid Carrier name input
    And user enters required data fields
      | carrier_name      | $unique Co         |
      | abbreviation      | $unique short      |
      | carrier_type      | Broker company     |
      | mc_number         | $unique long       |
      | dot_number        | $unique long       |
      | insurance         | Cucumber Insurance |
      | policy_expiration | 10302026           |
      | policy_number     | 0123456789         |
    And user clicks the Address Search button
    And user clicks the first address
    And user clicks Create New Button for Carriers
    Then user validates Carrier Created Successfully message "Carrier Created Successfully"

  @TC35
  Scenario: Validating invalid Carrier name with 0 characters
    And user enters required data fields
      | carrier_name      |                    |
      | abbreviation      | $unique short      |
      | carrier_type      | Broker company     |
      | mc_number         | $unique long       |
      | dot_number        | $unique long       |
      | insurance         | Cucumber Insurance |
      | policy_expiration | 10302026           |
      | policy_number     | 0123456789         |
    And user clicks the Address Search button
    And user clicks the first address
    And user clicks Create New Button for Carriers
    Then user validates Carrier error message for name with 0 characters "String must contain at least 1 character(s)"

  @TC36
  Scenario: Validating invalid Carrier name with more than 50 characters
    And user enters required data fields
      | carrier_name      | Thisisacarriernamethatislongerthanfiftycharactersinlength |
      | abbreviation      | $unique short                                             |
      | carrier_type      | Broker company                                            |
      | mc_number         | $unique long                                              |
      | dot_number        | $unique long                                              |
      | insurance         | Cucumber Insurance                                        |
      | policy_expiration | 10302026                                                  |
      | policy_number     | 0123456789                                                |
    And user clicks the Address Search button
    And user clicks the first address
    And user clicks Create New Button for Carriers
    Then user validates Carrier error message for name with more than 50 characters "String must contain at most 50 character(s)"

  @TC37
  Scenario: Validating invalid Carrier name with special characters
    And user enters required data fields
      | carrier_name      | !@#$               |
      | abbreviation      | $unique short      |
      | carrier_type      | Broker company     |
      | mc_number         | $unique long       |
      | dot_number        | $unique long       |
      | insurance         | Cucumber Insurance |
      | policy_expiration | 10302026           |
      | policy_number     | 0123456789         |
    And user clicks the Address Search button
    And user clicks the first address
    And user clicks Create New Button for Carriers
    Then user validates Carrier error message for name with special characters "Input must contain only alphanumeric and specific punctuation characters"

  @TC38
  Scenario: Validating valid Abbreviation
    And user enters required data fields
      | carrier_name      | $unique Co         |
      | abbreviation      | $unique short      |
      | carrier_type      | Broker company     |
      | mc_number         | $unique long       |
      | dot_number        | $unique long       |
      | insurance         | Cucumber Insurance |
      | policy_expiration | 10302026           |
      | policy_number     | 0123456789         |
    And user clicks the Address Search button
    And user clicks the first address
    And user clicks Create New Button for Carriers
    Then user validates Carrier Created Successfully message "Carrier Created Successfully"

  @TC39
  Scenario: Validating invalid Abbreviation with 0 characters
    And user enters required data fields
      | carrier_name      | $unique Co         |
      | abbreviation      |                    |
      | carrier_type      | Broker company     |
      | mc_number         | $unique long       |
      | dot_number        | $unique long       |
      | insurance         | Cucumber Insurance |
      | policy_expiration | 10302026           |
      | policy_number     | 0123456789         |
    And user clicks the Address Search button
    And user clicks the first address
    And user clicks Create New Button for Carriers
    Then user validates Carrier error message for Abbreviation with 0 characters "String must contain at least 1 character(s)"

  @TC40
  Scenario: Validating invalid Abbreviation with more than 3 characters
    And user enters required data fields
      | carrier_name      | $unique Co         |
      | abbreviation      | FOUR               |
      | carrier_type      | Broker company     |
      | mc_number         | $unique long       |
      | dot_number        | $unique long       |
      | insurance         | Cucumber Insurance |
      | policy_expiration | 10302026           |
      | policy_number     | 0123456789         |
    And user clicks the Address Search button
    And user clicks the first address
    And user clicks Create New Button for Carriers
    Then user validates Carrier error message for Abbreviation with more than 3 characters "String must contain at most 3 character(s)"

  @TC41
  Scenario: Validating Abbreviation with special characters
    And user enters required data fields
      | carrier_name      | $unique Co         |
      | abbreviation      | !@#                |
      | carrier_type      | Broker company     |
      | mc_number         | $unique long       |
      | dot_number        | $unique long       |
      | insurance         | Cucumber Insurance |
      | policy_expiration | 10302026           |
      | policy_number     | 0123456789         |
    And user clicks the Address Search button
    And user clicks the first address
    And user clicks Create New Button for Carriers
    Then user validates Carrier error message for Abbreviation with special characters "Input must contain only alphanumeric and specific punctuation characters"

  @TC42
  Scenario: Validating Company type drop-down with Broker company
    And user enters required data fields
      | carrier_name      | $unique Co         |
      | abbreviation      | $unique short      |
      | carrier_type      | Broker company     |
      | mc_number         | $unique long       |
      | dot_number        | $unique long       |
      | insurance         | Cucumber Insurance |
      | policy_expiration | 10302026           |
      | policy_number     | 0123456789         |
    And user clicks the Address Search button
    And user clicks the first address
    And user clicks Create New Button for Carriers
    Then user validates Carrier Created Successfully message "Carrier Created Successfully"

  @TC43
  Scenario: Validating Company type drop-down with Carrier company
    And user enters required data fields
      | carrier_name      | $unique Co         |
      | abbreviation      | $unique short      |
      | carrier_type      | Carrier company    |
      | mc_number         | $unique long       |
      | dot_number        | $unique long       |
      | insurance         | Cucumber Insurance |
      | policy_expiration | 10302026           |
      | policy_number     | 0123456789         |
    And user clicks the Address Search button
    And user clicks the first address
    And user clicks Create New Button for Carriers
    Then user validates Carrier Created Successfully message "Carrier Created Successfully"

  @TC44
  Scenario: Validating Company type drop-down with Broker+carrier company
    And user enters required data fields
      | carrier_name      | $unique Co             |
      | abbreviation      | $unique short          |
      | carrier_type      | Broker+carrier company |
      | mc_number         | $unique long           |
      | dot_number        | $unique long           |
      | insurance         | Cucumber Insurance     |
      | policy_expiration | 10302026               |
      | policy_number     | 0123456789             |
    And user clicks the Address Search button
    And user clicks the first address
    And user clicks Create New Button for Carriers
    Then user validates Carrier Created Successfully message "Carrier Created Successfully"