package vn.techzen.academy_12.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.LocalDate;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)

public class Employee {
     String id;
     String name;
     LocalDate birthDate; // Đổi từ Date sang LocalDate
     double salary;
     Gender gender;
     String phone;
     Integer departmentId;
}
