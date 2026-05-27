package org.geofence.springplayground.services;

import org.geofence.springplayground.dto.EmployeeRequestDTO;
import org.geofence.springplayground.dto.EmployeeResponseDTO;
import org.geofence.springplayground.dto.PageResponseDTO;
import org.geofence.springplayground.dto.StudentResponseDTO;
import org.geofence.springplayground.entities.Employee;
import org.geofence.springplayground.entities.Student;
import org.geofence.springplayground.exceptions.EmployeeNotFoundException;
import org.geofence.springplayground.repositories.EmployeeRepository;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    private final EmployeeRepository employeeRepository;
    private final ModelMapper modelMapper;

    public EmployeeServiceImpl(EmployeeRepository employeeRepository, ModelMapper modelMapper) {
        this.employeeRepository = employeeRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public EmployeeResponseDTO getEmployeeById(int id) {
        return toResponseDTO(findEmployeeById(id));
    }

    @Override
    public List<EmployeeResponseDTO> getAllEmployees() {
        return employeeRepository.findAll()
                .stream()
                .map(this::toResponseDTO)
                .toList();
    }

    @Override
    public EmployeeResponseDTO createEmployee(EmployeeRequestDTO employeeRequestDTO) {
        Employee employee = toEntity(employeeRequestDTO);
        return toResponseDTO(employeeRepository.save(employee));
    }

    @Override
    public List<EmployeeResponseDTO> addEmployees(List<EmployeeRequestDTO> employeeRequestDTOs) {
        List<Employee> employees = employeeRequestDTOs.stream()
                .map(this::toEntity)
                .toList();

        return employeeRepository.saveAll(employees)
                .stream()
                .map(this::toResponseDTO)
                .toList();
    }

    @Override
    public EmployeeResponseDTO updateEmployeeById(int id, EmployeeRequestDTO updatedEmployeeDTO) {
        Employee employee = findEmployeeById(id);
        modelMapper.map(updatedEmployeeDTO, employee);
        return toResponseDTO(employeeRepository.save(employee));
    }

    @Override
    public EmployeeResponseDTO patchEmployeeById(int id, EmployeeRequestDTO updatedEmployeeDTO) {
        Employee employee = findEmployeeById(id);
        modelMapper.map(updatedEmployeeDTO, employee);
        return toResponseDTO(employeeRepository.save(employee));
    }

    @Override
    public Map<String, Object> deleteEmployeeById(int id) {
        Employee employee = findEmployeeById(id);
        employeeRepository.delete(employee);

        return Map.of(
                "status", 200,
                "message", "Employee deleted successfully with id: " + id
        );
    }

    private Employee findEmployeeById(int id) {
        return employeeRepository.findById(id)
                .orElseThrow(() -> new EmployeeNotFoundException(id));
    }

    private EmployeeResponseDTO toResponseDTO(Employee employee) {
        return modelMapper.map(employee, EmployeeResponseDTO.class);
    }

    private Employee toEntity(EmployeeRequestDTO dto) {
        return modelMapper.map(dto, Employee.class);
    }

    @Override
    public PageResponseDTO<EmployeeResponseDTO> getAllEmployeesWithPagination(int pageNumber, int pageSize) {
        Pageable pageable = PageRequest.of(pageNumber, pageSize);
        Page<Employee>  employeePage = employeeRepository.findAll(pageable);
        List<Employee> employees = employeePage.getContent();
        List<EmployeeResponseDTO> studentResponses = new ArrayList<>();

        for(Employee employee : employees) {
            EmployeeResponseDTO employeeResponseDTO = modelMapper.map(employee, EmployeeResponseDTO.class);
            studentResponses.add(employeeResponseDTO);
        }

        PageResponseDTO<EmployeeResponseDTO> pageResponseDTO = new PageResponseDTO<>();

        pageResponseDTO.setContent(studentResponses);
        pageResponseDTO.setPageNumber(employeePage.getNumber());
        pageResponseDTO.setPageSize(employeePage.getSize());
        pageResponseDTO.setTotalCount((int) employeePage.getTotalElements());
        pageResponseDTO.setLastPage(employeePage.isLast());
        pageResponseDTO.setFirstPage(employeePage.isFirst());
        pageResponseDTO.setTotalPages(employeePage.getTotalPages());

        return pageResponseDTO;
    }
}
