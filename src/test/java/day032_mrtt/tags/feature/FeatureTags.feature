
@özel
Feature: Tags
#senaryolari ayri rumn etmek icin anotation veriyoruz ve
# runner e de tsgs=@smoke ekliyoruz
  @smoke @temp
  Scenario: Scenario 1
    Given tags  Scenario 1 step 1
    When  tags  Scenario 1 step 2
    Then  tags  Scenario 1 step 3


  @smoke  @regression
  Scenario: Scenario 2
    Given tags  Scenario 2 step 1
    When  tags  Scenario 2 step 2
    Then  tags  Scenario 2 step 3


  @regression
  Scenario: Scenario 3
    Given tags  Scenario 3 step 1
    When  tags  Scenario 3 step 2
    Then  tags  Scenario 3 step 3

