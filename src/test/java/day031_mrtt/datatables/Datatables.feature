Feature: Data tables

  Scenario: variable

    #buraya ekxtra sayi ekleyemem
    Given write the follaving numbers 1, 2, 3, 4, 5

    # buraya sonradan sayi ekleyebilirim

  #
  Scenario: list as datatable
    Given write the folloving  numbers
      | a |
      | 2 |
      | 3 |
      | 4 |
      | z |

  #list<string> list=dataTable.asList(String.class)
  #list<string> list=dataTable.asList()

  Scenario: listt as datatable
    Given write the follovingg numbers
      | 1 |
      | 2 |
      | 3 |
      | 4 |
      | 5 |
  Scenario: list of lists
    Given write the folloving  liatoflists
      | a  | b  | c  | d  |
      | 2  | 12 | 22 | 32 |
      | 3  | 12 | 23 | 33 |
      | 4  | 14 | 24 | 34 |
      | z1 | z2 | z3 | z4 |

#List<List<String>> lists=dataTable.asLists(str);
  Scenario: list of listss
    Given write the folloving  liatoflists
      | a  | b  | c  | d  |


    #List<List<Integer>> lists=dataTable.asLists(String.class)
  Scenario: list of lists1
    Given write the folloving  liatoflists as int

      | 2 | 12 | 22 | 32 |
      | 3 | 12 | 23 | 33 |
      | 4 | 14 | 24 | 34 |
      | 5 | 15 | 25 | 35 |

     #Map (key,value)
  #Map<String ,String> map=datatable.asMap(String.class ,String.class)
  #Map<String ,String> map=datatable.asMap() -->  Datatype string ise string.class yazmaya gerek yok
   #Map<String ,Integer> map=datatable.asMap(String.class ,integer.class)--> biri integer ise yazilir
  Scenario: map
    Given write the following as map
      | username  | uname1 |
      | password  | pass   |
      | firstname | ali    |
      | lastname  | veli   |

  Scenario: map
    #Map<Integer ,Double> map=dataTable.asMap(Integer.class,Double.class);
    Given write the following numbers as map
      | 1 | 1.2 |
      | 2 | 2.3 |
      | 3 | 3.6 |
      | 4 | 7.1 |


    #List<Map<String ,String>> listOfMaps=datatable.asMaps(String.class,String.class)
   #List<Map<String ,String>> listOfMaps=datatable.asMaps()
   #List<Map<String ,Integer>> listOfMaps=datatable.asMaps(String.class,Integer.class)
  Scenario: list of maps
    Given write the following maps
  | username| password| firstname |  lastname|
  | uname1  | pass1   | firstname1| lastname1|
  | uname2  | pass2   | firstname2| lastname2|
  | uname3  | pass3   | firstname3| lastname3|
  | uname4  | pass4   | firstname4| lastname4|
  | uname5  | pass5   | firstname5| lastname5|