package Pages;

import Utilities.utilities;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.Map;

public class shoppingCartPage extends utilities {

    public shoppingCartPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    // LOCATORS
    @FindBy(className = "cart-head")
        private WebElement shoppingCartTitle;
    @FindBy(xpath = "//td[@class='amount']")
        private WebElement midtransPillowPrice;
    @FindBy(xpath = "(//table[@class='table'])[2]/descendant::tr[1]/child::td[1]")
        private WebElement nameTxt;
    @FindBy(xpath = "(//table[@class='table'])[2]/descendant::tr[2]/child::td[1]")
        private WebElement emailTxt;
    @FindBy(xpath = "(//table[@class='table'])[2]/descendant::tr[3]/child::td[1]")
        private WebElement phoneTxt;
    @FindBy(xpath = "(//table[@class='table'])[2]/descendant::tr[4]/child::td[1]")
        private WebElement cityTxt;
    @FindBy(xpath = "(//table[@class='table'])[2]/descendant::tr[5]/child::td[1]")
        private WebElement addressTxt;
    @FindBy(xpath = "(//table[@class='table'])[2]/descendant::tr[6]/child::td[1]")
        private WebElement postalTxt;
    @FindBy(xpath = "(//table[@class='table'])[2]/descendant::tr[1]/child::td[2]")
        private WebElement nameTxtField;
    @FindBy(xpath = "(//table[@class='table'])[2]/descendant::tr[2]/child::td[2]")
        private WebElement emailTxtField;
    @FindBy(xpath = "(//table[@class='table'])[2]/descendant::tr[3]/child::td[2]")
        private WebElement phoneTxtField;
    @FindBy(xpath = "(//table[@class='table'])[2]/descendant::tr[4]/child::td[2]")
        private WebElement cityTxtField;
    @FindBy(xpath = "(//table[@class='table'])[2]/descendant::tr[5]/child::td[2]")
        private WebElement addressTxtField;
    @FindBy(xpath = "(//table[@class='table'])[2]/descendant::tr[6]/child::td[1]")
        private WebElement postalTxtField;
    @FindBy(className = "cart-checkout")
        private WebElement checkoutBtn;
    //

    // METHODS
    public boolean verifyShoppingCartPopupOpened() {
        return shoppingCartTitle.isDisplayed();
    }

    public String getMidtransPillowPrice() {
        return midtransPillowPrice.getText();
    }

    public boolean vefifyAllInfoTxtIsPresent() {
        boolean allTxtDisplayed = true;
        Map<String, WebElement> txtWebElements = Map.of(
                "name", nameTxt,
                "email", emailTxt,
                "phone", phoneTxt,
                "city", cityTxt,
                "address", addressTxt,
                "postal", postalTxt
        );

        for (Map.Entry<String, WebElement> webElement : txtWebElements.entrySet()) {
            WebElement element = webElement.getValue();
            if (!element.isDisplayed()) {
                allTxtDisplayed = false;
            }
        }

        return allTxtDisplayed;
    }

    public boolean vefifyAllInfoTxtFieldIsEditable() {
        boolean allTxtFieldIsEditable = true;
        Map<String, WebElement> txtFieldWebElements = Map.of(
                "name", nameTxtField,
                "email", emailTxtField,
                "phone", phoneTxtField,
                "city", cityTxtField,
                "address", addressTxtField,
                "postal", postalTxtField
        );

        for (Map.Entry<String, WebElement> webElement : txtFieldWebElements.entrySet()) {
            WebElement element = webElement.getValue();
            if (!element.isEnabled()) {
                allTxtFieldIsEditable = false;
            }
        }

        return allTxtFieldIsEditable;
    }

    public void clickCheckoutBtn() {
        waitUntilVisible(checkoutBtn, 4);
        waitUntilClickable(checkoutBtn, 4);
        checkoutBtn.click();
    }

}
