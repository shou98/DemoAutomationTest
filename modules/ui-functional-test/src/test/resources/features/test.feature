Feature: [Login] Ensure user is able to login to OrangeHrm

  @Outline
  Scenario Outline: Login to OrangeHrm with valid username and password
    Given Open " "
    When I login with <username> and <password>
    Then I login successfull on Dashboard page
    Examples:
      | username | password   |
      | "Admin"  | "admin123" |

  @Properties
  Scenario: Get data from properties to login to OrangeHrm with valid username and password
    Given Open "OrangeHrm"
    When I login with "username" and "password"
    Then I login successfull on Dashboard page