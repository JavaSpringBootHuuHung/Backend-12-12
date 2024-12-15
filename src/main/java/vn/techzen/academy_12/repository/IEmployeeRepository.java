package vn.techzen.academy_12.repository;

import vn.techzen.academy_12.model.Employee;
import vn.techzen.academy_12.model.Gender;

import java.time.LocalDate;
import java.util.List;

public interface IEmployeeRepository {
    List<Employee> findAll(String name, LocalDate dobFrom, LocalDate dobTo, Gender gender, Integer salaryRange, String phone, Integer departmentId);
    Employee findById(String id);
    Employee save(Employee employee);
    Employee update(Employee employee);
    Void deleteEmployee(String id);

}
