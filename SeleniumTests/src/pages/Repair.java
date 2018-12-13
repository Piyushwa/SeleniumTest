package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Reporter;

import baseClass.DriverHelper;
import locators.CommonLoctors;
import utitlities.Logs;
import utitlities.ReadExcelFile;

public class Repair implements CommonLoctors {

	
WebDriver driver;


	
	public Repair(WebDriver driver) throws InterruptedException{
		
		 this.driver = driver; 
		 }
	
	public void Repairorder() throws InterruptedException,Exception
	
	{
		ReadExcelFile.setExcelFile("C:\\Users\\IT\\workspace\\SeleniumTests\\TestData\\Inputfile.xlsx","input");
		String RepairSerialNu = ReadExcelFile.getCellData(9,1);
		String Repairloc = ReadExcelFile.getCellData(9,2);
		String RepairStatus = ReadExcelFile.getCellData(9,3);
		String Componentnu = ReadExcelFile.getCellData(9,4);
		String SymptomOpt = ReadExcelFile.getCellData(9,5);
		String Defectopt = ReadExcelFile.getCellData(9,6);
		
		
		
		driver.findElement(By.xpath(loc_RepairOption)).click();
		
		DriverHelper.waitMyTime(7);
		driver.findElement(By.xpath(loc_RepairSerialNo)).sendKeys(RepairSerialNu+"\n");
	       Thread.sleep(2000);
		driver.findElement(By.xpath(loc_Repairloc)).sendKeys(Repairloc);
	       Thread.sleep(3000);

		WebElement RepairlocSub = driver.findElement(By.xpath(loc_RepairlocSubmit));
		
		Actions actions = new Actions(driver);
		actions.moveToElement(RepairlocSub);
		actions.click();
		actions.build().perform();
		
	       Thread.sleep(2000);
	       
	   WebElement CompleteRep =   driver.findElement(By.xpath(loc_CompleteRepair));
	       
	       DriverHelper.scrolltoElement(CompleteRep);
	       
	     if(RepairStatus.equalsIgnoreCase("Repairable")){
	    	 driver.findElement(By.xpath(loc_Repairablechckbox)).click();
	    	 driver.findElement(By.xpath(loc_RepairPartsbutton)).click();
	    	WebElement Component =  driver.findElement(By.xpath(loc_RepairComponent));
   		Component .sendKeys(Componentnu);
   		Thread.sleep(6000);
   		Component.sendKeys(Keys.DOWN);
   		Component.sendKeys(Keys.ENTER);
	    	 Thread.sleep(2000);
	    	WebElement  Symptom =  driver.findElement(By.xpath(loc_RepairSymptom));
	    	Symptom.sendKeys(SymptomOpt);
	    	 Thread.sleep(3000);
	    	 Symptom.sendKeys(Keys.DOWN);
	    	 Symptom.sendKeys(Keys.ENTER);

	    	WebElement Defect =  driver.findElement(By.xpath(loc_RepairDefect));
	    	Defect.sendKeys(Defectopt);
	    	 Thread.sleep(3000);
	    	 
	    	 Defect.sendKeys(Keys.DOWN);
	    	 Defect.sendKeys(Keys.ENTER);
	    	 Thread.sleep(2000);
	    	 driver.findElement(By.xpath(loc_RepairAddinfo)).click();
	    	 driver.findElement(By.xpath(loc_RepairSubmitPart)).click();
	    	 
		       DriverHelper.scrolltoElement(CompleteRep);

	    	 driver.findElement(By.xpath(loc_RepairPartInfosave)).click();
	    	 
	    	 driver.findElement(By.xpath(loc_Repairnotes)).sendKeys("Test Repairable");
	    	 
	    	 CompleteRep.click();
	    	 
	     }
	     if(RepairStatus.equalsIgnoreCase("NTF")){
	    	 
	    	 driver.findElement(By.xpath(loc_NTFchckbox)).click();
	    	 
	    	 driver.findElement(By.xpath(loc_Repairnotes)).sendKeys("Test NTF");
	    	 CompleteRep.click();

             driver.findElement(By.xpath(loc_Repairloc2)).sendKeys(Repairloc);
  	       Thread.sleep(3000);

		WebElement RepairlocSub2 = driver.findElement(By.xpath(loc_Submitloc2));
  		Actions actions2 = new Actions(driver);
  		actions2.moveToElement(RepairlocSub2);
  		actions2.click();
  		actions2.build().perform();
	     }
	      if(RepairStatus.equalsIgnoreCase("Scrap")){
 driver.findElement(By.xpath(loc_UnRepairablechckbox)).click();
   Thread.sleep(3000);

	    	 //driver.findElement(By.xpath(loc_Repairnotes)).sendKeys("Test Unrepairable");
	    	 CompleteRep.click();
	    	 driver.findElement(By.xpath(loc_Repairloc3)).sendKeys(Repairloc);
	  	       Thread.sleep(3000);

			WebElement RepairlocSub3 = driver.findElement(By.xpath(loc_Submitloc3));
	  		Actions actions2 = new Actions(driver);
	  		actions2.moveToElement(RepairlocSub3);
	  		actions2.click();
	  		actions2.build().perform(); 	 
	    	 
	}
	     
	     else {
	    	 
	    	 Reporter.log( "Invalid Repair Status" +RepairStatus);
	    	 Logs.take_logs("Repair", "Invalid Repair Status");
	     }
	      

}
	
	public void ConsumePartinRepair()throws InterruptedException,Exception{
		
		ReadExcelFile.setExcelFile("C:\\Users\\IT\\workspace\\SeleniumTests\\TestData\\Inputfile.xlsx","input");
		String RepairSerialNu = ReadExcelFile.getCellData(9,1);
		String Repairloc = ReadExcelFile.getCellData(9,2);
		String RepairAction = ReadExcelFile.getCellData(9,10);
		driver.get("https://b2bolpdev.ctdi.com/#/repair");
		
	       Thread.sleep(3000);
	       driver.findElement(By.xpath(loc_RepairSerialNo)).sendKeys(RepairSerialNu+"\n");
	       Thread.sleep(2000);
		driver.findElement(By.xpath(loc_Repairloc)).sendKeys(Repairloc);
	       Thread.sleep(3000);

		WebElement RepairlocSub = driver.findElement(By.xpath(loc_RepairlocSubmit));
		
		Actions actions = new Actions(driver);
		actions.moveToElement(RepairlocSub);
		actions.click();
		actions.build().perform();
		
		WebElement  ActionToconsume =  driver.findElement(By.xpath(loc_RepairAction));
		ActionToconsume.sendKeys(RepairAction);
    	 Thread.sleep(3000);
    	 ActionToconsume.sendKeys(Keys.DOWN);
    	 ActionToconsume.sendKeys(Keys.ENTER);
		
		
	}
}
