package pages.leave;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.ControlActions;

public class LeaveListPage extends ControlActions {
	
	@FindBy(xpath="(//i[text()='date_range'])[1]")
	private WebElement fromCalanderIcon;
	
	@FindBy(xpath="(//i[text()='date_range'])[2]")
	private WebElement toCalanderIcon;
	
	@FindBy(xpath = "(//div[contains(@class,'--month')]/input)[1]")
	private WebElement monthDropdownFromElement;
	
	@FindBy(xpath = "(//div[contains(@class,'--month')]/input)[2]")
	private WebElement monthDropdownToElement;
	
	@FindBy(xpath = "(//div[contains(@class,'--year')]/input)[1]")
	private WebElement fromYearElement;
	
	@FindBy(xpath = "(//div[contains(@class,'--year')]/input)[2]")
	private WebElement toYearElement;
	
	@FindBy(css = "div#viewLeaveEntitlement table>tbody>tr")
	private List<WebElement> listOfRows; 
	
	@FindBy(css = "label[for='from']")
	private WebElement fromLabelElement;
	
	
	public LeaveListPage() {
		PageFactory.initElements(driver, this);
	}

	private void setMonthFrom(String month) {
		String currentSelectedMonth = getInputElementText(monthDropdownFromElement);
		if(!month.equalsIgnoreCase(currentSelectedMonth)) {
			clickOnElement(monthDropdownFromElement, false);
			clickOnElement("XPATH", "//ul[contains(@class,'active')]/li/span[text()='"+month+"']", true);
		}
	}
	
	private void setMonthTo(String month) {
		String currentSelectedMonth = getInputElementText(monthDropdownToElement);
		if(!month.equalsIgnoreCase(currentSelectedMonth)) {
			clickOnElement(monthDropdownToElement, false);
			clickOnElement("XPATH", "//ul[contains(@class,'active')]/li/span[text()='"+month+"']", true);
		}
	}
	
	private void setFromYear(String year) {
		String currentSelectedYear = getInputElementText(fromYearElement);
		if(!year.equalsIgnoreCase(currentSelectedYear)) {
			clickOnElement(fromYearElement, true);
			clickOnElement("XPATH", "//ul[contains(@class,'active')]/li/span[text()='"+year+"']", true);
		}
	}
	
	private void setToYear(String year) {
		String currentSelectedYear = getInputElementText(toYearElement);
		if(!year.equalsIgnoreCase(currentSelectedYear)) {
			clickOnElement(toYearElement, true);
			clickOnElement("XPATH", "//ul[contains(@class,'active')]/li/span[text()='"+year+"']", true);
		}
	}
	
	private void setDate(String date) {
		String locator = "//div[@class='picker picker--focused picker--opened']//table//div[text()='"+date+"'][contains(@class,'infocus')]//parent::td";
		clickOnElement("XPATH", locator, true);
	}
	
	public enum Month {
	    JANUARY("January"),
	    FEBRUARY("February"),
	    MARCH("March");
	  
	  	public final String value;
	  	private Month(String temp){
	    	value = temp;
	    }
	}
	
	/*
	 * public LeaveListPage setFromDate(String month, String year, String date) {
	 * clickOnElement(fromCalanderIcon, true); setMonth(month); setYear(year);
	 * setDate(date); return this; }
	 * 
	 * public LeaveListPage setToDate(String month, String year, String date) {
	 * clickOnElement(toCalanderIcon, true); setMonth(month); setYear(year);
	 * setDate(date); return this; }
	 */
	
	public enum DateType{
		FROM,TO;
	}
	
	public LeaveListPage waitForPageLoad() {
		//waitForElementToBeVisible(toCalanderIcon);
		m1();
		return this;
	}
	
	public LeaveListPage setDate(Month month, String year, String date, DateType dateElement) throws InterruptedException {
		if(dateElement == DateType.TO) {
			//Thread.sleep(2000);
			clickOnElement(toCalanderIcon, true);
			setToYear(year);
			setMonthTo(month.value);
			
		}else if(dateElement == DateType.FROM) {
			//Thread.sleep(2000);
			clickOnElement(fromCalanderIcon, true);
			setFromYear(year);
			setMonthFrom(month.value);
		}
		setDate(date);
		return this;
	}
	
	public enum LeaveBtnOptions{
		RESET("Reset"),
		EXPORTSUMMARY("Export Summary"),
		EXPORTDETAILS("Export Detail"),
		SEARCH("Search"),
		SAVE("Save");
		
		public final String value;
		private LeaveBtnOptions(String option) {
			value = option;
		}
	}
	
	public void clickOnBtn(LeaveBtnOptions btnType) {
		String locator = "//button[text()='"+btnType.value+"'] | //a[text()='"+btnType.value+"']";
		clickOnElement("XPATH", locator, false);
	}
	
	public int getRowCountInSearchResultTable() {
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return listOfRows.size();
	}
}
