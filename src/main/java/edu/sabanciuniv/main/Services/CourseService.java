package edu.sabanciuniv.main.Services;


import edu.sabanciuniv.main.Entity.Course;
import edu.sabanciuniv.main.Repository.CourseRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CourseService {


    private final CourseRepo courseRepo;

    @Autowired
    public CourseService(CourseRepo courseRepo) {
        this.courseRepo = courseRepo;
    }


    public void addCourse(Course course) {
        courseRepo.save(course);
    }

    public void deleteCourse(int id) {
        courseRepo.deleteById(id);
    }

    public void updateCourse(Course course) {
        courseRepo.save(course);
    }

    public Course getCourseById(int id) {
        return courseRepo.findById(id).get();
    }

    public List<Course> getCoursesByName(String name) {
        return courseRepo.findByName(name);
    }

    public ArrayList<Course> getAllCourses() {

        ArrayList<Course> coursesList = new ArrayList<Course>();
        Iterable<Course> courses = courseRepo.findAll();

        for (Course course : courses) {
            coursesList.add(course);
        }

        return coursesList;



    }


}
