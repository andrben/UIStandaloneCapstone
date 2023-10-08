package stepdefs;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.cucumber.java.After;
import io.cucumber.java.Before;


public class Hooks {
public static WebDriver driver;
public static Connection con;
	
	@Before
	public void SetUp() throws SQLException {
		System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir")+"//Driver/geckodriver.exe");
		driver = new FirefoxDriver();
		driver.manage().window().maximize();
		con = DriverManager.getConnection("jdbc:mysql://localhost:3306/flyaway", "root", "");
		
	}
	
	@After
	public void TearDown() throws SQLException {
		
		driver.quit();
		con.close();
		
	}
}