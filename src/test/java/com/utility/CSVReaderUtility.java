package com.utility;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;
import com.ui.pojo.User;

public class CSVReaderUtility {

	public static Iterator<User> readCSVFile(String filename) {
		File file=new File(System.getProperty("user.dir")+"\\TestData\\"+filename);
		FileReader fileReader = null;
		String[] line;
		CSVReader csv;
		List<User> userData = null;
		try {
			fileReader = new FileReader(file);
			csv=new CSVReader(fileReader);
			line=csv.readNext();
			userData=new ArrayList<User>();
			while((line=csv.readNext())!=null) {
				User user=new User(line[0],line[1]);
				userData.add(user);
			}
		} catch (IOException | CsvValidationException e) {
			e.printStackTrace();
		}
		
		return userData.iterator();
		

	}

}
