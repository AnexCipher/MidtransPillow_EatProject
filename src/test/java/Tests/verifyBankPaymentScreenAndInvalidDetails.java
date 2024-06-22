package Tests;

import BaseTest.baseTest;
import org.testng.annotations.Test;

public class verifyBankPaymentScreenAndInvalidDetails extends baseTest {

    @Test
    public void verifyBankPaymentScreenAndInvalidDetailsTest() {
        HomePage.clickBuyNowBtn();
        ShoppingCartPage.clickCheckoutBtn();
        CheckoutPage.clickCreditDebitCard();
        CreditDebitPaymentPage.inputCardNumber("4811111111111114");
        CreditDebitPaymentPage.inputCardExpDate("0225");
        CreditDebitPaymentPage.inputCardCvv("123");
        CreditDebitPaymentPage.clickPayNowBtn();
        softAssert.assertTrue(BankPaymentPage.verifyBankPaymentPage());
        softAssert.assertFalse(BankPaymentPage.verifyDetails("Rubicn Store", "20000.00",
                BankPaymentPage.getCurrentDateAndTime(), "48111111-1414"));

        softAssert.assertAll();
    }

}
