package testscripts;

import java.io.IOException;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import baseClass.DriverHelper;
import pages.*;
import utitlities.Logs;

public class TestClass extends DriverHelper{
	
	
	@AfterMethod
	
	public void aftermethod(){
		
	DriverHelper.switchToParentWindow();
		
	}

	@Test(priority=1)
	public static void login() throws InterruptedException, IOException,Exception{
		// Logs - helps the User to understand the test steps or any failure during the test case execution.
		
		Logs.take_logs("TestCase1","Login on OLP URL");
		
		LoginPage lp = new LoginPage(driver);
		
		//Login method helps to login with different users
		
		lp.loggedin("pwadhwa@ctdi.com","1Nd1@123");
		
		Logs.take_logs("TestCase1","Logged In OLP URL");
	       Thread.sleep(2000);
	}
	   	@Test(priority=2)
		public static void CreateOrder() throws InterruptedException, IOException,Exception{
	       
	 CreateOrder co = new CreateOrder(driver);
	 co.Createorderform();
	   		
	   	}
	   		@Test(priority=3)
			public static void ReceiveOrder() throws InterruptedException, IOException,Exception{
			ReceiveOrder ro = new ReceiveOrder(driver);
			ro.Receiveorderform();	
	   		
	   		}
	   		
	   		@Test(priority=4)
			public static void TestOrder() throws InterruptedException, IOException,Exception{
	      pages.Test ts = new pages.Test(driver);
	    ts.testorder();
	   		}
	   		
	   		@Test(priority=5)
			public static void RepairOrder() throws InterruptedException, IOException,Exception{
	       Repair rp =new Repair(driver);
	      rp.Repairorder();
	   		}
	   		
	   		@Test(priority=6)
			public static void QCOrder() throws InterruptedException, IOException,Exception{
	     QualityCheck qc = new QualityCheck(driver);
	      qc.QCOrd();
	   		}
	   			@Test(priority=7)
				public static void PackOrder() throws InterruptedException, IOException,Exception{
	       
	       PackageOrder po = new PackageOrder(driver);
	      po.Packorder();
	   			}
	   				@Test(priority=8)
	   				public static void ShipOrder() throws InterruptedException, IOException,Exception{
	     Shipping sp = new Shipping(driver);
	      sp.Shippingorder();
}
	
}