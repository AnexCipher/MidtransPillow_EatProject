package Pages;

import Utilities.utilities;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.*;

public class bankPaymentPage extends utilities {

    public bankPaymentPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    // LOCATORS
    @FindBy(xpath = "//h1[text()='Issuing Bank']")
        private WebElement bankPaymentPageTitle;
    @FindBy(id = "merchant_name")
        private WebElement merchantNameValue;
    @FindBy(id = "txn_amount")
        private WebElement amountValue;
    @FindBy(id = "txn_time")
        private WebElement transactionTimeValue;
    @FindBy(id = "card_number")
        private WebElement cardNumberValue;
    @FindBy(id = "otp")
        private WebElement otpPasswordTxtBox;
    @FindBy(name = "ok")
        private WebElement paymentOkBtn;
    @FindBy(name = "cancel")
        private WebElement paymentCancelBtn;
    @FindBy(className = "text-headline")
        private WebElement paymentSuccessMsg;

    // METHODS
    public boolean verifyBankPaymentPage() {
        boolean onBankPaymentPage = false;
        driver.switchTo().frame(driver.findElement(By.id("snap-midtrans")));
        driver.switchTo().frame(driver.findElement(By.className("iframe-3ds")));
        if (bankPaymentPageTitle.isDisplayed()) {
            onBankPaymentPage = true;
        }
        driver.switchTo().parentFrame();
        driver.switchTo().parentFrame();

        return onBankPaymentPage;
    }

    public boolean verifyDetails(String merchantName, String amount, String transactionTime, String cardNumber) {
        boolean correctDetails = false;
        driver.switchTo().frame(driver.findElement(By.id("snap-midtrans")));
        driver.switchTo().frame(driver.findElement(By.className("iframe-3ds")));
        List<WebElement> paymentDetailsWebElements = Arrays.asList(
                merchantNameValue, amountValue, transactionTimeValue, cardNumberValue
        );

        List<String> paymentDetailsActual = new ArrayList<>();
        for (WebElement paymentDetail : paymentDetailsWebElements) {
            paymentDetailsActual.add(paymentDetail.getText());
//            System.out.println(paymentDetail.getText());
        }

        List<String> paymentDetailsExpected = Arrays.asList(
                merchantName, amount, transactionTime, cardNumber
        );

        Collections.sort(paymentDetailsActual);
        Collections.sort(paymentDetailsExpected);

        if (paymentDetailsActual.equals(paymentDetailsExpected)) {
            correctDetails = true;
        }

        driver.switchTo().parentFrame();
        driver.switchTo().parentFrame();

        return correctDetails;
    }

    public void enterOtpPassword(String otpPassword) {
        driver.switchTo().frame(driver.findElement(By.id("snap-midtrans")));
        driver.switchTo().frame(driver.findElement(By.className("iframe-3ds")));
        otpPasswordTxtBox.sendKeys(otpPassword);
        driver.switchTo().parentFrame();
        driver.switchTo().parentFrame();
    }

    public void clickPaymentOkBtn() {
        driver.switchTo().frame(driver.findElement(By.id("snap-midtrans")));
        driver.switchTo().frame(driver.findElement(By.className("iframe-3ds")));
        paymentOkBtn.click();
        driver.switchTo().parentFrame();
        driver.switchTo().parentFrame();
    }

    public void clickPaymentCancelBtn() {
        driver.switchTo().frame(driver.findElement(By.id("snap-midtrans")));
        driver.switchTo().frame(driver.findElement(By.className("iframe-3ds")));
        paymentCancelBtn.click();
        driver.switchTo().parentFrame();
        driver.switchTo().parentFrame();
    }

    public boolean verifyOrderSuccessfulScreen() {
        boolean successPageDisplayed = false;
        driver.switchTo().frame(driver.findElement(By.id("snap-midtrans")));

        if (paymentSuccessMsg.isDisplayed()) {
            successPageDisplayed = true;
        }

        driver.switchTo().parentFrame();

        return successPageDisplayed;
    }

}
