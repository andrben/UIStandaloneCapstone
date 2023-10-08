package stepdefs;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;

import io.cucumber.java.en.*;
import pages.BookingConfirmation;
import pages.PaymentGateway;

public class ConfirmBooking {
	private WebDriver driver = Hooks.driver;
	private PaymentGateway payment_gtway = new PaymentGateway(driver);
	private BookingConfirmation confirm_booking_pg;

	@And("I click on the Click to complete booking link")
	public void confirm_booking() {
		confirm_booking_pg = payment_gtway.complete_booking();
	}

	@Then("I confirm my booking after landing on the final verification page")
	public void verify_booking() {
		Assert.assertTrue(confirm_booking_pg.see_ur_booking_is_displayed() && confirm_booking_pg.header_chk());
	}
}
