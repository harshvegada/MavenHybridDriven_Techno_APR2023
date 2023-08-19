package pages.employeemanagement.more.qualifications;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.ControlActions;

public class SkillPage extends ControlActions{

	@FindBy(css = "div.tooltipped>a.btn-large")
	private WebElement addIconElement;
	
	@FindBy(css = "input#name")
	private WebElement nameElement;
	
	@FindBy(css = "textarea#description")
	private WebElement descriptionTextAreaElement;
	
	@FindBy(css = "div.modal-footer>a.primary-btn")
	private WebElement saveBtn;
	
	public SkillPage() {
		PageFactory.initElements(driver, this);
	}
	
	public SkillPage clickOnAddIcon() {
		clickOnElement(addIconElement, true);
		return this;
	}
	
	public SkillPage enterName(String text) {
		setText(text, addIconElement, false);
		return this;
	}
	
	public SkillPage enterDescription(String descriptionText) {
		setText(descriptionText,descriptionTextAreaElement ,false);
		return this;
	}
	
	public SkillPage clickOnSaveButton() {
		clickOnElement(saveBtn, false);
		return this;
	}
	
	public boolean isSkillDisplayedByText(String skillText) {
		String locator = "//table[@class='highlight bordered']/tbody//span[text()='"+skillText+"']";
		return isElementDisplayed("XPATH", locator, true);
	}
}
