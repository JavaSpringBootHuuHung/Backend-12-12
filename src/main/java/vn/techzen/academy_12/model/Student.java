package vn.techzen.academy_12.model;

import lombok.*;
import lombok.experimental.FieldDefaults;

//generate getter và setter
@Getter
@Setter
// contructor không có tham số
@NoArgsConstructor
// tạo constructor có đầy đủ tham số
@AllArgsConstructor
// thêm thuococj tính private
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Student {
     int id;
     String name;
     double score;

}
