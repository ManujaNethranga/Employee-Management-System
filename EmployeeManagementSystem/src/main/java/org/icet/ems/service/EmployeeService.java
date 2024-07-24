package org.icet.ems.service;

import org.icet.ems.dto.Employee;

import java.util.List;

public interface EmployeeService {
    Employee persist(Employee employee);

    List<Employee> retrive();
}
