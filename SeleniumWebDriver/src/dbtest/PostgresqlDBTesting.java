package dbtest;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.sql.*;
import java.util.Properties;

public class PostgresqlDBTesting {

	// Connection object
	static Connection conn = null;
	// Statement object
	private static Statement st;
	// Result set
	private static ResultSet results = null;
	// Contant for Database URL
	public static String DB_URL = "jdbc:postgresql://localhost:5432/user";

	// Contant for Database Username
	public static String DB_USER = "postgres";
	// Contant for Database Password
	public static String DB_PASSWORD = "marwa";
	// Driver
	public static String driver = "org.postgresql.Driver";
	
	// WebDriver
	public static WebDriver wd;


	@BeforeClass
	public void beforeClass() {
		// Initialize WebDriver
		//wd = new ChromeDriver();
		
		// Properties for creating connection to database
		Properties props = new Properties();
		props.setProperty("user", "postgres");
		props.setProperty("password", "marwa");
		
		try {
			// STEP 1: Register JDBC driver
			Class.forName(driver).newInstance();
			
			// STEP 2: Get connection to DB
			System.out.println("Connecting to a selected database...");
			conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
			// conn = DriverManager.getConnection(DB_URL, props);
			
			System.out.println("Connected database successfully...");
			
			// STEP 3: Statement object to send the SQL statement to the Database
			System.out.println("Creating statement...");
			st = conn.createStatement();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test
	public void test() {
		String query = "select * from user_info";
		try {
			// STEP 4: Extract data from result set
			results = st.executeQuery(query);
			while(results.next()) {
				int id = results.getInt("user_id");
				String first = results.getString("first_name");
				String last = results.getString("last_name");
				String city = results.getString("city");
				
				// Display value
				System.out.println("ID: "+id);
				System.out.println("First Name: "+first);
				System.out.println("Last Name: "+last);
				System.out.println("City: "+city);
				
				// From GUI
				//WebElement element = wd.findElement(By.id("uname"));
				//String actualUsername = element.getText();
				
				//Assert.assertEquals(actualUsername, first);
			}
			results.close();
		} catch (SQLException se) {
			se.printStackTrace();
		}catch (Exception e) {
			e.printStackTrace();
		}
	}

	@AfterClass
	public void afterClass() {
		try {
			if(results != null)
				results.close();
			if(st != null)
				conn.close();
			if(conn != null)
				conn.close();
		} catch (SQLException se) {
			se.printStackTrace();
		}
	}
}
