package vn.techzen.academy_12.dto.gender;

import lombok.*;
import lombok.experimental.FieldDefaults;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class GenderResponse {
    int id;
    String name;
    GenderResponse gender;
}
