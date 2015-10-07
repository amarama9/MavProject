/**
 * 
 */
package com.org.mavenPro;



import org.openqa.selenium.WebDriver;

import com.org.mavenPro.Webinar.*;

/**
 * @author s-amarnathlingineni
 *
 */
public class GotoWebinar extends CitrixWeb {
	
	/**
	 * 
	 * 
	 * @param driverObject
	 * 
	 * 
	 */

	public  LoginPage loginPage ;
	public  WebinarsPage webinarsPage;
	public  SchedulePage schedulePage;
	public  HistoryPage historyPage;
	public  RecordingsPage recordingsPage;
	public  ReportsPage reportsPage;
	public  WebinarMenu webinarMenu;
	public  HeaderLinks headerLinks;
	//public  FooterLinks footerLinks;
	public  DatePickerWidget datePickerWidget;
	private WebDriver driver;
	
	public GotoWebinar() {
		
	}
	
	
	public GotoWebinar(WebDriver driver) {
		
				loginPage = loginPage(driver);
				schedulePage = schedulePage(driver);
				webinarsPage = webinarsPage(driver);
				
				/*historyPage = historyPage(driver);
				recordingsPage = recordingsPage(driver);
				reportsPage =reportsPage(driver);
				
		       /***************************************/	
				webinarMenu = webinarMenu(driver);
				headerLinks = headerLinks(driver);
				/*
				footerLinks = footerLinks(driver);*/

				/***************************************/
				
				datePickerWidget = datePickerWidget(driver);
				this.driver = driver;
	}
	
	/**
	 * @param driver
	 * @return
	 */


	
	public  LoginPage loginPage(WebDriver driver) {
		
		return new LoginPage(driver);
	}

	public WebinarsPage webinarsPage(WebDriver driver) {
		return new WebinarsPage(driver);
	}

	public  SchedulePage schedulePage(WebDriver driver) {
		return new SchedulePage(driver);
	}
	
	public  HistoryPage historyPage(WebDriver driver) {
		return new HistoryPage(driver);
	}
	
	public  RecordingsPage recordingsPage(WebDriver driver){
		return new RecordingsPage(driver);
	}
	
	public  ReportsPage reportsPage(WebDriver driver){
		return new ReportsPage(driver);
	}
	
	
	public static WebinarMenu webinarMenu(WebDriver driver) {
		return new WebinarMenu(driver);
	}
	
	public static HeaderLinks headerLinks(WebDriver driver){
		return new HeaderLinks(driver);
	}
	
/*	public static FooterLinks footerLinks(WebDriver driver) {
		return new FooterLinks(driver);
	}*/
	
	private DatePickerWidget datePickerWidget(WebDriver driver) {
	
		return new DatePickerWidget( driver);
	}

	

    
 
    

	/* (non-Javadoc)
	 * @see com.org.mavenPro.CitrixWeb#gotoMeeting()
	 */
	@Override
	public GotoMeeting gotoMeeting() {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see com.org.mavenPro.CitrixWeb#gotoTraining()
	 */
	@Override
	public GotoWebinar gotoTraining() {
		// TODO Auto-generated method stub
		return null;
	}
	

}
