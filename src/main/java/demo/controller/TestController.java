package demo.controller;


import demo.domain.Student;
import demo.repository.StudentRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
public class TestController {

    @Autowired
    StudentRepository studentRepository;

    @PersistenceContext
    EntityManager entityManager;

    @GetMapping(value = "/test")
    public String getTest() {
        return "test";
    }

    @PostMapping(value = "/tests")
    public String add(@RequestParam int id
            , @RequestParam String name, @RequestParam String password) {
        Optional<Student> student = studentRepository.findById(id);
        if (student.isPresent()) return "test";
        studentRepository.saveAndFlush(new Student(name, password));
        return "test";
    }
}
