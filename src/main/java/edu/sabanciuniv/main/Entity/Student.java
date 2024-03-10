package edu.sabanciuniv.main.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@Table(name = "student")
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int studentId;
    private String studentName;
    private String studentSurname;
    private String studentEmail;
    @ManyToMany()
    @JoinTable(name = "student_course", joinColumns = @JoinColumn(name = "studentId"), inverseJoinColumns = @JoinColumn(name = "courseId"))
    private List<Course> courses;
    @ManyToMany()
    @JoinTable(name = "student_instructer", joinColumns = @JoinColumn(name = "studentId"), inverseJoinColumns = @JoinColumn(name = "instructerId"))
    private List<Instructer> instructers;

}
