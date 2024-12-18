package vn.techzen.academy_12.entity;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Gender {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;

    String name; // Chỉ cần tên giới tính
}