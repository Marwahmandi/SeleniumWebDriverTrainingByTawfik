package basics;



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
import java.util.concurrent.TimeUnit;

public class Locators {

    WebDriver driver;
    String URL_02 = "http://nouri-tawfik.com/formations/selenium/demo-v1/practice-page.html";
    String URL_20 = "http://nouri-tawfik.com/formations/selenium/demo-v1/easy-bank/Manager/ManagerHomePage.php";

    @BeforeTest
    public void setup() {
        // iNIT
        System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(  15, TimeUnit.SECONDS) ;
        driver.manage().window().maximize();

    }


    @Test(enabled = false)
    public void demoById() {

        // LOADING PAGE
        driver.get(URL_02);
        //GETTING ID
       // driver.findElement(By.id("openwindow")).click();
        WebElement openwindow =driver.findElement(By.id("openwindow"));
        openwindow.click();

        // /html//form[@id='tsf']//div[@class='a4bIc']/input[@role='combobox']
        //Driver.findElement(By.xpath(""//form[@id='tsf']//div[@class='a4bIc']/input[@role='combobox'])ath("").sendkeys();
        //driver.findElement(By.id("lst-ib")).sendKeys("marwa\n");
        //String title = driver.getTitle();
       // Assert.assertEquals(title, "marwa - Recherche Google");

    }


    @Test(enabled = true)
     public  void demoClassName(){
        driver.get(URL_20);
        String t=driver.findElement(By.className("heading3")).getText(); //locate with classname
        Assert.assertEquals(t,"lala");
     }

    @Test(enabled = true)
    public  void demobyCSS(){
        driver.get(URL_20);
       String text= driver.findElement(By.cssSelector("h2.barone")).getText(); //locate with css:go to ranorex solicity and then select css instead of xpath
        Assert.assertEquals(text,"Easy Street");
    }
    @AfterTest
    public void clr() throws Exception {
    Thread.sleep(2000);
       driver.quit();
    }

}
