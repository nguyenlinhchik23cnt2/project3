package service;

import etity.Student;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Servicestudent {

    List<Student> students = new ArrayList<>();



    public Servicestudent() {
        students.addAll(Arrays.asList(
                new Student(1L, "Devmaster 1", 20, "Nam", "Số 25 VNP", "0978611889", "chungtrinhj@gmail.com"),
                new Student(2L, "Devmaster 2", 25, "Nam", "Số 25 VNP", "0978611889", "contact@devmaster.edu.vn"),
                new Student(3L, "Devmaster 3", 22, "Nam", "Số 25 VNP", "0978611889", "chungtrinhj@gmail.com")
        ));
    }

    public List<Student> getAllStudents() {
        return students;
    }

    // lay sinh vien theo id
    public Student getStudentById(Long id) {

        return students.stream().filter(s -> s.getId().equals(id)).findFirst().orElse(null);
    }

    // them moi mot sinh vien
    public Student addStudent(Student student) {
        students.add(student);
        return student;
    }
    //  cap nhap thong tin sinh vien
    public Student updateStudent(Long id, Student student) {
        Student check = getStudentById(id);
        if (check != null) {
            return null;
        }
        students.forEach(item -> {
            if (item.getId() == id) {
                item.setName(student.getName());
                item.setAddress(student.getAddress());
                item.setEmail(student.getEmail());
                item.setPhone(student.getPhone());
                item.setAge(student.getAge());
                item.setGender(student.getGender());
            }
        });
        return student;
    }

    // Xóa sinh viên
    public boolean deleteStudent(Long id) {
        Student check = getStudentById(id);
        return students.remove(check);
    }
}
