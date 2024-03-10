package edu.sabanciuniv.main.Repository;

import edu.sabanciuniv.main.Entity.Student;
import org.springframework.data.repository.CrudRepository;

public interface StudentRepo extends CrudRepository<Student, Integer> {

}
