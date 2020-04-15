package basics;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class MultiSelct {

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
    public void demoSelectClass() throws InterruptedException {
        driver.get(URL_02);
        WebElement multiselect = driver.findElement(By.id("multiple-select-example"));
        Select mySelect =new Select(multiselect);
        mySelect.selectByIndex(0);
        mySelect.selectByValue("orange");
        mySelect.selectByVisibleText("Peach");
        Thread.sleep (3000);
        mySelect.deselectAll();
        System.out.println("bye");



    }


    @AfterTest
    public void clr() throws Exception {
        Thread.sleep(2000);
        driver.quit();
    }

}
