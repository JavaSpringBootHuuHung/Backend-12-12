package vn.techzen.academy_12.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import vn.techzen.academy_12.entity.Student;

import java.util.List;

public interface IStudentRepository extends JpaRepository<Student, Integer> {
     List<Student> findByNameContainingAndScoreBetween(String name,Double fromScore,Double toScore);

     @Query("""
        FROM Student where
        name like  concat('%', :name, '%')
        AND (:fromScore IS NULL OR score>=:fromScore)
        AND (:toScore IS NULL OR score<=:toScore)
""")
     List<Student> findByAttr(String name,Double fromScore,Double toScore);
}
