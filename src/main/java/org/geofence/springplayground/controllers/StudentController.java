package org.geofence.springplayground.controllers;

import jakarta.validation.Valid;
import org.geofence.springplayground.dto.PageResponseDTO;
import org.geofence.springplayground.dto.StudentRequestDTO;
import org.geofence.springplayground.dto.StudentResponseDTO;
import org.geofence.springplayground.entities.Student;
import org.geofence.springplayground.services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/student")
public class StudentController {
//    private StudentRepository studentRepository;
    private final StudentService studentService;

//    @Autowired
//    public StudentController(StudentRepository studentRepository) {
//        this.studentRepository = studentRepository;
//    }

    @Autowired
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping("/getAllStudents")
    public ResponseEntity<List<StudentResponseDTO>> getAllStudents() {
        return ResponseEntity.ok(studentService.getAllStudents());
    }

    @GetMapping("/{id}")
    public ResponseEntity<StudentResponseDTO> getStudentById(@PathVariable int id) {
        return ResponseEntity.ok(studentService.getStudentById(id));
    }

    @PostMapping("/addStudent")
    public ResponseEntity<StudentResponseDTO> createStudent(@Valid @RequestBody StudentRequestDTO studentRequest) {
//        return studentRepository.save(student);
        return ResponseEntity.ok(studentService.createStudent(studentRequest));
    }

    @PostMapping("/addBulk")
    public ResponseEntity<List<StudentResponseDTO>> addMultipleStudents(@RequestBody List<@Valid StudentRequestDTO> students) {
        return ResponseEntity.ok(studentService.addMultipleStudents(students));
    }

    @GetMapping("/hello")
    public String helloStudent() {
        return "hello students";
    }
//
//    @PutMapping("/{id}")
//    public ResponseEntity<Student> updateStudentById(@PathVariable int id, @RequestBody Student updatedStudent) {
//        Optional<Student> foundStudent = studentRepository.findById(id);
//
//        if(foundStudent.isPresent()) {
//            Student existingStudent = foundStudent.get();
//            existingStudent.setName(updatedStudent.getName());
//            existingStudent.setAge(updatedStudent.getAge());
//
//            Student savedStudent = studentRepository.save(existingStudent);
//
//            return ResponseEntity.ok(savedStudent);
//        }
//
//        return ResponseEntity.notFound().build();
//    }

    @PutMapping("updateById/{id}")
    public ResponseEntity<StudentResponseDTO> updateStudentById(@PathVariable int id, @Valid @RequestBody StudentRequestDTO updatedStudent) {

//        Optional<Student> foundStudent = studentRepository.findById(id);
//
//        if (foundStudent.isPresent()) {
//
//            Student existingStudent = foundStudent.get();
//
//            existingStudent.setName(updatedStudent.getName());
//            existingStudent.setAge(updatedStudent.getAge());
//            existingStudent.setDepartment(updatedStudent.getDepartment());
//
//            Student savedStudent = studentRepository.save(existingStudent);
//
//            return ResponseEntity.ok(savedStudent);
//        }

//        return ResponseEntity.notFound().build();


//        Student existingStudent = studentRepository.findById(id).orElseThrow(() -> new StudentNotFoundException(id));
//        existingStudent.setName(updatedStudent.getName());
//        existingStudent.setAge(updatedStudent.getAge());
//        existingStudent.setDepartment(updatedStudent.getDepartment());
//
//        return studentRepository.save(existingStudent);

        return ResponseEntity.ok(studentService.updateStudentById(id, updatedStudent));
    }

    @PatchMapping("updateNameById/{id}")
    public ResponseEntity<StudentResponseDTO> updateStudentNameById(
            @PathVariable int id,
            @RequestBody StudentRequestDTO updatedStudent) {

//        Student existingStudent = studentRepository.findById(id).orElseThrow(() -> new StudentNotFoundException(id));

//        if (existingStudent.isEmpty()) {
//            return ResponseEntity.status(HttpStatus.NOT_FOUND)
//                    .body("Student not found with id: " + id);
//        }

//        Student existingStudent = existingStudent.get();

        // Only update non-null fields
//        if (updatedStudent.getName() != null) {
//            existingStudent.setName(updatedStudent.getName());
//        }
//
//        if (updatedStudent.getAge() != 0) {  // assuming 0 is not valid
//            existingStudent.setAge(updatedStudent.getAge());
//        }
//
//        if (updatedStudent.getDepartment() != null) {
//            existingStudent.setDepartment(updatedStudent.getDepartment());
//        }
//
//        Student savedStudent = studentRepository.save(existingStudent);
//
//        return ResponseEntity.ok(savedStudent);
        return ResponseEntity.ok(studentService.updateStudentNameById(id, updatedStudent));
    }

    @DeleteMapping("/deleteById/{id}")
    public ResponseEntity<?> deleteStudentById(@PathVariable int id) {

//        Student student = studentRepository.findById(id)
//                .orElseThrow(() -> new StudentNotFoundException(id));
//
//        studentRepository.delete(student);
//
//        return ResponseEntity.ok().body(
//                Map.of(
//                        "status", 200,
//                        "message", "Student deleted successfully with id: " + id
//                )
//        );
        Map<String, Object> deleteResponse = studentService.deleteStudentById(id);
        return ResponseEntity.ok().body(
                deleteResponse
        );
    }

    @GetMapping("/test-null")
    public String testNull() {
        String name = null;
        return String.valueOf(name).toUpperCase();
    }

    @GetMapping("/page")
    public PageResponseDTO<StudentResponseDTO> getAllStudentsWithPagination(
            @RequestParam(defaultValue = "0") int pageNumber,
            @RequestParam(defaultValue = "5") int pageSize
    ) {
        return studentService.getAllStudentsWithPagination(pageNumber, pageSize);
    }

}
