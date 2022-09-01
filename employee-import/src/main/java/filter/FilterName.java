package filter;

import com.progressoft.employee.domain.Employee;

import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FilterName {
    public static List<Employee> filterName(List<Employee> employeesList) {
        List<Employee> filteredList = new ArrayList<>();
        System.out.println("type in the wished name");
        Scanner input = new Scanner(System.in);
        String name = input.nextLine();
        for (int i = 0; i < employeesList.size(); i++) {
            if (name.equals(employeesList.get(i).getName())) {
                filteredList.add(employeesList.get(i));
            }
        }

        return filteredList;
    }

    public static List<Employee> noFilterName(List<Employee> employeesList) {
        return employeesList;
    }
}

