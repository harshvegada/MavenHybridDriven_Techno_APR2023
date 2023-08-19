package pages.employeemanagement.myinfo;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.ControlActions;

public class PersonalDetailsPage extends ControlActions{
	
	@FindBy(css = "input#firstName")
	WebElement firstElement;
	
	@FindBy(css = "input#middleName")
	WebElement middleElement;
	
	@FindBy(css = "input#lastName")
	WebElement lastElement;
	
	@FindBy(css = "div#personal_details_tab>h4")
	WebElement personalDetailsHeaderElement;
	
	public PersonalDetailsPage() {
		PageFactory.initElements(driver, this);
	}
	
	public String getFirstName() {
		return getInputElementText(firstElement);
	}
	
	public String getMiddleName() {
		return getInputElementText(middleElement);
	}
	
	public String getLastName() {
		return getInputElementText(lastElement);
	}
	
	public boolean isPersonalDetailsHeaderDisplayed() {
		return isElementDisplayed(personalDetailsHeaderElement, true);
	}
}
