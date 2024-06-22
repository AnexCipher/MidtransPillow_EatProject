package Tests;

import BaseTest.baseTest;
import org.testng.annotations.Test;

public class verifyNameEmailPhoneCityAddressPostalOnCheckoutPg extends baseTest {

    @Test
    public void verifyNameEmailPhoneCityAddressPostalOnCheckoutPgTest() {
        HomePage.clickBuyNowBtn();
        softAssert.assertTrue(ShoppingCartPage.vefifyAllInfoTxtIsPresent());

        softAssert.assertAll();
    }

}
