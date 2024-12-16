package vn.techzen.academy_12.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import vn.techzen.academy_12.entity.Employee;
import vn.techzen.academy_12.entity.Gender;

import java.time.LocalDate;
import java.util.List;

public interface IEmployeeRepository  extends JpaRepository<Employee, Integer> {

    @Query("""
    FROM Employee  
    WHERE (:name IS NULL OR name LIKE CONCAT('%', :name, '%'))
    AND (:dobFrom IS NULL OR birthDate >= :dobFrom)
    AND (:dobTo IS NULL OR birthDate <= :dobTo)
    AND (:gender IS NULL OR gender = :gender)
    AND (:salaryRange IS NULL OR
        (:salaryRange = 1 AND salary < 5000000) OR 
        (:salaryRange = 2 AND salary >= 5000000 AND salary < 10000000) OR
        (:salaryRange = 3 AND salary >= 10000000 AND salary <= 20000000) OR 
        (:salaryRange = 4 AND salary > 20000000))
    AND (:phone IS NULL OR phone LIKE CONCAT('%', :phone, '%'))
    AND (:departmentId IS NULL OR department = :departmentId)
""")
    List<Employee> findByAttr(
            @Param("name") String name,
            @Param("dobFrom") LocalDate dobFrom,
            @Param("dobTo") LocalDate dobTo,
            @Param("gender") Gender gender,
            @Param("salaryRange") Integer salaryRange,
            @Param("phone") String phone,
            @Param("departmentId") Integer departmentId
    );

}