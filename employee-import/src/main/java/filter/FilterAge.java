package filter;

import com.progressoft.employee.domain.Employee;

import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FilterAge {
    public static List<Employee> filterAge(List<Employee> employeesList) {
        List<Employee> filteredList = new ArrayList<>();
        System.out.println("type in the wished age");
        Scanner input = new Scanner(System.in);
        int age = input.nextInt();
        System.out.println("type g if you want to show the ages greater than the age entered" +
                "type l if you want to show the ages less than the age entered" +
                "type e if you want to show the ages equal to the age entered");
        Scanner secondInput = new Scanner(System.in);
        String salaryFilter = secondInput.nextLine();
        if (salaryFilter.equals("e")) {
            for (int i = 0; i < employeesList.size(); i++) {
                if (age == employeesList.get(i).getAge()) {
                    filteredList.add(employeesList.get(i));
                }
            }

        } else if (salaryFilter.equals("l")) {
            for (int i = 0; i < employeesList.size(); i++) {
                if (age > (employeesList.get(i).getAge())) {
                    filteredList.add(employeesList.get(i));
                }
            }
        } else if (salaryFilter.equals("g")) {
            for (int i = 0; i < employeesList.size(); i++) {
                if (age < employeesList.get(i).getAge()) {
                    filteredList.add(employeesList.get(i));
                }
            }
        } else {
            System.out.println("filter entered not understood!");
        }

        return filteredList;
    }

    public static List<Employee> noFilterAge(List<Employee> employeesList) {
        return employeesList;
    }
}
