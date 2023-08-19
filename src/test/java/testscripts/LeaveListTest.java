package testscripts;


import org.testng.Assert;
import org.testng.annotations.Test;

import pages.DashboardPage;
import pages.leave.LeaveListPage;
import pages.leave.LeaveListPage.DateType;
import pages.leave.LeaveListPage.LeaveBtnOptions;
import pages.leave.LeaveListPage.Month;

public class LeaveListTest extends TestBase{
	
	@Test
	public void verifyLeaveList() {
		DashboardPage dashboardPage = new DashboardPage();
		dashboardPage.waitUntilDashboardPageIsLoaded();
		
		System.out.println("STEP - Navigate to Leave Page");
		dashboardPage.clickOnDashboardLeftMenu("Leave");
		
		System.out.println("STEP - Selected To, From Date and Click on Search");
		LeaveListPage leaveListPage = new LeaveListPage();
		try {
			leaveListPage
			    .waitForPageLoad() 
				.setDate(Month.JANUARY, "2022", "1",DateType.FROM)
				.setDate(Month.MARCH, "2023", "31",DateType.TO)
				.clickOnBtn(LeaveBtnOptions.SEARCH);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("STEP - Get Row count of Search result");
		int actualRowCount = leaveListPage.getRowCountInSearchResultTable();
		
		System.out.println("VERIFY - Search result should be equal to expected value"+actualRowCount);
		Assert.assertEquals(actualRowCount, 3);
	}
}
