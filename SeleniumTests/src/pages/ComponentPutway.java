package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import locators.CommonLoctors;
import utitlities.Logs;
import utitlities.ReadExcelFile;

public class ComponentPutway implements CommonLoctors {
	
	static String filepath = System.getProperty("user.dir") +"\\TestData\\Inputfile.xlsx";
WebDriver driver;

	
	public ComponentPutway(WebDriver driver) throws InterruptedException{
		
		 this.driver = driver;
		 
		 }
	
	public void CompPutway() throws InterruptedException,Exception{
		
		
ReadExcelFile.setExcelFile(filepath,"input");
		
		String complocation = ReadExcelFile.getCellData(19,1);

		String Modelnumber = ReadExcelFile.getCellData(19,2);
		String Serialnumber = ReadExcelFile.getCellData(19,3);
		
	driver.navigate().to("https://b2bolpdev.ctdi.com/#/repair-component-putaway");
		
		Thread.sleep(4000);
		  Logs.take_logs("Component Putaway", "Started");	   	

	
			WebElement PutModul = 	driver.findElement(By.xpath(loc_CmputModal));
			PutModul.sendKeys(Modelnumber);
				Thread.sleep(3000);
				PutModul.sendKeys(Keys.DOWN);
				PutModul.sendKeys(Keys.ENTER);
				
				Thread.sleep(6000);
				
				
				WebElement PutSerialnu = 	driver.findElement(By.xpath(loc_CmputSerial));
				PutSerialnu.sendKeys(Serialnumber);
					Thread.sleep(3000);
					PutSerialnu.sendKeys(Keys.DOWN);
					PutSerialnu.sendKeys(Keys.ENTER);
					
					Thread.sleep(2000);
					
					
					WebElement PutLoc = 	driver.findElement(By.xpath(loc_Cmputin));
					PutLoc.sendKeys(complocation);
						Thread.sleep(3000);
						PutLoc.sendKeys(Keys.DOWN);
						PutLoc.sendKeys(Keys.ENTER);
						Thread.sleep(3000);
						
					
					

					Thread.sleep(3000);
					
					driver.findElement(By.xpath(loc_cmputSubmit)).click();
					
					  Logs.take_logs("Component Putaway", "Completed");	   	

				
		
	}

}
