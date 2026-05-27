package org.geofence.springplayground.controllers;

import jakarta.validation.Valid;
import org.geofence.springplayground.dto.EmployeeRequestDTO;
import org.geofence.springplayground.dto.EmployeeResponseDTO;
import org.geofence.springplayground.dto.PageResponseDTO;
import org.geofence.springplayground.dto.StudentResponseDTO;
import org.geofence.springplayground.services.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/employee")
public class EmployeeController {

    private final EmployeeService employeeService;

    @Autowired
    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/getAllEmployees")
    public ResponseEntity<List<EmployeeResponseDTO>> getAllEmployees() {
        return ResponseEntity.ok(employeeService.getAllEmployees());
    }

    @GetMapping("/{id}")
    public ResponseEntity<EmployeeResponseDTO> getEmployeeById(@PathVariable int id) {
        return ResponseEntity.ok(employeeService.getEmployeeById(id));
    }

    @PostMapping("/addEmployee")
    public ResponseEntity<EmployeeResponseDTO> createEmployee(@Valid @RequestBody EmployeeRequestDTO employeeRequestDTO) {
        return ResponseEntity.ok(employeeService.createEmployee(employeeRequestDTO));
    }

    @PostMapping("/addBulk")
    public ResponseEntity<List<EmployeeResponseDTO>> addEmployees(@RequestBody List<@Valid EmployeeRequestDTO> employeeRequestDTOs) {
        return ResponseEntity.ok(employeeService.addEmployees(employeeRequestDTOs));
    }

    @PutMapping("/updateById/{id}")
    public ResponseEntity<EmployeeResponseDTO> updateEmployeeById(@PathVariable int id,
                                                                  @Valid @RequestBody EmployeeRequestDTO updatedEmployeeDTO) {
        return ResponseEntity.ok(employeeService.updateEmployeeById(id, updatedEmployeeDTO));
    }

    @PatchMapping("/updateById/{id}")
    public ResponseEntity<EmployeeResponseDTO> patchEmployee(@PathVariable int id,
                                                             @RequestBody EmployeeRequestDTO updatedEmployeeDTO) {
        return ResponseEntity.ok(employeeService.patchEmployeeById(id, updatedEmployeeDTO));
    }

    @DeleteMapping("/deleteById/{id}")
    public ResponseEntity<?> deleteEmployee(@PathVariable int id) {
        Map<String, Object> deleteResponse = employeeService.deleteEmployeeById(id);
        return ResponseEntity.ok(deleteResponse);
    }

    @GetMapping("/page")
    public PageResponseDTO<EmployeeResponseDTO> getAllEmployeesWithPagination(
            @RequestParam(defaultValue = "0") int pageNumber,
            @RequestParam(defaultValue = "5") int pageSize
    ) {
        return employeeService.getAllEmployeesWithPagination(pageNumber, pageSize);
    }
}