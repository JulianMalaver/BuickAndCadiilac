package Base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class Test {

   //Initialization of instance

   //Google
   //public static WebDriver driver = new ChromeDriver();

   //Edge
   //public static WebDriver driver = new EdgeDriver();

   //Firefox
   public static WebDriver driver = new FirefoxDriver();


   //Manage application properties
   static Properties prop;

   //Constructor
   //Initialization of configuration settings
   public Test() {
      try{
         prop = new Properties();
         FileInputStream inputFile = new FileInputStream("src/test/resources/config.properties");
         prop.load(inputFile);
      } catch (IOException e){
         e.printStackTrace();
      }
   }

   //Setting up browser
   public void settingUp(){
      driver.manage().window().maximize();
      driver.manage().deleteAllCookies();
      driver.manage().timeouts().pageLoadTimeout(90, TimeUnit.SECONDS);
   }

   //Closing driver
   public void closeDriver(){
      driver.close();
   }

}
