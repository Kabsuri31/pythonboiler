package todo.Generic.TestBase;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

import org.openqa.selenium.*;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
//adding crossbrowser change, testng name 

public class BrowserConfig extends testBase{
	public static WebDriver driver;
	
	static String driverPath = "./Drivers_Jars";
	
	
	
	//Public function called by every page object to get driver post configuring browser executable and launching the URL passed through testng.xml
	public static WebDriver getDriver() 
	{
		return driver;
	}
	
	//Private function to set browser executable and to launch URL based on browsertype and URL passed through testng.xml
	protected static void setDriver(String browserType, String appURL) throws MalformedURLException, InterruptedException 
	{
		switch (browserType) 
		{
		case "chrome":
			
			  if(osystem.equals("Windows 10"))
			{
				//local run
				ChromeOptions options = new ChromeOptions();
				options.addArguments("--disable-notifications");
				System.out.println("testing chrome locally");
				System.out.println("Launching google chrome..");
				
				System.setProperty("webdriver.chrome.driver", driverPath+"/chromedriver.exe");
				
				driver=new ChromeDriver(options);
				driver.manage().window().maximize();
				driver.navigate().to(appURL);
				break;
				
			}
			
			else
			{
				 ChromeOptions options = new ChromeOptions().setHeadless(true);
				 options.addArguments("--disable-dev-shm-usage");
				 options.setAcceptInsecureCerts(true);
				 options.setCapability("build", "Testing Chrome Options [Selenium 4]");
                 options.setCapability("name", "Testing Chrome Options [Selenium 4]");
                 options.setCapability("browserName", "chrome");
                
				 System.out.println("RemoteWebdriver set test");
					 try {
                            driver = new RemoteWebDriver(new URL("http://selenium-hub:4444"), options);
							driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
							//driver.manage().window().maximize();

                         } catch (MalformedURLException e) {
                                 System.out.println("Invalid grid URL");
                                  }
								  driver.navigate().to(appURL);
								  break;
					
			}
		   
			
			
		case "firefox":	
			  if(osystem.equals("Windows 10"))
			 {
				//local run
				    FirefoxOptions options = new FirefoxOptions();
					options.addArguments("--disable-notifications");
				    System.out.println("testing firefox locally");
				    System.out.println("Launching mozilla firefox..");

					System.setProperty("webdriver.gecko.driver", driverPath+"/geckodriver.exe");

					driver=new FirefoxDriver();
					driver.manage().window().maximize();
					driver.navigate().to(appURL); 
					break;
			 }
			 
			 else
			 {
				//Jenkins run
					FirefoxOptions options = new FirefoxOptions().setHeadless(true);
					options.addArguments("--disable-dev-shm-usage");
                    options.setAcceptInsecureCerts(true);
					options.setCapability("build", "Testing Firefox Options [Selenium 4]");
                    options.setCapability("name", "Testing Firefox Options [Selenium 4]");
					options.setCapability("browserName", "Firefox");

					System.out.println("RemoteWebdriver set test");
					 try {
                            driver = new RemoteWebDriver(new URL("http://selenium-hub:4444"), options);
							driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
							//driver.manage().window().maximize();

                         } catch (MalformedURLException e) {
                                 System.out.println("Invalid grid URL");
                                  }
								  driver.navigate().to(appURL);
								  break;
								  
			 }
			
			
		default:
			  if(osystem.equals("Windows 10"))
			{
				//local run
				ChromeOptions options = new ChromeOptions();
				options.addArguments("--disable-notifications");
				System.out.println("testing chrome locally");
				System.out.println("Launching google chrome..");
				System.setProperty("webdriver.chrome.driver", driverPath+"/chromedriver.exe");
				driver=new ChromeDriver(options);
				driver.manage().window().maximize();
				driver.navigate().to(appURL);
				break;
				
			}
			
			else
			{
				 ChromeOptions options = new ChromeOptions().setHeadless(true);
				 options.addArguments("--disable-dev-shm-usage");
				 options.setAcceptInsecureCerts(true);
				 options.setCapability("build", "Testing Chrome Options [Selenium 4]");
                 options.setCapability("name", "Testing Chrome Options [Selenium 4]");
                 options.setCapability("browserName", "chrome");
                
				 System.out.println("RemoteWebdriver set test");
					 try {
							driver = new RemoteWebDriver(new URL("http://selenium-hub:4444"), options);
							//driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
							driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
							//driver.manage().window().maximize();

                         } catch (MalformedURLException e) {
                                 System.out.println("Invalid grid URL");
                                  }
								  driver.navigate().to(appURL);
								  break;
								  		
			}
		   
			
			
		}
	}



}


