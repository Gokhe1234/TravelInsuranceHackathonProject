package testBase;

import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.time.Duration;
import java.util.Properties;
import java.util.Scanner;



 
 
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

public class BaseClass {
	
	public static WebDriver driver;
	public Logger logger;
	Properties p;
	@Parameters({"os","browser"})
	@BeforeClass
	public void openUrl(String os , String browser) throws IOException{
	    
//		System.out.println("Select the driver you want...?");
//		System.out.println("1.Chrome Driver   2.Edge Driver");
//		Scanner sc =new Scanner(System.in);
//		int input=sc.nextInt();
//		
//		if(input==1) {
//			driver=new ChromeDriver();
//			
//		}
//		else{
//			driver=new EdgeDriver();
//			
//		}
		logger=LogManager.getLogger(this.getClass());
		FileReader file = new FileReader(".//src/test/resources/properties.config");
		p = new Properties();
		p.load(file);
		
		if(p.getProperty("execution_env").equalsIgnoreCase("remote")) {
			DesiredCapabilities capabalities = new DesiredCapabilities();
			//os
			if(os.equalsIgnoreCase("windows")) {
				capabalities.setPlatform(Platform.WIN11);
			}
			else if (os.equalsIgnoreCase("mac")) {
				capabalities.setPlatform(Platform.MAC);
			}
			else {
				System.out.println("no matching os .....");
				return;
			}
			//browser
			if(browser.equalsIgnoreCase("chrome")) {
				capabalities.setBrowserName("chrome");
			}
			else if(browser.equalsIgnoreCase("edge")) {
				capabalities.setBrowserName("MicrosoftEdge");
			}
			else {
				System.out.println("no matching browser .....");
				return;
			}
 
			 driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub") , capabalities);
		}
		else if(p.getProperty("execution_env").equalsIgnoreCase("local")) {
			
			ChromeOptions option = new ChromeOptions();
			EdgeOptions options = new EdgeOptions();
			option.addArguments("--disable-blink-features=AutomationControlled");
			option.addArguments("--disable-notifications");
			options.addArguments("--disable-blink-features=AutomationControlled");
			options.addArguments("--disable-notifications");
			//driver=new ChromeDriver(option);
			if(browser.equalsIgnoreCase("chrome")) {
				driver = new ChromeDriver(option);
				logger.info("Chrome browser opened successfully");
				
			}
			else if(browser.equalsIgnoreCase("edge")){
				driver = new EdgeDriver(options);
				logger.info("Edge browser opened successfully");
			}
			else {
				System.out.println("no matching browser......");
				logger.info("no matching browser......");
				return;
			}
		}
		
	
		driver.get("https://www.policybazaar.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(35));

	}
	
	
	@AfterClass
	public void closeBowser() {
		 driver.quit();
	 }
	



}
