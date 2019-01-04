package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import locators.CommonLoctors;

public class BinsMaster implements CommonLoctors {
	
	static String filepath = System.getProperty("user.dir") +"\\TestData\\Inputfile.xlsx";

	WebDriver driver;
	

public BinsMaster(WebDriver driver) throws InterruptedException{
	
	 this.driver = driver;
	 
	 }

public void CreateNewBin() throws InterruptedException,Exception{
	
	
	driver.findElement(By.xpath(loc_Settings)).click();
	
	Thread.sleep(3000);
			
	driver.findElement(By.xpath(loc_BinsMaster)).click();
		
	Thread.sleep(3000);

	driver.findElement(By.xpath(loc_CreateBinsButton)).click();
		
	Thread.sleep(3000);
		
	
	driver.findElement(By.xpath(loc_CreateBinsName)).sendKeys("Test");

	driver.findElement(By.xpath(loc_CreateBinsDescription)).sendKeys("User");

	driver.findElement(By.xpath(loc_CreateBinsType)).sendKeys("Tuser");

	driver.findElement(By.xpath(loc_CreateBinlocation)).sendKeys("Tuser@gmail.com");
	
	driver.findElement(By.xpath(loc_CreateCapicity)).sendKeys("Tuser@gmail.com");
	
}

}
