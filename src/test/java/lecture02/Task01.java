package lecture02;

import libs.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Task01 {

    private String browser = "Chrome";
    private WebDriver driver;
    private WebDriverManager manager = new WebDriverManager();

    @BeforeTest
    public void start() {
        driver = manager.startDriver(browser);
    }

    @Test
    public void openLink() {
        driver.get("https://www.google.ru/");
    }

    @AfterTest
    public void stop() {
        manager.stopDriver(driver);
    }
}