package com.tanishq.care.service;

import com.tanishq.care.model.Student;

import java.util.List;

public interface StudentService {

    int save(Student student);

    boolean saveAll(List<Student> students);

    int update(Student student);

    Student get(int id);

    List<Student> getAll();

    boolean delete(int id);
}
