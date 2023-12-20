Feature: islemler

  Scenario: sayilarin toplamii
    Given initial value is 5
    When user add the following numbers
    |1|
    |2|
    |3|
    |4|
    |5|
    Then  sum schould be 20