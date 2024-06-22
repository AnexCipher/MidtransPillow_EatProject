package Tests;

import BaseTest.baseTest;
import org.testng.annotations.Test;

public class verifyBuyNowBtnOpensCheckoutPopup extends baseTest {

    @Test
    public void verifyBuyNowBtnOpensCheckoutPopupTest() {
        HomePage.clickBuyNowBtn();
        softAssert.assertTrue(ShoppingCartPage.verifyShoppingCartPopupOpened());

        softAssert.assertAll();
    }

}
