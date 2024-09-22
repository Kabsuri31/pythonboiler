package todo.Functional;

import java.io.IOException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import todo.Generic.TestBase.*;
import todo.PageObjMethods.TodoPage;

public class todo extends testBase {
	public static boolean classname = false;
	private WebDriver driver = null;

	@BeforeClass
	public void initSetUp1() throws IOException, InterruptedException {
		driver = BrowserConfig.getDriver();
		try {
			if (driver == null)
				System.out.println("---Driver not found---");
	
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		System.out.println("chrome driver version is : " + driver);

	}

	@Test(priority = 0)
	public void TodoTest() throws InterruptedException, IOException {

		TodoPage todoPage = PageFactory.initElements(driver, TodoPage.class);
		todoPage.untitled();
	}
}
