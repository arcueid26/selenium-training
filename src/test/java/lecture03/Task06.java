package lecture03;

import org.openqa.selenium.By;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import util.WebDriverManager;

public class Task06 {

    private String username = "admin";
    private String password = "admin";
    private String browser = "Firefox Nightly";
    private WebDriverManager manager = new WebDriverManager();

    @BeforeTest
    public void start() {
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