package org.geofence.springplayground.dto;

import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class EmployeeRequestDTO {

    @NotBlank(message = "Name is required")
    private String empName;

    private String empCity;

    private String cityCode;

    @NotNull(message = "Salary is required")
    @PositiveOrZero(message = "Salary must be positive")
    private Double empSalary;

    @NotNull(message = "Age is required")
    @Min(value = 18, message = "Age must be at least 18")
    private Integer empAge;

    @NotBlank(message = "Email is required")
    @Email(message = "Invalid email format")
    private String empEmail;
}


