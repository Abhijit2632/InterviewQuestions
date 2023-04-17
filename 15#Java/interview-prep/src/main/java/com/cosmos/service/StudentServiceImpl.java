package com.cosmos.service;

import com.cosmos.pojo.Student;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

@Service
@Slf4j
public class StudentServiceImpl {
    public List<Student> getAllDefaultTenthStudents(){
        List<Student> studentList = Arrays.asList(
                    Student.builder()
                                .studentId(1L)
                                .studentName("Abhijit")
                                .classValue(10l)
                                .dob(LocalDate.of(1989,11,2))
                                .isActive(true)
                                .previousYearMark(67l)
                        .build(),
                Student.builder()
                        .studentId(2L)
                        .studentName("Abhijit Mishra")
                        .classValue(10l)
                        .dob(LocalDate.of(1989,11,2))
                        .isActive(true)
                        .previousYearMark(67l)
                        .build()

        );
        return studentList;
    }

    public List<Student> addNewStudent(List<Student> allDefaultTenthStudents) {
        List<Student> studentList = new ArrayList<Student>();
        Student student = Student.builder()
                .studentId(3L)
                .studentName("Abhijit")
                .classValue(10l)
                .dob(LocalDate.of(1989,11,2))
                .isActive(true)
                .previousYearMark(67l)
                .build();
        Student student1 = Student.builder()
                .studentId(4L)
                .studentName("Abhijit Mishra")
                .classValue(10l)
                .dob(LocalDate.of(1989,11,2))
                .isActive(true)
                .previousYearMark(67l)
                .build();
        Student student2 = Student.builder()
                .studentId(5L)
                .studentName("Abhijit Mishra")
                .classValue(10l)
                .dob(LocalDate.of(1989,11,2))
                .isActive(true)
                .previousYearMark(68l)
                .build();
        Student student3 = Student.builder()
                .studentId(6L)
                .studentName("Abhijit")
                .classValue(10l)
                .dob(LocalDate.of(1989,11,2))
                .isActive(true)
                .previousYearMark(74l)
                .build();
        Student student4 = Student.builder()
                .studentId(7L)
                .studentName("Abhijit")
                .classValue(10l)
                .dob(LocalDate.of(1989,11,2))
                .isActive(true)
                .previousYearMark(74l)
                .build();
        studentList.addAll(allDefaultTenthStudents);
        studentList.add(student);
        studentList.add(student1);
        studentList.add(student2);
        studentList.add(student3);
        studentList.add(student4);
        log.info("Updated the current list");
        return studentList;
    }

    public Student readStudentFromConsole(){
        // Using Scanner for Getting Input from User
        Scanner in = new Scanner(System.in);

        System.out.println("enter studentId ");
        Long studentId = in.nextLong();
        System.out.println("enter studentName ");
        String studentName = in.nextLine();
        System.out.println("enter classValue ");
        Long classValue = in.nextLong();
        System.out.println("enter previousYearMark ");
        Long previousYearMark = in.nextLong();

        Student student = Student.builder()
                .studentId(studentId)
                .studentName(studentName)
                .classValue(classValue)
                .dob(LocalDate.of(1989,11,2))
                .isActive(true)
                .previousYearMark(previousYearMark)
                .build();
        return student;
    }
}
