package pages.hradministration;

import java.util.List;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.ControlActions;

public class ManageUserRolesPage extends ControlActions{
	 
	@FindBy(css = "input.select-dropdown")
	WebElement paginationDropDown;
	
	@FindBy(css = "li[class='summary']")
	WebElement paginationSummary;
	
	@FindBy(css = "table.highlight>tbody>tr")
	List<WebElement> listOfAllRows;
	
	public ManageUserRolesPage() {
		PageFactory.initElements(driver, this);
	}
	
	public String getPaginationDefaultValue() {
		return paginationDropDown.getText();
	}
	
	public int getTotalTableRows() {
		return listOfAllRows.size();
	}
	
	public int getTotalRowsFromSummary() {
		String paginationText = getElementText(paginationSummary,false);
		String[] arr=paginationText.split("of");
		return Integer.parseInt(arr[1].trim());
	}
}
