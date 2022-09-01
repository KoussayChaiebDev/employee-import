package com.progressoft.employee.domain.imprt;

import check.importCheck;
import com.opencsv.exceptions.CsvException;
import com.progressoft.employee.domain.Employee;
import com.progressoft.employee.domain.EmployeeUtils;
import com.progressoft.employee.domain.EmployeeUtilsImpl;
import com.progressoft.employee.domain.export.ExportApplication;

import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static filter.FilterAge.filterAge;
import static filter.FilterAge.noFilterAge;
import static filter.FilterName.filterName;
import static filter.FilterName.noFilterName;
import static filter.FilterSalary.filterSalary;
import static filter.FilterSalary.noFilterSalary;


public class ImportApplication {
    public static void main(String[] args) throws IOException, CsvException {

        ExportApplication fileExport = new ExportApplication();
        List<String> folderAndFileName = fileExport.export();
        Files.write(Path.of(folderAndFileName.get(0)),folderAndFileName.get(1).getBytes(StandardCharsets.UTF_8));

        String filePath;
        List<Employee> employees = new ArrayList<>();
        Scanner inputScanner = new Scanner(System.in);
        EmployeeUtils employeeUtils = new EmployeeUtilsImpl();

        System.out.println("Enter file path or enter c to exit:");
        filePath = inputScanner.next();

        while(!filePath.equals("c")){
            employees.addAll(employeeUtils.importEmployees(filePath));
            System.out.println("Enter file path or enter c to exit:");
            // Multiple Checks :
            importCheck ch = new importCheck();
            if (ch.check(filePath)) {

                List<Employee> filteredListByName;
                List<Employee> filteredListBySalary;
                List<Employee> filteredListByAge;


                System.out.println("do you wish to age filter ? type y to proceed to filter");
                Scanner userInput = new Scanner(System.in);
                String option = userInput.nextLine();
                if (option.equals("y")) {
                    filteredListByAge = filterAge(employees);
                    System.out.println(filteredListByAge);
                } else {
                    filteredListByAge = noFilterAge(employees);
                    System.out.println(filteredListByAge);
                }


                System.out.println("do you wish to name filter ? type y to proceed to filter");
                Scanner userInput2 = new Scanner(System.in);
                String option2 = userInput2.nextLine();
                if (option2.equals("y")) {
                    filteredListByName = filterName(filteredListByAge);
                    System.out.println(filteredListByName);
                }else {
                    filteredListByName = noFilterName(filteredListByAge);
                    System.out.println(filteredListByName);
                }

                System.out.println("do you wish to salary filter ? type y to proceed to filter");
                Scanner userInput3 = new Scanner(System.in);
                String option3 = userInput3.nextLine();
                if (option3.equals("y")) {
                    filteredListBySalary = filterSalary(filteredListByName);
                    System.out.println(filteredListBySalary);
                }else {
                    filteredListBySalary = noFilterSalary(filteredListByName);
                    System.out.println(filteredListBySalary);
                }

                try {
                    FileWriter output = new FileWriter("Final List");

                    for (int i = 0; i < filteredListBySalary.size(); i++) {
                        Employee employee = (Employee) filteredListBySalary.get(i);
                        String data = employee.getName() + "," + String.valueOf(employee.getAge()) + "," + String.valueOf(employee.getSalary()) + "\n";
                        output.write(data);
                    }
                    output.close();
                } catch (Exception e) {
                    e.getStackTrace();
                }



            }else {
                System.out.println("check failed, you need to checkout the input file and fix the errors");
            }
            filePath = inputScanner.next();
        }
    }
}

