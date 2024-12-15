package vn.techzen.academy_12.service;

import vn.techzen.academy_12.model.Employee;
import vn.techzen.academy_12.model.Gender;

import java.time.LocalDate;
import java.util.List;

public interface IEmployeeService {
    public List<Employee> findAll(String name, LocalDate dobFrom, LocalDate dobTo, Gender gender, Integer salaryRange, String phone, Integer departmentId);
    public Employee findById(String id);
    public Employee save(Employee employee);
    public Employee update(Employee employee);
    Void deleteEmployee(String id);
}
