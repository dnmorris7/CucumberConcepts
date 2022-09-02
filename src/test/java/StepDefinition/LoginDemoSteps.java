package StepDefinition;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import java.util.logging.*;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

import io.cucumber.java.en.*;
import pages.LoginPage;

@Deprecated
public class LoginDemoSteps {
	// initialize logger
	private static Logger log = Logger.getLogger("LoginDemoSteps.class");
	// set log level to info
	WebDriver driver = null;
	LoginPage loginPage = null;
	String testURL = "https://example.testproject.io/web";

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
	/*
	 * @SuppressWarnings("deprecation")
	 * 
	 * @Given("browser is open")
	 * 
	 * public void browser_is_open() { // Write code here that turns the phrase
	 * above into concrete actions
	 * 
	 * System.setProperty("webdriver.edge.driver",
	 * "C:/seleniumdrivers/msedgedriver.exe"); driver = new EdgeDriver();
	 * driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
	 * driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
	 * 
	 * driver.manage().window().maximize();
	 * 
	 * }
	 */

	@Given("demo test browser is open")
	public void demo_test_browser_is_open() {
		Logger.getAnonymousLogger().setLevel(Level.INFO);
		System.out.println("=====LOGIN_DEMO_INITIALIZE=====");
		String projectPath = System.getProperty("user.dir")+"\\src\\test\\resources\\drivers\\";
		log.info("Project Path: " + projectPath);

		System.setProperty("webdriver.edge.driver", projectPath+"msedgedriver.exe");
		driver = new EdgeDriver();
		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);

		driver.manage().window().maximize();
	}

	@And("login demo user is on login page")
	public void login_demo_user_is_on_login_page() throws InterruptedException {
		try {
			driver.navigate().to(testURL);
		} catch (Exception e) {

			e.printStackTrace();
		}
		Thread.sleep(2000);
	}

	@When("^user enters (.*) and (.*)$")
	public void user_enters_username_and_password(String username, String password) {
		loginPage = new LoginPage(driver);
//		loginPage.validateLogin(username, password);
		System.out.println("==Entering Username: "+ username);
		loginPage.enterUsername(username);
		
		System.out.println("==Entering Password: "+ password);
		loginPage.enterPassword(password);
	}

	@When("user clicks on login")
	public void user_clicks_on_login() throws Exception{
		loginPage.clickButton();
	}

	@Then("user is navigated to the homepage")
	public void user_is_navigated_to_the_homepage() {
		loginPage.validateLogoutButton();
		loginPage.quit();

	}
}
