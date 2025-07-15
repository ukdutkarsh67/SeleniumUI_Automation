package com.utility;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import com.ui.pojo.User;

public class ExcelReaderUtiliy {

	public static Iterator<User> readExcel(String fileName) {
		File file = new File(System.getProperty("user.dir") + "\\TestData\\" + fileName);
		XSSFWorkbook xssfworkbook = null;
		try {
			xssfworkbook = new XSSFWorkbook(file);
		} catch (InvalidFormatException | IOException e) {
			e.printStackTrace();
		}
		XSSFSheet sheet = xssfworkbook.getSheet("Sheet1");
		List<User> userList = new ArrayList<User>();
		Cell emailCell;
		Cell passwordCell;
		Iterator<Row> rowItr = sheet.iterator();
		rowItr.next();
		while (rowItr.hasNext()) {
			Row row = rowItr.next();
			emailCell = row.getCell(0);
			passwordCell = row.getCell(1);
			User user = new User(emailCell.toString(), passwordCell.toString());
			userList.add(user);
		}
		return userList.iterator();

	}

}
