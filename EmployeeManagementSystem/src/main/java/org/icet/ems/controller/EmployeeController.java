package org.icet.ems.controller;

import org.icet.ems.dto.Employee;
import org.icet.ems.service.EmployeeService;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/employee")
public class EmployeeController {

    final EmployeeService employeeService;

    EmployeeController(EmployeeService employeeService){
        this.employeeService = employeeService;
    }


    @PostMapping()
    Employee addEmployee(@RequestBody Employee employee){
        return employeeService.persist(employee);
    }

    @GetMapping()
    List<Employee> retriveEmployee(){
        return employeeService.retrive();
    }

}
