package testCase;

import org.testng.annotations.Test;

import pageObject.CarInsurancePage;
import testBase.BaseClass;
import utilities.ExcelUtility;
import utilities.ScreenShots;

public class TC_002_CarInsurenceDetails extends BaseClass {
	public static String path;
	@Test
	public void CarInsurenceDetails() throws Exception {
		
		logger.info("**** starting TC_002_CarInsurenceDetails  *****");
		CarInsurancePage cip=new CarInsurancePage(driver);
		cip.carInsurance();
		logger.info("Open of Car Insurance Page ");
		path=ScreenShots.screenShots(driver, "Car Insurance Page");
		cip.buyCar();
		cip.getSearchRto();
		cip.selectCityOption();
		cip.selectCarOption();
		cip.carModelOption();
		cip.fuelTypeOption();
		cip.carVariantOption();
		cip.carVariantMode();
		logger.info("Filled all car Datail ");
		cip.getName(ExcelUtility.readExcel(1));
		
		cip.getEmail(ExcelUtility.readExcel(2));
		
		cip.getMobilNo(ExcelUtility.readExcel(3));
		
		cip.getErrorMessage();
		path=ScreenShots.screenShots(driver, "Error Message");
		logger.info("Capture Message.. ");
	  
		logger.info(" Finished TC_002_CarInsurenceDetailss ");
		
		cip.clearEmail();
		
		
	}

}
