package com.progressoft.employee.domain;

import java.io.FileWriter;
import java.math.BigDecimal;
import java.util.List;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;

public class EmployeeUtilsImpl implements EmployeeUtils{
    @Override
    public List<Employee> importEmployees(String destinationFolder) throws FileNotFoundException {
        Scanner fileScanner = new Scanner(new File(destinationFolder));
        List<Employee> employeeList = new ArrayList<>();
        fileScanner.useDelimiter("\n");
        //initiate a new employee for each line and add them to the list and then return it
        while (fileScanner.hasNext()) {
            String [] line = fileScanner.nextLine().split(",");
            employeeList.add(new Employee(line[0], Integer.parseInt(line[1]), Double.parseDouble(line[2])));
        }
        fileScanner.close();
        System.out.println(employeeList);
        return employeeList;
    }
    @Override
    public void exportEmployees(List<Employee> employees, String destinationFolder) {
        char choice;
        do
        {
            Scanner myObj = new Scanner(System.in);
            System.out.println("Enter employee's name please");
            String employeeName = myObj.nextLine();

            System.out.println("Enter employee's age please");
            int employeeAge = myObj.nextInt();

            System.out.println("Enter employee's Salary please");
           Double employeeSalary = myObj.nextDouble();
//            myObj.close();

            Employee employee = new Employee(employeeName,employeeAge,employeeSalary);

            //add employee to employeeList
            employees.add(employee);
            System.out.println("Employee added!");

            Scanner reader = new Scanner(System.in);
            System.out.println("Press any button to continue adding employees, Press N to exit");
            choice = reader.next().charAt(0);
//            reader.close();


        }
        while(choice!='N' && choice != 'n');

        // write to file
        try {
            FileWriter output = new FileWriter(destinationFolder);

            for (int i = 0; i < employees.size(); i++) {
                Employee employee = (Employee) employees.get(i);
                String data = employee.getName() + "," + String.valueOf(employee.getAge()) + "," + String.valueOf(employee.getSalary()) + "\n";
                output.write(data);
            }
            output.close();

        }catch(Exception e) {
            e.getStackTrace();
        }
    }
}
