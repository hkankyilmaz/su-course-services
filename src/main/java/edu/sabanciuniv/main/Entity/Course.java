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
    private String instructorName;
    private String courseCode;
    private String courseDescription;
    @ManyToMany(cascade = CascadeType.ALL, mappedBy = "courses")
    private List<Student> students;
}
