/**
 * 
 */
package com.org.mavenPro.DataAbstraction;

import java.sql.Timestamp;

import com.org.mavenPro.Enums.AMPM;
import com.org.mavenPro.Enums.Language;
import com.org.mavenPro.Enums.Occurs;
import com.org.mavenPro.Enums.TimeZone;




/**
 * @author s-amarnathlingineni
 *
 */
public class ScheduleFormData {
	
	
	/**
	 * @param webinarTitle
	 * @param webinarDescription
	 * @param frequency
	 * @param ndaysfromtoday
	 * @param timezone
	 * @param language
	 * @param startTime
	 * @param start
	 * @param endTime
	 * @param end
	 */
	public ScheduleFormData(String webinarTitle, String webinarDescription,
			Occurs frequency, int ndaysfromtoday, TimeZone timezone,
			Language language, String startTime, AMPM start, String endTime,
			AMPM end) {
		super();
		WebinarTitle = webinarTitle;
		WebinarDescription = webinarDescription;
		Frequency = frequency;
		Ndaysfromtoday = ndaysfromtoday;
		this.timezone = timezone;
		this.language = language;
		this.startTime = startTime;
		this.start = start;
		this.endTime = endTime;
		this.end = end;
	}

	String WebinarTitle ;
	String WebinarDescription;
	Occurs Frequency;
	int Ndaysfromtoday;
	TimeZone timezone;
	Language language;
	String startTime;
	AMPM start;
	String endTime;
	AMPM end;
	
	/**
	 * @return the webinarTitle
	 */
	public String getWebinarTitle() {
		return WebinarTitle;
	}
	/**
	 * @param webinarTitle the webinarTitle to set
	 */
	public void setWebinarTitle(String webinarTitle) {
		WebinarTitle = webinarTitle;
	}
	/**
	 * @return the webinarDescription
	 */
	public String getWebinarDescription() {
		return WebinarDescription;
	}
	/**
	 * @param webinarDescription the webinarDescription to set
	 */
	public void setWebinarDescription(String webinarDescription) {
		WebinarDescription = webinarDescription;
	}
	/**
	 * @return the frequency
	 */
	public Occurs getFrequency() {
		return Frequency;
	}
	/**
	 * @param frequency the frequency to set
	 */
	public void setFrequency(Occurs frequency) {
		Frequency = frequency;
	}
	/**
	 * @return the ndaysfromtoday
	 */
	public int getNdaysfromtoday() {
		return Ndaysfromtoday;
	}
	/**
	 * @param ndaysfromtoday the ndaysfromtoday to set
	 */
	public void setNdaysfromtoday(int ndaysfromtoday) {
		Ndaysfromtoday = ndaysfromtoday;
	}
	/**
	 * @return the timezone
	 */
	public TimeZone getTimezone() {
		return timezone;
	}
	/**
	 * @param timezone the timezone to set
	 */
	public void setTimezone(TimeZone timezone) {
		this.timezone = timezone;
	}
	/**
	 * @return the language
	 */
	public Language getLanguage() {
		return language;
	}
	/**
	 * @param language the language to set
	 */
	public void setLanguage(Language language) {
		this.language = language;
	}
	/**
	 * @return the startTime
	 */
	public String getStartTime() {
		return startTime;
	}
	/**
	 * @param startTime the startTime to set
	 */
	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}
	/**
	 * @return the start
	 */
	public AMPM getStart() {
		return start;
	}
	/**
	 * @param start the start to set
	 */
	public void setStart(AMPM start) {
		this.start = start;
	}
	/**
	 * @return the endTime
	 */
	public String getEndTime() {
		return endTime;
	}
	/**
	 * @param endTime the endTime to set
	 */
	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}
	/**
	 * @return the end
	 */
	public AMPM getEnd() {
		return end;
	}
	/**
	 * @param end the end to set
	 */
	public void setEnd(AMPM end) {
		this.end = end;
	}
	
	public ScheduleFormData() {
		
		WebinarTitle = "a test webinar " + getTimeStamp();
		WebinarDescription ="Describing the webinar...";
		Frequency=Occurs.Monthly;
		Ndaysfromtoday = 3;
	    timezone =TimeZone.ET;
		language = Language.Deutsch;
		startTime = "9:00";
		start = AMPM.AM;
		endTime = "10:00";
		end = AMPM.AM;
		
	}

	Timestamp getTimeStamp () {
		return new Timestamp(System.currentTimeMillis());
    }
}
