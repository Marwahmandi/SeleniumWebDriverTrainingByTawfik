package basics;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class RadioButton {

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
    public void demoById() {
        driver.get(URL_02);
        //GETTING ID
        //  Boolean isSelected = driver.findElement(By.id("bmwradio")).isSelected();
        //   Assert.assertEquals(isSelected,Boolean.FALSE);
        WebElement bmradio = driver.findElement(By.id("bmwradio"));
        Boolean isSelected = bmradio.isSelected();
        Assert.assertEquals(isSelected, Boolean.FALSE);
        bmradio.click();
        isSelected = bmradio.isSelected();
        Assert.assertEquals(isSelected, Boolean.TRUE);
        System.out.println("the value of the radio button is," +isSelected.booleanValue());




    }


    @AfterTest
    public void clr() throws Exception {
        Thread.sleep(2000);
        driver.quit();
    }

}
