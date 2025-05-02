package ex1.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import ex1.entity.Student;
@Repository
public interface StudentQueryRepository extends JpaRepository<Student,Long> {
	@Query("SELECT s FROM Student s WHERE s.age > :x")
    List<Student> findAllByAgeGreaterThan(@Param("x") long x);

    @Query("SELECT COUNT(s) FROM Student s WHERE s.ieltsScore = :x")
    long countByIeltsScoreEquals(@Param("x") double x);

    @Query("SELECT s FROM Student s WHERE LOWER(s.name) LIKE LOWER(CONCAT('%', :x, '%'))")
    List<Student> findAllByNameContainingIgnoreCase(@Param("x") String x);
}
