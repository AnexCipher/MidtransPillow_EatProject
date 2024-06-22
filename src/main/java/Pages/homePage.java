package Pages;

import Utilities.utilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class homePage extends utilities {

    public homePage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    // LOCATORS
    @FindBy(className = "buy")
        private WebElement buyNowBtn;
    //

    // METHODS
    public void clickBuyNowBtn() {
        buyNowBtn.click();
    }

}
