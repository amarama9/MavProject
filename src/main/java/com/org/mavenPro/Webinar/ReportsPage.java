/**
 * 
 */
package com.org.mavenPro.Webinar;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.org.mavenPro.GotoWebinar;

/**
 * @author s-amarnathlingineni
 *
 */
public class ReportsPage extends GotoWebinar {

	/**
	 * @param driver
	 */
	public static WebElement element;
	public static WebDriver driver;

	public ReportsPage(WebDriver driver) {

	}

	
	public static WebinarMenu webinarMenu(WebDriver driver) {
		return new WebinarMenu(driver);
	}
	
	public static HeaderLinks headerLinks(WebDriver driver){
		return new HeaderLinks(driver);
	}
	

	
}
