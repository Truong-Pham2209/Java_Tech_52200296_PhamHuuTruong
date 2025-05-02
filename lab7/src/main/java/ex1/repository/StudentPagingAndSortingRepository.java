package ex1.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import ex1.entity.Student;
@Repository
public interface StudentPagingAndSortingRepository extends PagingAndSortingRepository<Student,Long>{
	
}
