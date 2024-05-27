Feature: API CRUD calls

  @API-CRUD
  Scenario: API test for CRUD
    Given create JSon data
    Then get JSon by id 2
    And update JSon by id 2
    Then get JSon by id 2
    And delete JSon by id 2
    Then get JSon by id 2
    Then get JSon by id 3