package com.progressoft.employee.domain;

import java.io.FileNotFoundException;
import java.util.List;

public interface EmployeeUtils {
    List<Employee> importEmployees(String destinationFolder) throws FileNotFoundException;
    void exportEmployees(List<Employee> employees, String destinationFolder);
}
