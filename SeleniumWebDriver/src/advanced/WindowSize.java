package advanced;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class WindowSize {

    WebDriver driver;
    JavascriptExecutor js;
    String URL_14 = "http://nouri-tawfik.com/formations/selenium/demo-v1/views/droppable.php";

    @BeforeTest
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        js = (JavascriptExecutor) driver;

    }

    @Test
    public void demoSwitchAlerte() throws Exception {

        //open URL
        driver.get(URL_14);
        long height;
        long width;
        //size of the window
        //  js.executeScript(alert("Bonjour MARWA"));
        js.executeScript("alert('marwa')");
        height = (long) js.executeScript("return window.innerHeight;");
        width = (long) js.executeScript("return window.innerWidth;");
        System.out.println(height);
        System.out.println(width);


    }


    @AfterTest
    public void cleanUp() throws Exception {
        Thread.sleep(3000);
        //   driver.quit();
    }

}

