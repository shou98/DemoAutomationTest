Feature: [API] Ensure user is able to login to OrangeHrm and create successfully admin
  @API
  Scenario: Login to OrangeHrm with admin and create new user
    Given Login and get token successfully
    When Call API create new employee on PIM page
    And Call API create new Admin on Admin page
#    And Login with new Admin has been created