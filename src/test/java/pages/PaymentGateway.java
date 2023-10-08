package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PaymentGateway {
	private WebDriver driver;

	public PaymentGateway(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}
	
	
	@FindBy(linkText = "Home")
	private WebElement hm_lnk;


	@FindBy(linkText = "Dashboard")
	private WebElement dashboard_lnk;

	@FindBy(linkText = "Edit Profile")
	private WebElement edit_profile_lnk;

	@FindBy(linkText = "Your Bookings")
	private WebElement bookings_lnk;

	@FindBy(linkText = "Logout")
	private WebElement logout_lnk;
	
	@FindBy(linkText = "Click to complete booking")
	private WebElement complete_booking;
	
	public boolean confirm_text(String header) {
		return driver.getPageSource().contains(header);
	}
	
	public String get_url() {
		return driver.getCurrentUrl();
	}
	
	public BookingConfirmation complete_booking() {
		complete_booking.click();
		return new BookingConfirmation(driver);
	}
}
