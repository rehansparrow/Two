package testCase;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.BrowserType;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class TestIEandEdge {
	WebDriver driver;
	
@Parameters("browser")




	
	
	
		
	@Test(invocationCount = 3)
	public void golie(String browser) {
		
		if(browser.equalsIgnoreCase("IE")) {
		
System.setProperty("webdriver.ie.driver", "C:\\Users\\shaikh\\Desktop\\IEDriver\\IEDriverServer.exe");	
	  driver = new InternetExplorerDriver();
	 driver.get("https://kenmedics-staging.azurewebsites.net");
	  
		}
	 
		else if(browser.equalsIgnoreCase("edge")) {
	 System.setProperty("webdriver.edge.driver", "C:\\Users\\shaikh\\Desktop\\Edge Folder\\MicrosoftWebDriver.exe");
	  driver = new EdgeDriver();
	 driver.get("https://kenmedics-staging.azurewebsites.net");
		}
	
	 driver.manage().deleteAllCookies();
	 driver.close();
	 
	}
}