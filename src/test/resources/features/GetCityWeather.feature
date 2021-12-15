Feature:Weatherbit.io is a free to use website (and JSON API service) that can
  be used to query the weather forecast of major cities around the
  world. More information can be found here: https://www.weatherbit.io/
  api/weather-forecast-16-day
  The Mission Is to implement a test to automate the following acceptance criteria
  (in the form of a BDD) in your tool of choice/language
  User searching for top suburbs Surf beaches in Sydney via APIs

  Scenario Outline: As a choosey surfer
    Given I like to surf in any of top beaches '<postcodes>' of Sydney
    Then the result should include '<expectedResult>' with statusCode '<statusCode>'
    Examples:
      | api   | postcodes | days | country | statusCode | expectedResult |
      | daily | 2026      | 1    | AU      | 200        |                |
      | daily | 2035      | 1    | AU      | 200        |                |
      | daily | 2095      | 1    | AU      | 200        |                |
      | daily | 2096      | 1    | AU      | 200        |                |

#  Scenario Outline: As a choosey surfer
#    Given I like to surf in any of top beaches '<postcodes>' of Sydney
#    And I only like to surf on <Monday & Friday> in next 16 days
#    When I look up the the weather forecast for the next 16 days with postcodes
#    Then I check to if see the temperature is between 12°C and 30°C
#    And I check wind speed to be between 3 and 9
#    And I check to see if UV index is <= 12
#    And I Pick best suitable spot out of top two spots, based upon suitable weather forecast for the day
#    Then the result should include '<expectedResult>' with statusCode '<statusCode>'
#    Examples:
#      | api   | postcodes | days | country | statusCode | expectedResult |
#      | daily | 2026      | 1    | AU      | 200        |                |
#      | daily | 2035      | 1    | AU      | 200        |                |
#      | daily | 2095      | 1    | AU      | 200        |                |
#      | daily | 2096      | 1    | AU      | 200        |                |
