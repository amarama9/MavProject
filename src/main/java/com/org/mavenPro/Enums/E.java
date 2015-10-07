/**
 * 
 */
package com.org.mavenPro.Enums;

/**
 * @author s-amarnathlingineni
 *
 */
public class E {

	/*public enum Occurs {
		OneSession, Daily, Weekly, Monthly, CustomSchedule;
	}

	public enum AMPM {
		AM, PM;
	}

	public enum TimeZone {
		PST, MT, ET;
	}

	public enum Language {
		English, Deutsch, Italiano;
	}

	public enum WebiMenu {
		MyWebinars, ScheduleAWebinar, MyRecordings, WebinarHistory, GenerateReports, Settings;
	}

	public enum HeaderMenu {
		LOGOUT, MyAccount;
	}*/

	public static String val(Occurs OCRS) {

		String toReturn;

		switch (OCRS) {

		case OneSession:
			toReturn = "One session";
			break;
		case Daily:
			toReturn = "Daily";
			break;
		case Weekly:
			toReturn = "Weekly";
			break;
		case Monthly:
			toReturn = "Monthly";
			break;
		case CustomSchedule:

			toReturn = "Custom schedule";
			break;

		default:
			toReturn = "One session";
			break;

		}

		return toReturn;

	}

	public static String val(TimeZone TZ) {

		String toReturn;

		switch (TZ) {

		case PST:
			toReturn = "(GMT-07:00) Pacific Time (US and Canada);Tijuana";
			break;
		case MT:
			toReturn = "(GMT-06:00) Mountain Time (US and Canada)";
			break;
		case ET:
			toReturn = "(GMT-04:00) Eastern Time (US and Canada)";
			break;
		default:
			toReturn = "(GMT-07:00) Pacific Time (US and Canada);Tijuana";
			break;

		}

		return toReturn;

	}

	public static String val(WebiMenu WM) {

		String toReturn;

		switch (WM) {

		case MyWebinars:
			toReturn = "My Webinars";
			break;
		case ScheduleAWebinar:
			toReturn = "Schedule a Webinar";
			break;
		case MyRecordings:
			toReturn = "My Recordings";
			break;
		case WebinarHistory:
			toReturn = "Webinar History";
			break;
		case GenerateReports:
			toReturn = "Generate Reports";
			break;
		case Settings:
			toReturn = "Settings";
			break;

		default:
			toReturn = "My Webinars";
			break;

		}

		return toReturn;

	}

	public static String val(HeadMenu HM) {

		String toReturn;

		switch (HM) {

		case LOGOUT:
			toReturn = "Log Out";
			break;

		case MyAccount:
			toReturn = "My Account";
			break;

		default:
			toReturn = "GoToWebinar";
			break;

		}

		return toReturn;

	}

}
