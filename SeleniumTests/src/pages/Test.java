package pages;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import locators.CommonLoctors;
import utitlities.ReadExcelFile;
import baseClass.*;

public class Test implements CommonLoctors{

	String TestResult = "PASS";
	
WebDriver driver;
	
	public Test(WebDriver driver) throws InterruptedException{
		
		 this.driver = driver;
		 
		 }
	
	public void testorder() throws InterruptedException,Exception{
		
		ReadExcelFile.setExcelFile("C:\\Users\\IT\\workspace\\SeleniumTests\\TestData\\Inputfile.xlsx","input");
		String TestSerialNu = ReadExcelFile.getCellData(7,1);
		String Testloc = ReadExcelFile.getCellData(7,2);
		String TestResult = ReadExcelFile.getCellData(7,3);
		String TestFail = ReadExcelFile.getCellData(7,4);
		driver.findElement(By.xpath(loc_Testoption)).click();
		Thread.sleep(2000);
		
		driver.findElement(By.xpath(loc_TestSerialNo)).sendKeys(TestSerialNu+"\n");
		
		WebElement testloc = driver.findElement(By.xpath(loc_TestLocation));
		testloc.sendKeys(Testloc);
		Thread.sleep(6000);
		testloc.sendKeys(Keys.DOWN);
		testloc.sendKeys(Keys.TAB);
		driver.findElement(By.xpath(loc_TestLocSubmit)).click();
		Thread.sleep(6000);

		if(!TestResult.equalsIgnoreCase("PASS")){
			
			driver.findElement(By.xpath(loc_TestFail)).click();
		
			WebElement testfailcode = driver.findElement(By.xpath(loc_TestFailcode));
			testfailcode.sendKeys(TestFail);
			Thread.sleep(3000);

			DriverHelper.pressKeyDown(testfailcode);
			DriverHelper.pressKeyEnter(testfailcode);
			/*Actions actions = new Actions(driver);
			actions.moveToElement(testfailcode);
			actions.click();
			actions.sendKeys("Accelerometer Test 2");
			Thread.sleep(2000);
			actions.sendKeys(Keys.ARROW_DOWN);
			actions.sendKeys(Keys.ENTER);
			actions.build().perform();*/
			
			
			
			
			Thread.sleep(6000);
			

			driver.findElement(By.xpath(loc_AddFailCode)).click();
			Thread.sleep(2000);
			

			driver.findElement(By.xpath(loc_completeTesting)).click();
			
			WebElement testloc2 = driver.findElement(By.xpath(loc_Testlocation2));
			testloc2.sendKeys(Testloc);
			Thread.sleep(6000);
			//testloc2.sendKeys(Keys.DOWN);
			//testloc2.sendKeys(Keys.TAB);
			WebElement testfinalsubmit = driver.findElement(By.xpath(loc_TestLocSubmit2));
			
		//	driver.findElement(By.xpath(loc_TestLocSubmit)).click();

			
System.out.println(testfinalsubmit.getText());
			Actions actions = new Actions(driver);
			actions.moveToElement(testfinalsubmit);
			actions.click();
			actions.build().perform();
		}

		else {
			
			driver.findElement(By.xpath(loc_TestPass)).click();

			driver.findElement(By.xpath(loc_completeTesting)).click();
			
			WebElement testloc3 = driver.findElement(By.xpath(loc_Testlocation3));
			testloc3.sendKeys(Testloc);
			Thread.sleep(6000);
			//testloc2.sendKeys(Keys.DOWN);
			//testloc2.sendKeys(Keys.TAB);
			WebElement testfinalPasssubmit = driver.findElement(By.xpath(loc_TestLocSubmit3));
			Actions actions = new Actions(driver);
			actions.moveToElement(testfinalPasssubmit);
			actions.click();
			actions.build().perform();
		}
		
		
	}
}
