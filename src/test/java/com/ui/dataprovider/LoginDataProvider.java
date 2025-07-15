package com.ui.dataprovider;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.testng.annotations.DataProvider;
import com.google.gson.Gson;
import com.ui.pojo.TestData;
import com.ui.pojo.User;
import com.utility.CSVReaderUtility;
import com.utility.ExcelReaderUtiliy;

public class LoginDataProvider {

	@DataProvider(name = "LoginDataProvider")
	public Iterator<Object[]> loginDataProvider() {
		Gson gson = new Gson();
		File file = new File(System.getProperty("user.dir") + "\\TestData\\LoginData.json");
		FileReader fileReader = null;
		try {
			fileReader = new FileReader(file);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

		TestData testData = gson.fromJson(fileReader, TestData.class);

		List<Object[]> dataToReturn = new ArrayList<>();
		for (User user : testData.getData()) {
			dataToReturn.add(new Object[] { user });
		}
		return dataToReturn.iterator();
	}
	
	@DataProvider(name="LoginDataProviderByCSVFile")
	public Iterator<User> LoginDataProviderByCSVFile() {
		return CSVReaderUtility.readCSVFile("LoginData.csv");
	}
	
	@DataProvider(name="LoginDataProviderByExcelFile")
	public Iterator<User> LoginDataProviderByExcelFile() {
		return ExcelReaderUtiliy.readExcel("LoginData.xlsx");
	}
}
