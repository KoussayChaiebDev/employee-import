package check;

import com.opencsv.exceptions.CsvException;
import com.progressoft.employee.domain.Employee;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CheckAlreadyImported {
    public static boolean checkAlreadyImported(String file) throws IOException, CsvException {
        String line = "";
        String splitBy = ",";
        List<String> ListOfNames = new ArrayList<String>();
        try {
            BufferedReader br = new BufferedReader(new FileReader(file));
            while ((line = br.readLine()) != null) {
                String[] List = line.split(splitBy);
                if (ListOfNames.contains(List[0])) {
                    try {
                        FileWriter output = new FileWriter("Errors");
                        output.write(List[0] + " has already been imported earlier");
                        output.close();
                    } catch (Exception e) {
                        e.getStackTrace();
                    }
                    System.out.println("File didn't pass the already imported earlier check test");

                    return false;
                } else {
                    ListOfNames.add(List[0]);
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("this file passed the alreadyImported check test");
        return true;
    }
}
