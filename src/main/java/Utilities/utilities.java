package Utilities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class utilities {

    public WebDriver driver;
    public WebDriverWait wait;

    public utilities(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public String getCurrentDateAndTime() {
        LocalDateTime currentDateTime = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("M/d/yyyy h:mm:ss a");

        return currentDateTime.format(formatter);
    }

    // WAITS
    public void waitUntilVisible(WebElement webElement, int x) {
        wait = new WebDriverWait(driver, Duration.ofSeconds(x));
        wait.until(ExpectedConditions.visibilityOf(webElement));
    }

    public void waitUntilClickable(WebElement webElement, int x) {
        wait = new WebDriverWait(driver, Duration.ofSeconds(x));
        wait.until(ExpectedConditions.elementToBeClickable(webElement));
    }

    public void waitUntilNotClickable(WebElement webElement, int x) {
        wait = new WebDriverWait(driver, Duration.ofSeconds(x));
        wait.until(ExpectedConditions.not(ExpectedConditions.elementToBeClickable(webElement)));
    }

}
