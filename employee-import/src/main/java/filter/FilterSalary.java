package filter;

import com.progressoft.employee.domain.Employee;

import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FilterSalary {
    public static List<Employee> filterSalary(List<Employee> employeesList) {
        List<Employee> filteredList = new ArrayList<>();
        System.out.println("type in the wished Salary");
        Scanner input = new Scanner(System.in);
        Double salary = input.nextDouble();
        System.out.println("type g if you want to show the salaries greater than the salary entered" +
                "type l if you want to show the salaries less than the salary entered" +
                "type e if you want to show the salaries equal to the salary entered");
        Scanner secondInput = new Scanner(System.in);
        String salaryFilter = secondInput.nextLine();
        if (salaryFilter.equals("e")) {
            for (int i = 0; i < employeesList.size(); i++) {
                if (salary == employeesList.get(i).getSalary()) {
                    filteredList.add(employeesList.get(i));
                }
            }

        } else if (salaryFilter.equals("g")) {
            for (int i = 0; i < employeesList.size(); i++) {
                if (salary < (employeesList.get(i).getSalary())) {
                    filteredList.add(employeesList.get(i));
                }
            }
        } else if (salaryFilter.equals("l")) {
            for (int i = 0; i < employeesList.size(); i++) {
                if (salary > employeesList.get(i).getSalary()) {
                    filteredList.add(employeesList.get(i));
                }
            }
        } else {
            System.out.println("filter entered not understood!");
        }

        return filteredList;
    }

    public static List<Employee> noFilterSalary(List<Employee> employeesList) {
        return employeesList;
    }
}
