package com.tanishq.care.rest;

import com.tanishq.care.model.Student;
import com.tanishq.care.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping(value = "/api/students")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @PostMapping
    public int createStudent(@RequestBody Student student) {
        System.out.println("About to save a student.");
        return studentService.save(student);

    }

    @GetMapping
    public List<Student> getAllStudents() {
        System.out.println("About to get all  students.");
        return studentService.getAll();

    }

    @DeleteMapping("/{studentId}")
    public boolean deleteStudent(@PathVariable("studentId") int id) {
        System.out.println("About to delete student for id. " + id);
        return studentService.delete(id);
    }

    @GetMapping("/{studentId}")
    public Student getStudentById(@PathVariable("student_id") int id) {
        System.out.println("About to get student for id: " + id);
        return studentService.get(id);
    }

    @PostMapping("/{studentId}")
    public int updateStudent(@PathVariable("studentId") int id, @RequestBody Student student) {
        System.out.println("About to get update for id: " + id);
        student.setId(id);
        return studentService.update(student);
    }

}
