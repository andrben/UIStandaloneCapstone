package stepdefs;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;

import io.cucumber.java.en.*;
import pages.DashboardPage;
import pages.HomePage;
import pages.PaymentGateway;

public class FlightSearch {
	private WebDriver driver = Hooks.driver;
	Connection con=Hooks.con;
	private HomePage home_pg;
	private DashboardPage login_success_pg;
	private PaymentGateway payment_gtway;
	private String source;
	private String destination;
	
	@And("I click on Home page link")
	public void click_home_pg() throws InterruptedException{
		login_success_pg=new DashboardPage(driver);
		home_pg=login_success_pg.click_home();
	}
	
	@And("I select {string} to {string} as the source & desitnation")
	public void flight_search(String src, String dstn){
		this.source=src;
		this.destination=dstn;
		home_pg.select_source(src);
		home_pg.select_destination(dstn);
	}
	
	@And("I click on Submit")
	public void click_submit() {
		home_pg.click_submit();
	}
	
	@And("I confirm that the flight exists for booking")
	public void flight_exists() throws SQLException {
		Assert.assertTrue(home_pg.flight_exists(this.source,this.destination));
	}
	
	@And("I click on the Book Flight button")
	public void book_flight() {
		payment_gtway=home_pg.click_to_book();
	}
	
	@Then("I confirm whether the flight ID is the same in the Book Flight link and the database")
	public void confirm_booking() throws SQLException {
		int flight_id = -1;
		Statement stmt = con.createStatement();
		String q = ("select id from f_flights where source=(select id from f_places where name='" + this.source 
				+ "') and destination=(select id from f_places where name='" + this.destination + "')");
		ResultSet rec = stmt.executeQuery(q);

		while (rec.next()) {
			flight_id=rec.getInt("id");
		}
		String expected = Integer.toString(flight_id);
		System.out.println("The flight ID as per the database is: "+flight_id);
		String actual = payment_gtway.get_url().substring((payment_gtway.get_url().lastIndexOf("=") + 1));
		
		Assert.assertTrue(expected.contentEquals(actual));
	}
	
	
}
