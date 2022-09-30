Feature: feature to test Reqres

   @latihan
  Scenario Outline: Get list user with valid page
    Given Get list user with parameter page <page>
    When Send request get list user
    Then Should return 200 OK
    And Response body page should be <page>
    And Get list user json schema validator
    Examples:
    |page|
    |1   |
    |2   |

    @latihan
    Scenario: Post create new user with valid json
      Given Post create new user
      When Send request post create new user
      Then Should return 201 created
      And Response body should contain name "Fauzan" and job "QA Engineer"
      And Post create new user json schema validator

    @tugas
      Scenario Outline: Get single user valid id
      Given Get single user with valid id <id>
      When Send request get single user
      Then Should return 200 OK
      And Response body id should be <id>
      And Get single new user json schema validator
      Examples:
      |id|
      |1 |
      |2 |
      |3 |
      |4 |
      |5 |

    @tugas
      Scenario Outline: Get single user invalid id
      Given Get single user with invalid id <id>
      When Send request get single user
      Then Should return 404 not found
      Examples:
      |id|
      |13|
      |14|
      |15|

     @tugas
    Scenario: Post create user with invalid json
      Given Post create new invalid user
      When Send request post create new user
      Then Should return 400 bad request
      And  Post create invalid user json schema validator


     @latihan
     Scenario Outline: Put update user with valid json
       Given Put update user with id <id>
       When Send request put update user
       Then Should return 200 OK
       And Response body should contain name "Fauzan Edit" and job "QA Edit"
       Examples:
       |id|
       |1 |
       |2 |

     @latihan
     Scenario Outline: Delete user with valid id
       Given Delete user with valid id <id>
       When Send request delete user
       Then Should return 204 no content
       Examples:
       |id|
       |1 |
       |2 |

     @tugas
     Scenario: Post register successful
      Given Post register new user
      When Send request post register new user
      Then Should return 200 OK
       And Post register new user json validator

     @tugas
     Scenario: Register user unsuccessful
       Given Post register invalid new user
       When Send request post register new user
       Then Should return 400 bad request
       And Post register invalid new user json validator

     @tugas
     Scenario: Login successful
       Given Post login with valid body
       When Send request post login user
       Then Should return 200 OK
       And Post login new user json validator

     @tugas
     Scenario: Login unsuccessful
       Given Post login with invalid body
       When Send request post login user
       Then Should return 400 bad request
       And Post login invalid body new json validator


    @tugas
    Scenario: Login unregistered id
      Given Post login with unregistered body
      When Send request post login user
      Then Should return 400 bad request
      And Post login with unregistered body json validator

     @tugas
     Scenario Outline: Put update user with invalid json
       Given Put update user with invalid id <id>
       When Send request put update user
       Then Should return 400 bad request
       And Response body should contain name "Fauzan Edit"
       Examples:
         |id|
         |1 |
         |2 |

      @tugas
      Scenario: Login user with invalid parameter
        Given Post login with valid body
        When Send request post login user with invalid parameter
        Then Should return 404 not found

  @tugas
  Scenario: Post register with invalid parameter
    Given Post register new user
    When Send request post register new user with invalid parameter
    Then Should return 404 not found

    @tugas
  Scenario Outline: Get list user with invalid parameter
    Given Get list user with invalid parameter page "<page>"
    When Send request get list user
    Then Should return 404 not found
    And Response body page should be invalid "<page>"
    Examples:
      |page|
      |!!$#!|
      |!#$!%|

    @tugas
  Scenario Outline: Delete user with invalid parameter
    Given Delete user with invalid parameter id "<id>"
    When Send request delete user
    Then Should return 404 not found
    Examples:
      |id|
      |@$^#$ |
      |!@#^@ |

      @tugas
      Scenario Outline: Delete non existing id
        Given Delete user with non existing id <id>
        When Send request delete user
        Then Should return 204 no content
        Examples:
        |id|
        |54|
        |66|
        |90|

      @tugas
      Scenario Outline: Put update user with unregistered id
        Given Put update user with unregistered id <id>
        When Send request put update user
        Then Should return 404 not found
        And Response body should contain name "indah" and job "teacher"
        Examples:
          |id|
          |1 |
          |2 |
