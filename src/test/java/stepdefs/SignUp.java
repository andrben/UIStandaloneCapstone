package stepdefs;

import java.sql.*;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import pages.HomePage;
import pages.LoginPage;
import pages.RegistrationConfirm;
import pages.SignUpPage;
import io.cucumber.java.en.*;

public class SignUp {
	WebDriver driver = Hooks.driver;
	Connection con=Hooks.con;
	HomePage home_pg;
	LoginPage login_pg;
	SignUpPage signup_pg;
	RegistrationConfirm reg_pg;
	String signup_email;
	String signup_password;
	String signup_name;
	String signup_address;
	String signup_city;

	@Given("I have launched the Flyaway application")
	public void i_have_launched_the_application() throws InterruptedException {
		driver.get("http://localhost:8080/FlyAway/home");
		Thread.sleep(3000);
	}

	@When("I click on Login")
	public void click_on_login() {
		home_pg = new HomePage(driver);
		login_pg = home_pg.login_signup();

	}

	@And("I click on Signup")
	public void click_on_signup() {
		signup_pg = login_pg.click_on_signup();

	}

	@And("I enter email as {string}")
	public void enter_username(String string) {
		signup_pg.enter_email(string);
		this.signup_email = string;
	}

	@And("I enter password and confirm password as {string}")
	public void i_enter_password_and_confirm_password_as(String string) {
		signup_pg.enter_pwd(string);
		signup_pg.enter_pwd2(string);
		this.signup_password = string;
	}

	@And("I enter name as {string}")
	public void i_enter_name_as(String string) {
		signup_pg.enter_name(string);
		this.signup_name = string;
	}

	@And("I enter address as {string}")
	public void i_enter_address_as(String string) {
		signup_pg.enter_address(string);
		this.signup_address = string;
	}

	@When("I enter city as {string}")
	public void i_enter_city_as(String string) {
		signup_pg.enter_city(string);
		this.signup_city = string;
	}

	@And("I click on Signup button")
	public void i_click_on_signup_button() {
		reg_pg = signup_pg.signup_btn_click();

	}

	@Then("I should get the user successfully registered")
	public void i_should_get_the_user_successfully_registered() throws SQLException {

		boolean flag = false;
		Statement stmt = con.createStatement();
		String q = ("select count(*) as 'count_rec' from f_user where email ='" + this.signup_email + "' "
				+ "and name='" + this.signup_name + "' and address ='" + this.signup_address + "' and city ='"
				+ this.signup_city + "'");
		ResultSet rec = stmt.executeQuery(q);

		while (rec.next()) {
			if (rec.getInt("count_rec") == 1) {
				flag = true;
			} else {
				flag = false;
			}
		}
		Assert.assertTrue(reg_pg.reg_success_msg_chk() && flag);
	}
}
