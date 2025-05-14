package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginPage {
    //Driver
    WebDriver loginDriver;

    //Locator
    By userLogin = By.cssSelector("input[name='username']");
    By userPassword = By.cssSelector("input[name='password']");
    By loginBtn = By.className("oxd-button");

    //constructor
    public LoginPage(WebDriver driver) {
        loginDriver = driver;
    }

    public void typeUsername(String username) {
        new WebDriverWait(loginDriver, Duration.ofSeconds(10))
                .until(d -> d.findElement(userLogin)).sendKeys(username);

    }

    public void typePassword(String password) {
        loginDriver.findElement(userPassword).sendKeys(password);
    }

    public LogoutPage clickLoginBtn(){
        loginDriver.findElement(loginBtn).click();
        return new LogoutPage(loginDriver);
    }

}
