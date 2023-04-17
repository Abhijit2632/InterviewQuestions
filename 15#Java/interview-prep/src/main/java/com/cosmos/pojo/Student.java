package com.cosmos.pojo;

import lombok.*;

import java.time.LocalDate;
import java.util.Objects;

@Data
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Student {
    private Long studentId;
    private String studentName;
    private Long classValue;
    private LocalDate dob;
    private Long previousYearMark;
    private boolean isActive;

    //generate equals and hashCode()

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Student)) return false;
        Student student = (Student) o;
        return getStudentName().equals(student.getStudentName()) && Objects.equals(getClassValue(), student.getClassValue()) && getDob().equals(student.getDob()) && getPreviousYearMark().equals(student.getPreviousYearMark());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getStudentName(), getClassValue(), getDob(), getPreviousYearMark());
    }
}
