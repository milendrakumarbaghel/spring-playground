package org.geofence.springplayground.exceptions;

public class StudentNotFoundException extends NullPointerException {
    public StudentNotFoundException(int id) {
        super("Student not found with id: " + id);
    }
}
