Feature: Screnario Outline

  Scenario:  scenario 1
    Given so scenario 1 step 1
    Given so scenario 1 step 2
    Given so scenario 1 step 3


  Scenario:  scenario 2
    Given so scenario 2 step 1
    When so login with the following data
      | username | admin |
      | password | pass1 |
    Then so scenario 2 step 3

  Scenario:  scenario 3
    Given so my name is "Ahmet"
    Given so my age is 45
    Given so my country  is "Ankara"

      #scenario  outline da en altta  bir adet Example:bölümü olmali
      #example deki her bir satir icin senaryo tekrar edilir
      #example de ilk satir basliktir
      #burda 3 kez calisacak
  #farkli datalarla ayni senaryonun calistirlmasi
  Scenario Outline: scenario outline
    Given so my name is "<name>"
    Given so my age is <age>
    Given so my country  is "<country>"
    @so
    Examples:
      | name  | age | country  |
      | Ahmet | 50  | ankara   |
      | ali   | 34  | istanbul |
      | veli  | 45  | adana    |


  @so2
  Scenario Outline:  scenario outline 2
    Given so scenario <sceraniono> step <stepno1>
    When so login with the following data
      | username | <username> |
      | password | <password> |
    Then so scenario <sceraniono> step <stepno2>
    Examples:
      | sceraniono | stepno1 | stepno2 | username | password |
      | 1          | 1       | 3       | admin    | pass1    |
      | 2          | 1       | 3       | use      | pass2    |
      | 3          | 1       | 3       | demo     | pass3    |




