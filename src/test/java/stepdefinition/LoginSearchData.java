package stepdefinition;

import com.pages.LoginSearch;
import com.qa.factory.DriverFactory;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginSearchData {
	
	LoginSearch ls = new LoginSearch(DriverFactory.getDriver());
	
	private static String titlename;
	
	@When("user enters the data {string}")
	public void user_enters_the_data(String datavalue) {
	    // Write code here that turns the phrase above into concrete actions
		
		ls.DataTobeSearch(datavalue);
		 
	}

	@When("user clicks on search button")
	public void user_clicks_on_search_button() {
	    // Write code here that turns the phrase above into concrete actions
		
		ls.Search();
	 
	}

	@Then("its shows the desired page")
	public void its_shows_the_desired_page() {
	    // Write code here that turns the phrase above into concrete actions
		
		titlename =  ls.getSearchPageTitle();
		
		System.out.println("Page Title is " + titlename);

	}

}
