package org.geofence.springplayground.advices;

import org.geofence.springplayground.exceptions.EmployeeNotFoundException;
import org.geofence.springplayground.exceptions.UserNotFoundException;
import org.geofence.springplayground.exceptions.StudentNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class GlobalExceptionException {

    @ExceptionHandler(UserNotFoundException.class)
    public ResponseEntity<Map<String, Object>> handleUserNotFoundException(UserNotFoundException exception) {
        Map<String, Object> errorBody = new HashMap<>();

        errorBody.put("Timestamp", LocalDateTime.now());
        errorBody.put("Status", HttpStatus.NOT_FOUND.value());
        errorBody.put("Error", "Not Found");
        errorBody.put("Message", exception.getMessage());

        return new ResponseEntity<>(errorBody, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(EmployeeNotFoundException.class)
    public ResponseEntity<Map<String, Object>> handleEmployeeNotFoundException(EmployeeNotFoundException exception) {
        Map<String, Object> errorBody = new HashMap<>();

        errorBody.put("Timestamp", LocalDateTime.now());
        errorBody.put("Status", HttpStatus.NOT_FOUND.value());
        errorBody.put("Error", "Not Found");
        errorBody.put("Message", exception.getMessage());

        return new ResponseEntity<>(errorBody, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(StudentNotFoundException.class)
    public ResponseEntity<Map<String, Object>> handleStudentNotFoundException(StudentNotFoundException exception) {
        Map<String, Object> errorBody = new HashMap<>();

        errorBody.put("Timestamp", LocalDateTime.now());
        errorBody.put("Status", HttpStatus.NOT_FOUND.value());
        errorBody.put("Error", "Not Found");
        errorBody.put("Message", exception.getMessage());

        return new ResponseEntity<>(errorBody, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(MethodArgumentTypeMismatchException.class)
    public ResponseEntity<Map<String,Object>> handleTypeMismatchException(MethodArgumentTypeMismatchException exception) {
        Map<String, Object> errorBody = new HashMap<>();

        errorBody.put("Timestamp", LocalDateTime.now());
        errorBody.put("Status", HttpStatus.BAD_REQUEST.value());
        errorBody.put("Error", "Bad Request");
        errorBody.put("Message", "Invalid value for '" + exception.getName() + "': " + exception.getValue());

        return new ResponseEntity<>(errorBody, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<Map<String, Object>> handleGeneralException(Exception ex) {
        Map<String, Object> errorBody = new HashMap<>();

        errorBody.put("Timestamp", LocalDateTime.now());
        errorBody.put("Status", HttpStatus.INTERNAL_SERVER_ERROR.value());
        errorBody.put("Error", "Internal Server Error");
        errorBody.put("Message", ex.getMessage() != null ? ex.getMessage() : "Unexpected error occurred");
        errorBody.put("Path", "/api");

        return new ResponseEntity<>(errorBody, HttpStatus.INTERNAL_SERVER_ERROR);
    }

}
