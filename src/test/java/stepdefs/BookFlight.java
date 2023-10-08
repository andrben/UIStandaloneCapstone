package stepdefs;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;

import io.cucumber.java.en.Then;
import pages.PaymentGateway;

public class BookFlight {
	private WebDriver driver = Hooks.driver;
	private Connection con = Hooks.con;
	private String header = "FLYAWAY - PAYMENT GATEWAY";
	private PaymentGateway payment_gtway;
	
	
	
	@Then("I confirm my booking after checking the source and desitnation in the flight details")
	public void confirm_booking() throws SQLException {
		payment_gtway = new PaymentGateway(driver);
		String flight_id = payment_gtway.get_url().substring(payment_gtway.get_url().lastIndexOf("=") + 1);
		Statement stmt = con.createStatement();
		String q = ("select concat(concat(src.name,' - '),destn.name) source_2_destn from f_flights flt join f_places src on (flt.source=src.id)"
				+ " join f_places destn on (flt.destination=destn.id) where flt.id="+flight_id);
		ResultSet rec = stmt.executeQuery(q);
		
		String stc2destn=null;
		while (rec.next()) {
			stc2destn=rec.getString("source_2_destn");
		}		
		Assert.assertTrue(payment_gtway.confirm_text(this.header) && payment_gtway.confirm_text(stc2destn));
	}

}
