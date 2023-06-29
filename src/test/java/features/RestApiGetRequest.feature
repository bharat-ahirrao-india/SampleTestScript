Feature: Verify the Get Request In the API

  Scenario Outline: GET all Request from the API
    Given Get call to "<url>"
    Then Response is "<statusCode>"
    Examples:
      | url    | statusCode |
      | /posts | 200        |