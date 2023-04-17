package com.cosmos;

import com.cosmos.pojo.Person;
import com.cosmos.pojo.Student;
import com.cosmos.service.StudentServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@SpringBootApplication
@Slf4j
public class InterviewPrepApplication implements CommandLineRunner {
	@Autowired
	private StudentServiceImpl studentService;
	@Autowired
	private Person person;

	public static void main(String[] args) {
		SpringApplication.run(InterviewPrepApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		log.info("New 10th Student List, ");
		List<Student> studentList = studentService.getAllDefaultTenthStudents();
		studentList.stream()
				.forEach(System.out::println);
		List<Student> studentListNew = studentService.addNewStudent(studentList);
		studentListNew.stream()
				.forEach(System.out::println);
		Set<Student> studentSet = new HashSet<>();
		for(Student student:studentListNew){
			boolean response = studentSet.add(student);
			if(response==false){
				log.info("not inserting this record coz duplicate "+student);
			}
		}
		//studentSet.addAll(studentListNew);
		log.info("Unique 10th Student List, ");
		studentSet.stream()
				.forEach(System.out::println);

		//log.info("The person name is : "+person.getName());

		//read from console Student data and add to list/set
		/*Student student= studentService.readStudentFromConsole();
		//Optional<Student> optionalStudent = Optional.of(student);
		Optional.ofNullable(student.getClassValue())
				.orElse(10l);
		Optional.ofNullable(student.getStudentName())
				.orElse("Nikita");
		studentSet.add(student);
		Optional.ofNullable(student.getDob())
				.orElse(LocalDate.now());

		log.info("Unique 10th Student List, ");
		studentSet.stream()
				.forEach(System.out::println);

		log.info("The person name is : "+person.getName());*/
	}
}
