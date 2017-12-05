package util;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxBinary;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;

public class WebDriverManager {

    private WebDriver driver;
    private WebDriverWait wait;
    private FirefoxOptions options;

    public WebDriver getDriver() {
        return driver;
    }

    public void startDriver(String browser) {
        switch (browser) {
            case "Chrome":
                driver = new ChromeDriver();
                break;
            case "Firefox":
                options = new FirefoxOptions().setLegacy(false);
                driver = new FirefoxDriver(options);
                break;
            case "Firefox ESR":
                options = new FirefoxOptions().setLegacy(true);
                options.setBinary(new FirefoxBinary(new File("/Applications/Firefox ESR.app/Contents/MacOS/firefox-bin")));
                driver = new FirefoxDriver(options);
                break;
            case "Firefox Nightly":
                options = new FirefoxOptions().setLegacy(false);
                options.setBinary(new FirefoxBinary(new File("/Applications/FirefoxNightly.app/Contents/MacOS/firefox-bin")));
                driver = new FirefoxDriver(options);
                break;
            case "Safari":
                driver = new SafariDriver();
                break;
            default:
                driver = new ChromeDriver();
                break;
        }
        wait = new WebDriverWait(driver, 10);
    }

    public void stopDriver() {
        driver.quit();
        driver = null;
    }
}
