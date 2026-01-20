Feature: TestDatatable Scenarios

@Datatable1
Scenario:
Given I am using a Datatable which will fetch username and password
|username   |password| EmployeeID|
|user1      |password1|1         |
|user2      |password2|2         |
|user3      |password3|3         |


@Datatable2
Scenario:
Given I am using a Datatable using NestedPojo
 | firstName | lastName  | city       | zip      |
 | John      | Doe        | London     | 123      |
 | John1      | Doe1         | London1 | 1231  |
 | John2      | Doe2     | London2 | 1232   |


 @Datatable3
 Scenario:
 Given I am using a Datatable using NestedPojo and lombok
  | firstName | lastName  | city       | zip      |
  | John      | Doe        | London     | 123      |
  | John1      | Doe1         | London1 | 1231  |
  | John2      | Doe2     | London2 | 1232   |

