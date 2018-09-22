package testpackage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

public class Test_02 {
	
  public String baseUrl = "http://demoaut.com/";
  String driverpathC = "C:\\WebBrowserDriverTool\\chromedriver.exe";
  String driverpathF = "C:\\WebBrowserDriverTool\\geckodriver.exe";
  public WebDriver driverc;
  public WebDriver driverf;
  
  @Test
  public void setup() {
	  System.out.println("Launching Chrome Browser....");
	  System.setProperty("webdriver.chrome.driver",driverpathC );
	  
	  System.out.println("Launching FireFox Browser....");
	  System.setProperty("webdriver.firefox.driver",driverpathF );
	  
	  driverc = new ChromeDriver();
	  driverf = new FirefoxDriver();
	  
	  driverc.get(baseUrl);
	  driverf.get(baseUrl);
	  
  }
}
