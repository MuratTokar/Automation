Feature: Bu feature ile ilgili detayli aciklamalar yazilabilir
  her senaryonun ismi olmali

  Userstore nin genele yapisi:As a user, I want to login, so that I can change my password
                               Kim        Ne yapacak               saglanacak fayda

  As a user, i want to sum 2 numbers , so that I can see the result
  Bunlarin her biri step tir .Yazilarin zeminin rekli olmasi step definition larin yailmamis anlamindadir
  Bu steplerin definition larini yazmaliyiz
  Maus sag tiklayip --> show Context Actions -->Create step definition yada all step definition


  Scenario:Matematiksel islemler 1
    Given baslangic sayisi 2
    When bu sayiya 3 ekledigimde
    Then sonuc 5 olmali
    And sonuc uygun
    And netice "olumlu" olmali
    And sonuc ALI olmali

    Scenario: scenario 2
      Given baslangic sayisi 0
      When  bu sayiya 1 ekledigimde
      And  bu sayiya 2 ekledigimde
      *    bu sayiya 3 ekledigimde
      *    bu sayiya 5 ekledigimde
      Then sonuc 11 olmali