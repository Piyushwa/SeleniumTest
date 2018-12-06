package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import locators.CommonLoctors;
import utitlities.ReadExcelFile;

public class PickParts implements CommonLoctors {
	
	
	WebDriver driver;
	
	
	public PickParts(WebDriver driver) throws InterruptedException{
		
		 this.driver = driver;
		 
		 }

	
	public void pickparts() throws Exception,InterruptedException{
		
		ReadExcelFile.setExcelFile("C:\\Users\\IT\\workspace\\SeleniumTests\\TestData\\Inputfile.xlsx","input");
		
		String OrderNu = ReadExcelFile.getCellData(18,1);
		
		  String loc_pickorder ="//span[contains(text(),'"+OrderNu+"')]";
		
		driver.findElement(By.xpath("Pickpartsoptions")).click();
		
		driver.findElement(By.xpath(loc_pickorders)).click();
		driver.findElement(By.xpath(loc_pickorder)).click();

	}
}
