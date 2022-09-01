package check;

import com.opencsv.exceptions.CsvException;

import java.io.IOException;

import static check.CheckAge.checkAge;
import static check.CheckAlreadyImported.checkAlreadyImported;
import static check.CheckFileExtension.checkFile;
import static check.CheckName.checkName;
import static check.CheckSalary.checkSalary;

public class importCheck {

    public boolean check(String filePath) throws IOException, CsvException {
        if (checkName(filePath) &&
        checkAge(filePath) &&
        checkAlreadyImported(filePath) &&
        checkFile(filePath) &&
        checkSalary(filePath)) {
            System.out.println("ALl checkups are met");
            return true;
        }
        System.out.println("Not all checkups are met");
       return false;
    }
    }

