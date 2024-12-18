package vn.techzen.academy_12.dto.student;

import lombok.*;
import lombok.experimental.FieldDefaults;
import vn.techzen.academy_12.dto.clazz.ClazzResponse;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class StudentResponse {
    int id;
    String name;
    double score;


    ClazzResponse clazz;
}
