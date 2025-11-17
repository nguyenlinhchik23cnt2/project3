package k23cnt2_nlclesson06.k23cnt2_nlclesson06.service;

import k23cnt2_nlclesson06.k23cnt2_nlclesson06.dto.StudentDTO;
import k23cnt2_nlclesson06.k23cnt2_nlclesson06.entity.Student;
import k23cnt2_nlclesson06.k23cnt2_nlclesson06.repository.StudentRepository;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@NoArgsConstructor
public class StudentService {

    private StudentRepository studentRepository;

    @Autowired
    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public List<Student> findAll() {
        return studentRepository.findAll();
    }

    public Optional<StudentDTO> findById(Long id) {

        Student student = studentRepository.findById(id).orElse(null);
        if (student == null) return Optional.empty();

        StudentDTO studentDTO = new StudentDTO();
        studentDTO.setId(student.getId());
        studentDTO.setName(student.getName());
        studentDTO.setEmail(student.getEmail());
        studentDTO.setAge(student.getAge());

        return Optional.of(studentDTO);
    }

    public Boolean save(StudentDTO studentDTO) {

        Student student = new Student();
        student.setName(studentDTO.getName());
        student.setEmail(studentDTO.getEmail());
        student.setAge(studentDTO.getAge());

        try {
            studentRepository.save(student);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public Student updateStudentById(Long id, StudentDTO updatedStudent) {

        return studentRepository.findById(id)
                .map(student -> {
                    student.setName(updatedStudent.getName());
                    student.setEmail(updatedStudent.getEmail());
                    student.setAge(updatedStudent.getAge());
                    return studentRepository.save(student);
                })
                .orElseThrow(() -> new IllegalArgumentException("Invalid student ID: " + id));
    }

    public void deleteStudent(Long id) {
        studentRepository.deleteById(id);
    }
}
