package dev.cat.student;

import com.fasterxml.jackson.annotation.JsonView;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class StudentController {

    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping("/student")
    @JsonView(Views.Public.class)
    public Student getStudent(Long id) {
        return studentService.findById(id);
    }

    @GetMapping("/admin/student")
    @JsonView(Views.Internal.class)
    public Student getStudentInternal(Long id) {
        return studentService.findById(id);
    }

}
