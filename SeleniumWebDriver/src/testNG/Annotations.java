package testNG;

import org.testng.annotations.*;

public class Annotations {
    @BeforeSuite
    public void beforeSuite()

    {
        System.out.println("before Suite");

    }
    @BeforeTest
    public void beforeTest()

    {
        System.out.println("before Test");

    }
    @BeforeClass
    public void beforeClass()

    {
        System.out.println("before class");

    }
    @BeforeMethod
    public void beforeMethod()

    {
        System.out.println("before method");

    }

    @Test
    public void loginViaGmail()

    {
        System.out.println("GMAIL");

    }
    @Test
    public void loginViaFB()

    {
        System.out.println("FACEBOOK");

    }
    @AfterMethod
    public void AfterMethod()

    {
        System.out.println("After method");

    }
    @AfterClass
    public void AfterClass()

    {
        System.out.println("After Class");

    }
    @AfterTest
    public void AfterTest()

    {
        System.out.println("After Test");

    }
    @AfterSuite
    public void AfterSuite()

    {
        System.out.println("After Suite");

    }
}
