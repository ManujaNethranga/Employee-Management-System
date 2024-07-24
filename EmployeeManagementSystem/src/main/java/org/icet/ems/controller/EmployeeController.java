package org.icet.ems.controller;

import org.icet.ems.dto.Employee;
import org.icet.ems.service.EmployeeService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

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
    @ResponseStatus(HttpStatus.CREATED)
    void addEmployee(@RequestBody Employee employee){
        employeeService.persist(employee);
    }

    @GetMapping()
    List<Employee> retriveEmployee(){
        return employeeService.retrive();
    }

    @DeleteMapping("/{id}")
    String delete(@PathVariable Long id){
        return employeeService.delete(id);
    }

    @PatchMapping()
    String update(@RequestBody Employee employee){
        return employeeService.update(employee);
    }

    @GetMapping("/{id}")
    Employee findById(@PathVariable Long id){
        return employeeService.findById(id);
    }

    @GetMapping("/name/{name}")
    Employee findByName(@PathVariable String name){
        return employeeService.findByName(name);
    }

}
