package testscripts;

import java.io.IOException;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import baseClass.DriverHelper;
import pages.*;
import utitlities.Logs;

public class TestClass extends DriverHelper{
	

	@Test(priority=1)
	public static void login() throws InterruptedException, IOException,Exception{
		// Logs - helps the User to understand the test steps or any failure during the test case execution.
		
		
		
		LoginPage lp = new LoginPage(driver);
		
		//Login method helps to login with different users
		
		lp.loggedin("pwadhwa@ctdi.com","1Nd1@123");
		
	
	       Thread.sleep(2000);
	}
	
		@Test(priority=2,enabled=true)
	public static void DueDateCal() throws InterruptedException, IOException,Exception{
	   
		ReceiveOrder ro = new ReceiveOrder(driver);
		ro.DuedateCalc();	
			
		}
		/*	@Test(priority=2,enabled=false)
public static void CreatePart() throws InterruptedException, IOException,Exception{
   
CreatePart cp = new CreatePart(driver);
cp.CreatePartMaster();
		
	}

	@Test(priority=6,enabled=true)
	public static void ComponentPick() throws InterruptedException, IOException,Exception{
       
 ComponentPicking comp = new ComponentPicking(driver);
 comp.ComponentPick();;
   		
   	}

		
	@Test(priority=4,enabled=false)
		public static void ComponentPutway() throws InterruptedException, IOException,Exception{
	       
	 ComponentPutway comput = new ComponentPutway(driver);
	 comput.CompPutway();;
	   		
	   	}
	
	@Test(priority=7,enabled=true)
	public static void PickPart() throws InterruptedException, IOException,Exception{
       
 PickParts pp = new PickParts(driver);
 pp.pickparts();
   		
   	}
	
	@Test(priority=8,enabled=true)
	public static void DeliveryPart() throws InterruptedException, IOException,Exception{
       
DeliverParts dp = new DeliverParts(driver);
dp.DeliverPart();
   		
   	}
	

	@Test(priority=9,enabled=true)
	public static void ConsumedPart() throws InterruptedException, IOException,Exception{
       
		 Repair rp =new Repair(driver);
		  rp.ConsumePartinRepair();
				}
   		
   	
	
	@Test(priority=2,enabled=true)
	public static void CreateOrder() throws InterruptedException, IOException,Exception{
	CreateOrder co = new CreateOrder(driver);
	co.Createorderform();
		
		}

	@Test(priority=3,enabled=true)
	public static void ReceiveOrder() throws InterruptedException, IOException,Exception{
	ReceiveOrder ro = new ReceiveOrder(driver);
	ro.Receiveorderform();	
		
		}
	@Test(priority=4,enabled=true)
	public static void TestOrder() throws InterruptedException, IOException,Exception{
  pages.Test ts = new pages.Test(driver);
ts.testorder();
		}
	
@Test(priority=5,enabled=true)
	public static void RepairOrder() throws InterruptedException, IOException,Exception{
   Repair rp =new Repair(driver);
  rp.Repairorder();
		}
		
	
	   		@Test(priority=10,enabled=true)
			public static void QCOrder() throws InterruptedException, IOException,Exception{
	     QualityCheck qc = new QualityCheck(driver);
	      qc.QCOrd();
	   		}
	   			@Test(priority=11,enabled=true)
				public static void PackOrder() throws InterruptedException, IOException,Exception{
	       
	       PackageOrder po = new PackageOrder(driver);
	      po.Packorder();
	   			}
	   				@Test(priority=12,enabled=true)
	   				public static void ShipOrder() throws InterruptedException, IOException,Exception{
	     Shipping sp = new Shipping(driver);
	      sp.Shippingorder(); 
}
	 */
}