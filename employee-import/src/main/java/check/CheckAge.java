package check;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvException;
import com.progressoft.employee.domain.Employee;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CheckAge {

    public static boolean checkAge(String file) throws IOException, CsvException {
        List<Integer> ListOfAge = new ArrayList<Integer>();
        try (CSVReader reader = new CSVReader(new FileReader(file))) {
            List<String[]> r = reader.readAll();

            for (int i = 0; i < r.size(); i++) {
                ListOfAge.add(Integer.valueOf(r.get(i)[1]));
            }
            for (int i = 0; i < ListOfAge.size(); i++) {
                if (ListOfAge.get(i) < 18 || ListOfAge.get(i) > 100) {
                    try {
                        FileWriter output = new FileWriter("Errors");
                        output.write(r.get(i)[0]+ " has the age not between 18 and 100");
                        output.close();
                    } catch (Exception e) {
                        e.getStackTrace();
                    }
                    System.out.println("File didn't pass the age check test");
                    return false;
                }
            }
        }
        System.out.println("this file passed the age check test");
        return true;
    }
}
