package com.example.demo1.Service;

import com.example.demo1.model.Student;
import com.example.demo1.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentRepository studentRepository;
    @Override
    public Student saveStudent(Student student){
       return studentRepository.save(student);
    }

    @Override
    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    @Override
    public void deleteAll() {
        studentRepository.deleteAll();
    }
    @Override
    public void deleteStudent(int studentId) {
        studentRepository.deleteById(studentId);
    }
    @Override
    public Student updateStudent(int studentId, Student updatedStudent) {
        Student existingStudent = studentRepository.getById(studentId);
        if (existingStudent != null) {
            existingStudent.setName(updatedStudent.getName());
            existingStudent.setAddress(updatedStudent.getAddress());
            return studentRepository.save(existingStudent);
        }
        return null;
    }
}
