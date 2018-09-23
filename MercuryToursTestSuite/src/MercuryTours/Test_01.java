package MercuryTours;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;
import org.testng.annotations.Test;

public class Test_01 {

	public String driverPath = "E:\\Software\\QA_Practice\\WebBrowserDriverTool\\chromedriver.exe";
	public String baseUrl = "http://www.demoaut.com";
	
	//Elemnets in the page
	public String linkRegister = "REGISTER";
	public String title;
	public String titleExpected = "Register: Mercury Tours";
	public String submitButton = "register";
	public String txtEmail = "email";
	public String txtPassword = "password";
	public String txtConfirmPassword = "confirmPassword";
	public String confirmMsg = "Thank you for registering. You may now sign-in using the user name and password you've just entered.";
	
	WebDriver driver;
	
	@BeforeSuite
	public void setupWebDriver() {
		System.setProperty("webdriver.chrome.driver",driverPath);
		driver = new ChromeDriver();
		driver.get(baseUrl);

	}

	// This is for check the link
	@Test
	public void clickRegistration() {
		//System.out.println("Click Registration Method");
		driver.findElement(By.linkText(linkRegister)).click();
		title = driver.getTitle().toString();
		assertEquals(title, titleExpected);
		
		Assert.assertTrue(driver.findElement(By.name(submitButton)).isDisplayed());
	}

	@Test(dependsOnMethods = {"clickRegistration"})
	public void UserRegistration() {
		//System.out.println("Click User Registration Method");
		driver.findElement(By.name(txtEmail)).sendKeys("tstUser");
		driver.findElement(By.name(txtPassword)).sendKeys("123456");
		driver.findElement(By.name(txtConfirmPassword)).sendKeys("123456");
		driver.findElement(By.name(submitButton)).click();

		System.out.println("--------------Xpath Output-------------");
		String xpath = driver.findElement(By.xpath("/html/body/div/table/tbody/tr/td[2]/table/tbody/tr[4]/td/table/tbody/tr/td[2]/table/tbody/tr[3]/td/p[2]/font")).getText();
		//System.out.println(xpath);
		
		assertEquals(xpath, confirmMsg);
	}

	@AfterSuite
	public void cleanUp() {
		driver.quit();
	}
}
