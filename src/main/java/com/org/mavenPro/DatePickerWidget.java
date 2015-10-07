/**
 * 
 */
package com.org.mavenPro;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.org.mavenPro.GotoWebinar;

/**
 * @author s-amarnathlingineni
 *
 */
public class DatePickerWidget   {

	private WebDriver driver;

	public DatePickerWidget(WebDriver driver) {

		PageFactory.initElements(driver, this);
		this.driver = driver;

	}

	@FindBy(id = "ui-datepicker-div")
	WebElement dtPicker;

	@FindBy(css = ".ui-datepicker-calendar>tbody")
	WebElement dtPickerCalender;

	@FindBy(css = ".ui-datepicker-calendar>tbody>tr")
	List<WebElement> calRows;

	public void selNthDayFromToday(int n) {

	

		for (int i = 0; i < calRows.size(); i++) {

			boolean foundToday = false;
			boolean nextMonth = false;
			boolean greyDay = false;
			boolean daySelected = false;
			int count = -1;

			List<WebElement> coloumns = calRows.get(i).findElements(
					By.tagName("td"));

			for (WebElement coloumn : coloumns) {

				if (nextMonth) {

					if ((coloumn.getAttribute("class")
							.contains("ui-datepicker-other-month"))) {
						greyDay = true;
					} else {
						greyDay = false;
					}

				} else if (coloumn.getAttribute("class").contains(
						"ui-datepicker-today")) {
					foundToday = true;
				}

				if ((foundToday) && (!greyDay)) {

					count++;
					if ((count >= 1) && (count < n)) {

						if (coloumn.getAttribute("class").contains(
								"ui-datepicker-other-month")) {
							dtPicker.findElement(
									By.cssSelector("*[title='Next']"))
									.findElement(By.tagName("span")).click();
							dtPickerCalender = driver
									.findElement(
											By.cssSelector("table.ui-datepicker-calendar"))
									.findElement(By.tagName("tbody"));
							calRows = dtPickerCalender.findElements(By
									.tagName("tr"));

							nextMonth = true;
							count--;
							i = -1;
							break;
						}
					}

				}

				if (count == n) {
					coloumn.findElement(By.tagName("a")).click();
					daySelected = true;
					break;
				}

			}

			if (daySelected) {
				break;
			}

		}

	}

}
