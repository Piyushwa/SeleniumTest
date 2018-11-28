package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import baseClass.DriverHelper;
import locators.CommonLoctors;
import utitlities.ReadExcelFile;

public class PackageOrder implements CommonLoctors {
	
WebDriver driver;
	
	public PackageOrder(WebDriver driver) throws InterruptedException{
		
		 this.driver = driver;
		 
		 }
	public void Packorder() throws InterruptedException,Exception{
		
		ReadExcelFile.setExcelFile("C:\\Users\\IT\\workspace\\SeleniumTests\\TestData\\Inputfile.xlsx","input");
		String PackListNu = ReadExcelFile.getCellData(13,1);
		String PackRMAnu = ReadExcelFile.getCellData(13,2);
		String PackSerialnu = ReadExcelFile.getCellData(13,3);
		
		//utitlities.DatabaseConnectivity.Dbconn("BBADMIN", "BBADMIN");
		WebElement Pack =  driver.findElement(By.xpath(loc_PackOption));
		DriverHelper.clickusingjavaexceutor(Pack);
			Thread.sleep(3000);
			
			driver.findElement(By.xpath(loc_packlistno)).sendKeys(PackListNu);
driver.findElement(By.xpath(loc_CreatePaclist)).click();
Thread.sleep(3000);


		 
		 driver.findElement(By.xpath(loc_PackRMAno)).sendKeys(PackRMAnu + "\n");
		 
		 driver.findElement(By.xpath(loc_packSerialNu)).sendKeys(PackSerialnu+ "\n");
		 Thread.sleep(3000);
		 driver.findElement(By.xpath(loc_packaddinfo)).click();
		 Thread.sleep(3000);
		 
		 driver.findElement(By.xpath(loc_Completepack)).click();
		// String Message  = driver.findElement(By.xpath(loc_ValidationMessage)).getText();
		 
		 //System.out.println(Message);
		 
		 
		
	}
	

}