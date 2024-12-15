package vn.techzen.academy_12.repository.impl;

import org.springframework.stereotype.Repository;
import vn.techzen.academy_12.dto.exception.AppException;
import vn.techzen.academy_12.dto.exception.ErrorCode;
import vn.techzen.academy_12.model.Employee;
import vn.techzen.academy_12.model.Gender;
import vn.techzen.academy_12.repository.IEmployeeRepository;

import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;

@Repository
public class EmployeeRepository implements IEmployeeRepository {
    private List<Employee> employees = new ArrayList<>(Arrays.asList(
            new Employee("E001", "John Doe", LocalDate.of(2003, 12, 1), 1000, Gender.MALE, "0123456789",1),
            new Employee("E002", "Jane Smith", LocalDate.of(1998, 5, 15), 1200, Gender.FEMALE, "0987654321",2)
    ));
    public List<Employee> findAll(String name, LocalDate dobFrom, LocalDate dobTo, Gender gender, Integer salaryRange, String phone, Integer departmentId) {
        return employees.stream()
                .filter(e -> name == null || e.getName().toLowerCase().contains(name.toLowerCase()))
                .filter(e -> dobFrom == null || !e.getBirthDate().isBefore(dobFrom)) // Includes dobFrom
                .filter(e -> dobTo == null || !e.getBirthDate().isAfter(dobTo))     // Includes dobTo
                .filter(e -> gender == null || e.getGender() == gender)
                .filter(e -> phone == null || e.getPhone().contains(phone))
                .filter(e -> departmentId == null || Objects.equals(e.getDepartmentId(), departmentId))
                .filter(e -> {
                    if (salaryRange == null) return true; // Không lọc nếu salaryRange null
                    return switch (salaryRange) {
                        case 1 -> e.getSalary() < 5000000;
                        case 2 -> e.getSalary() >= 5000000 && e.getSalary() < 10000000;
                        case 3 -> e.getSalary() >= 10000000 && e.getSalary() <= 20000000;
                        case 4 -> e.getSalary() > 20000000;
                        default -> true;
                    };
                })
                .collect(Collectors.toList());
    }
    public Employee findById(String id) {
        for (Employee employee : employees) {
            if (Objects.equals(employee.getId(), id)){
                return employee;
            }

        }
        return  null;
    }
    // Random ID generation
    public String RandomId() {
        Random random = new Random();
        int id = random.nextInt(10000); // Generate a random number between 0 and 9999
        return String.format("ID%04d", id); // Format the ID as a 4-digit string (e.g., "ID0012")
    }
    public Employee save(Employee employee) {
        employee.setId(RandomId());
        employees.add(employee);
        return employee;
    }
    public Employee update(Employee employee) {
        Optional<Employee> existingEmployeeOpt = employees.stream()
                .filter(e -> e.getId().equals(employee.getId()))
                .findFirst();

        if (existingEmployeeOpt.isPresent()) {
            Employee existingEmployee = existingEmployeeOpt.get();
            existingEmployee.setName(employee.getName());
            existingEmployee.setBirthDate(employee.getBirthDate());
            existingEmployee.setSalary(employee.getSalary());
            existingEmployee.setGender(employee.getGender());
            existingEmployee.setPhone(employee.getPhone());
            existingEmployee.setDepartmentId(employee.getDepartmentId());
            return existingEmployee;
        } else {
            throw new AppException(ErrorCode.EMPLOYEE_NOT_EXIST);
        }
    }

    @Override
    public Void deleteEmployee(String id) {
        Optional<Employee> existingEmployeeOpt = employees.stream()
                .filter(e -> e.getId().equals(id))
                .findFirst();

        if (existingEmployeeOpt.isPresent()) {
            employees.remove(existingEmployeeOpt.get());
        } else {
            throw new AppException(ErrorCode.EMPLOYEE_NOT_EXIST);
        }
        return null;
    }


}
