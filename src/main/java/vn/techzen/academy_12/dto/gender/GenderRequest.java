package vn.techzen.academy_12.dto.gender;

import lombok.*;
import lombok.experimental.FieldDefaults;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class GenderRequest {
    String name;

    GenderRequest gender;
}

