Feature: Soucedemo login feature

  Scenario Outline: login functionilaty
    Given sd user navigate to homepage
    When sd user navigate with the following credentials
      | username | <username> |
      | password | <password> |
    Then login should be"<result>"
    Examples:
      | username      | password     | result |
      | standard_user | secret_sauce | true   |
      | admin         | admin        | false  |
      | problem_user  | secret_sauce | true   |
      | problem_user1 | secret_sauce | false  |