package org.geofence.springplayground.dao;

import org.geofence.springplayground.entities.Student;

import java.util.List;

public interface StudentDao {
    void save(Student student);
    Student findById(int id);
    List<Student> findAll();

    void update(Student student);
}
