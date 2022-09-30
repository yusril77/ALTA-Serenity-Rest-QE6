Feature: testing Reqres Put

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
      Scenario Outline: Put update user with unregistered id
        Given Put update user with unregistered id <id>
        When Send request put update user
        Then Should return 404 not found
        And Response body should contain name "indah" and job "teacher"
        Examples:
          |id|
          |1 |
          |2 |
