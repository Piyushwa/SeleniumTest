package pages;

import java.util.List;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import baseClass.DriverHelper;
import locators.CommonLoctors;
import utitlities.Logs;
import utitlities.ReadExcelFile;

public class CreateOrder implements CommonLoctors {
	
WebDriver driver;

	
	public CreateOrder(WebDriver driver) throws InterruptedException{
		
		 this.driver = driver;
		 
		 }
	
	public void Createorderform() throws InterruptedException,Exception
	
	{
		
	String Todaydate =	DriverHelper.getDateStamp();
	System.out.println("Date is:  " +Todaydate);
		ReadExcelFile.setExcelFile("C:\\Users\\IT\\workspace\\SeleniumTests\\TestData\\Inputfile.xlsx","input");
		String Orderno = ReadExcelFile.getCellData(2,1);
		String Orderdate = ReadExcelFile.getCellData(2,2);
		String Duedate = ReadExcelFile.getCellData(2,3);
		String Pono = ReadExcelFile.getCellData(2,4);
		String contactno = ReadExcelFile.getCellData(2, 5);
		String ordernotes = ReadExcelFile.getCellData(2,6);
		String contact = ReadExcelFile.getCellData(2,7);
		String Address = ReadExcelFile.getCellData(2,8);
		String city = ReadExcelFile.getCellData(2,9);
		String zip = ReadExcelFile.getCellData(2,10);
		String phone = ReadExcelFile.getCellData(2,11);
		String Address2 = ReadExcelFile.getCellData(2,12);
		String state = ReadExcelFile.getCellData(2,13);
		String country = ReadExcelFile.getCellData(2,14);
		String Serialno = ReadExcelFile.getCellData(2,15);
		String Partno = ReadExcelFile.getCellData(2,16);
		String Symptoms = ReadExcelFile.getCellData(2,17);


		WebElement Reports = driver.findElement(By.xpath(loc_Reports));
		Reports.click();
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);

	WebElement Scrollelem1 = driver.findElement(By.xpath(loc_Order));
        Actions actions = new Actions(driver);
        actions.moveToElement(Scrollelem1);
        actions.build().perform();
Thread.sleep(2000);
   
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
		driver.findElement(By.xpath(loc_Order)).click();
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
		driver.findElement(By.xpath(loc_CreateOrderbutton)).click();
		//DriverHelper.switchToNewWindow();
		//for(String winHandle : driver.getWindowHandles()){
			// driver.switchTo().window(winHandle);
			//}
		
		Thread.sleep(2000);
		
        Logs.take_logs("Create Order","Start Order Creation");


		driver.findElement(By.xpath(loc_Orderno)).sendKeys(Orderno);
		
		WebElement Ordertyp = driver.findElement(By.xpath(loc_Ordertype));
		
		Ordertyp.sendKeys("AdvanceReplacement");
		
		Thread.sleep(3000);
	DriverHelper.pressKeyDown(Ordertyp);
	Thread.sleep(1000);
	DriverHelper.pressKeyEnter(Ordertyp);
		WebElement Date1 = driver.findElement(By.xpath(loc_Orderdate));
				Date1.sendKeys(Todaydate);
				Date1.sendKeys(Keys.TAB);
		
		WebElement Date2  = driver.findElement(By.xpath(loc_duedate));
				Date2.sendKeys(Todaydate);
		Date2.sendKeys(Keys.TAB);

		
		driver.findElement(By.xpath(loc_POno)).sendKeys(Pono);
		driver.findElement(By.xpath(loc_contactno)).sendKeys(contactno);
		
		WebElement continuebutton = driver.findElement(By.xpath(loc_orderContinue));
		DriverHelper.scrolltoElement(continuebutton);
		WebElement Ordernotesnew =  driver.findElement(By.xpath(loc_ordernotes));
		Ordernotesnew.sendKeys(ordernotes);
		DriverHelper.pressKeyEnter(Ordernotesnew);
		driver.findElement(By.xpath(loc_orderContinue)).click();
		driver.findElement(By.xpath(loc_contact)).sendKeys(contact);
		driver.findElement(By.xpath(loc_Address)).sendKeys(Address);
		driver.findElement(By.xpath(loc_city)).sendKeys(city);
		driver.findElement(By.xpath(loc_zip)).sendKeys(zip);
		driver.findElement(By.xpath(loc_phone)).sendKeys(phone);
		driver.findElement(By.xpath(loc_Address2)).sendKeys(Address2);
		driver.findElement(By.xpath(loc_state)).sendKeys(state);
		driver.findElement(By.xpath(loc_country)).sendKeys(country);
		driver.findElement(By.xpath(loc_AddIinfo)).click();
		Thread.sleep(2000);

		WebElement Scrollelem2 = driver.findElement(By.xpath(loc_Symptoms));
		Thread.sleep(1000);

		DriverHelper.scrolltoElement(Scrollelem2);
       
        
        driver.findElement(By.xpath(loc_Serialno)).sendKeys(Serialno);

        driver.findElement(By.xpath(loc_Symptoms)).sendKeys(Symptoms);

      WebElement PartNu = driver.findElement(By.xpath(loc_Part));
    		  PartNu.sendKeys(Partno);
    		Thread.sleep(6000);
    		 PartNu.sendKeys(Keys.DOWN);
    		 PartNu.sendKeys(Keys.ENTER);

        
        
        
		Thread.sleep(1000);
		
          driver.findElement(By.xpath(loc_OrderAdd)).click();
          
          Logs.take_logs("Create Order","Complete Order Creation");
          
  		Thread.sleep(2000);

  		WebElement Scrollelem3 = driver.findElement(By.xpath(loc_SaveOrder));
  		
		DriverHelper.scrolltoElement(Scrollelem3);
		Thread.sleep(1000);
		Scrollelem3.click();
		
		WebElement Orderfilter =  driver.findElement(By.xpath(loc_Ordernumfilter));
		Orderfilter.sendKeys(Orderno);
		driver.findElement(By.xpath(loc_OrderApply)).click();
		

	}
}
