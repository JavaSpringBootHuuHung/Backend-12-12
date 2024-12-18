package vn.techzen.academy_12.mapper;

import org.mapstruct.Mapper;
import vn.techzen.academy_12.dto.student.StudentRequest;
import vn.techzen.academy_12.dto.student.StudentResponse;
import vn.techzen.academy_12.entity.Student;

@Mapper(componentModel = "spring")
public interface IStudentMapper {
    StudentResponse studentToStudentResponse(Student student);
    Student studentRequestToStudent(StudentRequest studentRequest);
}
