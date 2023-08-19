package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.ControlActions;
import io.qameta.allure.Step;

public class LoginPage extends ControlActions {

	private static LoginPage loginPage;

	@FindBy(css = "div#divLogin>div>img")
	WebElement logoElement;

	@FindBy(css = "input#txtUsername")
	WebElement userNameElement;

	@FindBy(css = "input#txtPassword")
	WebElement passwordElement;

	@FindBy(css = "button[type='submit']")
	WebElement submitBtn;

	@FindBy(xpath = "//div[contains(text(),'Invalid Credentials')]")
	WebElement invalidToastMessageElement;

	public LoginPage() {
		PageFactory.initElements(driver, this);
	}

	public boolean isLogoDisplayed() {
		return isElementDisplayed(logoElement, false);
	}

	@Step("User login through {0}")
	public void doLogin(String uname, String password) {
		setText(uname, userNameElement, false);
		setText(password, passwordElement, false);
		clickOnElement(submitBtn, false);
	}

	public boolean isInvalidToastMessageIsDisplayed() {
		return isElementDisplayed(invalidToastMessageElement, true);
	}

	public String getCurrentURL() {
		return super.getCurrentURL();
	}
}
