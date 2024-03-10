package edu.sabanciuniv.main.Controller;


import edu.sabanciuniv.main.Entity.Instructer;
import edu.sabanciuniv.main.Services.InstructerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/instructer")
public class InstructerConroller {


    private final InstructerService instructerService;

    @Autowired
    public InstructerConroller(InstructerService instructerService) {
        this.instructerService = instructerService;
    }


    @PostMapping("/add")
    public String addInstructer(Instructer instructer) {
        instructerService.addInstructer(instructer);
        return "Instructer added";
    }

    @PostMapping("/delete")
    public String deleteInstructer(int id) {
        instructerService.deleteInstructer(id);
        return "Instructer deleted";
    }

    @PostMapping("/update")
    public String updateInstructer(Instructer instructer) {
        instructerService.updateInstructer(instructer);
        return "Instructer updated";
    }

    @PostMapping("/get/{id}")
    public Instructer getInstructerById(@PathVariable("id") int id) {
        return instructerService.getInstructerById(id);
    }

    @PostMapping("/getAllInstructers")
    public List<Instructer> getAllInstructers() {
        return instructerService.getAllInstructers();
    }
}
