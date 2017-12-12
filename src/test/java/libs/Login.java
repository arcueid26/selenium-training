package libs;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Login {

    private String username = "admin";
    private String password = "admin";

    public void loginToAdminArea(WebDriver driver) {
        driver.get("http://localhost/litecart/admin/login.php");
        driver.findElement(By.name("username")).sendKeys(username);
        driver.findElement(By.name("password")).sendKeys(password);
        driver.findElement(By.name("login")).click();
    }
}