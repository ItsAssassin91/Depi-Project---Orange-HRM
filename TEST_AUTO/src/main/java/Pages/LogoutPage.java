package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LogoutPage {
    //driver
    WebDriver logoutDriver;
    WebDriverWait wait;

    //locator
    By userDropdown = By.cssSelector("oxd-userdropdown-tab");
    By logoutbutton = By.xpath("a[href='/web/index.php/auth/logout']");

    public LogoutPage(WebDriver driver) {
        logoutDriver = driver;
        this.wait = new WebDriverWait(logoutDriver, Duration.ofSeconds(10));
    }

//    public LoginPage clickLogout(){
//        logoutDriver.findElement(userDropdown).click();
//        Actions action = new Actions(logoutDriver);
//        action.moveToElement((WebElement) logout);
//        return new LoginPage(logoutDriver);
//    }

    public LoginPage logout() {

        WebElement dropDown = wait.until(ExpectedConditions.elementToBeClickable(userDropdown));
        dropDown.click();

        WebElement logout = wait.until(ExpectedConditions.elementToBeClickable(logoutbutton));
        logout.click();
        return new LoginPage(logoutDriver);
    }
}
