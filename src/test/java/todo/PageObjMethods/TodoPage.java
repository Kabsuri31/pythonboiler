package todo.PageObjMethods;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Alert;
import org.openqa.selenium.Keys;
import java.util.*;
import java.net.MalformedURLException;
import java.net.URL;

import todo.Generic.TestBase.testBase;

public class TodoPage extends testBase{
  private WebDriver driver = todo.Generic.TestBase.BrowserConfig.getDriver();
  private Map<String, Object> vars;
  JavascriptExecutor js;
  
  public void setUp() {
   // driver = new ChromeDriver();
    js = (JavascriptExecutor) driver;
    vars = new HashMap<String, Object>();
  }
  
  public void tearDown() {
    driver.quit();
  }
  
  public void untitled() {
    driver.get("applicationURL");
    driver.manage().window().setSize(new Dimension(1062, 664));
    driver.findElement(By.name("name")).click();
    driver.findElement(By.name("name")).sendKeys("har");
    driver.findElement(By.name("description")).click();
    driver.findElement(By.name("description")).sendKeys("ds");
    driver.findElement(By.cssSelector(".btn")).click();
    driver.findElement(By.name("name")).click();
    driver.findElement(By.name("name")).sendKeys("dsd");
    driver.findElement(By.name("description")).click();
    driver.findElement(By.name("description")).sendKeys("sd");
    driver.findElement(By.cssSelector(".btn")).click();
    driver.close();
  }
}
