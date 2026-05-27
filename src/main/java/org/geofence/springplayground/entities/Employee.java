package org.geofence.springplayground.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;

@Entity
@Table(name = "employees")
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int empId;

    @Column(name = "emp_name")
    @NotBlank(message = "Name is required")
    private String empName;

    @Column(name = "emp_city")
    private String empCity;

    @Column(name = "city_code")
    private String cityCode;

    @Column(name = "emp_salary")
    @Min(value = 0, message = "Salary must be positive")
    private double empSalary;

    @Column(name = "emp_age")
    @Min(value = 18, message = "Age must be at least 18")
    private int empAge;

    @Column(name = "emp_email", unique = true)
    @Email(message = "Invalid email format")
    private String empEmail;

    // Constructors
    public Employee() {}

    public Employee(String empName, String empCity, String cityCode,
                    double empSalary, int empAge, String empEmail) {

        this.empName = empName;
        this.empCity = empCity;
        this.cityCode = cityCode;
        this.empSalary = empSalary;
        this.empAge = empAge;
        this.empEmail = empEmail;
    }

    // Getters and Setters
    public int getEmpId() {
        return empId;
    }

    public void setEmpId(int empId) {
        this.empId = empId;
    }

    public String getEmpName() {
        return empName;
    }

    public void setEmpName(String empName) {
        this.empName = empName;
    }

    public String getEmpCity() {
        return empCity;
    }

    public void setEmpCity(String empCity) {
        this.empCity = empCity;
    }

    public String getCityCode() {
        return cityCode;
    }

    public void setCityCode(String cityCode) {
        this.cityCode = cityCode;
    }

    public double getEmpSalary() {
        return empSalary;
    }

    public void setEmpSalary(double empSalary) {
        this.empSalary = empSalary;
    }

    public int getEmpAge() {
        return empAge;
    }

    public void setEmpAge(int empAge) {
        this.empAge = empAge;
    }

    public String getEmpEmail() {
        return empEmail;
    }

    public void setEmpEmail(String empEmail) {
        this.empEmail = empEmail;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "empId=" + empId +
                ", empName='" + empName + '\'' +
                ", empCity='" + empCity + '\'' +
                ", cityCode='" + cityCode + '\'' +
                ", empSalary=" + empSalary +
                ", empAge=" + empAge +
                ", empEmail='" + empEmail + '\'' +
                '}';
    }
}
