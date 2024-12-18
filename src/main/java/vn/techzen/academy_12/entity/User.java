package vn.techzen.academy_12.entity;


import jakarta.persistence.*;

import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.HashSet;
import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @Column(unique = true)
    String username;

    String password;

    @OneToOne
    @JoinColumn(name = "profile_id")
    UserProfile profile;
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
            name = "user_roles", // Tên bảng trung gian
            joinColumns = @JoinColumn(name = "user_id"), // Cột khóa ngoại tham chiếu đến User
            inverseJoinColumns = @JoinColumn(name = "role_id") // Cột khóa ngoại tham chiếu đến Role
    )
    Set<Role> roles = new HashSet<>();

}