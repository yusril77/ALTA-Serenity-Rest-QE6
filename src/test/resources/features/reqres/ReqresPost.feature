Feature: testing Reqres Post


  @latihan
  Scenario: Post create new user with valid json
    Given Post create new user
    When Send request post create new user
    Then Should return 201 created
    And Response body should contain name "Fauzan" and job "QA Engineer"
    And Post create new user json schema validator


  @tugas
  Scenario: Post create user with invalid json
    Given Post create new invalid user
    When Send request post create new user
    Then Should return 400 bad request
    And  Post create invalid user json schema validator


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
  Scenario: Login user with invalid parameter
    Given Post login with valid body
    When Send request post login user with invalid parameter
    Then Should return 404 not found


  @tugas
  Scenario: Post register with invalid parameter
    Given Post register new user
    When Send request post register new user with invalid parameter
    Then Should return 404 not found