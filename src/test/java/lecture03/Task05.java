package lecture03;

import libs.Login;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import libs.WebDriverManager;

public class Task05 {

    private String browser = "Firefox ESR";
    private WebDriver driver;
    private WebDriverManager manager = new WebDriverManager();
    private Login login = new Login();

    @BeforeTest
    public void start() {
        driver = manager.startDriver(browser);
    }

    @Test
    public void loginToAdminArea() {
        login.loginToAdminArea(driver);
    }

    @AfterTest
    public void stop() {
        manager.stopDriver(driver);
    }
}