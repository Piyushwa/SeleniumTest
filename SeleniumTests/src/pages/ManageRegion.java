package pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import locators.CommonLoctors;
import utitlities.ReadExcelFile;

public class ManageRegion implements CommonLoctors {
	
	static String filepath = System.getProperty("user.dir") +"\\TestData\\Inputfile.xlsx";

	WebDriver driver;
	
	


public ManageRegion(WebDriver driver) throws InterruptedException{
	
	 this.driver = driver;
	 
	 }


public void CreateRegion() throws InterruptedException,Exception{
	
	
	ReadExcelFile.setExcelFile(filepath,"input");
	
	String RegionName1 = ReadExcelFile.getCellData(29,1);
	
	String Regionnm = RegionName1.replaceAll("\\s","");
	String RegionTimezone = ReadExcelFile.getCellData(29,2);
	
	
	driver.findElement(By.xpath(loc_Settings)).click();
	
	Thread.sleep(3000);

	driver.findElement(By.xpath(loc_ManageRegion)).click();
	
	Thread.sleep(3000);

	
	driver.findElement(By.xpath(loc_CreateRegion)).click();
	
	Thread.sleep(3000);


	
	WebElement RegionName = driver.findElement(By.xpath(loc_RegionName));
			RegionName.sendKeys(Regionnm);
	Thread.sleep(3000);
	RegionName.sendKeys(Keys.TAB);
	RegionName.sendKeys(Keys.ENTER);
	
	WebElement TimeZone =  driver.findElement(By.xpath(loc_RegionTimeZone));
	
	Actions act =new Actions(driver);
	act.moveToElement(TimeZone);

	act.build().perform();
			TimeZone.sendKeys(RegionTimezone);
			Thread.sleep(6000);
			TimeZone.sendKeys(Keys.DOWN);
			TimeZone.sendKeys(Keys.ENTER);
	
	
			driver.findElement(By.xpath(loc_RegionCreated)).click();



}

public void EditDeleteRegion() throws InterruptedException,Exception{
	
ReadExcelFile.setExcelFile(filepath,"input");
	
	String RegionName = ReadExcelFile.getCellData(29,1);
	
	 List<WebElement> columVal =  driver.findElements(By.xpath("html/body/app-root/div/div/app-manageregions/section[2]/div/div[2]/p-table/div/div/table/tbody/tr[1]/td[1]"));
	    // count the size of the list to match with the size of the column state
	    System.out.println("Size of the contents in the column state is : " +columVal.size());
	    
	  
	    
	    for(int i=0;i<columVal.size();i++){
	       System.out.println("Content text is : " + columVal.get(i).getText());
	        // match the content here in the if loop
	        if(columVal.get(i).getText().equalsIgnoreCase(RegionName)){
	           
	        	System.out.println("Fail code is: " + columVal.get(i).getText());
	        	
	        	List<WebElement> rowdata = driver.findElements(By.xpath("//*[@id='tbl_FailDetailList']/tbody/tr"));
	        	
	        	System.out.println("Fail Code Data is: " +rowdata.get(i).getText());
	        	break;
}
	

}
	    
}

}