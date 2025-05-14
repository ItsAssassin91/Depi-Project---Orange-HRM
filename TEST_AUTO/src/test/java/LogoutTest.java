import Pages.LoginPage;
import Pages.LogoutPage;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.IOException;
import java.time.Duration;

public class LogoutTest {

    WebDriver driver;
    LoginPage loginPage;
    LogoutPage logoutPage;
    WebDriverWait wait;

    @BeforeClass
    public void start() {
        driver = new FirefoxDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
        loginPage = new LoginPage(driver);
    }

    @Test(testName = "login" , priority = 1)
    public void login() {
        loginPage.typeUsername("Admin");
        loginPage.typePassword("admin123");
        loginPage.clickLoginBtn();
    }

    @Test(priority = 2)
    public void logout(){
        logoutPage = new LogoutPage(driver);
        logoutPage.logout();
    }

}
