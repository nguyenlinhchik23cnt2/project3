package controller;

import etity.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import service.Servicestudent;

import java.util.List;

@RestController
public class StudentController {

    @Autowired
    private Servicestudent studentService;

    @GetMapping("/student-list")
    public List<Student> getAllStudents(){
        return studentService.getAllStudents();
    }


    @GetMapping("/Student/{id}")
    public Student getStudentById(@PathVariable String id) {
        Long param = Long.parseLong(id);
        return studentService.getStudentById(param);
    }

    @PostMapping("/student-add")
    public Student addStudent(@RequestBody Student student) {
        return studentService.addStudent(student);
    }

    @PutMapping("/student/{id}")
    public Student updateStudent(@PathVariable String id, @RequestBody Student student) {
        Long param = Long.parseLong(id);
        return studentService.updateStudent(param, student);
    }

    @DeleteMapping("/student/{id}")
    public void deleteStudent(@PathVariable String id) {
        Long param = Long.parseLong(id);
        studentService.deleteStudent(param);
    }
}
