package driver;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.sql.Driver;
import java.util.List;
import java.util.Set;

public class ChromeDriverDemo {

    WebDriver driver;
    String URL = "https://www.google.com/";

    @BeforeTest
    public void setup() {
        // iNIT
        System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
        driver = new ChromeDriver();

    }


    @Test
    public void demochrome() {

        // LOADING PAGE
        driver.get(URL);
        //GETTING ID
       // /html//form[@id='tsf']//div[@class='a4bIc']/input[@role='combobox']
        //Driver.findElement(By.xpath(""//form[@id='tsf']//div[@class='a4bIc']/input[@role='combobox'])ath("").sendkeys();
        driver.findElement(By.id("lst-ib")).sendKeys("marwa\n");

        //
        String title = driver.getTitle();
        Assert.assertEquals(title, "marwa - Recherche Google");


    }


    @AfterTest
    public void clr() {

        driver.quit();
    }

}
