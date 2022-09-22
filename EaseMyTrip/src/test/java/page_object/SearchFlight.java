package page_object;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Date;
import java.util.List;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class SearchFlight {
	WebDriver driver;

	// select from city
	@FindBy(id = "frmcity")
	WebElement fromcity;

	@FindBy(id = "a_FromSector_show")
	WebElement writefrom;

	@FindBy(xpath =  "//div[@id='fromautoFill']//span[contains(text(),'Mumbai')]")
	WebElement selectFromSuggestion;
	// select dest city
	@FindBy(id = "tocity")
	WebElement tocity;

	@FindBy(id = "a_Editbox13_show")
	WebElement writeto;

	@FindBy(linkText = "Goa(GOI)")
	WebElement selecttoSuggestion;

	@FindBy(id = "dvfarecal")
	WebElement depdate;
	
	@FindBy(xpath = "//i[@id='iDownArr']")
	WebElement trcl;
	
	@FindBy(css = "input[type='button']")
	WebElement searchbutton;

	
	
	public SearchFlight(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void cities(String from, String to) throws InterruptedException {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

		fromcity.click();
		writefrom.sendKeys(from);
		driver.findElement(By.xpath("//div[@id='fromautoFill']//span[contains(text(),'"+from+"')]")).click();
		Thread.sleep(3000);
		tocity.click();
		writeto.sendKeys(to);
		driver.findElement(By.xpath("//div[@id='toautoFill']//span[contains(text(),'"+ to +"')]")).click();
		Thread.sleep(3000);
		// js.executeScript("arguments[0], scrollIntoView(200)");

	}

	public void selectdepdate(String date) throws Exception {
		driver.findElement(By.id("ddate")).click();
		driver.findElement(By.xpath("//div[@class='box']//li[text()='"+date+"']")).click();
		
		Thread.sleep(2000);
		
		driver.findElement(By.xpath("//button[@class='srchBtnSe']")).click();

	}
}

/*
 * fromcity.click(); /* Properties prop = new Properties(); prop.load(new
 * FileInputStream(
 * "D:\\Users\\Temp\\eclipse-workspace\\EaseMyTrip\\src\\main\\resources\\config.properties"
 * )); // writefrom.click();
 * 
 * Select from=new Select(fromcity); from.selectByIndex(8); // fromcity.click();
 * 
 * tocity.click(); Select to =new Select(tocity); to.selectByIndex(2); //
 * selecttoSuggestion.click();
 */

/*
 * By oneway =By.id("oway"); By Source = By.id("FromSector_show"); By Dest =
 * By.xpath("//div[@class=\"fss_flex arrcity_colm sechver\"]"); By DepDate =
 * By.xpath("//input[@id=\"ddate\"]"); By RetDate =
 * By.xpath("//div[@id=\"rdatelbl\"]"); By TravClass =
 * By.xpath("//div[@id=\"trvlr_colm\"]"); By SearchButton =
 * By.xpath("//button[@type=\"button\"]");
 * 
 * 
 * public void RunSearchFlight() { driver.findElement("")
 * 
 * WebElement fp = driver.findElement(Source); Select dp= new Select(fp);
 * dp.selectByIndex(2);
 * 
 * 
 * 
 * 
 * //DepDate //RetDate //TravClass
 * 
 * driver.findElement(SearchButton).click();
 * 
 * 
 * // ("        (//  a [ contains( text() ,   'Hotels' ) ]  )     [1]    ") }}
 * 
 */
