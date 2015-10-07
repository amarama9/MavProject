/**
 * 
 */
package com.org.mavenPro;

import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.org.mavenPro.DataAbstraction.ScheduleFormData;
import com.org.mavenPro.Enums.HeadMenu;
import com.org.mavenPro.Enums.WebiMenu;

/**
 * @author s-amarnathlingineni
 *
 */
public class seleniumTest {

	public static GotoWebinar gotoWebinar;
	public static WebDriverWait wait;
	public ScheduleFormData inputData;
	static String UserName;
	static String Password;

	@Before
	public void initVariables() {
		inputData = new ScheduleFormData();
	}

	@BeforeClass
	public static void setUpClass() {
		gotoWebinar = GotoWebinar.gotoWebinar();
		wait = GotoWebinar.getWebDriverWait();
		UserName = gotoWebinar.projectProperties.getUserName();
		Password = gotoWebinar.projectProperties.getPassword();
	}

	@Test
	public void test() throws InterruptedException {

		gotoWebinar.loginPage.login(UserName, Password);
		
		gotoWebinar.webinarMenu.open(WebiMenu.ScheduleAWebinar);

		String webinarTitle;
		webinarTitle = gotoWebinar.schedulePage.ScheduleAWebinar(inputData);

		gotoWebinar.webinarMenu.open(WebiMenu.MyWebinars);

		gotoWebinar.webinarsPage.txtSearchWebinars.sendKeys(webinarTitle);

		wait.until(ExpectedConditions.visibilityOfElementLocated(By
				.linkText(webinarTitle)));

		assertTrue(gotoWebinar.webinarsPage.tableWebinarResults.findElements(
				By.linkText(webinarTitle)).size() == 1);

		if ((gotoWebinar.webinarsPage.topSearchResult.getText()
				.contentEquals(webinarTitle))) {
			gotoWebinar.webinarsPage.topSearchResult.click();
		} else {
			fail("Search Funtionality not working as expected.");
		}

		assertTrue(gotoWebinar.webinarsPage.titleManageWebinar.getText()
				.contains(webinarTitle));

		gotoWebinar.headerLinks.ClickOn(HeadMenu.LOGOUT);

	}

}
