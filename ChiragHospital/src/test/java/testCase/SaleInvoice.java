package testCase;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class SaleInvoice {
	WebDriver driver;
	
	@BeforeMethod
	public void setup() throws InterruptedException {
		
			System.setProperty("webdriver.chrome.driver", "C:/Users/shaikh/Desktop\\Chrome Driver\\chromedriver.exe");	
			 driver = new ChromeDriver();
			driver.manage().window().maximize();
			driver.manage().deleteAllCookies();
			driver.get("http://localhost:50399/UI/Template/frmLogin.aspx");
			//Thread.sleep(4000);
			driver.findElement(By.name("txtUserName_Valid")).sendKeys("Superadmin");
			driver.findElement(By.name("txtPassword_Valid")).sendKeys("password");
			driver.findElement(By.name("btnLogin")).click();
			
			driver.navigate().to("http://localhost:50399/UI/Pharmacy/frmSalesInvoice.aspx");
			Thread.sleep(2000);
			
			
						
	}
	@Test(invocationCount = 1000)
	public void createSaleInvoice() throws Exception {
		
		WebElement pateintType = driver.findElement(By.name("ctl00$HMSContentPlaceHolder$ddlBillmode"));
		Select ptdrvr = new Select(pateintType);
		ptdrvr.selectByValue("1");
		Thread.sleep(2000);
		WebElement pateintName = driver.findElement(By.name("ctl00$HMSContentPlaceHolder$ddlName"));
		Select pndrvr = new Select(pateintName);
		pndrvr.selectByValue("7671");
		Thread.sleep(2000);
		WebElement itemName = driver.findElement(By.name("ctl00$HMSContentPlaceHolder$ddlItemNm"));
		Select indrvr = new Select(itemName);
		indrvr.selectByValue("94");
		Thread.sleep(2000);
		
		WebElement batchCode = driver.findElement(By.name("ctl00$HMSContentPlaceHolder$ddlBatchCode"));
		
		Select bcdrvr = new Select(batchCode);
		bcdrvr.selectByValue("786");
		Thread.sleep(2000);
		
		driver.findElement(By.name("ctl00$HMSContentPlaceHolder$txtNos_Dec")).sendKeys("1");
		Thread.sleep(2000);
		
		driver.findElement(By.name("ctl00$HMSContentPlaceHolder$btnAdd")).click();
		Thread.sleep(1000);
		
		WebElement modeOfPayment = driver.findElement(By.name("ctl00$HMSContentPlaceHolder$ddlPayMode"));
		Select mopdrvr = new Select(modeOfPayment);
		mopdrvr.selectByValue("111");
		Thread.sleep(2000);
		
		driver.findElement(By.name("ctl00$HMSContentPlaceHolder$txtAmount_Num")).sendKeys("50");
		Thread.sleep(2000);
		
		JavascriptExecutor jdrvr = (JavascriptExecutor)driver;
		jdrvr.executeScript("scroll(0,400)");
		Thread.sleep(2000);
		
		driver.findElement(By.name("ctl00$HMSContentPlaceHolder$btnPaymentAdd")).click();
		Thread.sleep(3000);
		
	WebElement submitBtn =driver.findElement(By.xpath("//input[@type='submit' and @id = 'ctl00_HMSContentPlaceHolder_btnSubmit']"));
		submitBtn.click();
		
		
		
		
		
	
	}
	
	
	
	@AfterMethod
	public void tearDown() throws Exception {
		Thread.sleep(1000);
		driver.quit();
	}

}
