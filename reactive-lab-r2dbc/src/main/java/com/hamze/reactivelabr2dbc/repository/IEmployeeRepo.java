package com.hamze.reactivelabr2dbc.repository;

import com.hamze.reactivelabr2dbc.domain.entity.EmployeeEntity;
import org.springframework.data.r2dbc.repository.Query;
import org.springframework.data.r2dbc.repository.R2dbcRepository;
import reactor.core.publisher.Flux;

public interface IEmployeeRepo extends R2dbcRepository<EmployeeEntity, Integer> {

    Flux<EmployeeEntity> findEmployeesBySalaryGreaterThan(Double salary);

    @Query("SELECT * FROM EMPLOYEE E WHERE E.SALARY = :salary")
    Flux<EmployeeEntity> getEmployeeBySpecificSalary(Double salary);

    @Query("SELECT NAME,SALARY FROM EMPLOYEE E")
    Flux<EmployeeEntity> getSelectedFields();

}