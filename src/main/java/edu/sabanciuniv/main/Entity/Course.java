package edu.sabanciuniv.main.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "course")
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int courseId;
    private String courseName;
    private int courseCode;
    private String courseDescription;
    @ManyToMany(mappedBy = "courses")
    private List<Student> students;
    @ManyToMany()
    @JoinTable(name = "instructer_course", joinColumns = @JoinColumn(name = "courseId"), inverseJoinColumns = @JoinColumn(name = "instructerId"))
    private List<Instructer> instructers;
}
