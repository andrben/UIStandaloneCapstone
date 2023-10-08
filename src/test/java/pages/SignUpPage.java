package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SignUpPage {

	WebDriver driver;

	public SignUpPage(WebDriver driver) {
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

	@FindBy(name = "pwd2")
	WebElement confirm_pwd_field;

	@FindBy(name = "name")
	WebElement name_field;

	@FindBy(name = "address")
	WebElement address_field;

	@FindBy(name = "city")
	WebElement city_field;
	
	@FindBy(xpath = "//button[text()='Signup']")
	WebElement signup_btn;

	public void send_keys(WebElement element, String text) {
		element.sendKeys(text);
	}
	
	public void enter_email(String text) {
		usr_nm_field.sendKeys(text);
	}
	
	public void enter_pwd(String text) {
		pwd_field.sendKeys(text);
	}
	
	public void enter_pwd2(String text) {
		confirm_pwd_field.sendKeys(text);
	}
	
	public void enter_name(String text) {
		name_field.sendKeys(text);
	}
	
	public void enter_address(String text) {
		address_field.sendKeys(text);
	}
	
	public void enter_city(String text) {
		city_field.sendKeys(text);
	}
	
	public RegistrationConfirm signup_btn_click() {
		signup_btn.click();
		return new RegistrationConfirm(driver);
	}
	
}
