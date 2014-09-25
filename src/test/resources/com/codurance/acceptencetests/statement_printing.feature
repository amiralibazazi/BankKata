Feature: Print bank statement

  Scenario: Print statement with a variety of transactions

    Given a client makes a deposit of 1000 on "10/09/2014"
    And a withdrawal of 500 on "12/09/2014"
    And a deposit of 300 on "14/09/2014"
    When she prints her bank statement
    Then she would see
      | date       | credit   | debit    | balance |
      | 10/09/2014 |          | 1000.00  | 1000.00 |
      | 12/09/2014 | 500.00   |          |  600.00 |
      | 14/09/2014 |          | 300.00   |  500.00 |