
package vn.techzen.academy_12.service;

import vn.techzen.academy_12.entity.Employee;
import vn.techzen.academy_12.entity.Gender;

import java.time.LocalDate;
import java.util.List;

public interface IEmployeeService {
    public List<Employee> findAll(String name, LocalDate dobFrom, LocalDate dobTo, Gender gender, Integer salaryRange, String phone, Integer department_id);
    public Employee findById(int id);
    public Employee save(Employee employee);
    public Employee update(Employee employee,int id);
    Void deleteEmployee(int id);
}
