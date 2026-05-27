package org.geofence.springplayground;

import org.geofence.springplayground.dao.EmployeeDao;
import org.geofence.springplayground.dao.StudentDao;
import org.geofence.springplayground.entities.Employee;
import org.geofence.springplayground.entities.Student;
import org.geofence.springplayground.repositories.EmployeeRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;
import java.util.Optional;

@SpringBootApplication
public class SpringplaygroundApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringplaygroundApplication.class, args);
    }

//    @Bean
//    public CommandLineRunner commandLineRunner(StudentDao studentDao, EmployeeDao employeeDao, EmployeeRepository employeeRepository) {
//        return runner -> {
//            createStudent(studentDao);
//            readStudent(studentDao);
//            updateStudent(studentDao, 1);
//            readAllStudents(studentDao);
//            createEmployees(employeeDao);
//            readAllEmployees(employeeDao);
//            updateEmployee(employeeDao, 1, "Hyderabad", 10000);
//            deleteEmployee(employeeDao, 2);
//            deleteAllEmployees(employeeDao);
//            readById(employeeDao, 1);
//            readByName(employeeDao, "Priya");
//            readByAge(employeeDao, 27);
//            readByCityCode(employeeDao, "DL01");
//            readBySalary(employeeDao, 10000);

            // JPA
//            createEmployees(employeeRepository);

//            Optional<Employee> employee = findEmployeeById(employeeRepository, 1);
//            System.out.println("Employee found: " + employee);
//
//            List<Employee> employeesByName = findEmployeeByName(employeeRepository, "Amit Sharma");
//            System.out.println("Employees find by name: ");
//            for(Employee emp : employeesByName) {
//                System.out.println(emp);
//            }
//
//            List<Employee> employeesByCity = findEmployeeByCity(employeeRepository, "Bhopal");
//            System.out.println("Employees find by City: ");
//            for(Employee emp : employeesByCity) {
//                System.out.println(emp);
//            }
//
//            List<Employee> employeesByCityCode = findEmployeeByCityCode(employeeRepository, "MP02");
//            System.out.println("Employees find by City Code: ");
//            for(Employee emp : employeesByCityCode) {
//                System.out.println(emp);
//            }
//
//            List<Employee> employeesBySalary = findEmployeeBySalary(employeeRepository, 22000);
//            System.out.println("Employees find by Salary: ");
//            for(Employee emp : employeesBySalary) {
//                System.out.println(emp);
//            }
//
//            List<Employee> employeesByAge = findEmployeeByAge(employeeRepository, 25);
//            System.out.println("Employees find by Age: ");
//            for(Employee emp : employeesByAge) {
//                System.out.println(emp);
//            }
//
//            Optional<Employee> employeeByEmail = findEmployeeByEmail(employeeRepository, "priya1@gmail.com");
//            System.out.println("Employees find by Email: " + employeeByEmail);
//
//        };
//    }

    // JPA Methods
//    private void createEmployees(EmployeeRepository employeeRepository) {
//        // Clear existing employees to avoid unique constraint violations
//        employeeRepository.deleteAll();
//
//        List<Employee> employees = List.of(
//                // Same city (Bhopal)
//                new Employee("Amit Sharma", "Bhopal", "MP01", 15000, 25, "amit1@gmail.com"),
//                new Employee("Rohit Verma", "Bhopal", "MP01", 18000, 28, "rohit1@gmail.com"),
//                new Employee("Neha Singh", "Bhopal", "MP01", 22000, 25, "neha1@gmail.com"),
//
//                // Same name (Amit Sharma)
//                new Employee("Amit Sharma", "Indore", "MP02", 20000, 30, "amit2@gmail.com"),
//                new Employee("Amit Sharma", "Delhi", "DL01", 25000, 35, "amit3@gmail.com"),
//
//                // Same age (25)
//                new Employee("Priya Patel", "Ahmedabad", "GJ01", 18000, 25, "priya1@gmail.com"),
//                new Employee("Karan Mehta", "Mumbai", "MH01", 40000, 25, "karan1@gmail.com"),
//
//                // Same city_code (MP02)
//                new Employee("Anjali Gupta", "Indore", "MP02", 12000, 23, "anjali1@gmail.com"),
//                new Employee("Vikas Yadav", "Indore", "MP02", 14000, 27, "vikas1@gmail.com"),
//
//                // Same salary (>10000 cases)
//                new Employee("Sneha Reddy", "Hyderabad", "TS01", 30000, 29, "sneha1@gmail.com"),
//                new Employee("Arjun Nair", "Kochi", "KL01", 30000, 31, "arjun1@gmail.com"),
//
//                // Mixed duplicates
//                new Employee("Neha Singh", "Delhi", "DL01", 22000, 30, "neha2@gmail.com"),
//                new Employee("Rohit Verma", "Mumbai", "MH01", 18000, 28, "rohit2@gmail.com")
//        );
//
//        employeeRepository.saveAll(employees);
//
//        System.out.println("Inserted realistic messy data. Finally your queries have something to chew on.");
//    }
//
//    private Optional<Employee> findEmployeeByEmail(EmployeeRepository employeeRepository, String mail) {
//        return employeeRepository.findByEmpEmail(mail);
//    }
//
//    private List<Employee> findEmployeeByAge(EmployeeRepository employeeRepository, int age) {
//        return employeeRepository.findByEmpAge(age);
//    }
//
//    private List<Employee> findEmployeeBySalary(EmployeeRepository employeeRepository, double salary) {
//        return employeeRepository.findByEmpSalary(salary);
//    }
//
//    private List<Employee> findEmployeeByCityCode(EmployeeRepository employeeRepository, String cityCode) {
//        return employeeRepository.findByCityCode(cityCode);
//    }
//
//    private List<Employee> findEmployeeByCity(EmployeeRepository employeeRepository, String city) {
//        return employeeRepository.findByEmpCity(city);
//    }
//
//    private List<Employee> findEmployeeByName(EmployeeRepository employeeRepository, String name) {
//        return employeeRepository.findByEmpName(name);
//    }
//
//    private Optional<Employee> findEmployeeById(EmployeeRepository employeeRepository, int id) {
//        return employeeRepository.findById(id);
//    }
//
//    // Dao Methods
//    private void deleteAllEmployees(EmployeeDao employeeDao) {
//        System.out.println("\nDeleting all employees...");
//        employeeDao.deleteAll();
//    }
//
//    private void readById(EmployeeDao employeeDao, int id) {
//        System.out.println("\nFind By ID:");
//        Employee employee = employeeDao.findById(id);
//        if (employee != null) {
//            System.out.println(employee.getEmpName());
//        }
//    }
//
//    private void readByName(EmployeeDao employeeDao, String name) {
//        System.out.println("\nFind By Name ("+ name +"): ");
//
//        employeeDao.findByName(name)
//                .forEach(e -> System.out.println(e.getEmpName()));
//    }
//
//    private void readByAge(EmployeeDao employeeDao, int age) {
//        System.out.println("\nFind By Age (" + age +"): ");
//
//        employeeDao.findByAge(age)
//                .forEach(e -> System.out.println(e.getEmpName()));
//    }
//
//    private void readByCityCode(EmployeeDao employeeDao, String cityCode) {
//        System.out.println("\nFind By City Code ("+ cityCode +"): ");
//
//        employeeDao.findByCityCode(cityCode)
//                .forEach(e -> System.out.println(e.getEmpName()));
//    }
//
//    private void readBySalary(EmployeeDao employeeDao, int salary) {
//        System.out.println("\nSalary > " + salary + ":");
//        employeeDao.findBySalaryGreaterThan(salary)
//                .forEach(e -> System.out.println(e.getEmpName()));
//    }
//
//    private void deleteEmployee(EmployeeDao employeeDao, int id) {
//        employeeDao.deleteById(id);
//        System.out.println("Employee deleted!");
//    }
//
//    private void updateEmployee(EmployeeDao employeeDAO, int id, String city, int salary) {
//        Employee emp = employeeDAO.findById(id);
//
//        if (emp != null) {
//            emp.setEmpSalary(salary);
//            emp.setEmpCity(city);
//
//            employeeDAO.update(emp);
//
//            System.out.println("Employee updated!");
//        }
//    }
//
//    private void readAllEmployees(EmployeeDao employeeDao) {
//        List<Employee> employees = employeeDao.findAll();
//
//        for (Employee e : employees) {
//            System.out.println(
//                    e.getEmpId() + " | " +
//                            e.getEmpName() + " | " +
//                            e.getEmpCity() + " | " +
//                            e.getEmpSalary()
//            );
//        }
//    }
//
//    private void createEmployees(EmployeeDao employeeDao) {
//        System.out.println("Creating employees...");
//
//        Employee e1 = new Employee("Amit", "Mumbai", "MH01", 50000, 25, "amit@gmail.com");
//        Employee e2 = new Employee("Rahul", "Delhi", "DL01", 60000, 28, "rahul@gmail.com");
//        Employee e3 = new Employee("Priya", "Pune", "MH12", 55000, 24, "priya@gmail.com");
//        Employee e4 = new Employee("Neha", "Bangalore", "KA01", 70000, 27, "neha@gmail.com");
//
//        employeeDao.save(e1);
//        employeeDao.save(e2);
//        employeeDao.save(e3);
//        employeeDao.save(e4);
//
//        System.out.println("Employees saved!");
//
//    }
//
//    private void updateStudent(StudentDao studentDao, int id) {
//        System.out.println("Getting student with id: " + id);
//
//        Student student = studentDao.findById(id);
//
//        if(student != null) {
//            System.out.println("Updating Student...");
//            student.setName("Amit Tiwari");
//            studentDao.update(student);
//            System.out.println("Student name updated");
//        } else System.out.println("Student not found");
//    }
//
//    private void readAllStudents(StudentDao studentDao) {
//        System.out.println("Fetching all students...");
//        List<Student> students = studentDao.findAll();
//
//        for (Student temp : students) {
//            System.out.println("ID: " + temp.getId() +
//                    " | Name: " + temp.getName());
//        }
//
//    }
//
//    private void readStudent(StudentDao studentDAO) {
//        int id = 1;
//        System.out.println("Fetching student with id: " + id);
//        Student student = studentDAO.findById(id);
//
//        if (student != null) {
//            System.out.println("Student found: " + student.getName());
//        } else {
//            System.out.println("Student not found");
//        }
//    }

//    private void createStudent(StudentDao studentDAO) {
//        System.out.println("Creating multiple students...");
//        Student s1 = new Student("Amit");
//        Student s2 = new Student("Rahul");
//        Student s3 = new Student("Priya");
//        Student s4 = new Student("Neha");
//        Student s5 = new Student("Rohit");
//
//        studentDAO.save(s1);
//        studentDAO.save(s2);
//        studentDAO.save(s3);
//        studentDAO.save(s4);
//        studentDAO.save(s5);
//
//        System.out.println("Students saved!");
//    }
}
