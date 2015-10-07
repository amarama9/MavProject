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
import com.org.mavenPro.Enums.WebiMenu;







/**
 * @author s-amarnathlingineni
 *
 */
public class WebinarMenu  {

	/**
	 * @param driver
	 */
	private WebDriver driver;

	public WebinarMenu(WebDriver driver) {
		PageFactory.initElements(driver, this);
		this.driver = driver;

	}

	@FindBy(css = "ul.sidebar-nav >li")
	List<WebElement> AllMenuItems;

	public boolean open(WebiMenu menuItem) {

		String Item = E.val(menuItem);

		boolean status = false;

		for (WebElement elem : AllMenuItems) {

			String getEachMenu = elem.findElement(By.tagName("a")).getText();
			System.out.println(getEachMenu);

			if (getEachMenu.equalsIgnoreCase(Item)) {

				elem.findElement(By.tagName("a")).click();
				status = true;

				break;
			}

		}

		return status;

	}

	/**
	 * 
	 */

}
