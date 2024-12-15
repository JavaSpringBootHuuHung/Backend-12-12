package vn.techzen.academy_12.service.impl;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;
import vn.techzen.academy_12.model.Employee;
import vn.techzen.academy_12.model.Gender;
import vn.techzen.academy_12.repository.IEmployeeRepository;
import vn.techzen.academy_12.repository.impl.EmployeeRepository;
import vn.techzen.academy_12.service.IEmployeeService;

import java.time.LocalDate;
import java.util.List;

@Service
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class EmployeeService  implements IEmployeeService {
    IEmployeeRepository employeeRepository;

    @Override
    public List<Employee> findAll(String name, LocalDate dobFrom, LocalDate dobTo, Gender gender, Integer salaryRange, String phone, Integer departmentId) {
        return employeeRepository.findAll( name,  dobFrom,  dobTo,  gender,  salaryRange,  phone,  departmentId);
    }
    @Override
    public Employee findById(String id){
        return employeeRepository.findById(id);
    }
    @Override
    public Employee save(Employee employee) {
        return employeeRepository.save(employee);
    }
    @Override
    public Employee update(Employee employee) {
        return employeeRepository.update(employee);
    }
    @Override
    public Void deleteEmployee(String id) {
        return employeeRepository.deleteEmployee(id);
    }


}
