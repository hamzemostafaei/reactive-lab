package com.hamze.reactivelabr2dbc.service;

import com.hamze.reactivelabr2dbc.domain.entity.EmployeeEntity;
import org.springframework.transaction.annotation.Transactional;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;

@Transactional
public interface IEmployeeService {
	Mono<EmployeeEntity> getEmployee(EmployeeEntity employeeEntity);

	Mono<EmployeeEntity> getEmployeeById(Integer id);

	Mono<List<EmployeeEntity>> getEmployees();

	Mono<EmployeeEntity> saveEmployee(EmployeeEntity employeeEntity);

	Mono<List<EmployeeEntity>> saveEmployees(List<EmployeeEntity> employeeEntities);

	Mono<List<EmployeeEntity>> findEmployeesBySalaryGreaterThan(Double salary);

	Mono<List<EmployeeEntity>> getEmployeeBySpecificSalary(Double salary);

	Flux<EmployeeEntity> getAllEmployees();
}
