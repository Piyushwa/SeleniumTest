package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import locators.CommonLoctors;

public class CreatePart implements CommonLoctors {
	
WebDriver driver;

	
	public CreatePart(WebDriver driver) throws InterruptedException{
		
		 this.driver = driver;
		 
		 }
	
	public void CreatePartMaster() throws InterruptedException,Exception{
		
		String Avlbmapvalue = "Test1234";
		driver.findElement(By.xpath(loc_Settings)).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath(loc_CreateParts)).click();
		
		Thread.sleep(6000);
		driver.findElement(By.xpath(loc_CreatePartsButton)).click();
		
		Thread.sleep(2000);
		driver.findElement(By.xpath(loc_Partsname)).sendKeys("TestPart192");
		
		driver.findElement(By.xpath(loc_PartsDescription)).sendKeys("TestNotes");
		Thread.sleep(6000);
	WebElement Family = 	driver.findElement(By.xpath(loc_Partfamily));
	Family.sendKeys("1300");
		Thread.sleep(6000);
		Family.sendKeys(Keys.DOWN);
		Family.sendKeys(Keys.ENTER);
	WebElement Type = 	driver.findElement(By.xpath(loc_PartType));
	Type.sendKeys("A");
	Thread.sleep(6000);
	Type.sendKeys(Keys.DOWN);
	Type.sendKeys(Keys.ENTER);

	Thread.sleep(2000);
	
	
	WebElement Origin = driver.findElement(By.xpath(loc_PartOrigin));
	
	Actions action =new Actions(driver);
	action.moveToElement(Origin);
action.build().perform();
	Origin.sendKeys("1090");
	Thread.sleep(6000);
	Origin.sendKeys(Keys.DOWN);
	Origin.sendKeys(Keys.ENTER);
		
	driver.findElement(By.xpath(loc_AvailableMapvalue)).sendKeys(Avlbmapvalue);
	Thread.sleep(2000);
	String loc_AvlMapopt = "//span[contains(text(),'"+Avlbmapvalue+"')]";
	driver.findElement(By.xpath(loc_AvlMapopt)).click();
		
	Thread.sleep(2000);
	driver.findElement(By.xpath(loc_throwtoMapped)).click();
	Thread.sleep(6000);
	driver.findElement(By.xpath(loc_CreatePartSubmit)).click();
	
	Thread.sleep(3000);
	
	String Validation = driver.findElement(By.xpath(loc_ValidationMessage)).getText();
	
	if(Validation.contains("already")){
		
		System.out.println(Validation);
	}
	
	else{
	driver.findElement(By.xpath(loc_Partfilter)).sendKeys("TestPart123");
	
	driver.findElement(By.xpath(loc_filterApply)).click();
	}
	}
}
