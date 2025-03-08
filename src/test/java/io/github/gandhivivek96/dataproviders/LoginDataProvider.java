package io.github.gandhivivek96.dataproviders;

import com.google.gson.Gson;
import io.github.gandhivivek96.pojo.TestData;
import io.github.gandhivivek96.pojo.User;
import io.github.gandhivivek96.utils.CSVReaderUtility;
import io.github.gandhivivek96.utils.ExcelReaderUtility;
import org.testng.annotations.DataProvider;

import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class LoginDataProvider {

    @DataProvider(name = "LoginTestDataProvider")
    public Iterator<Object[]> loginDataProvider() throws Exception
    {
         Gson gson = new Gson();
         File jsonfile = new File(System.getProperty("user.dir")+"/testData/logindata.json");
         FileReader fileReader = new FileReader(jsonfile);
         TestData testData = gson.fromJson(fileReader,TestData.class);

        List<Object[]> dataToReturn = new ArrayList<Object[]>();
        for( User user:testData.getData())
        {
            dataToReturn.add(new Object[] {user});
        }
        return dataToReturn.iterator();
    }

    @DataProvider(name = "LoginTestCSVDataProvider")
    public Iterator<User> loginCSVDataProvider()
    {
        return CSVReaderUtility.readCSVFile("loginData.csv");
    }

    @DataProvider(name = "LoginTestExcelDataProvider")
    public Iterator<User> loginExcelDataProvider()
    {

        return ExcelReaderUtility.readExcelReader("loginData.xlsx");
    }

}
