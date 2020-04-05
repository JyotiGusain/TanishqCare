package com.tanishq.care.service;

import com.tanishq.care.dao.StudentRepository;
import com.tanishq.care.exception.StudentException;
import com.tanishq.care.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentRepository studentRepository;

    @Override
    public int save(Student student) {
        try {
            Student s = studentRepository.save(student);
            System.out.println("Student saved successfully for id: " + s.getId());
            return s.getId();
        } catch (Exception e) {
            System.out.println("Error while saving student");
            throw new StudentException("Error while saving student", e);
        }
    }

    @Override
    public boolean saveAll(List<Student> students) {
        try {
            studentRepository.saveAll(students);
            System.out.println("Successfully saved all students total:  " + students.size());
            return true;
        } catch (Exception e) {
            System.out.println("Error while saving all student");
            throw new StudentException("Error while saving all student", e);
        }
    }

    @Override
    public int update(Student student) {
        try {
            Student s = studentRepository.save(student);
            System.out.println("Student updated successfully for id: " + s.getId());
            return s.getId();
        } catch (Exception e) {
            System.out.println("Error while updating student");
            throw new StudentException("Error while updating student", e);
        }
    }

    @Override
    public Student get(int id) {
        try {
            Optional<Student> s = studentRepository.findById(Integer.valueOf(id));
            if (s.isPresent()) {
                System.out.println("Student retrieved successfully for id: " + id);
                return s.get();
            } else {
                throw new StudentException("Student not found for id: " + id);
            }
        } catch (Exception e) {
            System.out.println("Error while fetching student for id: " + id);
            throw new StudentException("Error while fetching student for id: " + id, e);
        }
    }

    @Override
    public List<Student> getAll() {
        try {
            List<Student> students = (List<Student>) studentRepository.findAll();
            System.out.println("Successfully retreived students total: " + students.size());
            return students;
        } catch (Exception e) {
            System.out.println("Error while fetching all student.");
            throw new StudentException("Error while fetching all student. ", e);
        }
    }

    @Override
    public boolean delete(int id) {
        try {
            studentRepository.deleteById(id);
            System.out.println("Student deleted successfully for id: " + id);
            return true;
        } catch (Exception e) {
            System.out.println("Error while deleting student for id: " + id);
            throw new StudentException("Error while deleting student for id: " + id, e);
        }
    }
}
