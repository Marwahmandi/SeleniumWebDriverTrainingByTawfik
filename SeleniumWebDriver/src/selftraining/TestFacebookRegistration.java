package selftraining;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.sql.Driver;
import java.util.concurrent.TimeUnit;

public class TestFacebookRegistration {

    String URL = "http://www.facebook.com";
    WebDriver driver;

        // iNIT
        @BeforeTest
        public void setup() {
            System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
            driver = new ChromeDriver();

            driver.manage().window().maximize();
          //  driver.manage().timeouts().implicitlyWait(15, TimeUnit.MINUTES);


        }

        @Test
    public void TestFacebook(){
            driver.get(URL);
           WebElement name =driver.findElement(By.id("u_0_n"));
         //  WebElement name =driver.findElement(By.xpath(".//*[@id='u_0_1']"));// to be verified!!!
           name.sendKeys("marwa");

             WebElement LastName =driver.findElement(By.id("u_0_p"));
             LastName.sendKeys("Hmandi");

             driver.findElement(By.xpath("//input[@id='u_0_a']")).click();

            Select Day=new Select(driver.findElement(By.id("day")));
            Day.selectByIndex(3);

            Select Month=new Select(driver.findElement(By.id("month")));
            Month.selectByVisibleText("fév");

            Select Year=new Select(driver.findElement(By.id("year")));
            Year.selectByIndex(6);

            driver.findElement(By.id("u_0_15")).click();

        }

        @AfterTest
        public void End(){

            driver.quit();
        }

    }

