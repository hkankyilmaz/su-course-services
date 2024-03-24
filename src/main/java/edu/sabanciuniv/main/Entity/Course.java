package edu.sabanciuniv.main.Entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
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
    @JsonIgnoreProperties("courses")
    @ManyToMany(mappedBy = "courses")
    private List<Student> students;
    @JsonIgnoreProperties("courses")
    @ManyToMany(mappedBy = "courses")
    private List<Instructer> instructers;


}