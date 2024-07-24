package org.icet.ems.controller;

import org.icet.ems.dto.Employee;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/employee")
public class EmployeeController {

    List<Employee> list = new ArrayList<>();

    @PostMapping()
    void addEmployee(@RequestBody Employee employee){
        list.add(employee);
    }

    @GetMapping()
    List<Employee> retriveEmployee(){
        return list;
    }

}
