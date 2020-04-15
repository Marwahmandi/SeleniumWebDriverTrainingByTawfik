package Hello;

import org.testng.Assert;
import org.testng.annotations.*;

    public class Taxi2 {
        @Test
        public void StratCar() {

            System.out.println("StratCar");
           Assert.assertEquals("marwa","marwa");

        }

        @Test (dependsOnMethods = "StratCar")
        public void DriveCar() {

            System.out.println("DriveCar");
        }

        @Test(dependsOnMethods = "DriveCar")
        public void StopCar() {

            System.out.println("StopCar");
        }


    }
