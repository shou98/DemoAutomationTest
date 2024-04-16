Feature: [Login] Ensure user is able to login to OrangeHrm

#  @Outline
#  Scenario Outline: Login to OrangeHrm with valid username and password
#    Given Open "OrangeHrm"
#    When I login with <username> and <password> valid
#    Then I login successfull on Dashboard page
#    Examples:
#      | username | password   |
#      | "Admin"  | "admin123" |

  @UI
  Scenario Outline: Login to OrangeHrm with admin and create new user
    Given Open "OrangeHrm"
    When I login with "username" and "password" valid
    And I login successfull on Dashboard page
    And I Create successfully new Employee with information <FirstName> and <LastName> on PIM page
    And I created new user with <UserRole> <EmployeeName> <Status> <Username> <Password> on Admin page
    And I logout Admin successfully
    And I login with <Username> and <Password> valid
    Then Dashboard page is Displayed with <FirstName> <LastName>
    Examples:
      | FirstName | LastName | EmployeeName | UserRole | Status    | Username         | Password          |
      | "Joy"     | "Carter" | "Joy Carter" | "Admin"  | "Enabled" | "adminjoycarter" | "adminjoycarter1" |