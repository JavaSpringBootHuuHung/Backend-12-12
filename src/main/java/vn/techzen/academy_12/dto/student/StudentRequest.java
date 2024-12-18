package vn.techzen.academy_12.dto.student;

import lombok.*;
import lombok.experimental.FieldDefaults;
import vn.techzen.academy_12.dto.clazz.ClazzRequest;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class StudentRequest {
    String name;
    double score;

    ClazzRequest clazz;
}
