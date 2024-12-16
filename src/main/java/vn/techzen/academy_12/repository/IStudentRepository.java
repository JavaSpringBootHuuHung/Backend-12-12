package vn.techzen.academy_12.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import vn.techzen.academy_12.entity.Student;

import java.util.List;

public interface IStudentRepository extends JpaRepository<Student, Integer>, JpaSpecificationExecutor<Student> {
     List<Student> findByNameContainingAndScoreBetween(String name,
                                                       Double fromScore,
                                                       Double toScore,
                                                       Pageable pageable);

     @Query("""
            
            FROM Student 
            WHERE name LIKE concat('%', :name, '%')
              AND score BETWEEN :fromScore AND :toScore
            """)
     Page<Student> findByAttr(@Param("name") String name,
                              @Param("fromScore") Double fromScore,
                              @Param("toScore") Double toScore,
                              Pageable pageable);

     @Query(value = """
            FROM Student
            WHERE name LIKE concat('%', :name, '%')
              AND score BETWEEN :fromScore AND :toScore
            """)
     List<Student> findByAttrHQL(@Param("name") String name,
                                 @Param("fromScore") Double fromScore,
                                 @Param("toScore") Double toScore,
                                 Pageable pageable);
}
