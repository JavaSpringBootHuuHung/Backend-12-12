package vn.techzen.academy_12.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Entity
public class Employee {
     @Id
     @GeneratedValue(strategy = GenerationType.IDENTITY)
     int id;
     String name;
     LocalDate birthDate;
     double salary;
     String phone;

     @ManyToOne
     @JoinColumn(name = "department_id") // Đặt tên cột rõ ràng
     Department department;

     @ManyToOne
     @JoinColumn(name = "gender_id") // Đặt tên cột rõ ràng
     Gender gender;
}