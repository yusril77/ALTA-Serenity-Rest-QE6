Feature: testing Reqres Get


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