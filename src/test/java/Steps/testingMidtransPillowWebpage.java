package Steps;

import Pages.*;
import SetUp.browserFactory;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.testng.asserts.SoftAssert;

public class testingMidtransPillowWebpage {

    public WebDriver driver;
    public SoftAssert softAssert;
    public browserFactory BrowserFactory;
    public homePage HomePage;
    public shoppingCartPage ShoppingCartPage;
    public checkoutPage CheckoutPage;
    public creditDebitPaymentPage CreditDebitPaymentPage;
    public bankPaymentPage BankPaymentPage;

    @Before
    public void setUp() {
        BrowserFactory = new browserFactory();
        driver = BrowserFactory.launchBrowser("Chrome");

        softAssert = new SoftAssert();
        HomePage = new homePage(driver);
        ShoppingCartPage = new shoppingCartPage(driver);
        CheckoutPage = new checkoutPage(driver);
        CreditDebitPaymentPage = new creditDebitPaymentPage(driver);
        BankPaymentPage = new bankPaymentPage(driver);

    }
    @After
    public void tearDown() {
        softAssert.assertAll();
        driver.quit();
    }

    // GIVEN
    @Given("I am in the home page of MidTrans")
    public void i_am_in_the_home_page_of_mid_trans() {
        driver.get("https://demo.midtrans.com/");
    }

    // WHEN
    @When("I click on buy now")
    public void i_click_on_buy_now() {
        HomePage.clickBuyNowBtn();
    }

    @When("I click cancel button")
    public void iClickCancelButton() {
        BankPaymentPage.clickPaymentCancelBtn();
    }

    // AND
    @And("I click checkout button")
    public void iClickCheckoutButton() {
        ShoppingCartPage.clickCheckoutBtn();
    }

    @And("I click details button")
    public void iClickDetailsButton() {
        CheckoutPage.clickDetailsBtn();
    }

    @And("I click credit and debit card payment method")
    public void iClickCreditAndDebitCardPaymentMethod() {
        CheckoutPage.clickCreditDebitCard();
    }

    @And("I click first promotion")
    public void iClickFirstPromotion() {
        CreditDebitPaymentPage.clickFirstPromoOption();
    }

    @And("I enter card number")
    public void iEnterCardNumber() {
        CreditDebitPaymentPage.inputCardNumber("4811111111111114");
    }

    @And("I enter card experation date")
    public void iEnterCardExperationDate() {
        CreditDebitPaymentPage.inputCardExpDate("0225");
    }

    @And("I enter card cvv number")
    public void iEnterCardCvvNumber() {
        CreditDebitPaymentPage.inputCardCvv("123");
    }

    @And("I enter valid OTP password")
    public void iEnterValidOTPPassword() {
        BankPaymentPage.enterOtpPassword("112233");
    }

    @And("I enter invalid OTP password")
    public void iEnterInvalidOTPPassword() {
        BankPaymentPage.enterOtpPassword("574807");
    }

    @And("I click ok button")
    public void iClickOkButton() {
        BankPaymentPage.clickPaymentOkBtn();
    }

    // THEN
    @Then("I verify Midtrans Pillow added to cart and price 20,000")
    public void i_verify_midtrans_pillow_added_to_cart_and_price() {
        softAssert.assertEquals(ShoppingCartPage.getMidtransPillowPrice(), "20,000");
    }

    @Then("I verify user redirected to checkout popup")
    public void i_verify_user_redirected_to_checkout_popup() {
        softAssert.assertTrue(ShoppingCartPage.verifyShoppingCartPopupOpened());
    }

    @Then("I verify name, email, phone, city, Address, and postal code on checkout page")
    public void i_verify_name_email_phone_city_address_and_postal_code_on_checkout_page() {
        softAssert.assertTrue(ShoppingCartPage.vefifyAllInfoTxtIsPresent());
    }

    @Then("I verify name, email, phone, city, Address, and postal code fields are editable")
    public void iVerifyNameEmailPhoneCityAddressAndPostalCodeFieldsAreEditable() {
        softAssert.assertTrue(ShoppingCartPage.vefifyAllInfoTxtFieldIsEditable());
    }

    @Then("I verify Order Summary popup")
    public void iVerifyOrderSummaryPopup() {
        softAssert.assertTrue(CheckoutPage.checkoutPopupImgDisplayed());
    }

    @Then("I verify product name and price")
    public void iVerifyProductNameAndPrice() {
        softAssert.assertTrue(CheckoutPage.verifyProductNameAndPrice("Midtrans Pillow", "20.000"));
    }

    @Then("I verify all payment options are listed on the payment page")
    public void iVerifyAllPaymentOptionsAreListedOnThePaymentPage() {
        softAssert.assertTrue(CheckoutPage.verifyAllPaymentOptionsListedOnPaymentPage("GoPay/GoPay Later",
                "Virtual account", "Credit/debit card", "ShopeePay/SPayLater", "QRIS", "Alfa Group",
                "Indomaret", "Akulaku PayLater", "Kredivo"));
    }

    @Then("I verify credit and debit card payment method is clickable")
    public void iVerifyCreditDebitCardPaymentMethodIsClickable() {
        softAssert.assertTrue(CheckoutPage.verifyCreditDebitCardPaymentMethodClickable());
    }

    @Then("I verify credit and debit card payment screen")
    public void iVerifyCreditDebitCardPaymentScreen() {
        softAssert.assertTrue(CheckoutPage.verifyCreditDebitCardPaymentScreen());
    }

    @Then("I verify the original price of the product")
    public void iVerifyTheOriginalPriceOfTheProduct() {
        softAssert.assertEquals(CreditDebitPaymentPage.getOrderAmount(), "20.000");
    }

    @Then("I verify product price has changed")
    public void iVerifyProductPriceHasChanged() {
        softAssert.assertNotEquals(CreditDebitPaymentPage.getOrderAmount(), "20.000");
    }

    @Then("I click pay now button")
    public void iClickPayNowButton() {
        CreditDebitPaymentPage.clickPayNowBtn();
    }

    @Then("I verify user on bank payment screen")
    public void iVerifyUserOnBankPaymentScreen() {
        softAssert.assertTrue(BankPaymentPage.verifyBankPaymentPage());
    }

    @Then("I verify order details")
    public void iVerifyOrderDetails() {
        softAssert.assertTrue(BankPaymentPage.verifyDetails("Rubicon Store", "19000.00",
                BankPaymentPage.getCurrentDateAndTime(), "48111111-1114"));
    }

    @Then("I verify user on order successful screen")
    public void iVerifyUserOnOrderSuccessfulScreen() {
        softAssert.assertTrue(BankPaymentPage.verifyOrderSuccessfulScreen());
    }

    @Then("I verify user on order failed screen")
    public void iVerifyUserOnOrderFailedScreen() {
        softAssert.assertTrue(CreditDebitPaymentPage.verifyOrderFailedlScreen());
    }

}
