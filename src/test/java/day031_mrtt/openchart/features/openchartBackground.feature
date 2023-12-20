Feature: Open cart tests
  #tüm senaryolar oncesi calisir.tum senaryolar icin ortak olanlar buraya yazilir.ornek;url
  #tum senaryolardan once zorunlu olarak calisacak stepler buraya alinabilir
  Background:goto homepage
    Given user navigate to "https://opencart.abstracta.us/"

  Scenario: Search for mac
    When user search for"mac"
    Then listed product number be 4

  Scenario: Search for tablet
    When user search for"tablet"
    Then listed product number be 0

  Scenario: Search for Apple
    When user search for"Apple"
    Then listed product number be 1
