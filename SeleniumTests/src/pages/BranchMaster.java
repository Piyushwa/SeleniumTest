package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import locators.CommonLoctors;
import utitlities.ReadExcelFile;

public class BranchMaster implements CommonLoctors {

	
	static String filepath = System.getProperty("user.dir") +"\\TestData\\Inputfile.xlsx";

	WebDriver driver;


public BranchMaster(WebDriver driver) throws InterruptedException{
	
	 this.driver = driver;
	 
	 }


public void CreateBranch() throws InterruptedException,Exception{
	

	ReadExcelFile.setExcelFile(filepath,"input");
	
	String Region = ReadExcelFile.getCellData(31,1);
	String TimeZone = ReadExcelFile.getCellData(31,9);

	
	driver.findElement(By.xpath(loc_Settings)).click();
	
	Thread.sleep(3000);

	driver.findElement(By.xpath(loc_CreateBranch)).click();
	
	Thread.sleep(3000);

	
	driver.findElement(By.xpath(loc_CreateBranchButton)).click();
	
	Thread.sleep(3000);
	
	driver.findElement(By.xpath(loc_BranchRegion)).click();
	Thread.sleep(3000);

	String loc_Region = "//*[@id='locationRegion']/div/div[4]/div/ul/li/span[contains(text(),'"+Region+"')]";
 driver.findElement(By.xpath(loc_Region)).click();;
	
	
	//driver.findElement(By.xpath(loc_Region)).click();
	
	Thread.sleep(3000);

	driver.findElement(By.xpath(loc_BranchName)).sendKeys("TestBranch");
	driver.findElement(By.xpath(loc_BranchAddress)).sendKeys("TestAdd");
	driver.findElement(By.xpath(loc_BranchCity)).sendKeys("TestCity");	
	driver.findElement(By.xpath(loc_BranchState)).sendKeys("TestState");	
	driver.findElement(By.xpath(loc_BarnchZip)).sendKeys("TestZip");	
	driver.findElement(By.xpath(loc_BranchCountry)).sendKeys("TestCountry");
	
	
	Thread.sleep(3000);

	WebElement Timezone = driver.findElement(By.xpath(loc_BranchTimeZone));
	
	Timezone.sendKeys("India Standard Time");	
	
	
	Thread.sleep(6000);
	Timezone.sendKeys(Keys.DOWN);
	Timezone.sendKeys(Keys.ENTER);
	

	driver.findElement(By.xpath(loc_BranchContact)).sendKeys("TestUser");
	driver.findElement(By.xpath(loc_BranchContactPhone)).sendKeys("9999999999");
	driver.findElement(By.xpath(loc_BranchEmail)).sendKeys("Test@ctdi.com");

	Thread.sleep(3000);

	driver.findElement(By.xpath(loc_Createlocbutton)).click();

	Thread.sleep(3000);


}
	
}