package pageObject;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CarInsurancePage extends BasePage{
	public static String CarPlans;
	JavascriptExecutor js=(JavascriptExecutor)driver;
	
	public CarInsurancePage(WebDriver driver) {
		super(driver);
		
	}
	 
	
	@FindBy(xpath="(//i[@class='icon-bg homeIconsBg car-insurance'])[2]")
	WebElement carInsuranceClick;
	
	
	@FindBy(linkText="Buying a new car? Click here")
	WebElement buyingCar;
	
	@FindBy(xpath="//span[@class='CarRegDetails_blueTextButton__P1blP blueTextButton fontMedium']")
	WebElement updatedBuyingCar;
	
	@FindBy(xpath="//*[@id=\"searchInput\"]/div/input")
	WebElement searchRto;
	
	@FindBy(xpath="//div[@class='dropdown']")
	WebElement updatedSearchRto;
	
	@FindBy(xpath="//span[normalize-space()='Pune']")
	WebElement updatedCity;
	
	@FindBy(xpath="//li[normalize-space()='MH12']")
	WebElement updatedCode;
	
	@FindBy(xpath="//span[text()='MH35-GONDIA(Maharashtra)']")
	WebElement selectCity;
	
	@FindBy(xpath="//span[normalize-space()='TATA']")
	WebElement selectCar;
	
	@FindBy(xpath="//li[normalize-space()='NEXON']")
	WebElement carModel;
	
	@FindBy(xpath="//li[normalize-space()='Petrol']")
	WebElement fuelType;
	
	@FindBy(xpath="//li[text()='Automatic']")
	WebElement carVariant;
	
	@FindBy(xpath="//li[normalize-space()='Creative Plus 1.2 Revotron Petrol 6AMT (1199 cc)']")
	WebElement carVariantModel;
	
	@FindBy(xpath="//li[normalize-space()='Brand New Car']")
	WebElement BrandNC;
	
	@FindBy(xpath="//*[@id=\"name\"]")
	WebElement name;
	
	@FindBy(xpath="//input[@placeholder='Full name']")
	WebElement updatedName;
	
	@FindBy(xpath="//*[@id=\"email\"]")
	WebElement email;
	
	@FindBy(xpath="//input[@placeholder='Your email']")
	WebElement updatedEmail;
	
	@FindBy(xpath="//*[@id=\"mobileNo\"]")
	WebElement mobilNo;
	
	@FindBy(xpath="//input[@placeholder='Mobile number']")
	WebElement updatedMobilNo;
	
	@FindBy(xpath="//div[@class='msg-error show']")
	public WebElement errorMessage;
	
	@FindBy(xpath="//div[@class='errorMsg']")
	public WebElement updatederrorMessage;
	

	@FindBy(xpath="//a[@class='pb-logo']")
	WebElement logoClick2;
	
	@FindBy(xpath="//div[@class='logo']")
	WebElement updatedlogoClick2;
	
	

	
	public void carInsurance() {
		carInsuranceClick.click();
	}
	
	public void buyCar() {
		try {
			buyingCar.click();
		}
		catch(Exception e) {
			updatedBuyingCar.click();
		}
	}
	
	public void getSearchRto() {
		try {
			searchRto.click();
		}
		catch(Exception e) {
			updatedSearchRto.click();
		}
	}
	
	public void selectCityOption() {
		try {
			selectCity.click();
		}
		catch(Exception e) {
			updatedCity.click();
			updatedCode.click();
		}
	}
	
	public void selectCarOption() {
		selectCar.click();
	}
	public void carModelOption() {
		carModel.click();
	}
	
	public void fuelTypeOption() {
		fuelType.click();
	}
	public void carVariantOption() {
		carVariant.click();
	}
	
	public void carVariantMode() {
		carVariantModel.click();
	}
	public void getName(String name1) {
		
		try {
			name.sendKeys(name1);
		}
		catch(Exception e) {
			updatedName.click();
			updatedName.sendKeys(name1);
		}
	}
	public void getEmail(String mail) {
		
		try {
			email.sendKeys(mail);
		}
		catch(Exception e) {
			updatedEmail.click();
			updatedEmail.sendKeys(mail);
		}
	}
	public void getMobilNo(String mobil) {
		try {
			mobilNo.sendKeys("9876543468");
		}
		catch(Exception e) {
			updatedMobilNo.click();
			updatedMobilNo.sendKeys("9876543468");
		}
	}
	
	public void getErrorMessage() {
		
		System.out.println("---Capture the error message--- ");
		try {
		    System.out.println( errorMessage.getText());
		}
		catch(Exception e) {
			System.out.println( updatederrorMessage.getText());
		}
	}
	
	public void clearEmail() throws InterruptedException {
		
		
		try {
			email.clear();
		}
		catch(Exception e) {
		
			js.executeScript("arguments[0].value=''", updatedEmail);
			
		}
	}
	public void correctEmail(String mail1) {
		
		try {
			email.sendKeys(mail1);
		}
		catch(Exception e) {
			updatedEmail.click();
			updatedEmail.sendKeys(mail1);
		}
	}
	
	public void logoClickBack() {
		try{
			logoClick2.click();
		}
		catch(Exception e) {
			updatedlogoClick2.click();
		}
	}


}
