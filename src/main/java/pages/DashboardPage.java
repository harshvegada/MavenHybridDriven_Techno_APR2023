package pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.ControlActions;
import io.qameta.allure.Step;

public class DashboardPage extends ControlActions{
	
	By byWidgets = By.xpath("//div[@id='widget.id'  and not(contains(@class,'ng-hide'))]");
	
	@FindBy(xpath = "//div[text()='Employee Management']")
	WebElement employeeManagentHeaderElement;
	
	@FindBy(xpath = "//div[@id='widget.id'  and not(contains(@class,'ng-hide'))]")
	List<WebElement> listOfWidgets;
	
	@FindBy(xpath = "//div[@id='widget.id' and not(contains(@class,'ng-hide'))]//div[@class='widget-header']/span[2]")
	List<WebElement> listOfWidgetsTextElement;
	
	@FindBy(css = "div#sidebar-profile-picture")
	WebElement profilePictureElement;
	
	@FindBy(css = "div.image-container>a>i")
	WebElement settingBtn;
	
	@FindBy(css = "div.opened>div>div")
	List<WebElement> userMenuList;
	
	@FindBy(css = "div#displayAboutLoadMask")
	WebElement loaderElement;
	
	@FindBy(css = "div#companyInfo>div>div:nth-child(3)>p")
	WebElement employeeCountElement;
	
	@FindBy(css = "a#aboutDisplayLink")
	WebElement aboutLinkElement;
	
	@FindBy(css = "div.modal-footer>a#heartbeatSubmitBtn")
	WebElement submitBtn;
	
	@FindBy(css = "a[class='name']")
	WebElement profileNameElement;
	
	public DashboardPage() {
		PageFactory.initElements(driver, this);
	}
	
	
	@Step("Getting total widget count")
	public int getTotalVisibleWidgets() {
		return listOfWidgets.size();
	}
	
	public void waitUntilDashboardPageIsLoaded() {
		waitForElementToBeVisible(employeeManagentHeaderElement);
	}
	
	public void waitUntilWidgetsAreLoaded() {
		waitUntilElementsToBeMoreThan(byWidgets,1);
	}
	
	public List<String> getAllWidgetsName(){
		//return getListOfElementText("//div[@id='widget.id' and not(contains(@class,'ng-hide'))]//div[@class='widget-header']/span[2]");
		return getListOfElementText(listOfWidgetsTextElement); 
	}
	
	public boolean isEmployeeManagementHeaderDisplayed() {
		return isElementDisplayed(employeeManagentHeaderElement, true);
	}
	
	public boolean isUserProfileDisplayed() {
		return isElementDisplayed(profilePictureElement, true);
	}
	
	public void mouseHoverOnUserProfile() {
		mouseHover(profilePictureElement,false);
	}
	
	public void clickOnSettingButton() {
		clickOnElement(settingBtn,true);
	}
	
	public int getUserMenuListSize(){
		return userMenuList.size();
	}
	
	public void waitForInvisibilityOfLoader() {
		//wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("div#displayAboutLoadMask")));
		waitForInvisibilyOfElement(loaderElement);
	}
	
	@Step("Getting Employee Count")
	public int getEmployeeCount() {
		waitUntilTextToBePresent(employeeCountElement, "Employees:");
		String empCountInfo = getElementText(employeeCountElement, false);
		String[] empCountInfoArr = empCountInfo.split(" ");
		int actualEmpCount = Integer.parseInt(empCountInfoArr[1]);
		return actualEmpCount;
	}
	
	@Step("Clikc on User Menu Abount Link")
	public void clickOnUserMenuAboutLink() {
		clickOnElement(aboutLinkElement, false);
	}
	
	@Step("Clicked on OK button")
	public void clickOnOkButton() {
		clickOnElement(submitBtn, false);
	}
	
	@Step("Click on Dashbord left menu")
	public Navigations clickOnDashboardLeftMenu(String menuText) {
		getElement("XPATH", "(//span[contains(text(),'"+menuText+"')]/parent::a)[1]", true).click();
		return new Navigations();
	}
	
	public String getProfileName() {
		return getElementText(profileNameElement, false);
	}
	
}
