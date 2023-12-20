#allttakilere ayri ayri test yazmak yerine buraya test
# yadik ve alttakilerin test oldugunu belirtmis olduk
@test
Feature: Runners and reports

   @smoke
  Scenario: Scenario1

    Given rr Sceranio 1 Step 1
    When rr Sceranio 1 Step 2
    Then rr is 1 equals to 1


  @regression @smoke
  Scenario: Scenario2

    Given rr Sceranio 2 Step 1
    When rr Sceranio 2 Step 2
    Then rr is 1 equals to 2
