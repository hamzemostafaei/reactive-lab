package com.hamze.reactivelabr2dbc.controller;

import com.hamze.reactivelabr2dbc.model.EmployeeEntity;
import com.hamze.reactivelabr2dbc.service.IEmployeeSalaryService;
import com.hamze.reactivelabr2dbc.service.IEmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.Duration;
import java.util.List;
import java.util.function.Function;

@RestController
@RequestMapping(value = "/reactive-lab")
@RequiredArgsConstructor
public class EmployeeController {

    private final IEmployeeService employeeService;
    private final IEmployeeSalaryService salaryService;

    @PostMapping(path = "/getEmployeeById", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public Mono<EmployeeEntity> getEmployeeById(@RequestBody Integer employeeId) {

        Flux<EmployeeEntity> fluxEmployees = employeeService
                .getAllEmployees()
                .log()
                .filter(employee -> employee.getId().equals(employeeId))
                .log();

        return fluxEmployees.next();

    }

    @PostMapping(path = "/get-employees-by-salary", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public Mono<List<EmployeeEntity>> findEmployeesBySalaryGreaterThan(@RequestBody Double salary) {
        return employeeService.findEmployeesBySalaryGreaterThan(salary);
    }

    @PostMapping(path = "/get-employees-by-specific-salary", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public Mono<List<EmployeeEntity>> getEmployeeBySpecificSalary(@RequestBody Double salary) {
        return employeeService.getEmployeeBySpecificSalary(salary);
    }

    @PostMapping(path = "/save-employee", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public Mono<EmployeeEntity> saveEmployee(@RequestBody EmployeeEntity employeeEntity) {
        return employeeService.saveEmployee(employeeEntity).log();
    }

    @PostMapping(path = "/get-employees", produces = MediaType.APPLICATION_JSON_VALUE)
    public Mono<List<EmployeeEntity>> getEmployees() {
        return employeeService.getEmployees().log();
    }

    @PostMapping(path = "/save-employees", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public Mono<List<EmployeeEntity>> saveEmployee(@RequestBody List<EmployeeEntity> employeeEntity) {
        return employeeService.saveEmployees(employeeEntity);
    }

    @PostMapping(path = "/calc-salary", produces = MediaType.APPLICATION_JSON_VALUE)
    public Mono<Void> calcSalary() {
        Mono<Void> voidMono = salaryService.calcSalary();
        return voidMono
                .flatMap((Function<Void, Mono<Void>>) unused -> Mono.empty())
                .onErrorResume((Function<Throwable, Mono<Void>>) throwable -> Mono.empty());
    }

    @GetMapping(path = "/getEmployees/stream", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    public Flux<EmployeeEntity> getEmployeesStream() {
        return
                Flux.<EmployeeEntity>generate(
                                synchronousSink -> synchronousSink.next(
                                        new EmployeeEntity(1, "hamze", 1D, 1D, 1D)
                                )
                        )
                        .log()
                        .delayElements(Duration.ofSeconds(1L));

    }

}
