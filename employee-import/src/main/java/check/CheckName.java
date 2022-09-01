package check;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvException;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CheckName {
    public static boolean checkName(String file) throws IOException, CsvException {
        List<String> ListOfNames = new ArrayList<String>();
        try (CSVReader reader = new CSVReader(new FileReader(file))) {
            List<String[]> r = reader.readAll();

            for (int i = 0; i < r.size(); i++) {
                ListOfNames.add(r.get(i)[0]);
            }
            for (int i = 0; i < ListOfNames.size(); i++) {
                if (ListOfNames.get(i).length() > 35) {
                    System.out.println("Name length greater than 35");
                    System.out.println("File didn't pass the name check test");
                    try {
                        FileWriter output = new FileWriter("Errors");
                        output.write(r.get(i)[0]+ " has the name length greater than 35");
                        output.close();
                    } catch (Exception e) {
                        e.getStackTrace();
                    }
                    return false;
                }
            }
        }
        System.out.println("this file passed the name test check");
        return true;
    }
}
