package org.geofence.springplayground.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.boot.convert.DataSizeUnit;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class StudentResponseDTO {

    private String name;
    private int age;
    private String department;

//    public StudentResponseDTO() {
//    }
//
//    public StudentResponseDTO(String name, int age, String department) {
//        this.name = name;
//        this.age = age;
//        this.department = department;
//    }
//
//
//    public String getName() {
//        return name;
//    }
//
//    public void setName(String name) {
//        this.name = name;
//    }
//
//    public int getAge() {
//        return age;
//    }
//
//    public void setAge(int age) {
//        this.age = age;
//    }
//
//    public String getDepartment() {
//        return department;
//    }
//
//    public void setDepartment(String department) {
//        this.department = department;
//    }
}

