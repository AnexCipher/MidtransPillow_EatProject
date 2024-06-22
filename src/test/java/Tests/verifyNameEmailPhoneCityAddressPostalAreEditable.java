package Tests;

import BaseTest.baseTest;
import org.testng.annotations.Test;

public class verifyNameEmailPhoneCityAddressPostalAreEditable extends baseTest {

    @Test
    public void verifyNameEmailPhoneCityAddressPostalAreEditableTest() {
        HomePage.clickBuyNowBtn();
        softAssert.assertTrue(ShoppingCartPage.vefifyAllInfoTxtFieldIsEditable());

        softAssert.assertAll();
    }

}
