package Tests;

import BaseTest.baseTest;
import org.testng.annotations.Test;

public class verifyCheckoutBtnOpensOrderSummaryPopup extends baseTest {

    @Test
    public void verifyCheckoutBtnOpensOrderSummaryPopupTest() {
        HomePage.clickBuyNowBtn();
        ShoppingCartPage.clickCheckoutBtn();
        softAssert.assertTrue(CheckoutPage.checkoutPopupImgDisplayed());

        softAssert.assertAll();
    }

}
