package vn.techzen.academy_12.dto.exception;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.http.HttpStatus;

@Getter
@FieldDefaults(level = AccessLevel.PRIVATE)
@NoArgsConstructor
@AllArgsConstructor
public enum ErrorCode {
    EMPLOYEE_NOT_EXIST(1000,"Employee not found",HttpStatus.NOT_FOUND),
    EMPLOYEE_ALREADY_EXIST(1001,"Employee already exist",HttpStatus.CONFLICT),
    EMPLOYEE_NOT_ACTIVE(1002,"Employee not active",HttpStatus.BAD_REQUEST),

    STUDENT_NOT_EXIST(40401,"Student not found",HttpStatus.NOT_FOUND),
    TEACHER_NOT_EXIST(40402,"Teacher not found",HttpStatus.NOT_FOUND),

    ;

    Integer code;
    String message;
    HttpStatus httpStatus;
}
