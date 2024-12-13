package vn.techzen.academy_12.Controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestClient;
import vn.techzen.academy_12.JsonResponse;
import vn.techzen.academy_12.dto.ApiResponse;
import vn.techzen.academy_12.dto.exception.AppException;
import vn.techzen.academy_12.dto.exception.ErrorCode;
import vn.techzen.academy_12.model.Employee;
import vn.techzen.academy_12.model.Gender;

import java.time.LocalDate;
import java.util.*;
@CrossOrigin
@RestController
@RequestMapping("employees")
public class ManageEmployeeController {


    private List<Employee> employees = new ArrayList<>(Arrays.asList(
            new Employee("E001", "John Doe", LocalDate.of(2003, 12, 1), 1000, Gender.MALE, "0123456789"),
            new Employee("E002", "Jane Smith", LocalDate.of(1998, 5, 15), 1200, Gender.FEMALE, "0987654321")
    ));



    // API to get all employees
    @GetMapping
    public ResponseEntity<?> getAllEmployees() {
        return ResponseEntity.ok(ApiResponse.<List<Employee>>builder()
                .data(employees)
                .build());
    }

    // API to find employee by ID
    @GetMapping({"/{id}"})
    public ResponseEntity<?> getEmployeeById(@PathVariable String id) {
        for (Employee employee : employees) {
            if (employee.getId().equals(id)) {
                return ResponseEntity.ok(ApiResponse.<Employee>builder().data(employee).build());
            }
        }
        throw new AppException(ErrorCode.EMPLOYEE_NOT_EXIST);
    }

    // API to add a new employee
    @PostMapping
    public ResponseEntity<ApiResponse<Employee>> addEmployee(@RequestBody Employee employee) {
        employee.setId(RandomId());  // Generate a new ID
        employees.add(employee);
        return JsonResponse.created(employee);
    }

    // Random ID generation
    public String RandomId() {
        Random random = new Random();
        int id = random.nextInt(10000); // Generate a random number between 0 and 9999
        return String.format("ID%04d", id); // Format the ID as a 4-digit string (e.g., "ID0012")
    }

    // API to update employee by ID
    @PutMapping("/{id}")
    public ResponseEntity<ApiResponse<Employee>> updateEmployee(@PathVariable String id, @RequestBody Employee employee) {
        Optional<Employee> existingEmployeeOpt = employees.stream()
                .filter(e -> e.getId().equals(id))
                .findFirst();

        if (existingEmployeeOpt.isPresent()) {
            Employee existingEmployee = existingEmployeeOpt.get();
            existingEmployee.setName(employee.getName());
            existingEmployee.setBirthDate(employee.getBirthDate());
            existingEmployee.setSalary(employee.getSalary());
            existingEmployee.setGender(employee.getGender());
            existingEmployee.setPhone(employee.getPhone());

            return ResponseEntity.ok(ApiResponse.<Employee>builder().data(existingEmployee).build());
        } else {
            throw new AppException(ErrorCode.EMPLOYEE_NOT_EXIST);
        }
    }

    // API to delete employee by ID
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteEmployee(@PathVariable String id) {
        Optional<Employee> employeeOpt = employees.stream()
                .filter(e -> e.getId().equals(id))
                .findFirst();

        if (employeeOpt.isPresent()) {
            employees.remove(employeeOpt.get());
            return ResponseEntity.ok(ApiResponse.<List<Employee>>builder()
                    .message("Employee deleted successfully")
                    .data(employees)
                    .build());
        } else {
            throw new AppException(ErrorCode.EMPLOYEE_NOT_ACTIVE);
        }
    }

}
