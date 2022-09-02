package StepDefinition;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class GoogleSearchSteps {
	final static String EDGE = "EDGE";
	WebDriver driver = null;

	// setup test.properties to point to your Selenium driver location.
	public String getDriverProperties() {
		Properties prop = new Properties();
		final String SOME_PROP_ENV_NAME = "SELENIUM";

		try {
			prop.load(new FileReader("test.properties"));
			String propValue = prop.getProperty("CHROME", System.getenv().get(SOME_PROP_ENV_NAME));
			System.out.println(propValue);
			return propValue;
		} catch (IOException e) {
			e.printStackTrace();
			return null;
		}
	}

	public String getDriverProperties(String property) {
		Properties prop = new Properties();
		final String SOME_PROP_ENV_NAME = "SELENIUM";

		try {
			prop.load(new FileReader("test.properties"));
			String propValue = prop.getProperty(property, System.getenv().get(SOME_PROP_ENV_NAME));
			System.out.println(propValue);
			return propValue;
		} catch (IOException e) {
			e.printStackTrace();
			return null;
		}
	}

	/*@SuppressWarnings("deprecation")
	@Given("browser is open")
	public void browser_is_open() {
		// Write code here that turns the phrase above into concrete actions

		System.setProperty("webdriver.edge.driver", getDriverProperties(EDGE));
		driver = new EdgeDriver();
		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);

		driver.manage().window().maximize();

	}

	@Given("user is on google search page")
	public void user_is_on_google_search_page() {
		// Write code here that turns the phrase above into concrete actions
		driver.navigate().to("https://www.google.com");
		// driver.getTitle();
	}

	@When("user enters a text in search box")
	public void user_enters_a_text_in_search_box() throws InterruptedException {
		// Write code here that turns the phrase above into concrete actions
		driver.findElement(By.xpath("/html/body/div[1]/div[3]/form/div[1]/div[1]/div[1]/div/div[2]/input"))
				.sendKeys("Bible");
		Thread.sleep(2000);
	}

	@When("hits enter")
	public void hits_enter() {
		driver.findElement(By.xpath("/html/body/div[1]/div[3]/form/div[1]/div[1]/div[1]/div/div[2]/input"))
				.sendKeys(Keys.ENTER);
	}

	@Then("user is navigated to search results")
	public void user_is_navigated_to_search_results() {
		driver.findElement(
				By.xpath("//*[@id=\"rcnt\"]/div[1]/div/div/div[3]/div[1]/div/div[2]/div/div/div/div[1]/span"))
				.equals("The Bible");
		driver.close();
		driver.quit();
	}
*/
}
