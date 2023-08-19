package testscripts;

import java.util.ArrayList;
import java.util.List;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.qameta.allure.Epic;
import io.qameta.allure.Story;
import pages.DashboardPage;

@Epic("Widgets Test Cases")
public class WidgetTest extends TestBase {

	@Test
	@Story("Verify Widget Dashboard")
	public void verifyWidgetsOnDashboard() {
		int totalExpectedWidgetCount = 13;
		System.out.println("STEP -Get displayed widges on Dashboard page");
		DashboardPage dashboardPage = new DashboardPage();
		dashboardPage.waitUntilWidgetsAreLoaded();
		int totalActualWidgetCount = dashboardPage.getTotalVisibleWidgets();
		System.out.println(totalActualWidgetCount);

		System.out.println("VERIFY - Total Widgets should be 13");
		Assert.assertEquals(totalActualWidgetCount, totalExpectedWidgetCount);

		System.out.println("STEP - Get Widget Names");
		List<String> actualList = dashboardPage.getAllWidgetsName();

		List<String> expectedList = new ArrayList<>();
		expectedList.add("Quick Access");
		expectedList.add("Buzz Latest Posts");
		expectedList.add("My Actions");
		expectedList.add("Latest Documents");
		expectedList.add("Latest News");
		expectedList.add("Employees on Leave Today");
		expectedList.add("Time At Work");
		expectedList.add("Headcount by Location");
		expectedList.add("COVID-19 Report");
		expectedList.add("Current Year's Leave Taken by Department");
		expectedList.add("Leave Taken on Each Calendar Month Over the Years");
		expectedList.add("Leave Scheduled in Each Month");
		expectedList.add("Leave Taken on Each Day of the Week Over Time");

		System.out.println("VERIFY - Expected and Actual WIdget list is same");
		Assert.assertEquals(actualList, expectedList, "Elements are different : " + actualList + "----" + expectedList);
	}

}
