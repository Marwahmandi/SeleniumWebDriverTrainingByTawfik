package basics;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class SwitchFrame {

    WebDriver driver;

    // URL 02
    String baseUrl = "http://nouri-tawfik.com/formations/selenium/demo-v1/practice-page.html";

    @BeforeTest
    public void setUp() throws Exception{

        System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");

        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        //driver.manage().window().maximize();
        driver.get(baseUrl);

        Thread.sleep(1000);
    }

    @Test
    public void demoSwitchFrame() throws Exception {

        Thread.sleep(3000);
        // Switch to frame by Id
        driver.switchTo().frame("courses-iframe");
        // Switch to frame by name
        //driver.switchTo().frame("iframe-name");
        // Switch to frame by numbers
        //driver.switchTo().frame(0);

        // Open a new link
        driver.findElement(By.linkText("Les fondamentaux du Raspberry Pi")).click();
        Thread.sleep(4000);

        driver.switchTo().defaultContent();
        Thread.sleep(6000);
        driver.findElement(By.id("name")).sendKeys("Test Successful");

    }

    @AfterTest
    public void tearDown() throws Exception {

        Thread.sleep(5000);
        driver.quit();

    }

}
