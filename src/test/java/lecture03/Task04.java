package lecture03;

import libs.Login;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import libs.WebDriverManager;

//Run from loginSuite.xml
public class Task04 {

    private WebDriver driver;
    private WebDriverManager manager = new WebDriverManager();
    private Login login = new Login();

    @BeforeTest
    @Parameters("browser")
    public void start(String browser) {
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