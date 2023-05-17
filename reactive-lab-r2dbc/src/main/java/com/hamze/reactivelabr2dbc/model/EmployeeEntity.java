package com.hamze.reactivelabr2dbc.model;


import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;


@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "t_employee")
public class EmployeeEntity {

    @Id
    @Column("id")
    private Integer id;

    @Column("name")
    private String name;

    @Column("salary")
    private Double salary;

    @Column("overtime")
    private Double overtime;

    @Column("overtime_salary")
    private Double overtimeSalary;

}
