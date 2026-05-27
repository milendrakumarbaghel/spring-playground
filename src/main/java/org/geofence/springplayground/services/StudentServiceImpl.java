package org.geofence.springplayground.services;

import org.geofence.springplayground.dto.PageResponseDTO;
import org.geofence.springplayground.dto.StudentRequestDTO;
import org.geofence.springplayground.dto.StudentResponseDTO;
import org.geofence.springplayground.entities.Student;
import org.geofence.springplayground.exceptions.StudentNotFoundException;
import org.geofence.springplayground.repositories.StudentRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
public class StudentServiceImpl implements StudentService {
    private final StudentRepository studentRepository;
    private final ModelMapper modelMapper;

    @Autowired
    public StudentServiceImpl(StudentRepository studentRepository, ModelMapper modelMapper) {
        this.studentRepository = studentRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public StudentResponseDTO getStudentById(int id) {
        return toResponseDTO(studentRepository.findById(id)
                .orElseThrow(() -> new StudentNotFoundException(id)));
    }

    @Override
    public List<StudentResponseDTO> addMultipleStudents(List<StudentRequestDTO> students) {
        return studentRepository.saveAll(students.stream()
                        .map(this::toEntity)
                        .toList())
                .stream()
                .map(this::toResponseDTO)
                .toList();
    }

    @Override
    public List<StudentResponseDTO> getAllStudents() {
        return studentRepository.findAll()
                .stream()
                .map(this::toResponseDTO)
                .toList();
    }

    @Override
    public StudentResponseDTO updateStudentById(int id, StudentRequestDTO updatedStudent) {
        Student existingStudent = studentRepository.findById(id).orElseThrow(() -> new StudentNotFoundException(id));
        existingStudent.setName(updatedStudent.getName());
        existingStudent.setAge(updatedStudent.getAge());
        existingStudent.setDepartment(updatedStudent.getDepartment());

        return toResponseDTO(studentRepository.save(existingStudent));
    }

    @Override
    public StudentResponseDTO updateStudentNameById(int id, StudentRequestDTO updatedStudent) {
        Student existingStudent = studentRepository.findById(id).orElseThrow(() -> new StudentNotFoundException(id));

        if (updatedStudent.getName() != null) {
            existingStudent.setName(updatedStudent.getName());
        }

        if (updatedStudent.getAge() != null) {
            existingStudent.setAge(updatedStudent.getAge());
        }

        if (updatedStudent.getDepartment() != null) {
            existingStudent.setDepartment(updatedStudent.getDepartment());
        }

        return toResponseDTO(studentRepository.save(existingStudent));
    }

    @Override
    public Map<String, Object> deleteStudentById(int id) {
        Student student = studentRepository.findById(id)
                .orElseThrow(() -> new StudentNotFoundException(id));

        studentRepository.delete(student);

        return Map.of(
                "status", 200,
                "message", "Student deleted successfully with id: " + id
        );
    }

    @Override
    public StudentResponseDTO createStudent(StudentRequestDTO studentRequest) {
        return toResponseDTO(studentRepository.save(toEntity(studentRequest)));
    }

    private Student toEntity(StudentRequestDTO studentRequest) {
        Student student = new Student();
        student.setName(studentRequest.getName());
        student.setAge(studentRequest.getAge());
        student.setDepartment(studentRequest.getDepartment());
        return student;
    }

    private StudentResponseDTO toResponseDTO(Student student) {
        StudentResponseDTO responseDTO = new StudentResponseDTO();
        responseDTO.setName(student.getName());
        responseDTO.setAge(student.getAge());
        responseDTO.setDepartment(student.getDepartment());
        return responseDTO;
    }

    @Override
    public PageResponseDTO<StudentResponseDTO> getAllStudentsWithPagination(int pageNumber, int pageSize) {
        Pageable pageable = PageRequest.of(pageNumber, pageSize);
        Page<Student> studentPage = studentRepository.findAll(pageable);
        List<Student> students = studentPage.getContent();
        List<StudentResponseDTO> studentResponses = new ArrayList<>();

        for(Student student : students) {
            StudentResponseDTO studentResponseDTO = modelMapper.map(student, StudentResponseDTO.class);
            studentResponses.add(studentResponseDTO);
        }

        PageResponseDTO<StudentResponseDTO> pageResponseDTO = new PageResponseDTO<>();
        pageResponseDTO.setContent(studentResponses);
        pageResponseDTO.setPageNumber(studentPage.getNumber());
        pageResponseDTO.setPageSize(studentPage.getSize());
        pageResponseDTO.setTotalCount((int) studentPage.getTotalElements());
        pageResponseDTO.setLastPage(studentPage.isLast());
        pageResponseDTO.setFirstPage(studentPage.isFirst());
        pageResponseDTO.setTotalPages(studentPage.getTotalPages());

        return pageResponseDTO;
    }
}
