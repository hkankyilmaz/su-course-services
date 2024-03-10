package edu.sabanciuniv.main.Repository;

import edu.sabanciuniv.main.Entity.Course;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CourseRepo extends CrudRepository<Course, Integer> {


    @Query("select c from Course c where c.courseName = ?1")
    public List<Course> findByName(String name);



}
