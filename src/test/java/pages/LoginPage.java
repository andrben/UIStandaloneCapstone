package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

	WebDriver driver;

	public LoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	@FindBy(linkText = "Home")
	WebElement hm_lnk;

	@FindBy(linkText = "Login/Signup")
	WebElement login_sgnup_lnk;

	@FindBy(name = "email_id")
	WebElement usr_nm_field;

	@FindBy(name = "pwd")
	WebElement pwd_field;

	@FindBy(xpath = "//button[text()='Login']")
	WebElement login_btn;

	@FindBy(linkText = "Not a member? Signup")
	WebElement signup_lnk;

	public SignUpPage click_on_signup() {
		signup_lnk.click();
		return new SignUpPage(driver);
	}

	public void enter_email(String string) {
		usr_nm_field.sendKeys(string);
	}

	public void enter_password(String string) {
		pwd_field.sendKeys(string);
	}

	public DashboardPage login_click() {
		login_btn.click();
		return new DashboardPage(driver);
	}
}
