package com.example.demo1.controller;

import com.example.demo1.Service.StudentService;
import com.example.demo1.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/student")
public class StudentController {
    @Autowired
    private StudentService studentService;


    @PostMapping("/add")
    public String add(@RequestBody Student student){
        studentService.saveStudent(student);
        return ("new student is added");
    }
    @GetMapping("/getAll")
    public List<Student> getAllStudents(){
        return studentService.getAllStudents();
    }

    @DeleteMapping("/deleteAll")
    public ResponseEntity<String> deleteAllStudents() {
        studentService.deleteAll();
        return ResponseEntity.ok("Xóa tất cả sinh viên thành công");
    }
    @DeleteMapping("/delete/{studentId}")
    public ResponseEntity<String> deleteStudent(@PathVariable int studentId) {
        studentService.deleteStudent(studentId);
        return ResponseEntity.ok("Xóa sinh viên thành công");
    }
    @PutMapping("/update/{studentId}")
    public ResponseEntity<String> updateStudent(@PathVariable int studentId, @RequestBody Student updatedStudent) {
        Student student = studentService.updateStudent(studentId, updatedStudent);
        if (student != null) {
            return ResponseEntity.ok("Cập nhật thông tin sinh viên thành công");
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
