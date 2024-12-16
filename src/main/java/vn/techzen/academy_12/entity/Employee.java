package vn.techzen.academy_12.entity;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.LocalDate;
import java.util.Random;

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
     Gender gender;
     String phone;


     @ManyToOne
      @JoinColumn
     Department department;
}
