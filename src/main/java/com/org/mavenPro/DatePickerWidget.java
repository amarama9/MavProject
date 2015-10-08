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

	
		int count = -1;
		boolean foundToday = false;
		boolean daySelected = false;
		
		for (int i = 0; i < calRows.size(); i++) {

			boolean greyDay = false;
			boolean yesterday =false;
			boolean nextMonth = false;


			List<WebElement> coloumns = calRows.get(i).findElements(
					By.tagName("td"));
            
			int colCount = 0;
			for (WebElement coloumn : coloumns) {
				
				colCount++;
				System.out.println(colCount);
				
				if (nextMonth) {

					if ((coloumn.getAttribute("class")
							.contains("ui-datepicker-other-month"))) {
						greyDay = true;
					}else if((coloumn.getAttribute("class")
							.contains("ui-datepicker-unselectable"))){
						yesterday=true;
					}else {
					
						greyDay = false;
					}

				} else if (coloumn.getAttribute("class").contains(
						"ui-datepicker-today")) {
					foundToday = true;
				}

				if ((foundToday) && (!greyDay)&&(!yesterday)) {

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
System.out.println("count "+count);
				if (count == n) {
					System.out.println(coloumn.findElement(By.tagName("a")).getText());
					coloumn.findElement(By.tagName("a")).click();
					daySelected = true;
					break;
				}else if(colCount==7){
					break;
				}

			}

			if (daySelected) {
				break;
			}

		}

	}

}
