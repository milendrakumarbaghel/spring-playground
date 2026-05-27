package org.geofence.springplayground.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class EmployeeResponseDTO {

    private String empName;
    private String empCity;
    private String cityCode;
    private double empSalary;
    private int empAge;
    private String empEmail;
}

