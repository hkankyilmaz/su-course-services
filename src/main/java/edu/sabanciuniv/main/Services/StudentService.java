package edu.sabanciuniv.main.Services;


import edu.sabanciuniv.main.CustomException.GeneralCustomException;
import edu.sabanciuniv.main.Entity.Student;
import edu.sabanciuniv.main.Repository.StudentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class StudentService {


    private final StudentRepo studentRepo;

    @Autowired
    public StudentService(StudentRepo studentRepo) {
        this.studentRepo = studentRepo;
    }

    public void addStudent(Student student) {
        studentRepo.save(student);
    }

    public List<Student> getAllStudents() {
        Iterable<Student> students = studentRepo.findAll();
        List<Student> result = new ArrayList<>();
        for (Student student : students) {
            result.add(student);
        }
        return result;
    }

    public void deleteStudent(int id) throws GeneralCustomException {
        if (studentRepo.findById(id).isPresent()) {
            studentRepo.deleteById(id);
        } else {
            throw new GeneralCustomException("Student not found");
        }


    }

    public void updateStudent(Student student) throws GeneralCustomException {
        if (studentRepo.findById(student.getStudentId()).isPresent()) {
            studentRepo.save(student);
        } else {
            throw new GeneralCustomException("Student not found");
        }

    }

    public Student getStudentDetailsById(int id) throws GeneralCustomException {
        if (!studentRepo.findById(id).isPresent()) {
            throw new GeneralCustomException("Student not found");
        }
        return studentRepo.findById(id).get();
    }


}
