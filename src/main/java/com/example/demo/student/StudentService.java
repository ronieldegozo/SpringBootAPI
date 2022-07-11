package com.example.demo.student;

import java.time.LocalDate;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentService {
    private final StudentRepository studentRepository;

    @Autowired
    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    // GET ALL STUDENTS
    public List<Student> getStuds() {
        return studentRepository.findAll();
    }

    // POST ADD NEW STUDENTS CHECK IF THE EMAIL IS REGISTERED
    public void addNewStudent(Student student) {
        Optional<Student> studentOptional = studentRepository.findStudentByEmail(student.getEmail());
        if (studentOptional.isPresent()) {
            throw new IllegalStateException("Email already Registered");
        }

        studentRepository.save(student);
    }

    // DELETE STUDENT
    public void deleteStudent(Long studentId) {
        boolean exists = studentRepository.existsById(studentId);
        if (!exists) {
            throw new IllegalStateException("Student does not exist with an Id of: " + studentId);
        }
        studentRepository.deleteById(studentId);

    }

    // UPDATE STUDENT
    @Transactional
    public void updateStudent(Long studentId, String fname, String lname, String email) {
        Student student = studentRepository.findById(studentId).orElseThrow(() -> new IllegalStateException(
                "Student does not exist with an Id of: " + studentId));
        if (fname != null && fname.length() > 0 && !Objects.equals(student.getFname(), fname)) {
            student.setFname(fname);
        }

        if (lname != null && lname.length() > 0 && !Objects.equals(student.getLname(), lname)) {
            student.setLname(lname);
        }

        if (email != null && email.length() > 0 && !Objects.equals(student.getEmail(), email)) {
            Optional<Student> studentOptional = studentRepository.findStudentByEmail(email);
            if (studentOptional.isPresent()) {
                throw new IllegalStateException("Email already Registered");
            }
            student.setEmail(email);
        }
    }
}
