package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import locators.CommonLoctors;
import utitlities.ReadExcelFile;
import baseClass.DriverHelper;

public class QualityCheck implements CommonLoctors {
	
WebDriver driver;

	
	public QualityCheck(WebDriver driver) throws InterruptedException{
		
		 this.driver = driver;
		 
		 }
	
	public void QCOrd() throws InterruptedException,Exception{
		ReadExcelFile.setExcelFile("C:\\Users\\IT\\workspace\\SeleniumTests\\TestData\\Inputfile.xlsx","input");
		String QualitySerialNu = ReadExcelFile.getCellData(11,1);
		String Qualityloc = ReadExcelFile.getCellData(11,2);
		String QCStatus = ReadExcelFile.getCellData(11,3);
		String Inspectcode = ReadExcelFile.getCellData(11,4);
		driver.findElement(By.xpath(loc_QualityOption)).click();
		DriverHelper.waitMyTime(4);
		driver.findElement(By.xpath(loc_QualitySerNu)).sendKeys(QualitySerialNu +"\n");
		DriverHelper.waitMyTime(4);
		driver.findElement(By.xpath(loc_Qualityloc)).sendKeys(Qualityloc);
	       Thread.sleep(3000);
		WebElement QualitylocSub1 =	driver.findElement(By.xpath(loc_Qualitylocsub));
  		Actions actions = new Actions(driver);
  		actions.moveToElement(QualitylocSub1);
  		actions.click();
  		actions.build().perform();
		DriverHelper.waitMyTime(4);

		
		if(!QCStatus.equalsIgnoreCase("PASS")){
			
			driver.findElement(By.xpath(loc_QualityFail)).click();
			WebElement InspectCode = driver.findElement(By.xpath(loc_QualityInspcode));
					InspectCode.sendKeys(Inspectcode);
				       Thread.sleep(3000);

					InspectCode.sendKeys(Keys.ARROW_DOWN);
					InspectCode.sendKeys(Keys.ENTER);
					DriverHelper.waitMyTime(3);
					driver.findElement(By.xpath(loc_QualityAddInfo)).click();
				WebElement CompleteQCButton = 	driver.findElement(By.xpath(loc_QualityCompleteQC));
				
				DriverHelper.scrolltoElement(CompleteQCButton);
					Actions actions3 = new Actions(driver);
			  		actions3.moveToElement(CompleteQCButton);
			  		actions3.click();
					
					//driver.findElement(By.xpath(loc_QualityCompleteQC)).click();

					driver.findElement(By.xpath(loc_Qualityloc2)).sendKeys(Qualityloc);
					Thread.sleep(3000);
					WebElement QualitylocSub2 =	driver.findElement(By.xpath(loc_Qualitylocsub2));
			  		Actions actions2 = new Actions(driver);
			  		actions2.moveToElement(QualitylocSub2);
			  		actions2.click();
			  		actions2.build().perform();
		}
		
		else{
			
			driver.findElement(By.xpath(loc_QualityPass)).click();
			driver.findElement(By.xpath(loc_QualityCompleteQC)).click();
			Thread.sleep(3000);

		String Validation =  driver.findElement(By.xpath(loc_ValidationMessage)).getText();
		
		System.out.println(Validation);
		}
			
	}

}