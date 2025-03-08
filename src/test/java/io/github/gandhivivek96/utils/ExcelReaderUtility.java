package io.github.gandhivivek96.utils;

import io.github.gandhivivek96.pojo.User;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ExcelReaderUtility {

    public static Iterator<User> readExcelReader(String fileName) {

        File excelFile = new File(System.getProperty("user.dir")+"/testData/"+fileName);
        XSSFWorkbook xssfWorkbook;
        XSSFSheet xssfSheet;
        Iterator<Row> rowIterator;
        List<User> userList = new ArrayList<User>();;
        try {
            xssfWorkbook = new XSSFWorkbook(excelFile);
            xssfSheet = xssfWorkbook.getSheet("Sheet1");
             rowIterator = xssfSheet.iterator();
            rowIterator.next();

            while(rowIterator.hasNext())
            {
                Row row = rowIterator.next();
                User user = new User(row.getCell(0).toString(),row.getCell(1).toString());
                userList.add(user);
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (InvalidFormatException e) {
            throw new RuntimeException(e);
        }

        return userList.iterator();

    }

}
