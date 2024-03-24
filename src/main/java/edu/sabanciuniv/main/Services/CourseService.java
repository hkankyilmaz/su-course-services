package edu.sabanciuniv.main.Services;


import edu.sabanciuniv.main.CustomException.GeneralCustomException;
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

    public void deleteCourse(int id) throws GeneralCustomException {

        if (courseRepo.findById(id).isEmpty()) {
            throw new GeneralCustomException("Course not found");
        }
        courseRepo.deleteById(id);
    }

    public void updateCourse(Course course) throws GeneralCustomException {

        if (courseRepo.findById(course.getCourseId()).isPresent()) {
            courseRepo.save(course);
        } else {
            throw new GeneralCustomException("Course not found");
        }
    }

    public Course getCourseById(int id) throws GeneralCustomException {

        if (courseRepo.findById(id).isEmpty()) {
            throw new GeneralCustomException("Course not found");
        }
        return courseRepo.findById(id).get();
    }

    public List<Course> getCoursesByName(String name) throws GeneralCustomException {
        if (courseRepo.findByName(name).isEmpty()) {
            throw new GeneralCustomException("Course not found");
        }
        return courseRepo.findByName(name);
    }

    public ArrayList<Course> getAllCourses() {

        ArrayList<Course> coursesList = new ArrayList<Course>();
        Iterable<Course> courses = courseRepo.findAll();


        for (Course course : courses) {
            System.out.println(course.getCourseId());
            coursesList.add(course);
        }

        System.out.println(coursesList.size());


        return coursesList;

    }


}
