package Functions.Base;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Login {

    public static void main(String[] args) {
        System.setProperty("webdriver.gecko.driver", "C:\\Projects\\Automation\\BuickAndCadiilac\\src\\test\\resources\\Drivers\\geckodriver.exe");
        //It creates an instance
        WebDriver driver = new FirefoxDriver();
        driver.get("https://demo.serenity.is/Account/Login/?ReturnUrl=%2F");

        WebElement username = driver.findElement(By.id("LoginPanel0_Username"));
        username.clear();
        username.sendKeys("admin");

        WebElement password = driver.findElement(By.id("LoginPanel0_Password"));
        password.clear();
        password.sendKeys("serenity");

        WebElement loginButton = driver.findElement(By.id("LoginPanel0_LoginButton"));
        loginButton.click();
    }


}
