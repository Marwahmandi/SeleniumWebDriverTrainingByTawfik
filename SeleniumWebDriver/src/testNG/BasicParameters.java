package testNG;

import org.testng.annotations.*;

public class BasicParameters {
    @Test
    @Parameters({"login","password"})
        public void LoginViaGmail(String xlogin, String xpassword){


        System.out.println("Login via gmail with "+xlogin+": "+xpassword);



    }
}
