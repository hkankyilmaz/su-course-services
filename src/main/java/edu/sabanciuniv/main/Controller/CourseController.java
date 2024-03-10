package edu.sabanciuniv.main.Controller;


import edu.sabanciuniv.main.Entity.Course;
import edu.sabanciuniv.main.Services.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/course")
public class CourseController {

    private final CourseService courseService;

    @Autowired
    public CourseController(CourseService courseService) {
        this.courseService = courseService;
    }


    @PostMapping("/add")
    public String addCourse(@RequestBody Course course) {
        courseService.addCourse(course);
        return "Course added";
    }

    @GetMapping("/delete/{id}")
    public String deleteCourse(@PathVariable("id") int id) {
        courseService.deleteCourse(id);
        return "Course deleted";
    }

    @PutMapping("/update")
    public String updateCourse(@RequestBody Course course) {
        courseService.updateCourse(course);
        return "Course updated";
    }

    @GetMapping("/get/{id}")
    public Course getCourse(@PathVariable("id") int id) {
        return courseService.getCourseById(id);
    }


    @GetMapping("/getAllCourses")
    public ArrayList<Course> getAllCourses() {
        return courseService.getAllCourses();
    }


}
