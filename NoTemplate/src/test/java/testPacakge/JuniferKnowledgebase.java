package testPacakge;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import pagePackage.AllUpdates;
import pagePackage.JuniferKB;


public class JuniferKnowledgebase {
	
	WebDriver browser;
	String URL= "https://knowledgebase.junifersystems.com";
	
	JuniferKB junifer;
	AllUpdates updates;
	
	
	@Before
	public void openBrowser(){
		System.setProperty("webdriver.gecko.driver","C:\\Users\\Annamaria\\Downloads\\geckodriver-v0.11.1-win64\\geckodriver.exe");
		browser = new FirefoxDriver();
	}
	
	@Given("^Junifer Knowledgebase page open$")
	public void junifer_Knowledgebase_page_open() throws Throwable {
		browser.get(URL);
	  
	}

	@When("^Enter username \"([^\"]*)\" and password \"([^\"]*)\"$")
	public void enter_username_and_password(String username, String password) throws Throwable {
		junifer = new JuniferKB(browser);
		junifer.enterUsename(username);
		junifer.enterPassword(password);
		updates = junifer.clickLogin();
			   
	}

}
