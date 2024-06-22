package Tests;

import BaseTest.baseTest;
import org.testng.annotations.Test;

public class verifyValidOtpRedirectsToSuccessScreen extends baseTest {

    @Test
    public void verifyValidOtpRedirectsToSuccessScreenTest() {
        HomePage.clickBuyNowBtn();
        ShoppingCartPage.clickCheckoutBtn();
        CheckoutPage.clickCreditDebitCard();
        CreditDebitPaymentPage.inputCardNumber("4811111111111114");
        CreditDebitPaymentPage.inputCardExpDate("0225");
        CreditDebitPaymentPage.inputCardCvv("123");
        CreditDebitPaymentPage.clickPayNowBtn();
        BankPaymentPage.enterOtpPassword("112233");
        BankPaymentPage.clickPaymentOkBtn();
        softAssert.assertTrue(BankPaymentPage.verifyOrderSuccessfulScreen());

        softAssert.assertAll();
    }

}
