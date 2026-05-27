package org.geofence.springplayground.dao;

import org.geofence.springplayground.entities.Employee;

import java.util.List;

public interface EmployeeDao {
    void save(Employee employee);
    Employee findById(int id);
    List<Employee> findAll();
    void update(Employee employee);
    void deleteById(int id);

    List<Employee> findByName(String name);

    List<Employee> findByAge(int age);

    List<Employee> findByCityCode(String cityCode);

    List<Employee> findBySalaryGreaterThan(double salary);

    void deleteAll();
}
