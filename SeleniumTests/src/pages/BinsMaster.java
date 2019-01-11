package pages;

import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import baseClass.DriverHelper;
import locators.CommonLoctors;
import utitlities.ReadExcelFile;
import utitlities.Screenshots;

public class BinsMaster implements CommonLoctors {
	
	static String filepath = System.getProperty("user.dir") +"\\TestData\\Inputfile.xlsx";

	WebDriver driver;
	
	
	

public BinsMaster(WebDriver driver) throws InterruptedException{
	
	 this.driver = driver;
	 
	 }

public void CreateNewBin() throws InterruptedException,Exception{
	
	ReadExcelFile.setExcelFile(filepath,"input");
	
	String BinName = ReadExcelFile.getCellData(35,1);
	String BinDescription = ReadExcelFile.getCellData(35,2);

	String BinTypevalue =  ReadExcelFile.getCellData(35,3);
	
	String Binlocvalue =  ReadExcelFile.getCellData(35,4);
	
	String BinAislevalue =  ReadExcelFile.getCellData(35,5);
	String BinCapicity =  ReadExcelFile.getCellData(35,6);


	driver.findElement(By.xpath(loc_Settings)).click();
	
	Thread.sleep(3000);
			
	driver.findElement(By.xpath(loc_BinsMaster)).click();
		
	Thread.sleep(3000);

	driver.findElement(By.xpath(loc_CreateBinsButton)).click();
		
	Thread.sleep(3000);
		
	
	driver.findElement(By.xpath(loc_CreateBinsName)).sendKeys(BinName);

	driver.findElement(By.xpath(loc_CreateBinsDescription)).sendKeys(BinDescription);

	driver.findElement(By.xpath(loc_CreateBinsType)).click();
	
	Thread.sleep(3000);

	
	String loc_BinType = "//div/div[4]/div/ul/li/span[contains(text(),'"+BinTypevalue+"')]";
	
	driver.findElement(By.xpath(loc_BinType)).click();

	Thread.sleep(3000);

	
	driver.findElement(By.xpath(loc_CreateBinlocation)).click();
	Thread.sleep(3000);

	
	String loc_Binloc = "//*[@id='binLocation']/div/div[4]/div/ul/li/span[text() ='"+Binlocvalue+"']";
	
	WebElement binloc =  driver.findElement(By.xpath(loc_Binloc));

	
	//List<WebElement> dropvalues = driver.findElements(By.xpath("//*[@id='binLocation']/div/div[4]/div/ul/li"));
	
	//for (WebElement Valueall : dropvalues) {
		// System.out.print(Valueall.getText() + "\t");	
	//}
	
	
	 JavascriptExecutor je = (JavascriptExecutor) driver;
   
     je.executeScript("arguments[0].scrollIntoView(true);",binloc);
	
	System.out.println(loc_Binloc);

	binloc.click();
	
	Thread.sleep(3000);

	
	driver.findElement(By.xpath(loc_CreateBinAisle)).click();
	Thread.sleep(3000);

	
	String loc_BinAisle = "//*[@id='binAisle']/div/div[4]/div/ul/li/span[contains(text(),'"+BinAislevalue+"')]";
	
	
	driver.findElement(By.xpath(loc_BinAisle)).click();

	Thread.sleep(3000);


	driver.findElement(By.xpath(loc_CreateCapicity)).sendKeys(BinCapicity);
	
	Thread.sleep(3000);
	
	driver.findElement(By.xpath(loc_CreateBin)).click();
	
	Thread.sleep(6000);
	
	driver.findElement(By.xpath(loc_Binnamefilter)).sendKeys(BinName);
	driver.findElement(By.xpath(loc_Applyfilter)).click();
	
	Thread.sleep(6000);

	
	List<WebElement> Binnamecol = driver.findElements(By.xpath("//div/div/table/tbody/tr/td[1]"));

	
	 for(int i=0;i<Binnamecol.size();i++){
	        // match the content here in the if loop
		 
		 System.out.println("Size of Order" +Binnamecol.size());
	
		
		String BinNameActual = Binnamecol.get(i).getText();
		System.out.println("Bin Name is  " +BinName);
		
		Thread.sleep(4000);

		try{
Assert.assertEquals(BinName, BinNameActual);
		}
	
		catch(Exception e){
			Screenshots.takeSnapShot(driver, "C:\\Users\\IT\\workspace\\SeleniumTests\\Screenshots\\Binfail.png");
		}
	}
	

	
}
	 public void EditDeleteBin() throws InterruptedException,Exception{
		 
			ReadExcelFile.setExcelFile(filepath,"input");
			
			String BinName = ReadExcelFile.getCellData(35,1);
			String BinDescriptionEdit = ReadExcelFile.getCellData(35,7);

			
			driver.findElement(By.xpath(loc_Settings)).click();
			
			Thread.sleep(3000);
					
			driver.findElement(By.xpath(loc_BinsMaster)).click();
				
			Thread.sleep(3000);
			
			driver.findElement(By.xpath(loc_Binnamefilter)).sendKeys("Test");
			driver.findElement(By.xpath(loc_Applyfilter)).click();
			
			Thread.sleep(6000);

			List<WebElement> Binnamecol = driver.findElements(By.xpath("//div/div/table/tbody/tr/td[1]"));

		    for(int i=0;i<Binnamecol.size();i++){
		       //System.out.println("Content text is : " + columVal.get(i).getText());
		        // match the content here in the if loop
		        if(Binnamecol.get(i).getText().equalsIgnoreCase(BinName)){
		        	
			         WebElement EditClickElement =  driver.findElement(By.xpath("/html/body/app-root/div/div/app-bins/section[2]/div[2]/div[2]/p-table/div/div/table/tbody/tr["+(i+1)+"]/td[8]/a[1]"));

			     	Thread.sleep(3000);
			     	EditClickElement.click();    
			     	Thread.sleep(3000);
			     	
			    	driver.findElement(By.xpath(loc_CreateBinsDescription)).sendKeys(BinDescriptionEdit);
			    	
			    	Thread.sleep(3000);
			    	
			    	driver.findElement(By.xpath(loc_UpdateBin)).click();
			    	
			    	Thread.sleep(3000);

WebElement DeleteClickElement =  driver.findElement(By.xpath("/html/body/app-root/div/div/app-bins/section[2]/div[2]/div[2]/p-table/div/div/table/tbody/tr["+(i+1)+"]/td[8]/a[2]"));
Thread.sleep(3000);
   DeleteClickElement.click();    
  	Thread.sleep(3000);
  	
	driver.findElement(By.xpath(loc_DeletBin)).click();
		           
		    }
	 }

	
	
	 }

}
