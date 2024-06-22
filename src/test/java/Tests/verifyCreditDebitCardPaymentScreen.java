package Tests;

import BaseTest.baseTest;
import org.testng.annotations.Test;

public class verifyCreditDebitCardPaymentScreen extends baseTest {

    @Test
    public void verifyCreditDebitCardPaymentScreenTest() {
        HomePage.clickBuyNowBtn();
        ShoppingCartPage.clickCheckoutBtn();
        softAssert.assertTrue(CheckoutPage.verifyCreditDebitCardPaymentMethodClickable());
        CheckoutPage.clickCreditDebitCard();
        softAssert.assertTrue(CheckoutPage.verifyCreditDebitCardPaymentScreen());

        softAssert.assertAll();
    }

}
