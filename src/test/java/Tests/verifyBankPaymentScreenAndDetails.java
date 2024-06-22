package Tests;

import BaseTest.baseTest;
import org.testng.annotations.Test;

public class verifyBankPaymentScreenAndDetails extends baseTest {

    @Test
    public void verifyBankPaymentScreenAndDetailsTest() {
        HomePage.clickBuyNowBtn();
        ShoppingCartPage.clickCheckoutBtn();
        CheckoutPage.clickCreditDebitCard();
        CreditDebitPaymentPage.inputCardNumber("4811111111111114");
        CreditDebitPaymentPage.inputCardExpDate("0225");
        CreditDebitPaymentPage.inputCardCvv("123");
        CreditDebitPaymentPage.clickPayNowBtn();
        softAssert.assertTrue(BankPaymentPage.verifyBankPaymentPage());
        softAssert.assertTrue(BankPaymentPage.verifyDetails("Rubicon Store", "19000.00",
                BankPaymentPage.getCurrentDateAndTime(), "48111111-1114"));

        softAssert.assertAll();
    }

}
