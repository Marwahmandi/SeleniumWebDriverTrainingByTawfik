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

public class SwitchWindow {

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
    public void demoSwitchWindow () throws Exception {
        driver.get(URL_02);
        String parentHandel = driver.getWindowHandle();
        System.out.println(parentHandel);
        WebElement openwindow = driver.findElement(By.id("openwindow"));
        // nb pages = 1
        openwindow.click();
        // nb pages = 2
        //driver.getWindowHandles();
        int nbPages = driver.getWindowHandles().size();
        System.out.println("nb de page est: "+nbPages);
        String[] handles=new String[nbPages];
        //
        driver.getWindowHandles().toArray(handles);


        for (int i=0; i<nbPages; i++)
        {
            if(!handles[i].equals(parentHandel))
            {
                driver.switchTo().window(handles[i]);
                break;
            }

        }

        String subTitle = driver.findElement(By.xpath("//nav[@id='mainNav']//a[@href='#']")).getText();
        System.out.println(subTitle);
        Assert.assertEquals(subTitle,"FORMATION");
        driver.close();

        driver.switchTo().window(parentHandel);




    }


    @AfterTest
    public void cleanUp() throws Exception {
        Thread.sleep(2000);
        driver.quit();
    }

}
