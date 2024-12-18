
package vn.techzen.academy_12.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import vn.techzen.academy_12.entity.Employee;
import vn.techzen.academy_12.entity.Gender;

import java.time.LocalDate;

public interface IEmployeeService {
    Page<Employee> findAll(String name, LocalDate dobFrom, LocalDate dobTo, Gender gender, Integer salaryRange, String phone, Integer department_id, Pageable pageable);
    Employee findById(int id);
    Employee save(Employee employee);
    Employee update(Employee employee,int id);
    Void deleteEmployee(int id);
}
