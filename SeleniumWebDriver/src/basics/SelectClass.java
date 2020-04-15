package basics;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class SelectClass {

    WebDriver driver;
    String URL_02 = "http://nouri-tawfik.com/formations/selenium/demo-v1/practice-page.html";


    @BeforeTest
    public void setup() {
        // iNIT
        System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        driver.manage().window().maximize();
    }


    @Test
    public void demoSelectClass() {
        driver.get(URL_02);
        WebElement carselect = driver.findElement(By.id("carselect"));
        Select mySelect =new Select(carselect);
       mySelect.selectByIndex(2);


    }


    @AfterTest
    public void clr() throws Exception {
        Thread.sleep(5000);
        driver.quit();
    }

}
