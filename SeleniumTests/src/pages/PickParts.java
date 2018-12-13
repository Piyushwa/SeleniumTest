package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.sun.webkit.Utilities;

import locators.CommonLoctors;
import utitlities.ReadExcelFile;

public class PickParts implements CommonLoctors {
	
	
	WebDriver driver;
	
	
	public PickParts(WebDriver driver) throws InterruptedException{
		
		 this.driver = driver;
		 
		 }


	public void pickparts() throws Exception,InterruptedException{
		
		ReadExcelFile.setExcelFile("C:\\Users\\IT\\workspace\\SeleniumTests\\TestData\\Inputfile.xlsx","input");
		
		String ScanPartVal = ReadExcelFile.getCellData(23,1);
		String ScanlocVal = ReadExcelFile.getCellData(23,2);
		
		String CompOrder = utitlities.DatabaseConnectivity.Dbconn("select 'NUMBER' from COMPONENTORDERS Where 'ASSETID' IN ( select 'ID' from ASSETS  where ASSETTAG = 'HW002201')","BBADMIN","BBADMIN");
		
	System.out.println(CompOrder);
		
		driver.findElement(By.xpath(loc_Pickpartsoptions)).click();
		
		Thread.sleep(3000);
		
		driver.findElement(By.xpath(loc_pickorders)).click();
		Thread.sleep(1000);
		String loc_CompOrderval = "//span[contains(text(),'"+CompOrder+"')]";
		Thread.sleep(2000);
		driver.findElement(By.xpath(loc_CompOrderval)).click();
			
		driver.findElement(By.xpath(loc_scanPart)).sendKeys(ScanPartVal+"\n");
		
		driver.findElement(By.xpath(loc_scanloc)).sendKeys(ScanlocVal+"\n");
		
		driver.findElement(By.xpath(loc_PartpickSubmit)).click();
		
		String Message = driver.findElement(By.xpath(loc_ValidationMessage)).getText();

		System.out.println(Message);
		
		

	}
}
