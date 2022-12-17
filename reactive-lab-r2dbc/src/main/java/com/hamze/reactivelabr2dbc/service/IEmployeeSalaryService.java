package com.hamze.reactivelabr2dbc.service;

import org.springframework.transaction.annotation.Transactional;
import reactor.core.publisher.Mono;

@Transactional
public interface IEmployeeSalaryService {
    Mono<Void> calcSalary();
}
