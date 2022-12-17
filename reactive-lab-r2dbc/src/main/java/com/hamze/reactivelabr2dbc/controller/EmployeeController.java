package com.hamze.reactivelabr2dbc.controller;

import com.hamze.reactivelabr2dbc.model.Employee;
import com.hamze.reactivelabr2dbc.service.IEmployeeSalaryService;
import com.hamze.reactivelabr2dbc.service.IEmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

import java.util.List;
import java.util.function.Function;

@RestController
@RequestMapping(value = "/reactive-lab")
@RequiredArgsConstructor
public class EmployeeController {

    private final IEmployeeService employeeService;
    private final IEmployeeSalaryService salaryService;

    @PostMapping(path = "/get-employee",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public Mono<Employee> getEmployee(@RequestBody Employee employee) {
        return employeeService.getEmployee(employee)
                .log();
    }

    @PostMapping(path = "/get-employees-by-salary",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public Mono<List<Employee>> findEmployeesBySalaryGreaterThan(@RequestBody Double salary) {
        return employeeService.findEmployeesBySalaryGreaterThan(salary);
    }

    @PostMapping(path = "/get-employees-by-specific-salary",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public Mono<List<Employee>> getEmployeeBySpecificSalary(@RequestBody Double salary) {
        return employeeService.getEmployeeBySpecificSalary(salary);
    }

    @PostMapping(path = "/save-employee",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public Mono<Employee> saveEmployee(@RequestBody Employee employee) {
        return employeeService.saveEmployee(employee).log();
    }

    @PostMapping(path = "/get-employees",
            produces = MediaType.APPLICATION_JSON_VALUE)
    public Mono<List<Employee>> getEmployees() {
        return employeeService.getEmployees().log();
    }

    @PostMapping(path = "/save-employees",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public Mono<List<Employee>> saveEmployee(@RequestBody List<Employee> employee) {
        return employeeService.saveEmployees(employee);
    }

    @PostMapping(path = "/calc-salary",
            produces = MediaType.APPLICATION_JSON_VALUE)
    public Mono<Void> calcSalary() {
        Mono<Void> voidMono = salaryService.calcSalary();
        return voidMono.flatMap((Function<Void, Mono<Void>>) unused -> Mono.empty())
                .onErrorResume((Function<Throwable, Mono<Void>>) throwable -> Mono.empty());
    }

}
