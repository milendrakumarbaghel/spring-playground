package org.geofence.springplayground.repositories;

import org.geofence.springplayground.entities.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
//    List<Employee> findByEmpName(String empName);
//    List<Employee> findByEmpCity(String empCity);
//    List<Employee> findByCityCode(String cityCode);
//    List<Employee> findByEmpSalary(double empSalary);
//    List<Employee> findByEmpAge(int empAge);
//    Optional<Employee> findByEmpEmail(String empEmail);
}
