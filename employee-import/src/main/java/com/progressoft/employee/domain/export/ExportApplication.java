package com.progressoft.employee.domain.export;


import com.progressoft.employee.domain.Employee;
import com.progressoft.employee.domain.EmployeeUtils;
import com.progressoft.employee.domain.EmployeeUtilsImpl;



import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;



public class ExportApplication {
    public static List<String> export() {
        List<String> folderAndFileName = new ArrayList<>();


        // input destination folder
        Scanner obj1 = new Scanner(System.in);
        System.out.println("Enter destination folder");
        String destinationFolder = obj1.nextLine();

        // input file name
        Scanner obj2 = new Scanner(System.in);
        System.out.println("Enter file name");
        String fileName= obj2.nextLine();

        System.out.println(" file name is : " + fileName);

        List<Employee> employeeList = new ArrayList<>();

        EmployeeUtils employeeUtils = new EmployeeUtilsImpl();
        employeeUtils.exportEmployees(employeeList, fileName);

        folderAndFileName.add(destinationFolder);
        folderAndFileName.add(fileName);
        return folderAndFileName;


    }
}
