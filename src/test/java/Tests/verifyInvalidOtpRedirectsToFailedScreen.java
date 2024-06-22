package Tests;

import BaseTest.baseTest;
import org.testng.annotations.Test;

public class verifyInvalidOtpRedirectsToFailedScreen extends baseTest {

    @Test
    public void verifyInvalidOtpRedirectsToFailedScreenTest() {
        HomePage.clickBuyNowBtn();
        ShoppingCartPage.clickCheckoutBtn();
        CheckoutPage.clickCreditDebitCard();
        CreditDebitPaymentPage.inputCardNumber("4811111111111114");
        CreditDebitPaymentPage.inputCardExpDate("0225");
        CreditDebitPaymentPage.inputCardCvv("123");
        CreditDebitPaymentPage.clickPayNowBtn();
        BankPaymentPage.enterOtpPassword("574807");
        BankPaymentPage.clickPaymentOkBtn();
        softAssert.assertTrue(CreditDebitPaymentPage.verifyOrderFailedlScreen());

        softAssert.assertAll();
    }

}
