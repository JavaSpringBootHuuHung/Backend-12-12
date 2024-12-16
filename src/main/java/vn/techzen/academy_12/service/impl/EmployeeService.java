package vn.techzen.academy_12.service.impl;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;
import vn.techzen.academy_12.entity.Employee;
import vn.techzen.academy_12.entity.Gender;
import vn.techzen.academy_12.repository.IEmployeeRepository;
import vn.techzen.academy_12.service.IEmployeeService;

import java.time.LocalDate;
import java.util.List;

@Service
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class EmployeeService  implements IEmployeeService {
    IEmployeeRepository employeeRepository;

    @Override
    public List<Employee> findAll(String name, LocalDate dobFrom, LocalDate dobTo, Gender gender, Integer salaryRange, String phone, Integer department_id) {
        return employeeRepository.findByAttr( name,  dobFrom,  dobTo,  gender,  salaryRange,  phone,  department_id);
    }
    @Override
    public Employee findById(int id) {
        return employeeRepository.findById(id).get();
    }
    @Override
    public Employee save(Employee employee) {
        return employeeRepository.save(employee);
    }
    @Override
    public Employee update(Employee employee, int id) {

        Employee emp = employeeRepository.findById(id).get();
        if(emp != null) {
            emp.setName(employee.getName());
            emp.setGender(employee.getGender());
            emp.setSalary(employee.getSalary());
            emp.setPhone(employee.getPhone());
            emp.setBirthDate(employee.getBirthDate());
            return employeeRepository.save(employee);
        }
        return null;

    }

    @Override
    public Void deleteEmployee(int id) {
        return null;
    }

    public void deleteById(int id) {
        employeeRepository.deleteById(id);
    }

}