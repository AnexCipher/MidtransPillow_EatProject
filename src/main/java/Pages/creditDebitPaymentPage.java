package Pages;

import Utilities.utilities;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class creditDebitPaymentPage extends utilities {

    public creditDebitPaymentPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    // LOCATORS
    @FindBy(xpath = "//div[@class='header-amount']")
        private WebElement orderAmount;
    @FindBy(xpath = "//input[@autocomplete='cc-number']")
        private WebElement cardNumberTxtBox;
    @FindBy(id = "card-expiry")
        private WebElement cardExpirationTxtBox;
    @FindBy(id = "card-cvv")
        private WebElement cardCvvTxtBox;
    @FindBy(xpath = "//label[@for='690']")
        private WebElement firstPromoOption;
    @FindBy(xpath = "//button[@class='btn full primary  btn-theme']")
        private WebElement payNotBtn;
    @FindBy(className = "cancel-modal-title")
        private WebElement paymentDeclinedMsg;

    // METHODS
    public String getOrderAmount() {
        driver.switchTo().frame(driver.findElement(By.id("snap-midtrans")));
        String txtOrderAmount = orderAmount.getText();
        String[] partsOfOrderAmount = txtOrderAmount.split("Rp");
        String priceOfOrder = partsOfOrderAmount[1];
        driver.switchTo().parentFrame();

        return priceOfOrder;
    }

    public void inputCardNumber(String cardNumber) {
        driver.switchTo().frame(driver.findElement(By.id("snap-midtrans")));
        cardNumberTxtBox.sendKeys(cardNumber);
        driver.switchTo().parentFrame();
    }

    public void inputCardExpDate(String cardExpNumber) {
        driver.switchTo().frame(driver.findElement(By.id("snap-midtrans")));
        cardExpirationTxtBox.sendKeys(cardExpNumber);
        driver.switchTo().parentFrame();
    }

    public void inputCardCvv(String cardCvv) {
        driver.switchTo().frame(driver.findElement(By.id("snap-midtrans")));
        cardCvvTxtBox.sendKeys(cardCvv);
        driver.switchTo().parentFrame();
    }

    public void clickFirstPromoOption() {
        driver.switchTo().frame(driver.findElement(By.id("snap-midtrans")));
        firstPromoOption.click();
        driver.switchTo().parentFrame();
    }

    public void clickPayNowBtn() {
        driver.switchTo().frame(driver.findElement(By.id("snap-midtrans")));
        payNotBtn.click();
        driver.switchTo().parentFrame();
    }

    public boolean verifyOrderFailedlScreen() {
        boolean paymentDeclineMsg = false;
        driver.switchTo().frame(driver.findElement(By.id("snap-midtrans")));

        if (paymentDeclinedMsg.isDisplayed()) {
            paymentDeclineMsg = true;
        }

        driver.switchTo().parentFrame();

        return paymentDeclineMsg;
    }
}


