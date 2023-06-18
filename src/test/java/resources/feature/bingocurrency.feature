Feature: Currency Test
  As a User I want to test currency data options

  Scenario: Verify data of Bingo jackpot's currency of GBP
    When I Get data of Bingo's currency
    Then I Verify that data=GBP
    Then I verify that pot id="194" has name="Adventure"
