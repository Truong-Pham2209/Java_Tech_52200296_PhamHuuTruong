package ex1.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

@Entity
@Table(name = "student")
@FieldDefaults(level = AccessLevel.PRIVATE)
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Student {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	long id;
	@Column(name = "name", nullable = false)
	String name;
	@Column(name = "age", nullable = false)
	int age;
	@Column(name = "email", nullable = false)
	String email;
	@Column(name = "ieltsScore", nullable = false)
	double ieltsScore;
}
