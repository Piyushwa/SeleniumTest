package pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;

import locators.CommonLoctors;
import utitlities.Logs;
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
	Logs.take_logs("Manage Region", "New Region Creation started");	   	

	
	driver.findElement(By.xpath(loc_CreateRegion)).click();
	
	Thread.sleep(3000);


	
	WebElement RegionName = driver.findElement(By.xpath(loc_RegionName));
			RegionName.sendKeys(Regionnm);
	Thread.sleep(3000);
	
	
	WebElement TimeZone =  driver.findElement(By.xpath(loc_RegionTimeZone));
	
	Actions act =new Actions(driver);
	act.moveToElement(TimeZone);

	act.build().perform();
			TimeZone.sendKeys(RegionTimezone);
			Thread.sleep(6000);
			TimeZone.sendKeys(Keys.DOWN);
			TimeZone.sendKeys(Keys.ENTER);
	
	
			driver.findElement(By.xpath(loc_RegionCreated)).click();
			
			
			Thread.sleep(6000);
			Logs.take_logs("Manage Region", "New Region Creation Completeds");	   	

			
			 List<WebElement> columVal =  driver.findElements(By.xpath("/html/body/app-root/div/div/app-manage-regions/section[2]/div/div[2]/p-table/div/div/table/tbody/tr/td[1]"));
			    // count the size of the list to match with the size of the column state
			    System.out.println("Size of the contents in the column state is : " +columVal.size());
			    

		        //Get Row Count
		        //int rowCount=driver.findElements(By.tagName("tr")).size();
		        
		        //System.out.println(rowCount);

		        //Get Column Count
		        int colCount=driver.findElements(By.xpath("//thead//th")).size();
		        System.out.println(colCount);

			    
			    for(int i=0;i<columVal.size();i++){
			       //System.out.println("Content text is : " + columVal.get(i).getText());
			        // match the content here in the if loop
			        if(columVal.get(i).getText().equalsIgnoreCase(Regionnm)){
			           
			        	System.out.println("Search Region is found " + columVal.get(i).getText());
			        	
			        	List<WebElement> rowdata = driver.findElements(By.xpath("/html/body/app-root/div/div/app-manage-regions/section[2]/div/div[2]/p-table/div/div/table/tbody/tr"));
			        	
			        	System.out.println("Search Region is found " +rowdata.get(i).getText());
			        	
			        Assert.assertEquals(Regionnm, columVal.get(i).getText());	
			        	
		}
			        

		}

}

public void EditDeleteRegion() throws InterruptedException,Exception{
	
ReadExcelFile.setExcelFile(filepath,"input");
	
	String RegionName = ReadExcelFile.getCellData(29,1);
	String RegionTimezone = ReadExcelFile.getCellData(29,3);

	
	
driver.findElement(By.xpath(loc_Settings)).click();
	
	Thread.sleep(3000);

	driver.findElement(By.xpath(loc_ManageRegion)).click();
	
	Thread.sleep(3000);

	Logs.take_logs("Manage Region", "Edit Region");	   	

	 List<WebElement> RegioncolumVal =  driver.findElements(By.xpath("/html/body/app-root/div/div/app-manage-regions/section[2]/div/div[2]/p-table/div/div/table/tbody/tr/td[1]"));
	    // count the size of the list to match with the size of the column state
	    System.out.println("Size of the contents in the column state is : " +RegioncolumVal.size());
	    

        //Get Row Count
        int rowCount=driver.findElements(By.tagName("tr")).size();
        
        System.out.println(rowCount);

        //Get Column Count
        int colCount=driver.findElements(By.xpath("//thead//th")).size();
        System.out.println(colCount);

	    
	    for(int i=0;i<RegioncolumVal.size();i++){
	       //System.out.println("Content text is : " + columVal.get(i).getText());
	        // match the content here in the if loop
	        if(RegioncolumVal.get(i).getText().equalsIgnoreCase(RegionName)){
	           
	        	System.out.println("Search Region is found " + RegioncolumVal.get(i).getText());
	        	

	         WebElement EditClickElement =  driver.findElement(By.xpath("/html/body/app-root/div/div/app-manage-regions/section[2]/div/div[2]/p-table/div/div/table/tbody/tr["+(i+1)+"]/td[4]/a"));
	        	
	     	Thread.sleep(3000);
	     	EditClickElement.click();    
	     	Thread.sleep(3000);
	     	
	     	
	     	WebElement TimeZone =  driver.findElement(By.xpath(loc_RegionTimeZone));
	    	
	    	Actions act =new Actions(driver);
	    	act.moveToElement(TimeZone);

	    	act.build().perform();
	    	TimeZone.clear();
	    			TimeZone.sendKeys(RegionTimezone);
	    			Thread.sleep(6000);
	    			TimeZone.sendKeys(Keys.DOWN);
	    			TimeZone.sendKeys(Keys.ENTER);
	    	
	    	
	    			driver.findElement(By.xpath(loc_RegionCreated)).click();
	    			//Delete Region
	    			Thread.sleep(6000);
	   	         WebElement DeleteClickElement =  driver.findElement(By.xpath("/html/body/app-root/div/div/app-manage-regions/section[2]/div/div[2]/p-table/div/div/table/tbody/tr["+(i+1)+"]/td[5]/a"));
	   	  	Logs.take_logs("Manage Region", "Delete Region");	   	

	   	      Thread.sleep(3000);
	   	   DeleteClickElement.click();    
		     	Thread.sleep(3000);
		     	
			driver.findElement(By.xpath(loc_DeleteRegion)).click();

         
}
	        else {
	        	
	        	System.out.println("Not able to delete and edit");
	        }

}
	    
}

}