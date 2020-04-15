package driver;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.sql.Time;
import java.util.concurrent.TimeUnit;

public class FirefoxDriverDemo {

    WebDriver driver;
    String URL = "https://www.google.com/";

    @BeforeTest
    public void setup() {
        // iNIT
        System.setProperty("webdriver.gecko.driver", "./drivers/geckodriver-v0.19.1-win32.exe"); //emplacement du driver
        FirefoxOptions options =new FirefoxOptions();
        options.setCapability("marionette", true); // true: new firefox version
        driver =new FirefoxDriver(options);
        driver.manage().timeouts().implicitlyWait(  15, TimeUnit.SECONDS) ;


    }


    @Test
    public void demochrome() throws Exception{

        // LOADING PAGE
        driver.get(URL);
        //GETTING ID
        driver.findElement(By.id("lst-ib")).sendKeys("marwa\n");
        Thread.sleep(2000);

        //GETTING TITLE
        String title = driver.getTitle();
        Assert.assertEquals(title, "marwa - Recherche Google");


    }


    @AfterTest
    public void cleanup() {

        driver.quit();
    }

}
