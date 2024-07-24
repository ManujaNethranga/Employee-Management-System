package org.icet.ems.dto;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Employee {
    private Long id;
    private String firstName;
    private String lastName;
    private String address;
    private Integer age;
    private Integer phoneNumber;
    private String email;
    private String roleId;
    private String departmentId;
}
