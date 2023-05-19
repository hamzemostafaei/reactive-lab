package com.hamze.reactivelabr2dbc.service.impl;

import com.hamze.reactivelabr2dbc.domain.entity.EmployeeEntity;
import com.hamze.reactivelabr2dbc.service.IEmployeeSalaryService;
import com.hamze.reactivelabr2dbc.service.IEmployeeService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import reactor.core.publisher.Mono;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class EmployeeSalaryServiceImpl implements IEmployeeSalaryService {

    private final IEmployeeService employeeService;

    public Mono<Void> calcSalary() {

        return employeeService.getEmployees().flatMap(employees -> {
            if (CollectionUtils.isEmpty(employees)) {
                return Mono.empty();
            }

            for (EmployeeEntity employeeEntity : employees) {
                employeeEntity.setOvertimeSalary(employeeEntity.getOvertime() * employeeEntity.getSalary());
            }

            Mono<List<EmployeeEntity>> listMono = employeeService.saveEmployees(employees).log();

            for (EmployeeEntity employeeEntity : employees) {
                if (employeeEntity.getId().equals(1)) {
                    employeeEntity.setOvertime(1D);
                    employeeService.saveEmployee(employeeEntity);
                }
            }

            for (EmployeeEntity employeeEntity : employees) {
                if (employeeEntity.getId().equals(1)) {
                    employeeEntity.setOvertime(1000D);
                    employeeService.saveEmployee(employeeEntity);
                }
            }

            return listMono.flatMap(e -> Mono.empty());
        });

    }

}
