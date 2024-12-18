package vn.techzen.academy_12.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import vn.techzen.academy_12.dto.employee.EmployeeRequest;
import vn.techzen.academy_12.dto.employee.EmployeeResponse;
import vn.techzen.academy_12.entity.Employee;
@Mapper(componentModel = "spring")
public interface IEmployeeMapper {
    @Mapping(target = "genderName", source = "gender.name")
    EmployeeResponse employeeToEmployeeResponse(Employee employee);
    Employee employeeRequestToEmployeeRequest(EmployeeRequest employeeRequest);
}
