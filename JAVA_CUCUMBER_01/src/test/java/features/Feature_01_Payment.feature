@paymentFunction
Feature: Payment feature
  As an automation tester
  I want a payment function 
  So that I want to make sure payment correctly

  @CreateAccountAndLogin
  Scenario: Create account, login and verify login successfully
    Given I navigate to Guru bank and click Here link
    When I input to "emailid" textbox with data "automation"
    And I click to "btnLogin" button
    And I register email
    And I open login page
    And I input to "uid" textbox with variable data "usernameLogin"
    And I input to "password" textbox with variable data "passwordLogin"
    And I click to "btnLogin" button

  @newCustomer
  Scenario Outline: Create new Customer and get NewCustomerID
    Given I open "New Customer" page
    When I input to "name" textbox with data "<CustomerName>"
    When I input to "dob" date of birth with data "<DateOfBirth>"
    When I input to "addr" textbox with data "<Address>"
    When I input to "city" textbox with data "<City>"
    When I input to "state" textbox with data "<State>"
    When I input to "pinno" textbox with data "<PIN>"
    When I input to "telephoneno" textbox with data "<Phone>"
    When I input to "emailid" textbox with data "<Email>"
    When I input to "password" textbox with data "<Password>"
    And I click to "sub" button
    Then Verify successfully with message "Customer Registered Successfully!!!"
    And I get text UserID "Customer ID"

    Examples: 
      | CustomerName | DateOfBirth | Address | City    | State   | PIN    | Phone      | Email       | Password   |
      | Dam Dao      | 16/10/1989  | Da nang | Da nang | Da nang | 466250 | 4555442476 | randomEmail | 1234567890 |

  @editCustomer
  Scenario Outline: Edit Customer
    Given I open "Edit Customer" page
    When I input to "cusid" textbox with variable data "userID"
    And I click to "AccSubmit" button
    When I input to "addr" textbox with data "<addressUpdate>"
    When I input to "city" textbox with data "<cityUpdate>"
    When I input to "state" textbox with data "<stateUpdate>"
    When I input to "pinno" textbox with data "<PINUpdate>"
    When I input to "telephoneno" textbox with data "<mobileUpdate>"
    When I input to "emailid" textbox with data "<emailUpdate>"
    And I click to "sub" button
    Then Verify successfully with message "Customer details updated Successfully!!!"

    Examples: 
      | addressUpdate | cityUpdate | stateUpdate | PINUpdate | mobileUpdate | emailUpdate |
      | Ha Noi        | Ha Noi     | Ha Noi      |    123456 |   1234567890 | updateEmail |

  @newAccount
  Scenario: Create new account
    Given I open "New Account" page
    When I input to "cusid" textbox with variable data "userID"
    And Select item in dynamic dropdow "selaccount" with value "Current"
    And I input to "inideposit" textbox with data "50000"
    And I click to "button2" button
    And I get text dynamic label "Account ID"
    Then Verify successfully with message "Account Generated Successfully!!!"
    And Verify deposit with value "50000"

  @addDeposit
  Scenario: Add deposit
    Given I open "Deposit" page
    When I input to "accountno" textbox with variable data "accountID"
    And I input to "ammount" textbox with variable data "depositAdd"
    And I input to "desc" textbox with data "Deposit"
    And I click to "AccSubmit" button
    Then Verify successfully with message "Transaction details of Deposit for Account"
    And Verify Current balance is "55000"

  @withDraw
  Scenario: WithDraw money
    Given I open "Withdrawal" page
    When I input to "accountno" textbox with variable data "accountID"
    And I input to "ammount" textbox with variable data "monneyWithDraw"
    And I input to "desc" textbox with data "Withdraw"
    And I click to "AccSubmit" button
    Then Verify successfully with message "Transaction details of Withdrawal for Account"
    #after withdraw money: "40000"
    And Verify money after withdraw is "Current Balance"

  @fundTransfer
  Scenario: Fund Transfer
    Given I open "Fund Transfer" page
    When I input to "payersaccount" textbox with variable data "accountID"
    And I input to "payeeaccount" textbox with variable data "accountIDPayee"
    And I input to "ammount" textbox with data "10000"
    And I input to "desc" textbox with data "Transfer"
    And I click to "AccSubmit" button
    Then Verify successfully with message "Fund Transfer Details"
    # Money transfer: 10000
    And Verify money transfer is "Amount"

  @balanceEnquiry
  Scenario: Balance enquiry
    Given I open "Balance Enquiry" page
    When I input to "accountno" textbox with variable data "accountID"
    And I click to "AccSubmit" button
    # Current transfer: 30000
    Then Verify current balance is "Balance"
