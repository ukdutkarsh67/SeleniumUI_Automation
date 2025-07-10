package com.utility;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class propertiesUtility {

	public static String getURL(String url) {
		File file = new File(System.getProperty("user.dir") + "\\config\\config.properties");
		FileReader filereader;
		Properties prop=new Properties();
		try {
			filereader = new FileReader(file);
			prop.load(filereader);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		 catch (IOException e) {
			e.printStackTrace();
		}
		String URL=prop.getProperty(url);
		return URL;

	}

}
