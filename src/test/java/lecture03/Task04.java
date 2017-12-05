package lecture03;

import org.openqa.selenium.By;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import util.WebDriverManager;

//Run from loginSuite.xml
public class Task04 {

    private String username = "admin";
    private String password = "admin";
    private WebDriverManager manager = new WebDriverManager();

    @BeforeTest
    @Parameters("browser")
    public void start(String browser) {
        manager.startDriver(browser);
    }

    @Test()
    public void loginToAdminArea() {
        manager.getDriver().get("http://localhost/litecart/admin/login.php");
        manager.getDriver().findElement(By.name("username")).sendKeys(username);
        manager.getDriver().findElement(By.name("password")).sendKeys(password);
        manager.getDriver().findElement(By.name("login")).click();
    }

    @AfterTest
    public void stop() {
        manager.stopDriver();
    }
}