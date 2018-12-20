package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import baseClass.DriverHelper;
import locators.CommonLoctors;
import utitlities.Logs;
import utitlities.ReadExcelFile;

public class PackageOrder implements CommonLoctors {
	
WebDriver driver;

static String filepath = System.getProperty("user.dir") +"\\TestData\\Inputfile.xlsx";
	
	public PackageOrder(WebDriver driver) throws InterruptedException{
		
		 this.driver = driver;
		 
		 }
	public void Packorder() throws InterruptedException,Exception{
		
		ReadExcelFile.setExcelFile(filepath,"input");
		String PackListNu = ReadExcelFile.getCellData(13,1);
		String PackRMAnu = ReadExcelFile.getCellData(13,2);
		String PackSerialnu = ReadExcelFile.getCellData(13,3);
		
		Logs.take_logs("Pack order","Order Packaging Start");
		WebElement Pack =  driver.findElement(By.xpath(loc_PackOption));
		DriverHelper.clickusingjavaexceutor(Pack);
			Thread.sleep(3000);
			
			driver.findElement(By.xpath(loc_packlistno)).sendKeys(PackListNu);
driver.findElement(By.xpath(loc_CreatePaclist)).click();
Thread.sleep(3000);
WebElement Packlisttextfield = driver.findElement(By.xpath(loc_packlistnu));

Thread.sleep(3000);
Packlisttextfield.clear();
Packlisttextfield.sendKeys(PackListNu);
Thread.sleep(3000);
Thread.sleep(3000);
Packlisttextfield.sendKeys(Keys.DOWN);
Packlisttextfield.sendKeys(Keys.ENTER);

		 
		 driver.findElement(By.xpath(loc_PackRMAno)).sendKeys(PackRMAnu + "\n");
		 
		 driver.findElement(By.xpath(loc_packSerialNu)).sendKeys(PackSerialnu+ "\n");
		 Thread.sleep(3000);
		 driver.findElement(By.xpath(loc_packaddinfo)).click();
		 Thread.sleep(3000);
		 
		 driver.findElement(By.xpath(loc_Completepack)).click();
		String Message  = driver.findElement(By.xpath(loc_ValidationMessage)).getText();
		 System.out.println(Message);
		 
		 Logs.take_logs("Pack order","Order Packaging Completed");
		 
		 
		
	}
	

}
