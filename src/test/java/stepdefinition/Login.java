package stepdefinition;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;

import com.pages.LoginPage;
import com.qa.factory.DriverFactory;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Login {
	
	private static String title;
	private LoginPage lp = new LoginPage(DriverFactory.getDriver());
	
	Logger log = LogManager.getLogger("Login");
	
	
	@Given("User is on login page")
	public void user_is_on_login_page() {
	    // Write code here that turns the phrase above into concrete actions
		
		
		DriverFactory.getDriver().get("https://www.amazon.in/ap/signin?openid.pape.max_auth_age=900&openid.return_to=https%3A%2F%2Fwww.amazon.in%2Fgp%2Fyourstore%2Fhome%3Fpath%3D%252Fgp%252Fyourstore%252Fhome%26signIn%3D1%26useRedirectOnSuccess%3D1%26action%3Dsign-out%26ref_%3Dnav_AccountFlyout_signout&openid.assoc_handle=inflex&openid.mode=checkid_setup&openid.ns=http%3A%2F%2Fspecs.openid.net%2Fauth%2F2.0");
		log.info("Launch site");
	}

	@When("user gets the title of page")
	public void user_gets_the_title_of_page() {
	    // Write code here that turns the phrase above into concrete actions
		

		title =  lp.getLoginPageTitle();
		
		System.out.println("Page Title is " + title);
		
		log.info("User gets title of page");
	}

	@Then("page title should be {string}")
	public void page_title_should_be(String expectedtitlename) {
	    // Write code here that turns the phrase above into concrete actions

		Assert.assertTrue(title.contains(expectedtitlename));
		
		log.info("Page Title matches");
		
	}
	
	@When("User clicks on Continue Button")
	public void user_clicks_on_continue_button() {
	    // Write code here that turns the phrase above into concrete actions

		lp.ClickContinueButton();
	}

	@Then("Forgot your password link should be displayed.")
	public void forgot_your_password_link_should_be_displayed() {
	    // Write code here that turns the phrase above into concrete actions
		
		Assert.assertTrue(lp.isforgotpwdlinkexist());
	}

	@When("User enters username {string}")
	public void user_enters_username(String username) {
	    // Write code here that turns the phrase above into concrete actions
		
		lp.enterusername(username);
		
		log.info("User enters uname");
	}

	@When("User enters password {string}")
	public void user_enters_password(String password) {
	    // Write code here that turns the phrase above into concrete actions
		
		lp.enterpassword(password);
		
		log.info("User enters pwd");
	}

	@When("User clicks on Login Button")
	public void user_clicks_on_login_button() {
	    // Write code here that turns the phrase above into concrete actions
		
		lp.clickonlogin();
	}

}
