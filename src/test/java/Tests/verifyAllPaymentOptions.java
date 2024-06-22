package Tests;

import BaseTest.baseTest;
import org.testng.annotations.Test;

public class verifyAllPaymentOptions extends baseTest {

    @Test
    public void verifyAllPaymentOptionsTest() {
        HomePage.clickBuyNowBtn();
        ShoppingCartPage.clickCheckoutBtn();
        softAssert.assertTrue(CheckoutPage.verifyAllPaymentOptionsListedOnPaymentPage("GoPay/GoPay Later",
                "Virtual account", "Credit/debit card", "ShopeePay/SPayLater", "QRIS", "Alfa Group",
                "Indomaret", "Akulaku PayLater", "Kredivo"));

        softAssert.assertAll();
    }

}
