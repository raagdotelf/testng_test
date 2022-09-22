package page_object;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

public class BaseClass {
	WebDriver driver;

	// String url= "https://www.easemytrip.com/";
	/*
	 * @Test public void test() throws IOException { driver.get(url); String t =
	 * driver.getTitle(); System.out.println(driver.getTitle());
	 * driver.manage().window().maximize();
	 * 
	 * }
	 */
	@BeforeTest
	public void beforeTest() throws Exception {
//		FirefoxOptions options = new FirefoxOptions();
//		options.addArguments("--disable-notifications");
//		System.setProperty("webdriver.gecko.driver",
//				"D:\\Users\\Temp\\eclipse-workspace\\EaseMyTrip\\src\\test\\resources\\WebDriver\\geckodriver.exe");
//		driver = new FirefoxDriver();
		
		System.setProperty("webdriver.chrome.driver", "src/test/resources/WebDriver/chromedriver.exe");
		driver=new ChromeDriver();
		driver.get("https://www.easemytrip.com/");
		String t = driver.getTitle();
		System.out.println(t);
		driver.manage().window().maximize();
		Thread.sleep(3000);
		/*
		 * Alert a= driver.switchTo().alert(); a.dismiss(); Thread.sleep(1000);
		 */
	}

	@AfterTest
	public void afterTest() throws Exception {
		Thread.sleep(3000);
		driver.quit();
	}

}
