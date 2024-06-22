package Tests;

import BaseTest.baseTest;
import org.testng.annotations.Test;

public class verifyProductDetailsOnOrderSummeryPopup extends baseTest {

    @Test
    public void verifyProductDetailsOnOrderSummeryPopupTest() {
        HomePage.clickBuyNowBtn();
        ShoppingCartPage.clickCheckoutBtn();
        CheckoutPage.clickDetailsBtn();
        softAssert.assertTrue(CheckoutPage.verifyProductNameAndPrice("Midtrans Pillow", "20.000"));

        softAssert.assertAll();
    }

}
