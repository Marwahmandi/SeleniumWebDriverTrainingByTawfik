package basics;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class SwitchAlerte {

    WebDriver driver;
    String URL_02 = "http://nouri-tawfik.com/formations/selenium/demo-v1/practice-page.html";

    @BeforeTest
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        driver.manage().window().maximize();

    }

    @Test
    public void demoSwitchAlerte() throws Exception {
        String name = "marwa";
        //open URL
        driver.get(URL_02);
        //writing message
        driver.findElement(By.id("name")).sendKeys(name);

        //Click on alert
        driver.findElement(By.id("alertbtn")).click();
        //switching
        Alert myAlerte = driver.switchTo().alert();
        //getting alerte message
        String AlerteMessage = myAlerte.getText();
        myAlerte.accept();
        // myAlerte.dismiss();

        //Assert
        Assert.assertEquals(AlerteMessage, "Hello " + name + ", share this practice page and share your knowledge");



    }


    @AfterTest
    public void cleanUp() throws Exception {
        Thread.sleep(3000);
        // driver.quit();
    }

}
