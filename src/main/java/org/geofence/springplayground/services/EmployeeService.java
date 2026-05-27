package org.geofence.springplayground.services;

import org.geofence.springplayground.dto.EmployeeRequestDTO;
import org.geofence.springplayground.dto.EmployeeResponseDTO;
import org.geofence.springplayground.dto.PageResponseDTO;
import org.geofence.springplayground.dto.StudentResponseDTO;

import java.util.List;
import java.util.Map;

public interface EmployeeService {
    EmployeeResponseDTO getEmployeeById(int id);
    List<EmployeeResponseDTO> getAllEmployees();
    EmployeeResponseDTO createEmployee(EmployeeRequestDTO employeeRequestDTO);
    List<EmployeeResponseDTO> addEmployees(List<EmployeeRequestDTO> employeeRequestDTOs);
    EmployeeResponseDTO updateEmployeeById(int id, EmployeeRequestDTO updatedEmployeeDTO);
    EmployeeResponseDTO patchEmployeeById(int id, EmployeeRequestDTO updatedEmployeeDTO);
    Map<String, Object> deleteEmployeeById(int id);

    PageResponseDTO<EmployeeResponseDTO> getAllEmployeesWithPagination(int pageNumber, int pageSize);
}
