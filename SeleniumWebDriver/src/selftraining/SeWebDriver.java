package selftraining;

import net.bytebuddy.utility.JavaModule;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.Set;
import java.util.concurrent.TimeUnit;

public class SeWebDriver {
    WebDriver driver;
    String URL="http://nouri-tawfik.com/formations/selenium/demo-v1/practice-page.html";
    String URL2="http://nouri-tawfik.com/formations/selenium/demo-v1/views/droppable.php";

    @BeforeTest
    public void Setup(){

        System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(  15, TimeUnit.SECONDS) ;
        driver.manage().window().maximize();
    }

    @Test(enabled = false)
    public void test(){
        driver.get(URL);
        String title =driver.findElement(By.className("navbar-brand")).getText();
        Assert.assertEquals(title,"SELENIUM WEBDRIVER");

    }
   @Test(enabled = false)
   public void testRadioButton() {
        driver.get(URL);
        WebElement radio1 = driver.findElement(By.id("bmwradio"));
        Boolean IsSelected =radio1.isSelected();
        Assert.assertEquals(IsSelected,Boolean.FALSE);
        radio1.click();
        IsSelected =radio1.isSelected();
        Assert.assertEquals(IsSelected,Boolean.TRUE);
        WebElement radio2 =driver.findElement(By.id("benzradio"));
        radio2.click();

   }

   @Test(enabled = false)
   public void multiSelect(){
        driver.get(URL);
        WebElement select =driver.findElement(By.id("multiple-select-example"));
        Select mySelection=new Select(select);
        mySelection.selectByIndex(0);
        mySelection.selectByVisibleText("Orange");
        mySelection.selectByValue("peach");
        System.out.println("all items are selected");
     //  mySelection.deselectAll();
       //System.out.println("all items are deselected");

   }
   @Test(enabled =false)
   public void selectClass(){
        driver.get(URL);
        WebElement carSelect =driver.findElement(By.id("carselect"));
        Select car=new Select(carSelect);
        car.selectByValue("benz");

   }

   @Test(enabled = false)
   public void demoSwitchAlerte() throws Exception{
        String input="marwa";
        driver.get(URL);
        WebElement name=driver.findElement(By.id("name"));
        name.sendKeys(input);
        WebElement AlerteButton=driver.findElement(By.id("alertbtn"));
        AlerteButton.click();
        //Switching
       Alert myAlerte=driver.switchTo().alert();
       //getting ALerte message
       String AlerteMessage=myAlerte.getText();
       Assert.assertEquals(AlerteMessage,"Hello " +input+ ", share this practice page and share your knowledge");

       myAlerte.accept();




   }

   @Test(enabled = false)
   public void switchWindow()throws Exception{
        driver.get(URL);

       String mainPage = driver.getWindowHandle();
       System.out.println(mainPage);

       // Get the handle
       String parentHandle = driver.getWindowHandle();
       System.out.println("Parent Handle: " + parentHandle);
      // Find Open Window button
        WebElement OpenTab =driver.findElement(By.id("opentab"));
        OpenTab.click();
       // Get all handles
       Set<String> allPageshandles = driver.getWindowHandles();
       System.out.println("ALLpages= " + allPageshandles);
       // Switching between handles
       for (String currentPage : allPageshandles) {
           System.out.println("Current Page " + currentPage);
           if (!currentPage.equals(parentHandle)) {
               // Switch to new opened window ==> 'http://nouri-tawfik.com/se-former.html'
               driver.switchTo().window(currentPage);
               Thread.sleep(2000);

               // Open a new link
               driver.findElement(By.linkText("Les fondamentaux du Raspberry Pi")).click();
               Thread.sleep(4000);

               driver.close();
               break;
           }
       }
       // Switch back to the parent window
       driver.switchTo().window(parentHandle);
       driver.findElement(By.id("name")).sendKeys("Test Successful");
   }
     @Test(enabled = false)
     public void switchFrame() throws Exception{
        driver.get(URL);
        driver.switchTo().frame("courses-iframe");
         Thread.sleep(3000);
         driver.findElement(By.linkText("Développement d'objets connectés")).click();
         Thread.sleep(4000);
         driver.switchTo().defaultContent();
         Thread.sleep(6000);
         driver.findElement(By.id("name")).sendKeys("Test Successful");


    }
    @Test(enabled = false)
    public void dragAndDrop(){
        driver.get(URL2);
        WebElement MyFrame =driver.findElement(By.className("demo-frame"));
        driver.switchTo().frame(MyFrame);
        WebElement Draggable =driver.findElement(By.id("draggable"));

        WebElement Droppable =driver.findElement(By.id("droppable"));
        Actions myAction =new Actions(driver);
        myAction.clickAndHold(Draggable).moveToElement(Droppable).perform();


    }



   @AfterTest
    public  void clr() throws Exception{
        Thread.sleep(6000);
        driver.quit();
   }

}
