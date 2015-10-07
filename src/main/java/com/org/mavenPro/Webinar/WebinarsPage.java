/**
 * 
 */
package com.org.mavenPro.Webinar;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.org.mavenPro.GotoWebinar;

/**
 * @author s-amarnathlingineni
 *
 */
public class WebinarsPage   extends GotoWebinar {

	/*
	 * 
	 * @param driver
	 */

	private WebDriver driver;

	public WebinarsPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		this.driver = driver;

	}

	@FindBy(css = "#upcomingWebinar-searchWebinarSearchBox")
	public WebElement txtSearchWebinars;

	@FindBy(css = "#upcomingWebinar-page-0-result")
	public WebElement tableWebinarResults;

	@FindBy(css = ".word-wrap-break")
	public WebElement titleManageWebinar;

	@FindBy(css = "#upcomingWebinar-page-0-result>.table-data-row.openWebinar>ul:nth-child(1)>li:nth-child(3)>a")
	public WebElement topSearchResult;

}
