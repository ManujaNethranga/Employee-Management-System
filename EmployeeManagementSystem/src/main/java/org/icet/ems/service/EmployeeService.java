package org.icet.ems.service;

import org.icet.ems.dto.Employee;

import java.util.List;

public interface EmployeeService {
    void persist(Employee employee);

    List<Employee> retrive();

    String delete(Long id);

    String update(Employee employee);

    Employee findById(Long id);

    Employee findByName(String name);
}
