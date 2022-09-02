package StepDefinition;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginSteps {

	public void verifyLoginPage() {
		System.out.println("Hello World");
	}

	@Given("user is on login page")
	public void user_is_on_login_page() {
		System.out.println("==LoginSteps.java Has Begun==");
		System.out.println("Login Step 1: User enters username and password");
	}

	@When("user enters login")
	public void user_enters_login() {
		System.out.println("Login Step 2: User has entered password");
	}

	@When("clicks on the login button")
	public void clicks_on_the_login_button() {
		System.out.println("Login Step 3: User has clicked the login button");
	}

	@Then("user is navigated to the home page")
	public void user_is_navigated_to_the_home_page() {
		System.out.println("Login Step 4: Verify we're one the homepage.");
	}


	
}
