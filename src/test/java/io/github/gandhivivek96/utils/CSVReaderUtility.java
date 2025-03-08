package io.github.gandhivivek96.utils;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;
import io.github.gandhivivek96.pojo.User;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class CSVReaderUtility {

    public static Iterator<User> readCSVFile(String fileName) {

        File csvFile = new File(System.getProperty("user.dir")+"/testData/"+fileName);
        FileReader fileReader = null;
        String[] line;
        User user=null;
        CSVReader csvReader=null;
        List<User> userList;
        try {
            fileReader = new FileReader(csvFile);
             csvReader = new CSVReader(fileReader);
            csvReader.readNext();//skip 1st row/header
            userList = new ArrayList<User>();
            while((line =csvReader.readNext())!=null)
            {
                user = new User(line[0], line[1]);
                userList.add(user);
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
         catch (IOException e) {
            throw new RuntimeException(e);
        } catch (CsvValidationException e) {
            throw new RuntimeException(e);
        }
        return userList.iterator();
   }

}
