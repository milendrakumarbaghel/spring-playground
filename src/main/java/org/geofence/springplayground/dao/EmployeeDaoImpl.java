package org.geofence.springplayground.dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import org.geofence.springplayground.entities.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class EmployeeDaoImpl implements EmployeeDao {
    private EntityManager entityManager;

    @Autowired
    public EmployeeDaoImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    @Transactional
    public void save(Employee employee) {
        entityManager.persist(employee);
    }

    @Override
    public Employee findById(int id) {
        return entityManager.find(Employee.class, id);
    }

    @Override
    public List<Employee> findAll() {
        TypedQuery<Employee> query =
                entityManager.createQuery("FROM Employee", Employee.class);
        return query.getResultList();
    }

    @Override
    @Transactional
    public void update(Employee employee) {
        entityManager.merge(employee);
    }

    @Override
    @Transactional
    public void deleteById(int id) {
        Employee employee = entityManager.find(Employee.class, id);
        if (employee != null) {
            entityManager.remove(employee);
        }
    }

    @Override
    public List<Employee> findByName(String name) {
        TypedQuery<Employee> query = entityManager.createQuery(
                        "FROM Employee WHERE empName = :data",
                        Employee.class);

        query.setParameter("data", name);
        return query.getResultList();
    }

    @Override
    public List<Employee> findByAge(int age) {
        TypedQuery<Employee> query =
                entityManager.createQuery(
                        "FROM Employee WHERE empAge = :age",
                        Employee.class);
        query.setParameter("age", age);

        return query.getResultList();
    }

    @Override
    public List<Employee> findByCityCode(String cityCode) {
        TypedQuery<Employee> query =
                entityManager.createQuery(
                        "FROM Employee WHERE cityCode = :code",
                        Employee.class);
        query.setParameter("code", cityCode);
        return query.getResultList();
    }

    @Override
    public List<Employee> findBySalaryGreaterThan(double salary) {
        TypedQuery<Employee> query =
                entityManager.createQuery(
                        "FROM Employee WHERE empSalary > :salary",
                        Employee.class);
        query.setParameter("salary", salary);

        return query.getResultList();
    }

    @Override
    @Transactional
    public void deleteAll() {

        entityManager.createQuery("DELETE FROM Employee")
                .executeUpdate();
    }
}
