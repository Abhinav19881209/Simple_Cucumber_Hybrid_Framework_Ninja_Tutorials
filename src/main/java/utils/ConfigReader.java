package utils;

import java.util.Properties;
import java.io.*;

public class ConfigReader {
	
	public static Properties initializedProperties() {
		
		Properties prop = new Properties();
		File file = new File(System.getProperty("user.dir")+"\\src\\test\\resource\\configReader\\config.properties");
		FileInputStream fis = null;
		try {
			fis = new FileInputStream(file);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			prop.load(fis);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return prop;
		
	}
	
	private static String browserType = null;

	public static String getBrowserType() {
		
		if(browserType!=null)
		    	return browserType;
		else
			throw new RuntimeException("browser not in testng.xml");
	}

	public static void setBrowserType(String browser) {
		browserType = browser;
	}
	
	
}
