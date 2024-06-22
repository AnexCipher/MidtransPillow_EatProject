package Tests;

import BaseTest.baseTest;
import org.testng.annotations.Test;

public class verifyOrderAmountAndPriceChangeWithCouponOnCreditDetailScreen extends baseTest {

    @Test
    public void verifyOrderAmountAndPriceChangeWithCouponOnCreditDetailScreenTest() {
        HomePage.clickBuyNowBtn();
        ShoppingCartPage.clickCheckoutBtn();
        CheckoutPage.clickCreditDebitCard();
//        System.out.println(CreditDebitPaymentPage.getOrderAmount());
        softAssert.assertEquals(CreditDebitPaymentPage.getOrderAmount(), "20.000");
        CreditDebitPaymentPage.inputCardNumber("4811111111111114");
        CreditDebitPaymentPage.clickFirstPromoOption();
        softAssert.assertNotEquals(CreditDebitPaymentPage.getOrderAmount(), "20.000");

        softAssert.assertAll();
    }

}
