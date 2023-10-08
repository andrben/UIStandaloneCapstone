package stepdefs;

import org.openqa.selenium.WebDriver;
import org.junit.Assert;
import io.cucumber.java.en.*;
import pages.HomePage;
import pages.LoginPage;
import pages.DashboardPage;

public class LoginSuccess {
	WebDriver driver = Hooks.driver;
	HomePage home_pg;
	LoginPage login_pg; //=new LoginPage(driver);
	DashboardPage login_success_pg; //=new LoginSuccessPage(driver);
	

	@When("I click on Login on the Home page")
	public void click_on_login() {
		home_pg = new HomePage(driver);
		login_pg = home_pg.login_signup();

	}
	
	@And("I enter email as {string} on the Login page")
	public void enter_email(String string) {
		login_pg.enter_email(string);
	}
	
	@And("I enter password as {string} on the Login page")
	public void enter_password(String string) {
		login_pg.enter_password(string);
	}

	@And("I click on Login button on the Login page")
	public void login_click() {
		login_success_pg=login_pg.login_click();
	}
	
	@Then("I should be able to login successfully")
	public void successful_login() {
		Assert.assertTrue(login_success_pg.h3_header_chk() && login_success_pg.confirm_login());   
	}
	
}
