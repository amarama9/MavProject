/**
 * 
 */
package com.org.mavenPro.Webinar;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.org.mavenPro.GotoWebinar;

import com.org.mavenPro.Enums.E;
import com.org.mavenPro.Enums.HeadMenu;




/**
 * @author s-amarnathlingineni
 *
 */
public class HeaderLinks extends GotoWebinar {

	/**
	 * @param driver
	 */

	private WebDriver driver;

	public HeaderLinks(WebDriver driver) {
		PageFactory.initElements(driver, this);
		this.driver = driver;
	}

	@FindBy(css = ".header-nav>ul>li")
	public List<WebElement> allMenuLinks;

	public boolean ClickOn(HeadMenu linkName) {

		String Item = E.val(linkName);

		boolean status = false;

		for (WebElement elem : allMenuLinks) {

			String getEachMenu = elem.findElement(By.tagName("a")).getText();

			if (getEachMenu.equalsIgnoreCase(Item)) {

				elem.findElement(By.tagName("a")).click();
				status = true;

				break;
			}

		}

		return status;

	}

}
