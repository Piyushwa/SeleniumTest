package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import locators.CommonLoctors;
import utitlities.Logs;
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
	String BranchName = ReadExcelFile.getCellData(31,2);
	String BranchAdd = ReadExcelFile.getCellData(31,3);
	String Branchcity = ReadExcelFile.getCellData(31,5);
	String BranchState = ReadExcelFile.getCellData(31,6);
	String BranchZip = ReadExcelFile.getCellData(31,7);
	String BranchCountry = ReadExcelFile.getCellData(31,8);
	String BranchContact = ReadExcelFile.getCellData(31,10);
	String BranchContactno = ReadExcelFile.getCellData(31,11);
	String BranchContactemail = ReadExcelFile.getCellData(31,12);

	String TimeZone = ReadExcelFile.getCellData(31,9);

	
	driver.findElement(By.xpath(loc_Settings)).click();
	
	Thread.sleep(3000);

	driver.findElement(By.xpath(loc_CreateBranch)).click();
	
	Thread.sleep(3000);

	  Logs.take_logs("Branch Master", "New Branch Create");	   	

	driver.findElement(By.xpath(loc_CreateBranchButton)).click();
	
	Thread.sleep(3000);
	
	driver.findElement(By.xpath(loc_BranchRegion)).click();
	Thread.sleep(3000);

	String loc_Region = "//*[@id='locationRegion']/div/div[4]/div/ul/li/span[contains(text(),'"+Region+"')]";
 driver.findElement(By.xpath(loc_Region)).click();;
	
	
	//driver.findElement(By.xpath(loc_Region)).click();
	
	Thread.sleep(3000);

	driver.findElement(By.xpath(loc_BranchName)).sendKeys(BranchName);
	driver.findElement(By.xpath(loc_BranchAddress)).sendKeys(BranchAdd);
	driver.findElement(By.xpath(loc_BranchCity)).sendKeys(Branchcity);	
	driver.findElement(By.xpath(loc_BranchState)).sendKeys(BranchState);	
	driver.findElement(By.xpath(loc_BarnchZip)).sendKeys(BranchZip);	
	driver.findElement(By.xpath(loc_BranchCountry)).sendKeys(BranchCountry);
	
	
	Thread.sleep(3000);

	WebElement Timezone = driver.findElement(By.xpath(loc_BranchTimeZone));
	
	Timezone.sendKeys("India Standard Time");	
	
	
	Thread.sleep(6000);
	Timezone.sendKeys(Keys.DOWN);
	Timezone.sendKeys(Keys.ENTER);
	

	driver.findElement(By.xpath(loc_BranchContact)).sendKeys(BranchContact);
	driver.findElement(By.xpath(loc_BranchContactPhone)).sendKeys(BranchContactno);
	driver.findElement(By.xpath(loc_BranchEmail)).sendKeys(BranchContactemail);

	Thread.sleep(3000);

	driver.findElement(By.xpath(loc_Createlocbutton)).click();

	Thread.sleep(3000);
	  Logs.take_logs("Branch Master", "New Branch Created");	   	


}
	
}