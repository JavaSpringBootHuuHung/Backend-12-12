package vn.techzen.academy_12.dto.employee;

import lombok.*;
import lombok.experimental.FieldDefaults;
import vn.techzen.academy_12.dto.department.DepartmentResponse;
import vn.techzen.academy_12.entity.Gender;

import java.time.LocalDate;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class EmployeeResponse {
    int id;
    String name;
    LocalDate birthDate;
    double salary;
    String genderName;
    String phone;

    DepartmentResponse department;
}
