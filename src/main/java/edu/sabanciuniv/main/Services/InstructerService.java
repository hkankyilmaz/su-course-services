package edu.sabanciuniv.main.Services;


import edu.sabanciuniv.main.CustomException.GeneralCustomException;
import edu.sabanciuniv.main.Entity.Course;
import edu.sabanciuniv.main.Entity.Instructer;
import edu.sabanciuniv.main.Repository.InstructerRepo;
import edu.sabanciuniv.main.Repository.StudentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class InstructerService {


    private final InstructerRepo instructerRepo;


    @Autowired
    public InstructerService(InstructerRepo instructerRepo) {
        this.instructerRepo = instructerRepo;
    }

    public void addInstructer(Instructer instructer) {
        instructerRepo.save(instructer);

    }

    public void deleteInstructer(int id) throws GeneralCustomException {
        if (instructerRepo.findById(id).isPresent()) {
            instructerRepo.deleteById(id);
        } else {
            throw new GeneralCustomException("Instructer not found");
        }

    }

    public void updateInstructer(Instructer instructer) throws GeneralCustomException {
        if (instructerRepo.findById(instructer.getId()).isPresent()) {
            instructerRepo.save(instructer);
        } else {
            throw new GeneralCustomException("Instructer not found");
        }

    }

    public Instructer getInstructerById(int id) throws GeneralCustomException {
        if (!instructerRepo.findById(id).isPresent()) {
            throw new GeneralCustomException("Instructer not found");
        }
        return instructerRepo.findById(id).get();
    }

    public ArrayList<Instructer> getAllInstructers() {

        ArrayList<Instructer> coursesList = new ArrayList<Instructer>();
        Iterable<Instructer> courses = instructerRepo.findAll();

        for (Instructer instructer : courses) {
            coursesList.add(instructer);
        }

        return coursesList;
    }
}
