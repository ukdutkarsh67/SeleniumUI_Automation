package com.utility;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import com.google.gson.Gson;
import com.ui.pojo.Config;
import com.ui.pojo.Environment;

public class JSONUtiliy {

	public static String readJson(String env) {
		File jsonFile = new File(System.getProperty("user.dir") + "\\config\\config.json");
		FileReader fileReader = null;
		try {
			fileReader = new FileReader(jsonFile);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		Gson gson = new Gson();
		Config config = gson.fromJson(fileReader, Config.class);
		Environment environment = config.getEnvironments().get(env);
		return environment.getUrl();

	}
}
