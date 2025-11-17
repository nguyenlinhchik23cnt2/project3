package k23cnt2_nlclesson06.k23cnt2_nlclesson06.controller;

import k23cnt2_nlclesson06.k23cnt2_nlclesson06.dto.StudentDTO;
import k23cnt2_nlclesson06.k23cnt2_nlclesson06.service.StudentService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/students")
public class StudentController {

    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    // Hiển thị danh sách sinh viên
    @GetMapping
    public String getStudents(Model model) {
        model.addAttribute("students", studentService.findAll());
        return "students/student-list"; // template: student-list.html
    }

    // Form thêm sinh viên mới
    @GetMapping("/add-new")
    public String addNewStudent(Model model) {
        model.addAttribute("student", new StudentDTO());
        return "students/student-add"; // template: student-add.html
    }

    // Form chỉnh sửa sinh viên
    @GetMapping("/edit/{id}")
    public String showFormForUpdate(@PathVariable Long id, Model model) {
        StudentDTO student = studentService
                .findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid student Id:" + id));

        model.addAttribute("student", student);
        return "students/student-edit"; // template: student-edit.html
    }

    // Lưu sinh viên mới
    @PostMapping
    public String saveStudent(@ModelAttribute("student") StudentDTO student) {
        studentService.save(student);
        return "redirect:/students";
    }

    // Cập nhật sinh viên
    @PostMapping("/update/{id}")
    public String updateStudent(@PathVariable Long id,
                                @ModelAttribute("student") StudentDTO student) {
        studentService.updateStudentById(id, student);
        return "redirect:/students";
    }

    // Xóa sinh viên
    @GetMapping("/delete/{id}")
    public String deleteStudent(@PathVariable Long id) {
        studentService.deleteStudent(id);
        return "redirect:/students";
    }
}
