package ex1.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ex1.entity.Student;
@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {
	List<Student> findAllByAgeGreaterThan(long x);
	long countByIeltsScoreEquals(double x);
	List<Student> findAllByNameContainingIgnoreCase(String x);
}
