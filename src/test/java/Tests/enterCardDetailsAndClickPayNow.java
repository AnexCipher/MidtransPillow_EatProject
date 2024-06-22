package Tests;

import BaseTest.baseTest;
import org.testng.annotations.Test;

public class enterCardDetailsAndClickPayNow extends baseTest {

    @Test
    public void enterCardDetailsAndClickPayNowTest() {
        HomePage.clickBuyNowBtn();
        ShoppingCartPage.clickCheckoutBtn();
        CheckoutPage.clickCreditDebitCard();
        CreditDebitPaymentPage.inputCardNumber("4811111111111114");
        CreditDebitPaymentPage.inputCardExpDate("0225");
        CreditDebitPaymentPage.inputCardCvv("123");
        CreditDebitPaymentPage.clickPayNowBtn();

    }
}
