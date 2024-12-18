package vn.techzen.academy_12.dto.student;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.*;
import lombok.experimental.FieldDefaults;
import vn.techzen.academy_12.dto.clazz.ClazzRequest;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class StudentRequest {

    @NotBlank(message = "Name cannot be blank")
    @Pattern(regexp = "[A-Za-zÀ-ỹ\\s]+", message = "Name invalid")
    @Size(max = 45, message = "Name must be less than 45 characters.")
    String name;

    @NotNull(message = "Score cannot be null")
    @Min(value = 0, message = "Score cannot be negative") // Đảm bảo score không âm
    @Max(value = 10, message = "Score must be less than or equal to 10") // Đảm bảo score bé hơn hoặc bằng 10
    double score;

    ClazzRequest clazz;
}