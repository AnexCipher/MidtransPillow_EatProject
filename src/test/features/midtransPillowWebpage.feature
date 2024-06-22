Feature: Testing Midtrans Pillow Webpage
  Background:
    Given I am in the home page of MidTrans

  Scenario: Verify "Midtrans Pillow" has added into cart with cost of 20000
    When I click on buy now
    Then I verify Midtrans Pillow added to cart and price 20,000

  Scenario: Verify clicking on Buy Now button redirects user to Checkout popup
    When I click on buy now
    Then I verify user redirected to checkout popup

  Scenario: Verify Name, email, phone, city, Address, postal code on checkout page
    When I click on buy now
    Then I verify name, email, phone, city, Address, and postal code on checkout page

  Scenario: Verify Name, email, phone, city, Address, postal code fields are editable
    When I click on buy now
    Then I verify name, email, phone, city, Address, and postal code fields are editable

  Scenario: Verify clicking on Checkout button redirect user on Order Summary popup
    When I click on buy now
    And I click checkout button
    Then I verify Order Summary popup

  Scenario: Verify all the product details on order summery popup - price, product name
    When I click on buy now
    And I click checkout button
    And I click details button
    Then I verify product name and price

  Scenario: Verify all the payment options listed on payment page
    When I click on buy now
    And I click checkout button
    Then I verify all payment options are listed on the payment page

  Scenario: Verify user can click on Credit/Debit Card payment method which redirected to card details
  screen
    When I click on buy now
    And I click checkout button
    Then I verify credit and debit card payment method is clickable
    And I click credit and debit card payment method
    Then I verify credit and debit card payment screen

  Scenario: Verify order amount on card details screen and apply coupon code and validate changes in
  amount
    When I click on buy now
    And I click checkout button
    And I click credit and debit card payment method
    Then I verify the original price of the product
    And I enter card number
    And I click first promotion
    Then I verify product price has changed

  Scenario: Enter Valid card details - and click pay now
    When I click on buy now
    And I click checkout button
    And I click credit and debit card payment method
    And I enter card number
    And I enter card experation date
    And I enter card cvv number
    Then I click pay now button

  Scenario: Verify Clicking on Paynow redirect user to Bank Payment Screen, verify all the exiting details
    When I click on buy now
    And I click checkout button
    And I click credit and debit card payment method
    And I enter card number
    And I enter card experation date
    And I enter card cvv number
    Then I click pay now button
    Then I verify user on bank payment screen
    Then I verify order details

  Scenario: Verify clicking on OK button with Valid OTP should redirect user to order succssfull
  screen
    When I click on buy now
    And I click checkout button
    And I click credit and debit card payment method
    And I enter card number
    And I enter card experation date
    And I enter card cvv number
    Then I click pay now button
    And I enter valid OTP password
    And I click ok button
    Then I verify user on order successful screen

  Scenario: Verify clicking on OK button with Invalid OTP should redirect user to order failed screen
    When I click on buy now
    And I click checkout button
    And I click credit and debit card payment method
    And I enter card number
    And I enter card experation date
    And I enter card cvv number
    Then I click pay now button
    And I enter invalid OTP password
    And I click ok button
    Then I verify user on order failed screen

  Scenario: Verify clicking on CANCLE button should redirect user to order failed screen
    When I click on buy now
    And I click checkout button
    And I click credit and debit card payment method
    And I enter card number
    And I enter card experation date
    And I enter card cvv number
    Then I click pay now button
    When I click cancel button
    Then I verify user on order failed screen
