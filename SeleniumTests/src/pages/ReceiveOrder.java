package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import baseClass.DriverHelper;
import locators.CommonLoctors;
import utitlities.ReadExcelFile;

public class ReceiveOrder implements CommonLoctors{
	
	
	WebDriver driver;
	
	public ReceiveOrder(WebDriver driver) throws InterruptedException{
		
		 this.driver = driver;
		 
		 }
	
	public void Receiveorderform() throws InterruptedException,Exception{
		
		ReadExcelFile.setExcelFile("C:\\Users\\IT\\workspace\\SeleniumTests\\TestData\\Inputfile.xlsx","input");
		String ReceiveSrl = ReadExcelFile.getCellData(5,1);
		String Rono = ReadExcelFile.getCellData(5,3);
        String ReceiveAsstext  = ReadExcelFile.getCellData(5,4);
        String Receivenotes  = ReadExcelFile.getCellData(5,5);
        String Printername = ReadExcelFile.getCellData(5,6);
        String Location = ReadExcelFile.getCellData(5,7);

		
		driver.findElement(By.xpath(loc_Receiveoption)).click();
		
		Thread.sleep(2000);
		driver.findElement(By.xpath(loc_Receiveserialnoinput)).sendKeys(ReceiveSrl +"\n");
		
		driver.findElement(By.xpath(loc_ReceiveROnumber)).sendKeys(Rono);
		
		/*WebElement RMAnu = driver.findElement(By.xpath(loc_RcvRMAno));
		RMAnu.sendKeys("NO");
		Thread.sleep(6000);
		RMAnu.sendKeys(Keys.DOWN);
		RMAnu.sendKeys(Keys.TAB);
		
		Thread.sleep(2000);
		
		
		WebElement RecvPartNu = driver.findElement(By.xpath(loc_RecvPartno));
		
		Actions actions = new Actions(driver);

		actions.moveToElement(RecvPartNu);
		actions.click();
		actions.sendKeys("6110GP91232E0HF");
		actions.build().perform();

	
		
		Thread.sleep(7000);
		RecvPartNu.sendKeys(Keys.DOWN);
		RMAnu.sendKeys(Keys.TAB);*/

		
		driver.findElement(By.xpath(loc_ReceiveDockdate)).sendKeys("11/16/2018");
	WebElement Damagechckbx = 	driver.findElement(By.xpath(loc_RecvPhydamageCheckbox));
	
	//DriverHelper.checkbox_Checking(Damagechckbx);
	
	driver.findElement(By.xpath(loc_ReceiveAccersories)).click();
	driver.findElement(By.xpath(loc_ReceiveAccersoriestext)).sendKeys(ReceiveAsstext);
WebElement Accesories1 =	driver.findElement(By.xpath(loc_ReceiveAccersoriesvalue1));
DriverHelper.checkbox_Checking(Accesories1);
Thread.sleep(2000);

WebElement Submiit = driver.findElement(By.xpath(loc_ReceiveSubmit));

	DriverHelper.scrolltoElement(Submiit);

driver.findElement(By.xpath(loc_receivingnotes)).click();
driver.findElement(By.xpath(loc_receivingnotes)).sendKeys(Receivenotes);
DriverHelper.clickWebelement(Submiit);


Thread.sleep(6000);

WebElement RecvPrinter = driver.findElement(By.xpath(loc_RecvPrinter));
RecvPrinter.sendKeys(Printername);
Thread.sleep(6000);
RecvPrinter.sendKeys(Keys.DOWN);
RecvPrinter.sendKeys(Keys.ENTER);

WebElement RecvLocations = driver.findElement(By.xpath(loc_RecvLocations));
RecvLocations.sendKeys(Location);
Thread.sleep(6000);
RecvLocations.sendKeys(Keys.DOWN);
RecvLocations.sendKeys(Keys.ENTER);

driver.findElement(By.xpath(loc_RecvFinalSubmit)).click();



	}

}
