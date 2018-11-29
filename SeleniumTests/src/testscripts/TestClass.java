package testscripts;

import java.io.IOException;


import org.testng.annotations.Test;

import baseClass.DriverHelper;
import pages.*;
import utitlities.Logs;

public class TestClass extends DriverHelper{
	

	@Test
	public static void test_Sce2() throws InterruptedException, IOException,Exception{
		// Logs - helps the User to understand the test steps or any failure during the test case execution.
		
		Logs.take_logs("TestCase1","Login on OLP URL");
		
		LoginPage lp = new LoginPage(driver);
		
		//Login method helps to login with different users
		
		lp.loggedin("pwadhwa@ctdi.com","1Nd1@123");
		
		Logs.take_logs("TestCase1","Logged In OLP URL");
	       Thread.sleep(2000);
	       
	 //CreateOrder co = new CreateOrder(driver);
	 //co.Createorderform();
			//ReceiveOrder ro = new ReceiveOrder(driver);
			//ro.Receiveorderform();	
	      //pages.Test ts = new pages.Test(driver);
	   // ts.testorder();
	       
	       //Repair rp =new Repair(driver);
	      //rp.Repairorder();
	       
	     //QualityCheck qc = new QualityCheck(driver);
	     // qc.QCOrd();
	       
	      // PackageOrder po = new PackageOrder(driver);
	     // po.Packorder();
	       
	     Shipping sp = new Shipping(driver);
	      sp.Shippingorder();
}
	
}