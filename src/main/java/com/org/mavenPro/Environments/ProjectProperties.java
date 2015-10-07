/**
 * 
 */
package com.org.mavenPro.Environments;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * @author s-amarnathlingineni
 *
 */
public class ProjectProperties {

	/**
	 * @return the userName
	 */

	private String UserName;
	private String Password;
	private String Browser;
	private String GotoMeetingTestEnv;

	private Properties props;
	private InputStream inStream;

	public ProjectProperties() {

		props = new Properties();
		inStream = null;
	}

	public String getUserName() {

		UserName = getDataFromFile("Username", "userdetails.properties");
		return UserName;

	}

	/**
	 * @param userName
	 *            the userName to set
	 */
	public void setUserName(String userName) {

	}

	/**
	 * @return the password
	 */
	public String getPassword() {

		Password = getDataFromFile("Password", "userdetails.properties");
		return Password;
	}

	/**
	 * @param password
	 *            the password to set
	 */
	public void setPassword(String password) {
		Password = password;
	}

	/**
	 * @return the browser
	 */
	public String getBrowser() {

		Browser = getDataFromFile("Browser", "execution.properties");
		return Browser;
	}

	/**
	 * @param browser
	 *            the browser to set
	 */
	public void setBrowser(String browser) {
		Browser = browser;
	}

	/**
	 * @return the gotoMeetingTestEnv
	 */
	public String getGotoMeetingTestEnv() {

		GotoMeetingTestEnv = getDataFromFile("GotoMeetingTest",
				"execution.properties");

		return GotoMeetingTestEnv;
	}

	/**
	 * @param gotoMeetingTestEnv
	 *            the gotoMeetingTestEnv to set
	 */
	public void setGotoMeetingTestEnv(String gotoMeetingTestEnv) {
		GotoMeetingTestEnv = gotoMeetingTestEnv;
	}

	private String getDataFromFile(String DataVariable, String PropertiesFile) {

		try {

			inStream = new FileInputStream(PropertiesFile);

			props.load(inStream);

		} catch (IOException ex) {
			ex.printStackTrace();
		} finally {
			if (inStream != null) {
				try {
					inStream.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}

		return props.getProperty(DataVariable);

	}

}
