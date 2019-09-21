@login
Feature: Verify UI Login test
  Scenario: Verify customer login via UI
    Given launch homepage
    Then verify page title is "MishiPay"
    And wait for text "Scan" to exist
    And click on button: "Next"
    And wait for text "Pay" to exist
    And click on button: "Next"
    And wait for text "Leave" to exist
    And click on button: "ShowStores"
    And wait for text "Seems" to exist
    And click on element: "MishipayGlobalStore"
    And click on button: "StoreLogin"
    And wait for text "Login" to exist
    Then login to webapp as user

  Scenario: Verify customer login via API
    Then verify customer login
    Then verify payment session creation
    Then initialize payment
    Then verify payment
    Then get card details
    And test item scan



