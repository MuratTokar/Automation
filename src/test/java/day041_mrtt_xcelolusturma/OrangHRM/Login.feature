Feature: login

  Scenario: Login
    Given user navigate to"https://opensource-demo.orangehrmlive.com/web/index.php/auth/login"
    When  user try to login with data in  the excel file "src/test/java/day041_mrtt_xcelolusturma/OrangHRM/MOCK_DATA1 (1).xlsx"

