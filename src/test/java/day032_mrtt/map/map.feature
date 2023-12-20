Feature: map islemleri
#yatay olan liste tek te olsa listoflist aliriz
  Scenario: map islemi
    Given my string is a follows
      | ankara   |
      | istanbul |
    When my data is as follows
      | name1  | name2    | name3    |
      | ankara | istanbul | name3    |
      | name1  | istanbul | name3    |
      | name1  | ankara   | istanbul |
      | name1  | name2    | name3    |
    Then the count of the cities are 5
