Feature: Navigate to Amazon website, search and verify results

  @NavigateAndSearch
  Scenario: Navigate to site and Search
    Given user navigates to "https://www.amazon.com/"
    When enter search term "iphone" on site
    Then verify that the 1st result contains "Apple iPhone"
    Then close the browser
