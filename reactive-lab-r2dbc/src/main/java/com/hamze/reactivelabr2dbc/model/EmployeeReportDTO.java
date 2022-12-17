package com.hamze.reactivelabr2dbc.model;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class EmployeeReportDTO {
    private int count;
    private double totalSalary;

    public void addSalary(double salary) {
        this.totalSalary += salary;
    }

    public void addCount() {
        this.count += 1;
    }
}
