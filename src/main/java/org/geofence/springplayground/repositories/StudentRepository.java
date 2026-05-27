package org.geofence.springplayground.repositories;

import org.geofence.springplayground.entities.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, Integer> {
}
