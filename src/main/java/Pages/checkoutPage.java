package Pages;

import Utilities.utilities;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@SuppressWarnings("ALL")
public class checkoutPage extends utilities {

    public checkoutPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    // LOCATORS
    @FindBy(xpath = "//img[@alt='logo']")
        private WebElement checkoutPopupImg;
    @FindBy(className = "header-detail-icon")
        private WebElement detailsBtn;
    @FindBy(xpath = "//span[text()='Midtrans Pillow']")
        private WebElement productName;
    @FindBy(className = "float-right")
        private WebElement productPrice;
    @FindBy(xpath = "//div[text()='GoPay/GoPay Later']")
        private WebElement goPay_paymentMethod;
    @FindBy(xpath = "//span[text()='Virtual account']")
        private WebElement virtualAccount_paymentMethod;
    @FindBy(xpath = "//div[text()='Credit/debit card']")
        private WebElement creditDebitCard_paymentMethod;
    @FindBy(xpath = "//div[text()='ShopeePay/SPayLater']")
        private WebElement shopeePay_paymentMethod;
    @FindBy(xpath = "//div[text()='QRIS']")
        private WebElement qris_paymentMethod;
    @FindBy(xpath = "//div[text()='Alfa Group']")
        private WebElement alfaGroup_paymentMethod;
    @FindBy(xpath = "//div[text()='Indomaret']")
        private WebElement indomaret_paymentMethod;
    @FindBy(xpath = "//span[text()='Akulaku PayLater']")
        private WebElement akulakuPayLater_paymentMethod;
    @FindBy(xpath = "//span[text()='Kredivo']")
        private WebElement kredivo_paymentMethod;
    @FindBy(xpath = "//span[text()='Credit/debit card']")
        private WebElement creditDebitCardPaymentScreen;

    //

    // METHODS
    public boolean checkoutPopupImgDisplayed() {
        driver.switchTo().frame(driver.findElement(By.id("snap-midtrans")));
        waitUntilVisible(checkoutPopupImg, 4);
        boolean displayedCheckoutPopupImg = checkoutPopupImg.isDisplayed();
        driver.switchTo().parentFrame();

        return displayedCheckoutPopupImg;
    }

    public void clickDetailsBtn() {
        driver.switchTo().frame(driver.findElement(By.id("snap-midtrans")));
        waitUntilClickable(detailsBtn, 5);
        detailsBtn.click();
        driver.switchTo().parentFrame();
    }

    public boolean verifyProductNameAndPrice(String name, String price) {
        driver.switchTo().frame(driver.findElement(By.id("snap-midtrans")));
        boolean correctProductNameAndPrice = false;
        String nameOfProduct = productName.getText();
        String txtPriceOfProduct = productPrice.getText();
        String[] partsOfPriceOfProduct = txtPriceOfProduct.split("Rp");
        String priceOfProduct = partsOfPriceOfProduct[1];

        if (nameOfProduct.equals(name) && priceOfProduct.equals(price)) {
            correctProductNameAndPrice = true;
        }
        driver.switchTo().parentFrame();

        return correctProductNameAndPrice;
    }

    public boolean verifyAllPaymentOptionsListedOnPaymentPage(String payment1, String payment2, String payment3, String payment4, String payment5, String payment6, String payment7, String payment8, String payment9) {
        driver.switchTo().frame(driver.findElement(By.id("snap-midtrans")));
        boolean allPaymentOptionsListed = false;
        List<WebElement> paymentOptionsWebElements = Arrays.asList(
                goPay_paymentMethod, virtualAccount_paymentMethod, creditDebitCard_paymentMethod,
                shopeePay_paymentMethod, qris_paymentMethod, alfaGroup_paymentMethod,
                indomaret_paymentMethod, akulakuPayLater_paymentMethod, kredivo_paymentMethod
        );

        List<String> paymentOptionsWebelementsTexts = new ArrayList<>();
        for (WebElement payment : paymentOptionsWebElements) {
            paymentOptionsWebelementsTexts.add(payment.getText());
        }

        List<String> paymentMethods = Arrays.asList(
                payment1, payment2, payment3,
                payment4, payment5, payment6,
                payment7, payment8, payment9
        );

        Collections.sort(paymentOptionsWebelementsTexts);
        Collections.sort(paymentMethods);

        if (paymentOptionsWebelementsTexts.equals(paymentMethods)) {
            allPaymentOptionsListed = true;
        }

        driver.switchTo().parentFrame();

        return allPaymentOptionsListed;
    }

    public boolean verifyCreditDebitCardPaymentMethodClickable() {
        boolean creditDebitPaymentMethodClickable = false;
        driver.switchTo().frame(driver.findElement(By.id("snap-midtrans")));
        if (creditDebitCard_paymentMethod.isEnabled()) {
            creditDebitPaymentMethodClickable = true;
        }
        driver.switchTo().parentFrame();

        return creditDebitPaymentMethodClickable;
    }

    public void clickCreditDebitCard() {
        driver.switchTo().frame(driver.findElement(By.id("snap-midtrans")));
        creditDebitCard_paymentMethod.click();
        driver.switchTo().parentFrame();
    }

    public boolean verifyCreditDebitCardPaymentScreen() {
        boolean creditDebitPaymentScreenDisplayed = false;
        driver.switchTo().frame(driver.findElement(By.id("snap-midtrans")));
        if (creditDebitCardPaymentScreen.isDisplayed()) {
            creditDebitPaymentScreenDisplayed = true;
        }
        driver.switchTo().parentFrame();

        return creditDebitPaymentScreenDisplayed;
    }

}
