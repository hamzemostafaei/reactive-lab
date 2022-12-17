package com.hamze.reactivelabblocking.model;


import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
public class Employee {

    @Id
    @Column(name = "id")
    private Integer id;

    @Column(name = "name")
    private String name;

    @Column(name = "salary")
    private Double salary;

    @Column(name = "overtime")
    private Double overtime;

    @Column(name = "overtime_salary")
    private Double overtimeSalary;

}
