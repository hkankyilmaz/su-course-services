package edu.sabanciuniv.main.Controller;


import edu.sabanciuniv.main.Entity.Instructer;
import edu.sabanciuniv.main.Services.InstructerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
    public String addInstructer(@RequestBody Instructer instructer) {
        instructerService.addInstructer(instructer);
        return "Instructer added";
    }

    @DeleteMapping("/delete/{id}")
    public String deleteInstructer(@PathVariable("id") int id) {
        instructerService.deleteInstructer(id);
        return "Instructer deleted";
    }

    @PutMapping("/update")
    public String updateInstructer(@RequestBody Instructer instructer) {
        instructerService.updateInstructer(instructer);
        return "Instructer updated";
    }

    @GetMapping("/get/{id}")
    public Instructer getInstructerById(@PathVariable("id") int id) {
        return instructerService.getInstructerById(id);
    }

    @GetMapping("/getAllInstructers")
    public List<Instructer> getAllInstructers() {
        return instructerService.getAllInstructers();
    }
}
