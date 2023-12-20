#geneline genel dedik ve runner class ta tags a genel yazinca  bu genel
# altindakilerin hepsini run eder
@genel
Feature: Tags
#senaryolari ayri rumn etmek icin anotation veriyoruz ve
# runner e de tsgs=@smoke ekliyoruz
  @smoke @temp
  Scenario: Scenario 4
    Given tags  Scenario 4 step 1
    When  tags  Scenario 4 step 2
    Then  tags  Scenario 4 step 3


  @smoke  @regression
  Scenario: Scenario 5
    Given tags  Scenario 5 step 1
    When  tags  Scenario 5 step 2
    Then  tags  Scenario 5 step 3


  @regression
  Scenario: Scenario 6
    Given tags  Scenario 6 step 1
    When  tags  Scenario 6 step 2
    Then  tags  Scenario 6 step 3

