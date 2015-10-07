/**
 * 
 */
package com.org.mavenPro.Webinar;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.org.mavenPro.GotoWebinar;
import com.org.mavenPro.DataAbstraction.ScheduleFormData;
import com.org.mavenPro.Enums.AMPM;
import com.org.mavenPro.Enums.E;
import com.org.mavenPro.Enums.Language;
import com.org.mavenPro.Enums.Occurs;
import com.org.mavenPro.Enums.TimeZone;



/**
 * @author s-amarnathlingineni
 *
 */
public class SchedulePage  extends GotoWebinar{

	/**
	 * @param driver
	 */

	private static WebDriver driver;

	public SchedulePage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		this.driver = driver;
	}

	@FindBy(css = "#scheduleForm #name")
	public WebElement txtTitle;

	@FindBy(css = "#scheduleForm #description")
	public WebElement txtDescription;

	@FindBy(css = "#recurrenceForm_recurs_trig .arrow")
	public WebElement arrOccurs;

	@FindBy(css = "#recurrenceForm_recurs__menu>ul>li")
	public List<WebElement> selRecurrence;

	@FindBy(css = ".ui-datepicker-trigger")
	public WebElement trigDatePicker;

	@FindBy(id = "webinarTimesForm.dateTimes_0.startTime")
	public WebElement txtStartTime;

	@FindBy(css = "#dateContainer_0 input[class='text endTime']")
	public WebElement txtEndTime;

	@FindBy(css = "#webinarTimesForm_dateTimes_0_startAmPm_trig .arrow")
	public WebElement arrStartTime;

	@FindBy(css = "#webinarTimesForm_dateTimes_0_endAmPm_trig .arrow")
	public WebElement arrEndTime;

	@FindBy(css = "#webinarTimesForm_dateTimes_0_startAmPm__menu>ul>li")
	public List<WebElement> selAMorPMonStartTime;

	@FindBy(css = "#webinarTimesForm_dateTimes_0_endAmPm__menu>ul>li")
	public List<WebElement> selAMorPMonEndTime;

	@FindBy(css = "#webinarTimesForm_timeZone_trig .arrow")
	public WebElement arrWebinarTimeZone;

	@FindBy(css = "#webinarTimesForm_timeZone__menu>ul>li")
	public List<WebElement> selTimeZone;

	@FindBy(css = "#language_trig .arrow")
	public WebElement arrLanguage;

	@FindBy(css = "#language__menu>ul>li")
	public List<WebElement> selWebinarLanguage;

	@FindBy(id = "schedule.submit.button")
	public WebElement btnSchedule;

	public boolean SelectReccurence(Occurs frequency) {

		boolean status = false;
		String freq = E.val(frequency);
		arrOccurs.click();
		for (WebElement menu : selRecurrence) {

			if (menu.getText().contains(freq)) {

				menu.click();
				status = false;
				break;

			}

		}
		return status;

	}

	public boolean selAMPM_StartTime(String starttime, AMPM AMorPM) {

		// txtStartTime.clear();
		// txtStartTime.sendKeys(starttime);
		arrStartTime.click();

		return selectAMPM(AMorPM, selAMorPMonStartTime);

	}

	public boolean selAMPM_EndTime(String endtime, AMPM AMorPM) {

		// txtEndTime.clear();
		// txtEndTime.sendKeys(endtime);
		arrEndTime.click();

		return selectAMPM(AMorPM, selAMorPMonEndTime);

	}

	public boolean selectAMPM(AMPM AMorPM, List<WebElement> elements) {

		if (AMorPM.toString().equalsIgnoreCase("AM")) {

			WebDriverWait wait = new WebDriverWait(driver, 10);
			List<WebElement> element = wait.until(ExpectedConditions
					.visibilityOfAllElements(elements));
			elements.get(0).click();

		} else if (AMorPM.toString().equalsIgnoreCase("PM")) {

			elements.get(1).click();

		} else {

			return false;
		}

		return true;
	}

	public boolean selectWebinarTimeZone(TimeZone timeZone) throws InterruptedException {

		boolean status = false;
		String tZone = E.val(timeZone);
		Thread.sleep(500);
		arrWebinarTimeZone.click();
		for (WebElement time : selTimeZone) {

			if (time.getText().equalsIgnoreCase(tZone)) {
				time.click();
				status = true;
				break;
			}
		}

		return status;
	}

	public boolean SelectWebinarLanguage(Language Lang) {

		boolean status = false;
		arrLanguage.click();
		for (WebElement Language : selWebinarLanguage) {

			if (Language.getText().equalsIgnoreCase(Lang.toString())) {
				Language.click();
				status = true;
				break;
			}
		}

		return status;

	}

	public String ScheduleAWebinar() {

		return null;

	}

	public String ScheduleAWebinar(String webinarTitle) {

		return webinarTitle;

	}

	public String ScheduleAWebinar(String copyTitle, boolean fromcopy) {

		return copyTitle;
	}

	public String ScheduleAWebinar(String Title, String Description,
			Occurs freq, int Ndaysfromtoday, TimeZone timezone,
			Language language, String startTime, AMPM start, String endTime,
			AMPM end) throws InterruptedException {

		txtTitle.sendKeys(Title);
		txtDescription.sendKeys(Description);
		SelectReccurence(freq);
		selectWebinarTimeZone(timezone);
		SelectWebinarLanguage(language);
		gotoWebinar.schedulePage.trigDatePicker.click();
		gotoWebinar.datePickerWidget.selNthDayFromToday(Ndaysfromtoday);
		selAMPM_StartTime(startTime, start);
		selAMPM_EndTime(endTime, end);
		btnSchedule.click();

		return Title;
	}

	public String ScheduleAWebinar(ScheduleFormData data) throws InterruptedException {
		return ScheduleAWebinar(data.getWebinarTitle(),
				data.getWebinarDescription(), data.getFrequency(),
				data.getNdaysfromtoday(), data.getTimezone(),
				data.getLanguage(), data.getStartTime(), data.getStart(),
				data.getEndTime(), data.getEnd());
	}

}
