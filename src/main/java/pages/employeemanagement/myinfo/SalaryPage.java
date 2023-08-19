package pages.employeemanagement.myinfo;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.ControlActions;

public class SalaryPage extends ControlActions{
	
	@FindBy(css = "div.summary-cards-container>div:first-child>div:last-child")
	WebElement empCTCInfoElement;
	
	public SalaryPage() {
		PageFactory.initElements(driver,this);
	}
	
	public double getCTCValue() {
		 String empCTCInfo = getElementText(empCTCInfoElement, true);
		 empCTCInfo = empCTCInfo.substring(1).replace(",", "");
		 return Double.parseDouble(empCTCInfo);
	}
}
