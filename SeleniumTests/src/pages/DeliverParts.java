package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import locators.CommonLoctors;
import utitlities.ReadExcelFile;

public class DeliverParts implements CommonLoctors {
	
WebDriver driver;

static String filepath = System.getProperty("user.dir") +"\\TestData\\Inputfile.xlsx";
	public DeliverParts(WebDriver driver) throws InterruptedException{
		
		 this.driver = driver;
		 
		 }
	
	public void DeliverPart() throws InterruptedException,Exception{
		
ReadExcelFile.setExcelFile(filepath,"input");

String Rono = ReadExcelFile.getCellData(5,3);

String DelvOrder = utitlities.DatabaseConnectivity.Dbconn("select * from COMPONENTORDERS Where ASSETID IN ( select ID from ASSETS  where ASSETTAG = '"+Rono+"')","NUMBER","BBADMIN","BBADMIN");
String DelSerialnu = ReadExcelFile.getCellData(25,2);
		
		driver.findElement(By.xpath(loc_DeliverPartsOptions)).click();
		
		Thread.sleep(2000);
		
		driver.findElement(By.xpath(loc_DeliverOrderno)).sendKeys(DelvOrder);
		
		Thread.sleep(2000);
		
		driver.findElement(By.xpath(loc_DeliverSerialno)).sendKeys(DelSerialnu);
		
		Thread.sleep(2000);
		
	driver.findElement(By.xpath(loc_PartDelvrySubmit)).click();
		
		String Message = driver.findElement(By.xpath(loc_ValidationMessage)).getText();

		System.out.println(Message);
		
		
		
		
	}

}
