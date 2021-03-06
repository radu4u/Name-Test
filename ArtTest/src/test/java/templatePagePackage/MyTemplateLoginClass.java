package templatePagePackage;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MyTemplateLoginClass {
	WebDriver browser;
	String title = "Title";
	
	@FindBy (css = "input[class = 'classvalue']") private WebElement userNameField;
	@FindBy (id= "IDforPassword") private WebElement passwordField;
	@FindBy (name= "IDForLoginButton") private WebElement loginButton;
	
	public MyTemplateLoginClass(WebDriver browser) {
		new WebDriverWait(browser,10).until(ExpectedConditions.titleContains(title));//Wait for the title to load
		Assert.assertEquals(title, browser.getTitle());
		this.browser = browser;
		PageFactory.initElements(browser,this);
		
	}

	public void typeUserName(String username) {
		userNameField.sendKeys(username);
		
	}

	public void typePassword(String password) {
		passwordField.sendKeys(password);
		
	}

	public MyTemplateSummaryPage clickLoginButton() { //MyTemplateSummaryPage is a class/ the type of the method
		new WebDriverWait(browser,10).until(ExpectedConditions.elementToBeClickable(loginButton)); //Wait for login button to be present
		loginButton.click();
		return new MyTemplateSummaryPage(browser); //here i create the object from the MyTemplateSummaryPage which will be returned
		
		
	}

}
