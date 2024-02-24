package testCase;

import org.testng.annotations.Test;

import pageObject.HealthInsurancePage;
import testBase.BaseClass;
import utilities.ExcelUtility;
import utilities.ScreenShots;

public class TC_003_HealthInsurancePlan extends BaseClass{
	public static String path;
	@Test
	public void HealthInsurancePlan() throws Exception {
		logger.info("**** starting TC_003_HealthInsurancePlan  *****");
		HealthInsurancePage hip=new HealthInsurancePage(driver);
		hip.getHealthInsurance();
		path=ScreenShots.screenShots(driver, "Health Insurance Page");
		hip.getContinueBtn();
		hip.getAge();
		hip.getContinueBtn2();
		hip.GetCitySelect();
		hip.getFullName(ExcelUtility.readExcel(4));
		hip.getMobileNumber(ExcelUtility.readExcel(5));
		hip.continueBt3();
		hip.getMedical();
		hip.getInsurance();
		hip.getOfficeInsurance();
		hip.getViewBtn();
		
		hip.allHealthInSu();
		path=ScreenShots.screenShots(driver, "Health Insurance package");
		logger.info(" Finished TC_003_HealthInsurancePlan ");
		
		logger.info("**** Finished TC_003_HealthInsurancePlan  *****");
	}

}
