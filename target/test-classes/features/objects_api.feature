Feature: Objects API
 
  Scenario: Retrieve the list of objects
    Given the objects API is available
    When I request the list of objects
    Then the response status should be 200
    And the response should contain objects