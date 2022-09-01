import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public interface SeleniumDrivers {
	// setup test.properties to point to your Selenium driver location.
	public String getDriverProperties();

	public String getDriverProperties(String property);
}
