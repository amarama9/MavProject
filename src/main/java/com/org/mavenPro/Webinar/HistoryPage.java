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
public class HistoryPage extends GotoWebinar {
	
	
	/**
	 * @param driver
	 */
	
	public static WebElement element;
	public static WebDriver driver;
	
	public HistoryPage(WebDriver driver) {
		
		this.driver = driver;
	}


}
