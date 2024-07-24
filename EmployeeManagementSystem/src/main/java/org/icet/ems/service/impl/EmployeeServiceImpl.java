package org.icet.ems.service.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.icet.ems.dto.Employee;
import org.icet.ems.entity.EmployeeEntity;
import org.icet.ems.repository.EmployeeRepository;
import org.icet.ems.service.EmployeeService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    final ObjectMapper mapper;
    final EmployeeRepository employeeRepository;

    EmployeeServiceImpl(ObjectMapper mapper, EmployeeRepository employeeRepository) {
        this.mapper = mapper;
        this.employeeRepository = employeeRepository;
    }

    @Override
    public Employee persist(Employee employee) {
        EmployeeEntity save = employeeRepository.save(mapper.convertValue(employee, EmployeeEntity.class));
        return mapper.convertValue(save, Employee.class);
    }

    @Override
    public List<Employee> retrive() {
        List<Employee> list = new ArrayList<>();
        Iterable<EmployeeEntity> all = employeeRepository.findAll();
        all.forEach(element -> {
            list.add(mapper.convertValue(element, Employee.class));
        });
        return list;
    }
}
