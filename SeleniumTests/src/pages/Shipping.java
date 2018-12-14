package pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import baseClass.DriverHelper;
import locators.CommonLoctors;
import utitlities.Logs;
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

		   String Shiptype  =ReadExcelFile.getCellData(15,5);
		   String loc_Shiptypevalue ="//span[contains(text(),'"+Shiptype+"')]";
			
			WebElement Ship = driver.findElement(By.xpath(loc_Shipoption));
			DriverHelper.clickusingjavaexceutor(Ship);
			 Logs.take_logs("Pack order","Order Shipping Started");
		WebElement Shippacknu = driver.findElement(By.xpath(loc_ShipPacklist));
		Shippacknu.sendKeys(ShipPackListnu);
		Thread.sleep(3000);
		DriverHelper.pressKeyDown(Shippacknu);
		DriverHelper.pressKeyEnter(Shippacknu);
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
			Thread.sleep(1000);
		
			driver.findElement(By.xpath(CarrierUPS)).click();
			
			WebElement submitshipinfo = 	driver.findElement(By.xpath(loc_SubmittoUPS));
			
			DriverHelper.waitTillElementFound(submitshipinfo, 15);
			
		
			driver.findElement(By.xpath(loc_ShipInfoContact)).clear();
			driver.findElement(By.xpath(loc_ShipInfoContact)).sendKeys("Piyush");
			driver.findElement(By.xpath(loc_ShipInfoPhone)).sendKeys("9999513537");
			driver.findElement(By.xpath(loc_ShipInfoAdress1)).sendKeys("Manesar");
			driver.findElement(By.xpath(loc_ShipInfoCity)).sendKeys("GGN");
			driver.findElement(By.xpath(loc_ShipInfoState)).sendKeys("HRY");
			driver.findElement(By.xpath(loc_ShipInfoCountry)).sendKeys("IND");	
			
		//WebElement submitshipinfo = 	driver.findElement(By.xpath(loc_SubmittoUPS));
		
		DriverHelper.scrolltoElement(submitshipinfo);
			driver.findElement(By.xpath(loc_ShipInfoWeight)).sendKeys("72");
			WebElement unit =driver.findElement(By.xpath(loc_Shipinfounit));
		
			driver.findElement(By.xpath(loc_Shipinfolength)).sendKeys("52");
			driver.findElement(By.xpath(loc_Shipinfowidth)).sendKeys("35");
			//driver.findElement(By.xpath(loc_ShipinfoMeasureunit)).sendKeys("");
			driver.findElement(By.xpath(loc_ShipinfoHeight)).sendKeys("35");
			Thread.sleep(3000);
			WebElement ShippingType = driver.findElement(By.xpath(loc_Shiptype));
			DriverHelper.clickusingjavaexceutor(ShippingType);
			Thread.sleep(3000);
		
			driver.findElement(By.xpath(loc_Shiptypevalue)).click();
			//DriverHelper.pressKeyDown(ShippingType);
			//DriverHelper.pressKeyEnter(ShippingType);
			Thread.sleep(3000);
			driver.findElement(By.xpath(loc_SubmittoUPS)).click();
			
			String Message  = driver.findElement(By.xpath(loc_ValidationMessage)).getText();
			
			System.out.println(Message);
			
			if(Message.contains("eError")){
				Logs.take_logs("Pack order","Order Shipping completed with Carrievalue UPS");
				
			}
			
		}
			else {
				
				driver.findElement(By.xpath(loc_ShipTrackingnu)).sendKeys(ShippingTrackingNu);
				driver.findElement(By.xpath(loc_Shipbutton)).click();
				
				Thread.sleep(3000);
				
				driver.findElement(By.xpath(loc_ShipAddconfirm)).click();
				
				Logs.take_logs("Pack order","Order Shipping completed with Carrievalue External ");
			}

			

			
		}
		
		
}
