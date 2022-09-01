import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class SeleniumLoader implements SeleniumDrivers {

	private enum BROWSERS {
		EDGE, FIREFOX, CHROME
	};

	WebDriver driver = null;

	public SeleniumLoader() {
		this.getDriverProperties();

	}

	public WebDriver loadDriver() {
		System.setProperty("webdriver.edge.driver", getDriverProperties());
		driver = new ChromeDriver();
		return driver;
	}

	// TODO
	public WebDriver loadDriver(String property) throws IOException {
		System.setProperty("webdriver.edge.driver", getDriverProperties(property));
		driver = new ChromeDriver();
		return driver;
	
	}

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
}
