package demo.controller;


import demo.domain.Student;
import demo.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class TestController {

    @Autowired
    StudentRepository studentRepository;

    @GetMapping(value = "/test")
    public String getTest() {
        return "test";
    }

    @PostMapping(value = "/tests")
    public String add(@RequestParam String name, @RequestParam String password) {
        List<Student> student = studentRepository.findByName(name);
        if (student.size() > 0) return "test";
        studentRepository.insertInfo(new Student(name, password));
        return "test";
    }
}
