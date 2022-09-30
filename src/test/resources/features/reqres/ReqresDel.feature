Feature: testing Reqres Del


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