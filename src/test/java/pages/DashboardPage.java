package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DashboardPage {

	WebDriver driver;
	private String h3_header = "FLYAWAY - DASHBOARD";

	public DashboardPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	@FindBy(linkText = "Home")
	WebElement hm_lnk;

	@FindBy(linkText = "Dashboard")
	WebElement dashboard_lnk;

	@FindBy(linkText = "Edit Profile")
	WebElement edit_profile_lnk;

	@FindBy(linkText = "Your Bookings")
	WebElement bookings_lnk;

	@FindBy(linkText = "Logout")
	WebElement logout_lnk;

	public HomePage click_logout() {
		logout_lnk.click();
		return new HomePage(driver);
	}

	public boolean h3_header_chk() {
		return driver.getPageSource().contains(h3_header);
	}

	public boolean confirm_login() {
		return logout_lnk.isDisplayed();
	}

	public HomePage click_home() {
		hm_lnk.click();
		return new HomePage(driver);
	}
	
	

}
