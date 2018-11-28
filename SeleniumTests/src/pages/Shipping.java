package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import baseClass.DriverHelper;
import locators.CommonLoctors;
import utitlities.ReadExcelFile;

public class Shipping implements CommonLoctors {

	
	WebDriver driver;


		
		public Shipping(WebDriver driver) throws InterruptedException{
			
			 this.driver = driver;
			 
			 }
		
		
		public void Shippingorder() throws InterruptedException,Exception{
			ReadExcelFile.setExcelFile("C:\\Users\\IT\\workspace\\SeleniumTests\\TestData\\Inputfile.xlsx","input");
			String ShipPackListnu = ReadExcelFile.getCellData(15,1);
			String ShipSerialnu = ReadExcelFile.getCellData(15,2);
			String Carrievalue = ReadExcelFile.getCellData(15,3);
			String ShippingTrackingNu = ReadExcelFile.getCellData(15,4);
			
			WebElement Ship = driver.findElement(By.xpath(loc_Shipoption));
			DriverHelper.clickusingjavaexceutor(Ship);
			
		WebElement Shippacknu = driver.findElement(By.xpath(loc_ShipPacklist));
		Shippacknu.sendKeys(ShipPackListnu);
		Thread.sleep(3000);

		DriverHelper.pressKeyDown(Shippacknu);
		DriverHelper.pressKeyEnter(Shippacknu);
			
			driver.findElement(By.xpath(loc_Shipserialnu)).sendKeys(ShipSerialnu +"\n");
			
			Thread.sleep(3000);
			
			driver.findElement(By.xpath(loc_ShipAddinfo)).click();
			
			Thread.sleep(3000);
			
		WebElement Carrier =	driver.findElement(By.xpath(loc_ShipCarrier));
		
		
		
		if (Carrievalue.equalsIgnoreCase("UPS")){
			Carrier.click();
			DriverHelper.pressKeyDown(Shippacknu);
		DriverHelper.pressKeyDown(Shippacknu);
			DriverHelper.pressKeyEnter(Shippacknu);
			String arg0 = "Test";
			driver.findElement(By.xpath(loc_ShipInfoContact)).sendKeys(arg0);
			driver.findElement(By.xpath(loc_ShipInfoPhone)).sendKeys(arg0);
			driver.findElement(By.xpath(loc_ShipInfoAdress1)).sendKeys(arg0);
			driver.findElement(By.xpath(loc_ShipInfoCity)).sendKeys(arg0);
			driver.findElement(By.xpath(loc_ShipInfoState)).sendKeys(arg0);
			driver.findElement(By.xpath(loc_ShipInfoCountry)).sendKeys(arg0);
			driver.findElement(By.xpath(loc_ShipInfoWeight)).sendKeys(arg0);
			driver.findElement(By.xpath(loc_Shipinfounit)).sendKeys(arg0);
			driver.findElement(By.xpath(loc_Shipinfolength)).sendKeys(arg0);
			driver.findElement(By.xpath(loc_Shipinfowidth)).sendKeys(arg0);
			driver.findElement(By.xpath(loc_ShipinfoMeasureunit)).sendKeys();
		}
			else {
				
				driver.findElement(By.xpath(loc_ShipTrackingnu)).sendKeys(ShippingTrackingNu);
				driver.findElement(By.xpath(loc_Shipbutton)).click();
				
				Thread.sleep(3000);
				
				driver.findElement(By.xpath(loc_ShipAddconfirm)).click();
			}

			

			
		}
		
		
}
