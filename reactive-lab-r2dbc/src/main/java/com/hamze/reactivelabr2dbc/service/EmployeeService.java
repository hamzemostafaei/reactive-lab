package com.hamze.reactivelabr2dbc.service;

import com.hamze.reactivelabr2dbc.model.Employee;
import com.hamze.reactivelabr2dbc.repository.EmployeeRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
@Slf4j
public class EmployeeService {

    private final EmployeeRepository employeeRepository;

    public Mono<Employee> getEmployee(Employee employee) {
        return employeeRepository.findOne(
                Example.of(employee)
        );
    }

    public Mono<Employee> saveEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }
}
