package check;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvException;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CheckSalary {
    public static boolean checkSalary(String file) throws IOException, CsvException {
        List<Double> ListOfSalary = new ArrayList<>();
        try (CSVReader reader = new CSVReader(new FileReader(file))) {
            List<String[]> r = reader.readAll();

            for (int i = 0; i < r.size(); i++) {
                ListOfSalary.add(Double.valueOf(r.get(i)[2]));
            }

            for (int i = 0; i < ListOfSalary.size(); i++) {
                String salaryString = Double.toString(ListOfSalary.get(i));
                Integer integerPlaces = salaryString.indexOf('.');
                Integer decimalPlaces = salaryString.length() - integerPlaces - 1;
                if (decimalPlaces != 3 || ListOfSalary.get(i)< 0 ) {
                    System.out.println("File didn't pass the salary check test");
                    try {
                        FileWriter output = new FileWriter("Errors");
                        output.write(r.get(i)[0]+ " has the salary number of decimals not equal to 3");
                        output.close();
                    } catch (Exception e) {
                        e.getStackTrace();
                    }
                    return false;
                }
            }
        }
        System.out.println("this file passed the salary check test");
        return true;
    }
}

