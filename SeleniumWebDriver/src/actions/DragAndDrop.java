package actions;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class DragAndDrop {

    WebDriver driver;
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
        long startTime;
        long endTime;
        long duration;
        double seconds;
        //open URL
        startTime=System.nanoTime();
        driver.get(URL_14);
        endTime=System.nanoTime();
        duration=endTime-startTime;
        seconds=duration/1000000000.0;
        System.out.println("logging page time:" +seconds);
        //from
        WebElement MyFrame = driver.findElement(By.className("demo-frame"));
        driver.switchTo().frame(MyFrame);
        WebElement draggable =driver.findElement(By.id("draggable"));
        //to
        WebElement  droppable =driver.findElement(By.id("droppable"));
        //message
        WebElement message =driver.findElement(By.xpath("//div[@id='droppable']/p"));

        //
       Actions myAction =new Actions(driver) ;
       myAction.clickAndHold(draggable).moveToElement(droppable).release().build().perform(); // action enchainé par une autre action
       String newMessage =message.getText();
        System.out.println(newMessage);
       Assert.assertEquals(newMessage,"Dropped!");
    }


    @AfterTest
    public void cleanUp() throws Exception {
        Thread.sleep(3000);
      //   driver.quit();
    }

}

