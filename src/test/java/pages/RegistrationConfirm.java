package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RegistrationConfirm {
	WebDriver driver;
	private String reg_success_msg = "Your registration is confirmed.";

	public RegistrationConfirm(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(linkText = "Home")
	WebElement hm_lnk;

	@FindBy(linkText = "Login/Signup")
	WebElement login_sgnup_lnk;

	@FindBy(linkText = "Login to continue checking flights")
	WebElement login_lnk;

	
	public LoginPage login_signup() {
		login_lnk.click();
		return new LoginPage(driver);
	}
	
	
	
	public boolean reg_success_msg_chk() {
		return driver.getPageSource().contains(reg_success_msg);
	}

}
