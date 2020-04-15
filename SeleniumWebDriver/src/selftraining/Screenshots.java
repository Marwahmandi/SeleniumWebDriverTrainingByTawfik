package selftraining;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;


import java.io.File;
import org.openqa.selenium.io.FileHandler;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.concurrent.TimeUnit;

    public class Screenshots {

        WebDriver driver;

        // URL05
        String baseUrl = "https://www.expedia.com/";

        @Before
        public void setUp() throws Exception{

            System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");

            driver = new ChromeDriver();
            driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
            //driver.manage().window().maximize();
            driver.get(baseUrl);

            Thread.sleep(1000);
        }

        @Test
        public void demoScreenshots() throws Exception {

            driver.findElement(By.id("tab-flight-tab-hp")).click();

            //Find elements
            WebElement flight_origin = driver.findElement(By.id("flight-origin-hp-flight"));
            WebElement flight_destination = driver.findElement(By.id("flight-destination-hp-flight"));
            WebElement departure_date = driver.findElement(By.id("flight-departing-hp-flight"));
            WebElement return_date = driver.findElement(By.id("flight-returning-hp-flight"));
         //   WebElement search = driver.findElement(By.xpath("//*[@id='gcw-flights-form-hp-flight']/div[8]/label/button"));
            WebElement search =driver.findElement(By.id("search-button-hp-package"));


            //Send data to the elements
            flight_origin.sendKeys("New York");
            departure_date.sendKeys("05/22/2018");
            return_date.clear();
            return_date.sendKeys("05/23/2018");
            flight_destination.sendKeys("Chicago");
            search.click();
        }



        @After
        public void tearDown() throws Exception {

        /*String fileName = ".//Screenshots//ScreenShot"+"_"+getDate()+".png";
        File screenFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        FileHandler.copy(screenFile, new File(fileName));
        */
            File myFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
            FileHandler.copy(myFile, new File("c:/test.png"));
            System.out.println("screenshot finished");
            Thread.sleep(2000);
            driver.quit();
        }

        public static String getDate() {
            Date today = Calendar.getInstance().getTime();
            SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd-hh.mm.ss");
            return formatter.format(today);
        }

    }



