package advanced;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.openqa.selenium.io.FileHandler;
import java.util.concurrent.TimeUnit;
import java.io.File;


public class ScreenShot {

    WebDriver driver;
    JavascriptExecutor js;
    String URL_14 = "http://nouri-tawfik.com/formations/selenium/demo-v1/views/droppable.php";

    @BeforeTest
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        driver.manage().window().maximize();


    }

    @Test
    public void demoSwitchAlerte() throws Exception {

        //open URL
        driver.get(URL_14);
        File ramFile=((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);//TakesScreenshot is an interface that implements chromedriver
        FileHandler.copy(ramFile, new File("C:\\IMAGE\\Testt.png"));




    }


    @AfterTest
    public void cleanUp() throws Exception {
        Thread.sleep(3000);
        //   driver.quit();
    }

}

