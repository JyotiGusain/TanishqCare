package com.tanishq.care.rest;

import com.tanishq.care.model.Student;
import com.tanishq.care.service.StudentService;
import com.tanishq.care.util.FileUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import java.io.IOException;
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
    public Student getStudentById(@PathVariable("studentId") int id) {
        System.out.println("About to get student for id: " + id);
        return studentService.get(id);
    }

    @PutMapping("/{studentId}")
    public int updateStudent(@PathVariable("studentId") int id, @RequestBody Student student) {
        System.out.println("About to get update for id: " + id);
        student.setId(id);
        return studentService.update(student);
    }

    @GetMapping("/v1/download")
    public void download() throws IOException {
        System.out.println("About to get download");
        List<Student> students = studentService.getAll();
        FileUtil.write(students);
    }

    @GetMapping("/v1/upload")
    public void upload() throws IOException {
        System.out.println("About to get upload");
        List<Student> students =  FileUtil.read();
        studentService.saveAll(students);
    }
    @PostConstruct()
    public void postContruct() throws IOException {
        System.out.println("About to get upload");
        List<Student> students = FileUtil.read();
        studentService.saveAll(students);
    }
    @PreDestroy()
    public void preDestroy() throws IOException {
        System.out.println("About to get download");
        List<Student> students = studentService.getAll();
        FileUtil.write(students);
    }



}
