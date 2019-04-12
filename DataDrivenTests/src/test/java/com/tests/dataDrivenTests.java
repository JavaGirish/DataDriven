package com.tests;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.test.utility.TestUtil;

public class dataDrivenTests {

	WebDriver driver;

	@BeforeMethod
	public void setUp() {
		System.setProperty("webdriver.chrome.driver", "C:\\Automation\\Drivers\\chromedriver_win32\\chromedriver.exe");
		driver = new ChromeDriver();

		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(25, TimeUnit.SECONDS);
		driver.get("https://www.onlineservices.nsdl.com/paam/endUserRegisterContact.html");

	}

	@DataProvider
	public Iterator<Object[]> getData() {
		ArrayList<Object[]> data = TestUtil.getDataFromExcel();
		return data.iterator();

	}

	@Test(dataProvider = "getData")
	public void panDataTests(String firstName, String lastName, String middleName, String mobile, String appType,
			String category) throws InterruptedException {

		Select s1 = new Select(driver.findElement(By.xpath("//select[@id='type']")));
		s1.selectByVisibleText(appType);

		Select s2 = new Select(driver.findElement(By.xpath("//select[@id='cat_applicant1']")));
		s2.selectByVisibleText(category);
		Thread.sleep(3000);
		
		driver.findElement(By.xpath("//span[@id='select2-rvNameInitials-container']")).click();
		driver.findElement(By.xpath("//li[text()='Shri']")).click();

		
		driver.findElement(By.id("l_name_end")).sendKeys(lastName);
		driver.findElement(By.id("f_name_end")).sendKeys(firstName);

		driver.findElement(By.id("m_name_end")).sendKeys(middleName);
		driver.findElement(By.id("rvContactNo")).sendKeys(mobile);

	}

	@AfterMethod
	public void tearDown() {
		//driver.quit();

	}

}
