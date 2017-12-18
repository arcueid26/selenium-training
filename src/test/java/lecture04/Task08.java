package lecture04;

import libs.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.List;

public class Task08 {

    private String browser = "Chrome";
    private WebDriver driver;
    private WebDriverManager manager = new WebDriverManager();

    @BeforeTest
    public void start() {
        driver = manager.startDriver(browser);
    }

    @Test
    public void checkStickers() {
        driver.get("http:///localhost/litecart/en/");
        List<WebElement> ducks = driver.findElements(By.cssSelector(".product"));
        for (WebElement duck : ducks) {
            Assert.assertTrue(duck.findElements(By.cssSelector(".sticker")).size() == 1, "Количество стикеров товара не равно 1");
        }
    }

    @AfterTest
    public void stop() {
        manager.stopDriver(driver);
    }
}