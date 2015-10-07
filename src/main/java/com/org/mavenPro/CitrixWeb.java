/**
 * 
 */
package com.org.mavenPro;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.org.mavenPro.Environments.ProjectProperties;



/**
 * @author s-amarnathlingineni
 *
 */
public abstract class CitrixWeb {

	private static WebDriver driver;

	public static GotoWebinar gotoWebinar;
	
	public static ProjectProperties projectProperties;

	private static WebDriver getDriver() {

		return getDriver(BrowserType.CHROME);

	}

	public static GotoWebinar gotoWebinar() {

		getDriver().navigate().to(projectProperties.getGotoMeetingTestEnv());



		gotoWebinar = new GotoWebinar(driver);

		return gotoWebinar;

	}

	public static WebDriverWait getWebDriverWait() {

		return new WebDriverWait(driver, 10);

	}

	public enum BrowserType {

		FIREFOX("firefox"), CHROME("chrome"), IE("internetexplorer"), SAFARI(
				"safari"), HTMLUNIT("htmlunit");

		private String value;

		BrowserType(String value) {
			this.value = value;
		}

		public String getBrowserName() {

			return this.value;
		}

	}

	public static WebDriver getDriver(BrowserType enumBrowserType) {

		projectProperties = new ProjectProperties();

		for (BrowserType browsertype : BrowserType.values()) {

			if (browsertype.getBrowserName().equalsIgnoreCase(projectProperties.getBrowser())) {
				enumBrowserType = browsertype;
				System.out.println("BROWSER EXECUTION ENVIRONMENT IS "
						+ browsertype.getBrowserName());
			}

		}

		projectProperties.getBrowser();

		switch (enumBrowserType) {

		case FIREFOX:

			driver = new FirefoxDriver();
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

			break;

		case CHROME:

			driver = new ChromeDriver();
			System.setProperty("webdriver.chrome.driver",
					"drivers/chrome/chromedriver.exe");
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

			break;

		case IE:

			driver = new InternetExplorerDriver();
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

			break;

		case SAFARI:

			driver = new SafariDriver();
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

			break;

		case HTMLUNIT:

			break;

		default:

		}

		return driver;

	}

	public abstract GotoMeeting gotoMeeting();

	public abstract GotoWebinar gotoTraining();

}
