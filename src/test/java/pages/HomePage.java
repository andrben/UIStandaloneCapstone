package pages;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class HomePage {
	WebDriver driver;
	List<WebElement> flights = null;

	public HomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	@FindBy(linkText = "Home")
	WebElement hm_lnk;

	@FindBy(linkText = "Login/Signup")
	WebElement login_signup_lnk;

	@FindBy(linkText = "Dashboard")
	WebElement dashboard_lnk;

	@FindBy(linkText = "Edit Profile")
	WebElement edit_profile_lnk;

	@FindBy(linkText = "Your Bookings")
	WebElement bookings_lnk;

	@FindBy(linkText = "Logout")
	WebElement logout_lnk;

	@FindBy(name = "source")
	WebElement source_drpdwn;

	@FindBy(name = "destination")
	WebElement destn_drpdwn;

	@FindBy(xpath = "//button[text()='Submit']")
	WebElement submit_btn;

	public LoginPage login_signup() {
		login_signup_lnk.click();
		return new LoginPage(driver);
	}

	public void click_submit() {
		submit_btn.click();
	}

	public void select_source(String src) {
		Select src_drpdwn = new Select(source_drpdwn);
		src_drpdwn.selectByVisibleText(src);
	}

	public void select_destination(String destn) {
		Select src_drpdwn = new Select(destn_drpdwn);
		src_drpdwn.selectByVisibleText(destn);
	}

	
	public int get_flight_id(String src, String destn) throws SQLException {
		int flight_id = -1;
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/flyaway", "root", "");
		Statement stmt = con.createStatement();
		String q = ("select id from f_flights where source=(select id from f_places where name='" + src 
				+ "') and destination=(select id from f_places where name='" + destn + "')");
		ResultSet rec = stmt.executeQuery(q);

		while (rec.next()) {
			flight_id=rec.getInt("id");
		}
		con.close();
		return flight_id;
	}
	
	
	public boolean flight_exists(String src, String destn) throws SQLException {
		flights = driver.findElements(By.linkText("Book Flight"));
		boolean flight_exists = false;
		for(WebElement flight:flights) {
			if(flight.getAttribute("href").substring(flight.getAttribute("href").lastIndexOf("=") + 1).contentEquals(Integer.toString(get_flight_id(src, destn)))){
				flight_exists = true;
			}
			
		}
		return flight_exists;
	}

	public PaymentGateway click_to_book() {
		flights = driver.findElements(By.linkText("Book Flight"));
		if (flights.size() > 0) {
			flights.get(0).click();
			return new PaymentGateway(driver);
		} else {
			return new PaymentGateway(null);
		}
	}
}
