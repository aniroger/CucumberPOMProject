package stepdefinition;

import java.util.List;
import java.util.Map;

import org.junit.Assert;

import com.pages.HomeImprove;
import com.pages.LoginPage;
import com.qa.factory.DriverFactory;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

public class HomeIm {
	
	private LoginPage lp = new LoginPage(DriverFactory.getDriver());
	
	private HomeImprove hi;
	
	@Given("User has already logged into application")
	public void user_has_already_logged_into_application(DataTable credtable) {
		
		List<Map<String,String>> credlist = credtable.asMaps();
		String uname = credlist.get(0).get("username");
		String pwd = credlist.get(0).get("password");
		
		DriverFactory.getDriver().get("https://www.amazon.in/ap/signin?openid.pape.max_auth_age=900&openid.return_to=https%3A%2F%2Fwww.amazon.in%2Fgp%2Fyourstore%2Fhome%3Fpath%3D%252Fgp%252Fyourstore%252Fhome%26signIn%3D1%26useRedirectOnSuccess%3D1%26action%3Dsign-out%26ref_%3Dnav_AccountFlyout_signout&openid.assoc_handle=inflex&openid.mode=checkid_setup&openid.ns=http%3A%2F%2Fspecs.openid.net%2Fauth%2F2.0");
		
		lp.dologin(uname, pwd);	

	}

	@Given("User is on home improvement page")
	public void user_is_on_home_improvement_page() {
	    // Write code here that turns the phrase above into concrete actions
	    
		hi = lp.Home();
	}

	@Then("User gets on Home section")
	public void user_gets_on_home_section(DataTable sectionstable) {
		
		List<String> exlist = sectionstable.asList();
		System.out.println("exected home section list " + exlist);
		List<String> aclist = hi.getHomeCountList();
		System.out.println("actual home section list " + aclist);
		
		Assert.assertTrue(exlist.containsAll(aclist));
		
	}

	@Then("page section should be {int}")
	public void page_section_should_be(Integer expectedcountsection) {
		
		Assert.assertTrue(hi.getHomeCount() == expectedcountsection);
		
	}

}
