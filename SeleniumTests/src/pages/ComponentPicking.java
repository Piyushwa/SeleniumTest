package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import baseClass.DriverHelper;
import locators.CommonLoctors;
import utitlities.ReadExcelFile;

public class ComponentPicking implements CommonLoctors {
	
	
WebDriver driver;

	
	public ComponentPicking(WebDriver driver) throws InterruptedException{
		
		 this.driver = driver;
		 
		 }
	
	public void ComponentPick() throws InterruptedException,Exception{
		
ReadExcelFile.setExcelFile("C:\\Users\\IT\\workspace\\SeleniumTests\\TestData\\Inputfile.xlsx","input");
		
		String complocation = ReadExcelFile.getCellData(19,1);

		String Modelnumber = ReadExcelFile.getCellData(19,2);
		String Serialnumber = ReadExcelFile.getCellData(19,3);
	
		
		driver.navigate().to("https://b2bolpdev.ctdi.com/#/repair-component-receiving");
		
		Thread.sleep(4000);
		
	
		
		WebElement CompLoc = 	driver.findElement(By.xpath(loc_PartsPickingPrinter));
		CompLoc.sendKeys(complocation);
			Thread.sleep(3000);
			CompLoc.sendKeys(Keys.DOWN);
			CompLoc.sendKeys(Keys.ENTER);
			Thread.sleep(3000);
			
			WebElement Modulnu = 	driver.findElement(By.xpath(loc_CmRecModel));
			Modulnu.sendKeys(Modelnumber);
				Thread.sleep(3000);
				
				String loc_ModulValue = "//span[contains(text(),'"+Modelnumber+"')]";
				driver.findElement(By.xpath(loc_ModulValue)).click();
					
			
				Thread.sleep(6000);
				
				
				WebElement Serialnu = 	driver.findElement(By.xpath(loc_CmRecSerial));
				Serialnu.sendKeys(Serialnumber +"\n");
					Thread.sleep(3000);
					
					
					
				/*	WebElement Addlist =  driver.findElement(By.xpath(loc_compAddlistbutton));
					Actions act = new Actions(driver);
							act.moveToElement(Addlist);
							act.build().perform();
							Addlist.click();*/
					

					
					WebElement Submit = driver.findElement(By.xpath(loc_CompRecvSubmit));
					Actions act2 = new Actions(driver);
					act2.moveToElement(Submit);
					act2.build().perform();
					Submit.click();
					
					Thread.sleep(2000);
					
					String Message = driver.findElement(By.xpath(loc_ValidationMessage)).getText();

					System.out.println(Message);
				
					
	}

}
