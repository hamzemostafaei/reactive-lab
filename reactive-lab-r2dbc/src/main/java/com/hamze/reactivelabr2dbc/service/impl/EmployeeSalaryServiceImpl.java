package com.hamze.reactivelabr2dbc.service.impl;

import com.hamze.reactivelabr2dbc.model.Employee;
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

            for (Employee employee : employees) {
                employee.setOvertimeSalary(employee.getOvertime() * employee.getSalary());
            }

            Mono<List<Employee>> listMono = employeeService.saveEmployees(employees).log();

            for (Employee employee : employees) {
                if (employee.getId().equals(1)) {
                    employee.setOvertime(1D);
                    employeeService.saveEmployee(employee);
                }
            }

            for (Employee employee : employees) {
                if (employee.getId().equals(1)) {
                    employee.setOvertime(1000D);
                    employeeService.saveEmployee(employee);
                }
            }

            return listMono.flatMap(e -> Mono.empty());
        });

    }

}
