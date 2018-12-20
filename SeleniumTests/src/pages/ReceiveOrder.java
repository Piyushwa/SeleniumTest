package pages;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;

import baseClass.DriverHelper;
import locators.CommonLoctors;
import utitlities.Logs;
import utitlities.ReadExcelFile;

public class ReceiveOrder implements CommonLoctors{
	
	static String filepath = System.getProperty("user.dir") +"\\TestData\\Inputfile.xlsx";

	WebDriver driver;
	
	public ReceiveOrder(WebDriver driver) throws InterruptedException{
		
		 this.driver = driver;
		 
		 }
	
	public static LocalDate add(LocalDate date, int workdays) {
	    if (workdays < 1) {
	        return date;
	    }

	    LocalDate result = date;
	    int addedDays = 0;
	    while (addedDays < workdays) {
	        result = result.plusDays(1);
	        if (!(result.getDayOfWeek() == DayOfWeek.SATURDAY ||
	              result.getDayOfWeek() == DayOfWeek.SUNDAY)) {
	            ++addedDays;
	        }
	    }

	    return result;
	}
	
	public void Receiveorderform() throws InterruptedException,Exception{
		
		ReadExcelFile.setExcelFile(filepath,"input");
		String ReceiveSrl = ReadExcelFile.getCellData(5,1);
		String Rono = ReadExcelFile.getCellData(5,3);
        String ReceiveAsstext  = ReadExcelFile.getCellData(5,4);
        String Receivenotes  = ReadExcelFile.getCellData(5,5);
        String Printername = ReadExcelFile.getCellData(5,6);
        String Location = ReadExcelFile.getCellData(5,7);

		
		driver.findElement(By.xpath(loc_Receiveoption)).click();
		
		Thread.sleep(3000);
		driver.findElement(By.xpath(loc_Receiveserialnoinput)).sendKeys(ReceiveSrl +"\n");
		 Logs.take_logs("Receive order", "Receiving Order Started ");	   
			
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

//driver.findElement(By.xpath(loc_receivingnotes)).click();
//driver.findElement(By.xpath(loc_receivingnotes)).sendKeys(Receivenotes);
Thread.sleep(6000);
Submiit.click();


String Message = driver.findElement(By.xpath(loc_ValidationMessage)).getText();

System.out.println(Message);

if(Message.contains("already exists")){
	
	System.out.println("RO Number is already avaliable: " +Message);
	
}

else {
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
Thread.sleep(6000);

String Duedate = driver.findElement(By.xpath(loc_DuedateText)).getText();


Logs.take_logs("Receive order", "Receiving Order Completed ");	   
}

	}
	
	
	
	
	
	public  void DuedateCalc() throws InterruptedException,Exception{
	ReadExcelFile.setExcelFile(filepath,"input");
		String Ordenu = ReadExcelFile.getCellData(27,1);
		String ReceiveSrl = ReadExcelFile.getCellData(27,4);
		String Rono = ReadExcelFile.getCellData(27,2);
        String ReceiveAsstext  = ReadExcelFile.getCellData(5,4);
        String Receivenotes  = ReadExcelFile.getCellData(5,5);
        String Printername = ReadExcelFile.getCellData(5,6);
        String Location = ReadExcelFile.getCellData(5,7);
    	/*driver.findElement(By.xpath(loc_Receiveoption)).click();
		
		Thread.sleep(3000);
		driver.findElement(By.xpath(loc_Receiveserialnoinput)).sendKeys(ReceiveSrl +"\n");
		 Logs.take_logs("Receive order", "Receiving Order Started ");	   
			
		driver.findElement(By.xpath(loc_ReceiveROnumber)).sendKeys(Rono);
		
		
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

//driver.findElement(By.xpath(loc_receivingnotes)).click();
//driver.findElement(By.xpath(loc_receivingnotes)).sendKeys(Receivenotes);
Thread.sleep(6000);
Submiit.click();


String Message = driver.findElement(By.xpath(loc_ValidationMessage)).getText();

System.out.println(Message);

if(Message.contains("already exists")){
	
	System.out.println("RO Number is already avaliable: " +Message);
	
}

else {
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
Thread.sleep(6000);*/
		
		
		String Dockdate = utitlities.DatabaseConnectivity.Dbconn("select to_char(DOCKDATEUTC,'mm/dd/yyyy')Dockdate from assets where SERIALNUMBER = '"+ReceiveSrl+"'","DOCKDATE","BBADMIN","BBADMIN");

		System.out.println("Dockdate is " +Dockdate);
		
		String qry1="select  a. * from orders a where"+'"'+"NUMBER"+'"'+"='"+Ordenu+"'" ;
		String qry2="select to_char(DUEDATEUTC,'mm/dd/yyyy') Duedate from orders where"+'"'+"NUMBER"+'"'+"='"+Ordenu+"'" ;
		
		String TAT =  utitlities.DatabaseConnectivity.Dbconn(qry1,"TATTIMEINDAYS","BBADMIN","BBADMIN");
		

		System.out.println("TAT is " +TAT);
		
		String DueDate = utitlities.DatabaseConnectivity.Dbconn(qry2,"DUEDATE","BBADMIN","BBADMIN");
		System.out.println("Actual Due Date is" + DueDate);
		
		
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy");
		LocalDate DockDateValue = LocalDate.parse(Dockdate, formatter);
		
	
		Integer TATValue = Integer.parseInt(TAT);
		
	LocalDate ResultDuedate = add(DockDateValue.plusDays(1), TATValue);
	
	//System.out.println("Result Due Date is" +ResultDuedate);
	
	DateTimeFormatter formatter1 = DateTimeFormatter.ofPattern("MM/dd/yyyy");
	String FinalDuedate = ResultDuedate.format(formatter1);
	
	//System.out.println("FinalDate is" +FinalDuedate);
	
	String qry3 = "select count(*) HolidayCount  from HOLIDAYS where DATEUTC between to_date('"+Dockdate+"','MM/DD/YYYY') and to_date('"+FinalDuedate+"','MM/DD/YYYY')";

	//System.out.println("qry3 is " +qry3);
	

String Holidays =  utitlities.DatabaseConnectivity.Dbconn(qry3,"HolidayCount","BBADMIN","BBADMIN");


System.out.println("HolidayCount is " +Holidays);

Integer HolidaysCount = Integer.parseInt(Holidays);


LocalDate ExpDuedate = add(ResultDuedate, HolidaysCount);



DateTimeFormatter formatter2 = DateTimeFormatter.ofPattern("MM/dd/yyyy");
String ExpectedDuedate = ExpDuedate.format(formatter2);

//LocalDate Mastdate = ResultDuedate.plusDays(HolidaysCount);

//DateTimeFormatter formatter2 = DateTimeFormatter.ofPattern("MM/dd/yyyy");
//String ActualDuedate = Mastdate.format(formatter2);

System.out.println("Expected Due Date is" +ExpectedDuedate);


//System.out.println("Masterdate is"  +Mastdate);


try {
Assert.assertEquals(DueDate, ExpectedDuedate);
	
	System.out.println("Pass");
} catch (Exception e) {
	System.out.println("Wrong Due Date Calculation");

}
	
	
	
}


	
	}
		
		
	
	
//}
