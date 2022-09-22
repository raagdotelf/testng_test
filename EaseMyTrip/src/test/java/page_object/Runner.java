package page_object;

import java.io.FileNotFoundException;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

public class Runner extends BaseClass {
	SearchFlight sf;

	@Test
	public void RunSearchFlight() throws Exception {
		SearchFlight sf = PageFactory.initElements(driver, SearchFlight.class);

		sf.cities("Mumbai", "Lucknow");
		sf.selectdepdate("25");

	}
}
