package dev.cat.student;

import org.springframework.stereotype.Service;

@Service
public class StudentService {

    private final StudentRepository repository;

    public StudentService(StudentRepository repository) {
        this.repository = repository;
    }

    public Student findById(Long id) {
        return this.repository.findById(id).orElse(null);
    }

}
