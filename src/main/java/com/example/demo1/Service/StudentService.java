package com.example.demo1.Service;

import com.example.demo1.model.Student;

import java.util.List;

public interface StudentService {
    public Student saveStudent(Student student);
    public List<Student> getAllStudents();
    public void deleteAll();
    public void deleteStudent(int studentId);
    public Student updateStudent(int studentId, Student updatedStudent);
}
