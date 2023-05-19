package com.hamze.reactivelabr2dbc.domain.entity;


import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;


@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "employee")
public class EmployeeEntity extends ABaseVersionedEntity<Integer> {

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
