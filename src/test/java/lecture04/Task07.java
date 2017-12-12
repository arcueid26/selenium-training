package lecture04;

import libs.Login;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import libs.WebDriverManager;

public class Task07 {

    private String browser = "Chrome";
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

    @Test
    public void navigateOnMenu() {
        int parentCount = driver.findElements(By.id("app-")).size();
        for (int i = 0; i < parentCount; i++) {
            driver.findElements(By.id("app-")).get(i).click();
            Assert.assertTrue(driver.findElement(By.tagName("h1")).isEnabled(), "Заголовок не найден");
            int childCount = driver.findElements(By.id("app-")).get(i).findElements(By.tagName("li")).size();
            for (int j = 1; j < childCount; j++) {
                driver.findElements(By.id("app-")).get(i).findElements(By.tagName("li")).get(j).click();
                Assert.assertTrue(driver.findElement(By.tagName("h1")).isEnabled(),"Заголовок не найден");
            }
        }
    }

    @AfterTest
    public void stop() {
        manager.stopDriver(driver);
    }
}