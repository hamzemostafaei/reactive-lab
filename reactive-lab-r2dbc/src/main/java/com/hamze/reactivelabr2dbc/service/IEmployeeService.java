package com.hamze.reactivelabr2dbc.service;

import com.hamze.reactivelabr2dbc.model.Employee;
import org.springframework.transaction.annotation.Transactional;
import reactor.core.publisher.Mono;

import java.util.List;

@Transactional
public interface IEmployeeService {
    Mono<Employee> getEmployee(Employee employee);

    Mono<List<Employee>> getEmployees();

    Mono<Employee> saveEmployee(Employee employee);

    Mono<List<Employee>> saveEmployees(List<Employee> employees);

    Mono<List<Employee>> findEmployeesBySalaryGreaterThan(Double salary);

    Mono<List<Employee>> getEmployeeBySpecificSalary(Double salary);
}
