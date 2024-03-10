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
@Table(name = "instructer")
public class Instructer {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private String surname;
    private String email;
    @ManyToMany(mappedBy = "instructers")
    private List<Course> courses;
    @ManyToMany(mappedBy = "instructers")
    private List<Student> students;



}
