package Tests;

import BaseTest.baseTest;
import org.testng.annotations.Test;

public class verifyMidtransPillowAddedToCart extends baseTest {

    @Test
    public void verifyMidtransPillowAddedToCartTest() {
        HomePage.clickBuyNowBtn();
//        System.out.println("Price: " + ShoppingCartPage.getMidtransPillowPrice());
        softAssert.assertEquals(ShoppingCartPage.getMidtransPillowPrice(), "20,000");

        softAssert.assertAll();
    }

}
