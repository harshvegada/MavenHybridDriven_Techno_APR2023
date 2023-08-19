package testscripts;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import base.ControlActions;
import constant.ConstantPath;
import okhttp3.internal.platform.ConscryptPlatform;
import pages.DashboardPage;
import pages.LoginPage;
import utlity.ExcelOperations;

public class LoginTest {
	
	@BeforeMethod
	public void setUp() {
		System.out.println("STEP - Launch Browser");
		ControlActions.start();
	}
	
	@Test
	public void verifyLogin() {
		System.out.println("VERIFY - Logo is displayed on Login Page");
		LoginPage loginPage = new LoginPage();
		boolean isLogoDisplayedFlag = loginPage.isLogoDisplayed();
		Assert.assertTrue(isLogoDisplayedFlag);
		
		System.out.println("STEP - Login with given credentials");
		loginPage.doLogin("Admin", "yW3kfVH9J@");
		
		DashboardPage dashboardPage = new DashboardPage();
		boolean isHeaderVisible = dashboardPage.isEmployeeManagementHeaderDisplayed();
		Assert.assertTrue(isHeaderVisible);
	}
	
	@Test
	public void verifyLoginWithInvalidCredentials() {
		System.out.println("VERIFY - Logo is displayed on Login Page");
		LoginPage loginPage = new LoginPage();
		boolean isLogoDisplayedFlag = loginPage.isLogoDisplayed();
		Assert.assertTrue(isLogoDisplayedFlag);
		
		System.out.println("STEP - Login with given credentials");
		loginPage.doLogin("Admin", "yW3kfVH9J@123");
		
		boolean unsuccessfulLoginFlag = loginPage.isInvalidToastMessageIsDisplayed();
		Assert.assertTrue(unsuccessfulLoginFlag);
		
		String currentURL = loginPage.getCurrentURL();
		Assert.assertTrue(currentURL.endsWith("retryLogin"));
	}
	
	@Test(dataProvider = "loginDataProvider")
	public void verfiyLoginWithDataProvider(String username, String password, String result) {
		
		System.out.println("VERIFY - Logo is displayed on Login Page");
		LoginPage loginPage = new LoginPage();
		boolean isLogoDisplayedFlag = loginPage.isLogoDisplayed();
		Assert.assertTrue(isLogoDisplayedFlag);
		
		System.out.println("STEP - Login with given credentials");
		loginPage.doLogin(username, password);
		
		if(result.equalsIgnoreCase("valid")) {
			DashboardPage dashboardPage = new DashboardPage();
			boolean isHeaderVisible = dashboardPage.isEmployeeManagementHeaderDisplayed();
			Assert.assertTrue(isHeaderVisible);
		}else {
			boolean unsuccessfulLoginFlag = loginPage.isInvalidToastMessageIsDisplayed();
			Assert.assertTrue(unsuccessfulLoginFlag);
			
			String currentURL = loginPage.getCurrentURL();
			Assert.assertTrue(currentURL.endsWith("retryLogin"));
		}
	}
	
	@DataProvider
	public Object[][] loginDataProvider() throws IOException{
		String filePath = ConstantPath.LOGIN_DATA_FILEPATH;
		String sheetName = ConstantPath.LOGIN_SHEET_NAME;
		return ExcelOperations.getSheetAllRows(filePath,sheetName);
	}
	
	@AfterMethod
	public void tearDown() {
		ControlActions.closeBrowser();
	}
}
