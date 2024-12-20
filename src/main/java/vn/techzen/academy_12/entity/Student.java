package vn.techzen.academy_12.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
@Entity
public class Student {
     @Id
     @GeneratedValue(strategy = GenerationType.IDENTITY)
     int id;
     String name;
     double score;

     @ManyToOne
     @JsonIgnoreProperties("students")
     Clazz clazz;
}
