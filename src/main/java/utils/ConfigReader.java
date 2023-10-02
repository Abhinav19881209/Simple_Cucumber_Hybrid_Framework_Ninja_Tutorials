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
}
