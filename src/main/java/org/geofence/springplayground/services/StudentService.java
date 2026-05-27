package org.geofence.springplayground.services;

import org.geofence.springplayground.dto.PageResponseDTO;
import org.geofence.springplayground.dto.StudentRequestDTO;
import org.geofence.springplayground.dto.StudentResponseDTO;

import java.util.List;
import java.util.Map;

public interface StudentService {
    StudentResponseDTO createStudent(StudentRequestDTO studentRequest);
    List<StudentResponseDTO> addMultipleStudents(List<StudentRequestDTO> students);
    StudentResponseDTO getStudentById(int id);
    List<StudentResponseDTO> getAllStudents();
    StudentResponseDTO updateStudentById(int id, StudentRequestDTO updatedStudent);
    StudentResponseDTO updateStudentNameById(int id, StudentRequestDTO updatedStudent);
    Map<String, Object> deleteStudentById(int id);

    PageResponseDTO<StudentResponseDTO> getAllStudentsWithPagination(int pageNumber, int pageSize);
}
