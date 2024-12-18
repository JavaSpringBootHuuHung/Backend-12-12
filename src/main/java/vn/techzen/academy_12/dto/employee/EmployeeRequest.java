package vn.techzen.academy_12.dto.employee;

import lombok.*;
import lombok.experimental.FieldDefaults;
import vn.techzen.academy_12.dto.department.DepartmentRequest;
import vn.techzen.academy_12.entity.Gender;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class EmployeeRequest {
    String name;
    LocalDate birthDate;
    double salary;
    Gender gender;
    String phone;

    //Department
    DepartmentRequest department;
}
