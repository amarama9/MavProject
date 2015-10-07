/**
 * 
 */
package com.org.mavenPro.Webinar;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.org.mavenPro.CitrixWeb;
import com.org.mavenPro.GotoMeeting;
import com.org.mavenPro.GotoWebinar;

/**
 * @author s-amarnathlingineni
 *
 */
public class LoginPage extends GotoWebinar {

	/**
	 * @param driver
	 */
	private WebDriver driver;

	public LoginPage(WebDriver driver) {

		PageFactory.initElements(driver, this);
		this.driver = driver;

	}

	@FindBy(id = "emailAddress")
	public WebElement txtUsername;

	@FindBy(id = "password")
	public WebElement txtPassword;

	@FindBy(id = "submit")
	public WebElement btnSubmit;

	public void login(String Username, String Password) {

		txtUsername.sendKeys(Username);
		txtPassword.sendKeys(Password);
		txtUsername.submit();

	}

	
	public static WebinarMenu webinarMenu(WebDriver driver) {
		return new WebinarMenu(driver);
	}
	
	public static HeaderLinks headerLinks(WebDriver driver){
		return new HeaderLinks(driver);
	}
	

	
}
