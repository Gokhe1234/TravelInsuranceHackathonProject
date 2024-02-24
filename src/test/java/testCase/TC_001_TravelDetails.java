package testCase;

import org.testng.annotations.Test;

import pageObject.PolicyBazzarPage;
import pageObject.TravelInsurancePage;
import pageObject.TravelPlanPage;
import testBase.BaseClass;
import utilities.ExcelUtility;
import utilities.ScreenShots;

public class TC_001_TravelDetails extends BaseClass {
	public static String path;
    
	@Test(priority=1)
	public void travelDetails() throws Exception 
	{
		//logger.debug("application logs started......");
		logger.info("**** starting TC_001_TravelDetails  *****");
		
		PolicyBazzarPage pbp = new PolicyBazzarPage(driver);
		pbp.travelInsu();
		path=ScreenShots.screenShots(driver, "Policy Bazzar Page");
		logger.info("Opening of Travel Insurance Page ");
		TravelInsurancePage tip = new TravelInsurancePage(driver);
		tip.destination();
		logger.info("Entering customer details.. ");
		path=ScreenShots.screenShots(driver, "City Select");
		tip.getNextButton();
		
		tip.getSubmeetbutton();
		logger.info("clicked on continue..");
		tip.getSearchClick();
		tip.getNextbutton2();
		tip.studentSelect();
		logger.info("Sellect Student...");
		tip.getSelectAgeOption1();
		tip.getAgeOptions1();
		tip.getSelectAgeOption2();
		tip.getAgeOption2();
		tip.getnextButton3();
		logger.info("clicked on continue..");
		tip.getMedicalCondition();
		logger.info("Medical Condotion..");
		tip.getNextButton4();
		tip.MobileNo(ExcelUtility.readExcel(0));
		tip.viewPlan();
		logger.info("View all plans..");
		path=ScreenShots.screenShots(driver, "Student Plan");
		
		TravelPlanPage tp=new TravelPlanPage(driver);
		tp.getStudentPlan();
		
		tp.getTraveller1();
		tp.getTraveller2();
		tp.tripDurationTime();
		tp.applyButton();
		logger.info("clicked on continue..");
		tp.getSortBy();
		tp.lowHigh();
		tp.getData();
		logger.info("All student first 3 plan..");
		
		//logger.debug("application logs end.......");
		logger.info("**** finished TC_001_TravelDetails  *****");

		

	}
	
	
	
	

		
	
	

}
