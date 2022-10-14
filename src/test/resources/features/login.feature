@login
Feature: As user I want to be able to login under different roles
  # this is a comment
# Background - test pre-condition
  #will be executed before every scenario in tha particular feature file

  Background: common steps
    Given user is on the login page

    @seleniumGrid
  Scenario: Login as a sales manger

    When user logs in
    Then user should see dashboard page

  @parametrized_test @smoke_test
  Scenario: Parametrized login

    When user logs in as a "store manager"
    Then user should see dashboard page

  @parametrized_test @smoke_test
  Scenario: Parametrized login

    When user logs in as a "sales manager"
    Then user should see dashboard page

  @s_o
  Scenario Outline: Parametrized login as <role>
    When user logs in as a "<role>"
    Then user should see dashboard page
    Examples:
      | role          |
      | sales manager |
      | store manager |
      | driver        |

  @s_o @with_two_columns
  Scenario Outline: Parametrized login as <role>
    When user logs in as a "<role>"
    Then user should see "<page_title>" page
    Examples:
      | role          | page_title      |
      | sales manager | Dashboard       |
      | store manager | Dashboard       |
      | driver        | Quick Launchpad |

  @negative_login @ie
  Scenario: Invalid password

    When user logs in with "storemanager85" username and "Wrong" password
    Then user verifies that "Invalid user name or password." message is displayed

  @negative_scenario_outline
  Scenario Outline:  Invalid login with <username> and <password>
    When user logs in with "<username>" username and "<password>" password
    Then user verifies that "<message>" message is displayed
    Examples: date set
      | username | password | message                        |
      | wrong    | bad      | Invalid user name or password. |
      | wrong213 | bad      | Invalid user name or password. |
      | wrong222 | bad      | Invalid user name or password. |
      | wrong224 | bad      | Invalid user name or password. |
      | wrong225 | bad      | Invalid user name or password. |

