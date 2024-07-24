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
    public void persist(Employee employee) {
          employeeRepository.save(mapper.convertValue(employee, EmployeeEntity.class));
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

    @Override
    public String delete(Long id) {
        if(employeeRepository.existsById(id)){
            employeeRepository.deleteById(id);
        }else{
            return "id Already Deleted";
        }
        return "Deleted";
    }

    @Override
    public String update(Employee employee) {
        if(employeeRepository.existsById(employee.getId())){
            employeeRepository.save(mapper.convertValue(employee, EmployeeEntity.class));
        }else{
            return "Employee Not Found";
        }
        return "Updated";
    }

    @Override
    public Employee findById(Long id) {
        if(employeeRepository.existsById(id)){
            return mapper.convertValue(employeeRepository.findById(id),Employee.class);
        }
        return new Employee();
    }
}
