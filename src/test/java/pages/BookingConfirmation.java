package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class BookingConfirmation {
	WebDriver driver;
	private String header = "FLYAWAY - BOOKING CONFIRMATION";

	public BookingConfirmation(WebDriver driver) {
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
	
	@FindBy(linkText = "See Your Bookings")
	WebElement check_bookings_link;
	
	public HomePage click_logout() {
		logout_lnk.click();
		return new HomePage(driver);
	}
	
	public boolean header_chk() {
		return driver.getPageSource().contains(header);
	}
	
	public HomePage click_home() {
		hm_lnk.click();
		return new HomePage(driver);
	}
	
	public boolean see_ur_booking_is_displayed() {
		return check_bookings_link.isDisplayed();
	}
}
