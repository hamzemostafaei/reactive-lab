package com.hamze.reactivelabr2dbc.service.impl;

import com.hamze.reactivelabr2dbc.domain.entity.EmployeeEntity;
import com.hamze.reactivelabr2dbc.repository.IEmployeeRepo;
import com.hamze.reactivelabr2dbc.service.IEmployeeService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class EmployeeServiceImpl implements IEmployeeService {

    private final IEmployeeRepo employeeRepository;

    public Mono<EmployeeEntity> getEmployee(EmployeeEntity employeeEntity) {
        return employeeRepository.findOne(
                Example.of(employeeEntity)
        );
    }

    @Override
    public Mono<EmployeeEntity> getEmployeeById(Integer id) {
        return employeeRepository.findById(id);
    }

    @Override
    public Mono<List<EmployeeEntity>> getEmployees() {
        return employeeRepository
                .findAll()
                .log()
                .collectList()
                .log();
    }

    public Mono<EmployeeEntity> saveEmployee(EmployeeEntity employeeEntity) {
        return employeeRepository.save(employeeEntity);
    }

    @Override
    public Mono<List<EmployeeEntity>> saveEmployees(List<EmployeeEntity> employeeEntities) {
        return employeeRepository.saveAll(employeeEntities).collectList();
    }

    @Override
    public Mono<List<EmployeeEntity>> findEmployeesBySalaryGreaterThan(Double salary) {
        return employeeRepository.findEmployeesBySalaryGreaterThan(salary).collectList();
    }

    @Override
    public Mono<List<EmployeeEntity>> getEmployeeBySpecificSalary(Double salary) {
        return employeeRepository.getEmployeeBySpecificSalary(salary).collectList();
    }

    @Override
    public Flux<EmployeeEntity> getAllEmployees(){
        return employeeRepository
                .findAll()
                .log();
    }

}

