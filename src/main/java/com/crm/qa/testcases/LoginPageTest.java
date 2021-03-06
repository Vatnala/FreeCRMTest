package com.crm.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.util.ExtentReporterNG;
@Listeners(ExtentReporterNG.class)
public class LoginPageTest extends TestBase{
	LoginPage loginPage;
	HomePage homePage;
	public LoginPageTest()
	{
		super();
	}
	
	@BeforeMethod
	public void setUp()
	{
		initialization();
		 loginPage = new LoginPage();
	}
	
	@Test(priority=1, groups = "titletest")
	public void loginPageTitleTest()
	{
		String title = loginPage.validateLoginPageTitle();
		Assert.assertEquals(title, "Free CRM software in the cloud powers sales and customer service");
	}
	
	@Test(priority=2, groups = "imagetest")
	public void crmLogoImageTest()
	{
		boolean flag = loginPage.validateCRMImage();
		Assert.assertTrue(flag);
	}
	
	@Test(priority=3, groups = "logintest")
	public void loginTest()
	{
		homePage = loginPage.login("username", "pasword");
	}
	@AfterMethod
	public void tearDown()
	{
		driver.quit();
	}
}
