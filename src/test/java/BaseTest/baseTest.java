package BaseTest;

import Pages.*;
import SetUp.browserFactory;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.asserts.SoftAssert;

import java.time.Duration;

public class baseTest {

    public WebDriver driver;
    public SoftAssert softAssert;
    public browserFactory BrowserFactory;
    public homePage HomePage;
    public shoppingCartPage ShoppingCartPage;
    public checkoutPage CheckoutPage;
    public creditDebitPaymentPage CreditDebitPaymentPage;
    public bankPaymentPage BankPaymentPage;

    public WebDriver initialiseDriver(String browserName) {
        BrowserFactory = new browserFactory();
        driver = BrowserFactory.launchBrowser(browserName);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.manage().window().maximize();

        return driver;
    }

    @BeforeClass
    public void initialiseBrowserAndObjects() {
        driver = initialiseDriver("Chrome");

        softAssert = new SoftAssert();
        HomePage = new homePage(driver);
        ShoppingCartPage = new shoppingCartPage(driver);
        CheckoutPage = new checkoutPage(driver);
        CreditDebitPaymentPage = new creditDebitPaymentPage(driver);
        BankPaymentPage = new bankPaymentPage(driver);

        driver.get("https://demo.midtrans.com/");
    }

    @AfterClass
    public void closeBrowser() {
        driver.close();
    }

}
