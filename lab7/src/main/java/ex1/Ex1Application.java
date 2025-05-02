package ex1;

import java.util.Optional;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;

import ex1.entity.Student;
import ex1.repository.StudentPagingAndSortingRepository;
import ex1.repository.StudentQueryRepository;
import ex1.repository.StudentRepository;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;

@SpringBootApplication
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@RequiredArgsConstructor
public class Ex1Application {
	StudentRepository studentRepository;
	StudentQueryRepository studentQueryRepository;
	StudentPagingAndSortingRepository studentPagingAndSortingRepository;

	public static void main(String[] args) {
		SpringApplication.run(Ex1Application.class, args);
	}

	@Bean
	CommandLineRunner commandLineRunner() {
		return args -> {
			System.out.println("Java Technology have started");

			studentRepository
					.save(Student.builder().name("Student 1").age(17).email("abc@abc.com").ieltsScore(7.5).build());
			studentRepository
					.save(Student.builder().name("Student 2").age(20).email("abc@abc.com").ieltsScore(7.0).build());
			studentRepository
					.save(Student.builder().name("Student 3").age(15).email("abc@abc.com").ieltsScore(5.5).build());
			studentRepository
					.save(Student.builder().name("Student 4").age(15).email("abc@abc.com").ieltsScore(5.5).build());
			studentRepository
					.save(Student.builder().name("Student 5").age(15).email("abc@abc.com").ieltsScore(5.5).build());
			studentRepository
					.save(Student.builder().name("Student 6").age(15).email("abc@abc.com").ieltsScore(5.5).build());
			studentRepository
					.save(Student.builder().name("Student 7").age(15).email("abc@abc.com").ieltsScore(5.5).build());
			studentRepository
					.save(Student.builder().name("Student 8").age(15).email("abc@abc.com").ieltsScore(5.5).build());
			studentRepository
					.save(Student.builder().name("Student 9").age(15).email("abc@abc.com").ieltsScore(5.5).build());
			studentRepository
					.save(Student.builder().name("Student 10").age(15).email("abc@abc.com").ieltsScore(5.5).build());
			studentRepository.findAll().stream().forEach(System.out::println);
			Student updateStudent = studentRepository.findAll().get(0);
			long id = updateStudent.getId();
			System.out.println("---Student before update:---\n" + updateStudent);
			updateStudent.setName("Updated Student");
			studentRepository.save(updateStudent);
			System.out.println("---Student after update:---\n" + updateStudent);
			studentRepository.deleteById(id);
			Optional<Student> deletedStudent = studentRepository.findById(id);
			if (!deletedStudent.isPresent())
				System.out.println("Student id(" + id + ") have deleted");
			System.out.println("---Jpa Method---");
			studentRepository.findAllByNameContainingIgnoreCase("udent").stream().forEach(System.out::println);
			studentRepository.findAllByAgeGreaterThan(7).stream().forEach(System.out::println);
			System.out.println(studentRepository.countByIeltsScoreEquals(7.0));
			System.out.println("---Jpa Query Annotation Method---");
			studentQueryRepository.findAllByNameContainingIgnoreCase("udent").stream().forEach(System.out::println);
			studentQueryRepository.findAllByAgeGreaterThan(7).stream().forEach(System.out::println);
			System.out.println(studentQueryRepository.countByIeltsScoreEquals(7.0));
			System.out.println("---Sorting---");
			studentPagingAndSortingRepository.findAll(Sort.by(Sort.Order.desc("age"), Sort.Order.asc("ieltsScore")))
					.forEach(System.out::println);
			System.out.println("---Pagination---");
			studentPagingAndSortingRepository.findAll(PageRequest.of(1, 3)).getContent().forEach(System.out::println);
			;
		};
	}

}
