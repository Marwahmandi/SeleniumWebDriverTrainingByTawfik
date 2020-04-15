package testNG;

import com.sun.deploy.cache.Cache;
import org.openqa.selenium.interactions.SourceType;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class BasicDataProvider {
    @Test(dataProvider = "gmailData")
    public void LoginViaGmail(String login,String password){

       // System.out.println("Login "+login+" :"+password);
        System.out.println("Login:" +login+",Password: "+password);

    }
    @DataProvider(name ="gmailData")
    public Object [][] getData(){
        Object [][] data =new Object[3][2];
        //OPEN XLS FLE AND READ DATA
        //
        data[0][0]="user1";
        data[0][1]="pwd1";
        data[1][0]="user2";
        data[1][1]="pwd2";
        data[2][0]="user3";
        data[2][1]="pwd3";

        return data;


    }
}
