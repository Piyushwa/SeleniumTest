package locators;

import utitlities.ReadExcelFile;

public interface CommonLoctors {
	
	String loc_Username  = "userNameInput";
	String loc_PassWord  = "passwordInput";
	String loc_LoginSubmit = "//*[@id='submitButton']";
	String loc_Reports = "//a/span[contains(text(),'Reports')]";
	
	//create order locators
	String loc_Order = "//a/span[contains(text(),'Orders')]";
	String loc_components = "//a/span[contains(text(),'Components')]";
	String loc_Ordernumfilter = "//input[@name ='orderNumber']";
	
     String loc_OrderStatusfilter = "/html/body/app-root/div/div/app-orders/section[2]/div/div[1]/div[2]/form/div/div[2]/div/p-multiselect/div/div[2]/label";
    String loc_OrderStatusValue = "/html/body/app-root/div/div/app-orders/section[2]/div/div[1]/div[2]/form/div/div[2]/div/p-multiselect/div/div[4]/div[1]/div[2]/input";
    String loc_Orderstatuscheck = "/html/body/app-root/div/div/app-orders/section[2]/div/div[1]/div[2]/form/div/div[2]/div/p-multiselect/div/div[4]/div[2]/ul/li[2] ";
    String loc_OrderStartdatefilter = "//input[@name ='startDueDate']";
    String loc_OrderEnddatefilter = "//input[@name ='endDueDate']";
    String loc_OrderApply = "/html/body/app-root/div/div/app-orders/section[2]/div/div[1]/div[2]/form/div/div[5]/div/button";
	String loc_CreateOrderbutton = "//*[@id='btnCreateOrder']";
	String loc_Orderno = "/html/body/app-root/div/div/app-orders/section[2]/div/p-sidebar/div/component-order-editor/section[2]/div[1]/div[1]/form/div/div[2]/div[1]/input";
	String loc_Ordertype = "/html/body/app-root/div/div/app-orders/section[2]/div/p-sidebar/div/component-order-editor/section[2]/div[1]/div[1]/form/div/div[2]/div[2]/div/p-autocomplete/span/button";
	String loc_Orderdate = "//input[@name ='orderDate']";
	String loc_duedate = "//input[@name ='dueDate']";
	String loc_POno ="//input[@name ='poNumber']";
	String loc_contactno ="//input[@name ='contractNumber']";
	String loc_ordernotes ="/html/body/app-root/div/div/app-orders/section[2]/div/p-sidebar/div/component-order-editor/section[2]/div[1]/div[1]/form/div/div[2]/div[6]/textarea";
	String loc_orderContinue = "//button[contains(text(),'Continue')]";
	String loc_contact = "//input[@name ='contact']";
	String loc_Address = "//input[@name ='address1']";
	String loc_city = "//input[@name ='city']";
	String loc_zip = "//input[@name ='zip']";
	String loc_phone = "//input[@name ='contactPhoneNumber']";
	String loc_Address2 = "//input[@name ='address2']";
	String loc_state = "//input[@name ='state']";
	String loc_country ="//input[@name ='country']"; 
	String loc_AddIinfo = "//button[contains(text(),'Add Unit Info')]";
	String loc_Serialno = "/html/body/app-root/div/div/app-orders/section[2]/div/p-sidebar/div/component-order-editor/section[2]/div[2]/div/div/div[2]/form/div/div[2]/div/input";
	String loc_Symptoms = "	/html/body/app-root/div/div/app-orders/section[2]/div/p-sidebar/div/component-order-editor/section[2]/div[2]/div/div/div[2]/form/div/div[5]/div/textarea";
	String loc_Part	 = "/html/body/app-root/div/div/app-orders/section[2]/div/p-sidebar/div/component-order-editor/section[2]/div[2]/div/div/div[2]/form/div/div[3]/div/div/p-autocomplete/span/input";
    String loc_OrderAdd ="/html/body/app-root/div/div/app-orders/section[2]/div/p-sidebar/div/component-order-editor/section[2]/div[2]/div/div/div[2]/form/div/div[6]/div/button";
    String loc_SaveOrder  = "//button[contains(text(),'Save')]";
    String loc_ColumnCountOrder ="/html/body/app-root/div/div/app-orders/section[2]/div/div[2]/div/p-table/div/div/table/tbody/tr[1]/td[1]";

//Receive order locator
    
    String loc_Receiveoption = "//a/span[contains(text(),'Receive')]";
	String loc_ReceiveTrackingnoinput = "//input[@name ='trackingNumber']";
	String loc_Receiveserialnoinput = "//input[@placeholder ='Search by Serial # ...']";
			
	String loc_ReceiveROnumber = "//input[@name ='assetTag']";
	String loc_ReceiveDockdate = "//input[@name ='dockDate']";
	String loc_RcvRMAno = "/html/body/app-root/div/div/app-receiving/section[2]/div/div[2]/form/div/div[2]/div[2]/div/p-autocomplete/span/input";
	String loc_RecvPartno = "/html/body/app-root/div/div/app-receiving/section[2]/div/div[2]/form/div/div[2]/div[3]/div/p-autocomplete/span/input";
	String loc_RecvPhydamageCheckbox ="/html/body/app-root/div/div/app-receiving/section[2]/div/div[2]/form/div/div[2]/div[6]/div/label/input";
	String loc_ReceiveAccersories = "/html/body/app-root/div/div/app-receiving/section[2]/div/div[2]/form/div/div[2]/div[7]/span/p-multiselect/div/div[2]/label";
	String loc_ReceiveAccersoriestext = "/html/body/app-root/div/div/app-receiving/section[2]/div/div[2]/form/div/div[2]/div[7]/span/p-multiselect/div/div[4]/div[1]/div[2]/input";
	String loc_ReceiveAccersoriesvalue1 = "/html/body/app-root/div/div/app-receiving/section[2]/div/div[2]/form/div/div[2]/div[7]/span/p-multiselect/div/div[4]/div[2]/ul/li[1]/div/div[2]";
	String loc_ReceiveAccersoriesvalue2 = "/html/body/app-root/div/div/app-receiving/section[2]/div/div[2]/form/div/div[2]/div[7]/span/p-multiselect/div/div[4]/div[2]/ul/li[2]/div/div[2]";
	String loc_ReceiveAccersoriesvalue3 = "/html/body/app-root/div/div/app-receiving/section[2]/div/div[2]/form/div/div[2]/div[7]/span/p-multiselect/div/div[4]/div[2]/ul/li[3]/div/div[2]";
	String loc_ReceiveAccersoriesvalue4 = "/html/body/app-root/div/div/app-receiving/section[2]/div/div[2]/form/div/div[2]/div[7]/span/p-multiselect/div/div[4]/div[2]/ul/li[4]/div/div[2]";
	String loc_ReceiveAccersoriesvalue5 = "/html/body/app-root/div/div/app-receiving/section[2]/div/div[2]/form/div/div[2]/div[7]/span/p-multiselect/div/div[4]/div[2]/ul/li[5]/div/div[2]";
	String loc_ReceiveAccersoriesvalue6 = "/html/body/app-root/div/div/app-receiving/section[2]/div/div[2]/form/div/div[2]/div[7]/span/p-multiselect/div/div[4]/div[2]/ul/li[6]/div/div[2]";

String loc_receivingnotes = "/html/body/app-root/div/div/app-receiving/section[2]/div/div[2]/form/div/div[2]/div[8]/textarea";
String loc_ReceiveReset =  "//button[contains(text(),'Reset')]";
String loc_RecvPrinter = "/html/body/app-root/div/app-header/header/p-sidebar/div/div/div[2]/div/div/p-autocomplete/span/input";
String loc_RecvLocations = "/html/body/app-root/div/div/app-receiving/section[2]/p-sidebar[2]/div/app-bin-selector/div/div[2]/div/p-autocomplete/span/input";
String loc_ReceiveSubmit =  "//button[contains(text(),'Submit')]";
String loc_RecvFinalSubmit = "/html/body/app-root/div/div/app-receiving/section[2]/p-sidebar[2]/div/app-bin-selector/div/div[3]/div/button[1]";
String loc_DuedateText = "/html/body/app-root/div/div/app-receiving/section[2]/div[2]/div/div/div/div/h2[1]/span";

String loc_TATText ="/html/body/app-root/div/div/app-receiving/section[2]/div[2]/div/div/div/div/h2[2]/span";

//Test Order
String loc_Testoption = "//a/span[contains(text(),'Test')]";
String loc_TestLocation = "/html/body/app-root/div/div/app-diagnostic/section[2]/p-sidebar[1]/div/app-bin-selector/div/div[2]/div/p-autocomplete/span/input";
String loc_TestSerialNo = "//input[@placeholder = 'Enter Serial / RO #...']";
String loc_TestFailcode ="/html/body/app-root/div/div/app-diagnostic/section[2]/div[2]/div/div/div[2]/div[2]/form/div/div[1]/div/p-autocomplete/span/input";
String loc_AddFailCode ="/html/body/app-root/div/div/app-diagnostic/section[2]/div[2]/div/div/div[2]/div[2]/form/div/div[3]/div/button";
String loc_TestPass = "/html/body/app-root/div/div/app-diagnostic/section[2]/div[2]/div/div/div[2]/div/div[1]/label/span";
String loc_TestFail ="/html/body/app-root/div/div/app-diagnostic/section[2]/div[2]/div/div/div[2]/div[1]/div[2]/label/span";
String loc_Testlocation2 ="/html/body/app-root/div/div/app-diagnostic/section[2]/p-sidebar[2]/div/app-bin-selector/div/div[2]/div/p-autocomplete/span/input";
String loc_TestLocSubmit = "/html/body/app-root/div/div/app-diagnostic/section[2]/p-sidebar[1]/div/app-bin-selector/div/div[3]/div/button[1]";
String loc_TestLocSubmit2 ="/html/body/app-root/div/div/app-diagnostic/section[2]/p-sidebar[2]/div/app-bin-selector/div/div[3]/div/button[1]";
String loc_TestLocSubmit3 ="/html/body/app-root/div/div/app-diagnostic/section[2]/p-sidebar[2]/div/app-bin-selector/div/div[3]/div/button[1]";
String loc_Testlocation3    = "/html/body/app-root/div/div/app-diagnostic/section[2]/p-sidebar[2]/div/app-bin-selector/div/div[2]/div/p-autocomplete/span/input";
String loc_completeTesting = "//button[contains(text(),'Complete Testing')]";


//Repair

String loc_RepairOption = "//a/span[contains(text(),'Repair')]";
String loc_RepairSerialNo = "//input[@placeholder ='Enter Serial / RO # to repair...']";
String loc_Repairloc = "/html/body/app-root/div/div/app-repair/section[2]/p-sidebar[1]/div/app-bin-selector/div/div[2]/div/p-autocomplete/span/input";
String loc_RepairlocSubmit = "/html/body/app-root/div/div/app-repair/section[2]/p-sidebar[1]/div/app-bin-selector/div/div[3]/div/button[1]";
String loc_Repairablechckbox = "//div/label[@class ='color-coded-radio has-success']";
String loc_NTFchckbox = "//div/label[@class ='color-coded-radio has-info']";
String loc_UnRepairablechckbox = "//div/label[@class ='color-coded-radio has-error']";
String loc_Repairnotes = "/html/body/app-root/div/div/app-repair/section[2]/div[4]/div/div/div/form/div[1]/div/div/textarea";
String loc_CompleteRepair = "//button[contains(text(),'Complete Repair')]";
String loc_Repaircancel = "//button[contains(text(),'Cancel')]";
String loc_RepairPartsbutton = "//button[contains(text(),'Request Parts')]";
String loc_RepairComponent = "/html/body/app-root/div/div/app-repair/section[2]/app-repair-detail/p-sidebar/div/section/div/div[2]/form/div/div[1]/div/div/p-autocomplete/span/input";
String loc_RepairSymptom = "/html/body/app-root/div/div/app-repair/section[2]/app-repair-detail/p-sidebar/div/section/div/div[2]/form/div/div[3]/div/div/p-autocomplete/span/input";
String loc_RepairDefect = "/html/body/app-root/div/div/app-repair/section[2]/app-repair-detail/p-sidebar/div/section/div/div[2]/form/div/div[4]/div/div/p-autocomplete/span/input";
String loc_RepairAddinfo = "/html/body/app-root/div/div/app-repair/section[2]/app-repair-detail/p-sidebar/div/section/div/div[2]/form/div/div[5]/div/button";
String loc_RepairSubmitPart = "//button[contains(text(),'Submit Request')]";
String loc_RepairPartInfosave = "//button[contains(text(),'Save')]";
String loc_Repairloc2 = "/html/body/app-root/div/div/app-repair/section[2]/p-sidebar[2]/div/app-bin-selector/div/div[2]/div/p-autocomplete/span/input";
String loc_Submitloc2 = "/html/body/app-root/div/div/app-repair/section[2]/p-sidebar[2]/div/app-bin-selector/div/div[3]/div/button[1]";
String loc_Repairloc3 ="/html/body/app-root/div/div/app-repair/section[2]/p-sidebar[2]/div/app-bin-selector/div/div[2]/div/p-autocomplete/span/input";
String  loc_Submitloc3 ="/html/body/app-root/div/div/app-repair/section[2]/p-sidebar[2]/div/app-bin-selector/div/div[3]/div/button[1]";
String loc_RepairAction = "/html/body/app-root/div/div/app-repair/section[2]/app-repair-detail/div/div[2]/div[1]/ul/li/div/div[5]/p-autocomplete/span/input";
//Quality Control

String loc_QualityOption ="//a/span[contains(text(),'Quality Control')]";
String loc_QualitySerNu = "//input[@placeholder ='Enter Serial / RO # ...']";
String loc_Qualityloc = "/html/body/app-root/div/div/app-quality-control/section[2]/p-sidebar[1]/div/app-bin-selector/div/div[2]/div/p-autocomplete/span/input";
String loc_Qualitylocsub = "/html/body/app-root/div/div/app-quality-control/section[2]/p-sidebar[1]/div/app-bin-selector/div/div[3]/div/button[1]";
String loc_QualityFail  = "//*[@id='qc-result-status-fail']";
String loc_QualityPass = "//*[@id='qc-result-status-pass']";
String loc_QualityInspcode  = "/html/body/app-root/div/div/app-quality-control/section[2]/div[2]/div/div/div[2]/div[2]/div/form/div/div[1]/div/p-autocomplete/span/input";
String loc_QualityAddInfo = "/html/body/app-root/div/div/app-quality-control/section[2]/div[2]/div/div/div[2]/div[2]/div/form/div/div[3]/div/button";
String loc_QualityCompleteQC = "/html/body/app-root/div/div/app-quality-control/section[2]/div[2]/div/div/div[2]/div[3]/button[2]";
String loc_QualityReset = "//button[contains(text(),'Reset')]";
String loc_Qualityloc2 = "/html/body/app-root/div/div/app-quality-control/section[2]/p-sidebar[2]/div/app-bin-selector/div/div[2]/div/p-autocomplete/span/input";
String loc_Qualitylocsub2 = "/html/body/app-root/div/div/app-quality-control/section[2]/p-sidebar[2]/div/app-bin-selector/div/div[3]/div/button[1]";
String loc_QualitylocPass = "/html/body/app-root/div/div/app-quality-control/section[2]/p-sidebar[2]/div/app-bin-selector/div/div[2]/div/p-autocomplete/span/input";
String loc_QualitylocSubPass = "/html/body/app-root/div/div/app-quality-control/section[2]/p-sidebar[2]/div/app-bin-selector/div/div[3]/div/button[1]";


//Packaging

String loc_PackOption ="//a/span[contains(text(),'Pack')]";
String loc_packlistno = "//input[@placeholder ='Enter new Packlist # ...']"; 
String loc_packlistnu = "//*[@id='print-section']/div/div[1]/div/div/div[1]/div/div/div/p-autocomplete/span/input"; 
String loc_CreatePaclist = "//*[@id='print-section']/div/div[3]/app-create-shipment/div/div[2]/div/div/div/span/button";
String loc_PackRMAno = "//input[@name ='formRmaNumber']"; 
String loc_packSerialNu = "//input[@placeholder ='Enter Serial / RO # to pack...']"; 
String loc_packaddinfo = "//button[contains(text(),'+ Add')]";
String loc_Completepack =  "//button[contains(text(),'Complete Pack')]";
String loc_CompletePackPrint = "//button[contains(text(),'Complete Pack & Print')]";
String loc_ValidationMessage = "/html/body/app-root/div/div/app-messages/div/p-growl/div/div[1]/div/div[2]/p";

//Shipment

String loc_Shipoption = "//a/span[contains(text(),'Ship')]";
String loc_ShipPacklist = "//*[@id='print-section']/div/div[1]/div/div/div[1]/div/div/div/p-autocomplete/span/input";
String loc_Shipserialnu = "//input[@placeholder ='Enter Serial / RO # to pack...']"; 
String loc_ShipAddinfo = "//*[@id='print-section']/div/div[1]/div/div/div[2]/div[2]/div/div/button";
String loc_ShipCarrier = "//*[@id='print-section']/div/div[1]/div[2]/form/div[2]/div[1]/div[1]/div/p-dropdown/div/label";
String loc_ShipTrackingnu ="//input[@name ='outboundTrackingNumber']"; 
String loc_Shipbutton ="//button[contains(text(),'Ship')]";
String loc_ShipAddconfirm = "//*[@id='print-section']/p-sidebar[2]/div/div/div[3]/div/button[2]";
String loc_ShipInfoContact = "//input[@name ='shipToContact']";
String loc_ShipInfoPhone = "//input[@name ='shipToPhone']";
String loc_ShipInfoAdress1 = "//input[@name ='shipToAddr1']";
String loc_ShipInfoCity = "//input[@name ='shipToCity']";
String loc_ShipInfoState = "//input[@name ='stateshipToStateProvinceCode']";
String loc_ShipInfoCountry = "//input[@name ='shipToCountry']";
String loc_ShipInfoWeight = "//*[@id='print-section']/p-sidebar[1]/div/component-carrier-ship/section[2]/form/div[2]/div/div/div[2]/div[1]/div[1]/div/p-spinner/span/input";

String loc_Shipinfounit = "//*[@id='print-section']/p-sidebar[1]/div/component-carrier-ship/section[2]/form/div[2]/div/div/div[2]/div[1]/div[2]/div/p-dropdown/div/label";
String loc_Shipinfolength = "//*[@id='print-section']/p-sidebar[1]/div/component-carrier-ship/section[2]/form/div[2]/div/div/div[2]/div[2]/div[1]/div/p-spinner/span/input";
String loc_Shipinfowidth = "//*[@id='print-section']/p-sidebar[1]/div/component-carrier-ship/section[2]/form/div[2]/div/div/div[2]/div[2]/div[2]/div/p-spinner/span/input";
String loc_ShipinfoHeight  = "//*[@id='print-section']/p-sidebar[1]/div/component-carrier-ship/section[2]/form/div[2]/div/div/div[2]/div[3]/div[1]/div/p-spinner/span/input";
String loc_ShipinfoMeasureunit  = "//*[@id='print-section']/p-sidebar[1]/div/component-carrier-ship/section[2]/form/div[2]/div/div/div[2]/div[3]/div[2]/div/p-dropdown/div/label";
String loc_Shiptype = "//*[@id='print-section']/p-sidebar[1]/div/component-carrier-ship/section[2]/form/div[3]/div/div/div[2]/div/div/div/p-dropdown/div/label";
String CarrierUPS ="//*[@id='print-section']/div/div[1]/div[2]/form/div[2]/div[1]/div[1]/div/p-dropdown/div/div[4]/div/ul/li[2]";
String loc_SubmittoUPS = "//button[contains(text(),'Submit to UPS')]";


// Settings-CreateParts

String loc_Settings = "//a[@href ='#/settings']";
String loc_CreateParts = "//a[@href ='#/parts' ]";
String loc_CreatePartsButton ="//button[contains(text(),'Create Part')]";
String loc_Partsname = "//input[@name ='partNumber']";
String loc_PartsDescription = "//div/textarea[@name ='description']";
String loc_Partfamily = "/html/body/app-root/div/div/app-parts/section[2]/div/p-sidebar[1]/div/part-editor-component/div/form/div[1]/div[1]/div[2]/div[1]/div/p-autocomplete/span/input";
String loc_PartType = "/html/body/app-root/div/div/app-parts/section[2]/div/p-sidebar[1]/div/part-editor-component/div/form/div[1]/div[1]/div[2]/div[2]/div/p-autocomplete/span/input";
String loc_PartOrigin ="/html/body/app-root/div/div/app-parts/section[2]/div/p-sidebar[1]/div/part-editor-component/div/form/div[1]/div[1]/div[2]/div[3]/div/p-autocomplete/span/input";

String loc_AvailableMapvalue = "/html/body/app-root/div/div/app-parts/section[2]/div/p-sidebar[1]/div/part-editor-component/div/form/div[1]/div[2]/div/div[1]/p-listbox/div/div[3]/div[2]/input";

String loc_throwtoMapped = "//button[@class ='btn btn-default wd-xxs']";
String loc_CreatePartSubmit = "//button[contains(text(),'Submit')] ";

String loc_Partfilter =  "//input[@name ='orderNumber']";
String loc_filterApply = "//button[contains(text(),'Apply')]";

//Setting - CreateBranches
String loc_CreateBranch = "//a[@href='#/branches']";
String loc_CreateBranchButton = "//button[contains(text(),'Create Branch')]";
String loc_BranchRegion = "//*[@id='locationRegion']/div/label";
String loc_BranchName = "//*[@id='locationName']";
String loc_BranchAddress = "//*[@id='addr1']";
String loc_BranchCity = "//*[@id='city']";
String loc_BranchState = "//*[@id='state']";
String loc_BranchCountry = "//*[@id='country']";
String loc_BarnchZip = "//*[@id='zip']";
String loc_BranchTimeZone = "/html/body/app-root/div/div/app-locations/section[2]/p-sidebar[1]/div/app-location-editor/div/form/div[1]/div/div[2]/div[2]/p-autocomplete/span/input";
String loc_BranchContact  ="//*[@id='contactName'] ";
String loc_BranchContactPhone = "//*[@id= 'contactPhone']";
String loc_BranchEmail = "//*[@id= 'contactEmail']";
String loc_BranchCTDIlocChkbox = "/html/body/app-root/div/div/app-locations/section[2]/p-sidebar[1]/div/app-location-editor/div/form/div[1]/div/div[2]/div[6]/p-checkbox/div/div[2]";
String loc_Createlocbutton = "//button[contains(text(),'Create Location')]";

//PickParts

String loc_Pickpartsoptions = "//a/span[contains(text(),'Pick Parts')]";

String loc_pickorders = "/html/body/app-root/div/div/component-picking-component/section[2]/div/div/div/div[1]/div/div/div/div/p-dropdown/div/label";
String loc_scanPart = "//input[@placeholder ='Scan Part #']";
String loc_scanloc = "//input[@placeholder ='Scan Location #']";
String loc_Comp   =  "//table/tbody/tr/td[1]/div";
String loc_PartpickSubmit =  "//button[contains(text(),'Submit')]";
String loc_PartsPickingPrinter ="//input[@placeholder ='Enter/Select Printer ...']";

//Deliver parts

String loc_DeliverPartsOptions = "//a/span[contains(text(),'Deliver Parts')]";
String loc_DeliverOrderno = "//input[@name ='orderNumber']";
String loc_DeliverSerialno = "//input[@name ='serialNumberOrAssetTag']";
String loc_PartDelvrySubmit =  "//button[contains(text(),'Submit')]";

//Component Receiving

String loc_CmRecLocation = "//input[@placeholder ='Enter Location # ...']";

String loc_CmRecModel = "//input[@placeholder ='Enter Model # ...']";

String loc_CmRecSerial =  "//input[@name ='serialNumber']";

String loc_compAddlistbutton = "//button[contains(text(),'Add to list')]";

String loc_CompRecvSubmit = "//button[contains(text(),'Submit')]";


//component putaway


String loc_CmputModal = "/html/body/app-root/div/div/app-repair-component-putaway/section[2]/form/div/div/div/div/div/div/p-autocomplete/span/input";
String loc_CmputSerial = "//input[@name ='serialNumber']";
String loc_Cmputin = "//input[@name ='toBin']";
String loc_cmputSubmit = "//button[contains(text(),'Submit')]";

//logsviewer



//ManageRegion
String loc_ManageRegion = "//a[@href='#/regions']";

String loc_CreateRegion = "//button[contains(text(),'Create Region')]";

String loc_RegionName = "//*[@id='manageregionName']";

String loc_RegionTimeZone = "/html/body/app-root/div/div/app-manage-regions/section[2]/p-sidebar[1]/div/app-manage-regions-editor/div/form/div[1]/div/div/div[2]/p-autocomplete/span/input";
String loc_RegionCreated = "/html/body/app-root/div/div/app-manage-regions/section[2]/p-sidebar[1]/div/app-manage-regions-editor/div/form/div[2]/div/button[2]";
String loc_DeleteRegion =" //button[contains(text(),'Delete Region')]";


//UserMaster

String loc_UserMaster = "//a[@href='#/users']";

String loc_CreateNewuser = "//button[contains(text(),'Create New User')]";

String loc_UserFname = "//*[@id='firstName']";
String loc_UserLastname = "//*[@id='lastName']";
String loc_UserUsername = "//*[@id='userName']";
String loc_UserEmail = "//*[@id='email']";

String loc_UserRole = "//input[@placeholder ='Select Role']";










}