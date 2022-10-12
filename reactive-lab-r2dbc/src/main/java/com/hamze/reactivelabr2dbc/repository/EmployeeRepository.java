package com.hamze.reactivelabr2dbc.repository;

import com.hamze.reactivelabr2dbc.model.Employee;
import org.springframework.data.r2dbc.repository.R2dbcRepository;

public interface EmployeeRepository extends R2dbcRepository<Employee, Long> {
}
