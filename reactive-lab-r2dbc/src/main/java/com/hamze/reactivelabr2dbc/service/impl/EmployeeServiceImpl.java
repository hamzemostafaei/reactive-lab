package com.hamze.reactivelabr2dbc.service.impl;

import com.hamze.reactivelabr2dbc.model.Employee;
import com.hamze.reactivelabr2dbc.repository.IEmployeeRepo;
import com.hamze.reactivelabr2dbc.service.IEmployeeService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Slf4j
public class EmployeeServiceImpl implements IEmployeeService {

    private final IEmployeeRepo employeeRepository;

    public Mono<Employee> getEmployee(Employee employee) {
        return employeeRepository.findOne(
                Example.of(employee)
        );
    }

    @Override
    public Mono<List<Employee>> getEmployees() {
        return employeeRepository.findAll().collectList();
    }

    public Mono<Employee> saveEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }

    @Override
    public Mono<List<Employee>> saveEmployees(List<Employee> employees) {
        return employeeRepository.saveAll(employees).collectList();
    }

    @Override
    public Mono<List<Employee>> findEmployeesBySalaryGreaterThan(Double salary) {
        return employeeRepository.findEmployeesBySalaryGreaterThan(salary).collectList();
    }

    @Override
    public Mono<List<Employee>> getEmployeeBySpecificSalary(Double salary) {
        return employeeRepository.getEmployeeBySpecificSalary(salary).collectList();
    }

}
