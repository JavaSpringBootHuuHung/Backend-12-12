package vn.techzen.academy_12.Controller;

import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import vn.techzen.academy_12.JsonResponse;
import vn.techzen.academy_12.dto.ApiResponse;
import vn.techzen.academy_12.dto.exception.AppException;
import vn.techzen.academy_12.dto.exception.ErrorCode;
import vn.techzen.academy_12.dto.page.PageResponse;
import vn.techzen.academy_12.entity.Employee;
import vn.techzen.academy_12.entity.Gender;
import vn.techzen.academy_12.mapper.IEmployeeMapper;
import vn.techzen.academy_12.service.impl.EmployeeService;

import java.time.LocalDate;
import java.util.stream.Collectors;

@CrossOrigin
@RestController
@AllArgsConstructor
@RequestMapping("employees")
public class ManageEmployeeController {

    EmployeeService employeeService;
    IEmployeeMapper employeeMapper;
    @GetMapping
    public ResponseEntity<?> getAllEmployees(
            @RequestParam(value = "name", required = false) String name,
            @RequestParam(value = "dobFrom", required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate dobFrom,
            @RequestParam(value = "dobTo", required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate dobTo,
            @RequestParam(value = "gender", required = false) Gender gender,
            @RequestParam(value = "salaryRange", required = false) Integer salaryRange,
            @RequestParam(value = "phone", required = false) String phone,
            @RequestParam(value = "departmentId", required = false) Integer departmentId,
            @PageableDefault(size = 2, sort = "id", direction = Sort.Direction.DESC) Pageable pageable
    ) {

        return ResponseEntity.ok(employeeService.findAll(name, dobFrom, dobTo, gender, salaryRange, phone, departmentId, pageable)
                .stream()
                .map(employeeMapper::employeeToEmployeeResponse)
                .collect(Collectors.toList())
        );
    }
//        try {
//            List<Employee> filteredEmployees = employeeService.findAll(name, dobFrom, dobTo, gender, salaryRange, phone, departmentId);
//            return ResponseEntity.ok(ApiResponse.<List<Employee>>builder()
//                    .data(filteredEmployees)
//                    .build());
//        } catch (Exception e) {
//            throw new AppException(ErrorCode.CANNOT_CALL_API);
//        }
//        return ResponseEntity.ok(ApiResponse.<PageResponse<Employee>>builder()
//                .data(new PageResponse<>(employeeService.findAll(name, dobFrom, dobTo, gender, salaryRange, phone, departmentId, pageable)))
//                .build());

    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse<Employee>> getEmployee(@PathVariable int id) {
        Employee employee = employeeService.findById(id);
        if (employee == null) {
            throw  new AppException(ErrorCode.STUDENT_NOT_EXIST);
        }

        return ResponseEntity.ok(ApiResponse.<Employee>builder()
                .data(employee)
                .build());
    }
    // API to add a new employee
    @PostMapping
    public ResponseEntity<ApiResponse<Employee>> addEmployee(@RequestBody Employee employee) {
        employeeService.save(employee);
        return JsonResponse.created(employee);
    }



    // API to update employee by ID
    @PutMapping("/{id}")
    public ResponseEntity<ApiResponse<Employee>> updateEmployee(@PathVariable int id, @RequestBody Employee employee) {
        employeeService.update(employee,id);
        return JsonResponse.ok(employee);
    }

    // API to delete employee by ID
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteEmployee(@PathVariable int id,@PageableDefault(size = 2, sort = "id", direction = Sort.Direction.DESC) Pageable pageable) {
        employeeService.deleteEmployee(id);
        Page<Employee> remainingEmployees = employeeService.findAll(null, null, null, null, null, null, null,pageable);

        return ResponseEntity.ok(ApiResponse.<PageResponse<Employee>>builder()
                .data(new PageResponse<>(remainingEmployees))
                .build());

    }



}