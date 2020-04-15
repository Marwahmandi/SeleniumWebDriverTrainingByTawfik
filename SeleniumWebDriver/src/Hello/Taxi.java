package Hello;

import org.testng.annotations.*;

public class Taxi {
    @Test (priority = 3)
    public void StratCar(){

        System.out.println("StratCar");
    }
    @Test (priority = 2)
    public void DriveCar(){

        System.out.println("DriveCar");
    }
    @Test (priority = 1)
    public void StopCar(){

        System.out.println("StopCar");
    }

}
