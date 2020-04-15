package testNG;

import org.testng.annotations.Test;

public class Grouping {
    @Test (groups = {"BMW"})
    public  void testBMW_S1(){

        System.out.println("testBMW_S1");


    }
    @Test (groups = {"BMW"})
    public  void testBMW_S2(){

        System.out.println("testBMW_S2");


    }
    @Test (groups = {"PG"})
    public  void testPG_S1(){

        System.out.println("testPG_S1");


    }
    @Test (groups = {"PG"})
    public  void testPG_S2(){

        System.out.println("testPG_S2");


    }
}
