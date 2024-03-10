package edu.sabanciuniv.main.Controller;


import edu.sabanciuniv.main.Entity.Student;
import edu.sabanciuniv.main.Services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/student")
public class StudentController {


    private final StudentService studentService;

    @Autowired
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @PostMapping("/add")
    public String addStudent(@RequestBody Student student) {
        studentService.addStudent(student);
        return "Student added";

    }

    @GetMapping("/delete/{id}")
    public String deleteStudent(@PathVariable("id") int id) {
        studentService.deleteStudent(id);
        return "Student deleted";
    }

    @PutMapping("/update")
    public String updateStudent(@RequestBody Student student) {
        studentService.updateStudent(student);
        return "Student updated";
    }


    @GetMapping("/get/{id}")
    public Student getStudent(@PathVariable("id") int id) {
        return studentService.getStudentDetailsById(id);
    }


    @GetMapping("/getAllStudents")
    public List<Student> getAllStudents() {
        return studentService.getAllStudents();
    }


    @GetMapping("/getStudentDetailsById/{id}")
    public Student getStudentDetailsById(@PathVariable("id") int id) {
        return studentService.getStudentDetailsById(id);
    }


}
