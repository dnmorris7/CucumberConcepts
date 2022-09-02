package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
	WebDriver driver;
	By txt_username = By.xpath("//*[@id=\"name\"]");
	By txt_password = By.xpath("//*[@id=\"password\"]");
	By btn_login = By.xpath("/html/body/div[2]/div[1]/form/div[3]/button");
	By btn_logout = By.xpath("//*[@id=\"logout\"]");

	public LoginPage(WebDriver driver) {
		this.driver = driver;

	}

	public void enterUsername(String username) {

		driver.findElement(txt_username).sendKeys(username);

	}

	public void enterPassword(String password) {
		driver.findElement(txt_password).sendKeys(password);

	}

	// click the login button
	public void clickButton() {
		driver.findElement(btn_login).click();
	}

	public void validateLogin(String username, String password) {
		driver.findElement(txt_username).sendKeys(username);
		driver.findElement(txt_password).sendKeys(password);
		driver.findElement(btn_login).click();
	}

	public void validateHomepage() {

	}

	public void validateLogoutButton() {
		driver.findElement(btn_logout);
	}

	public void quit() {
		driver.close();
		driver.quit();
		// TODO Auto-generated method stub

	}
}
