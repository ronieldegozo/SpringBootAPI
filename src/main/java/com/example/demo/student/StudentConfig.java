package com.example.demo.student;

import com.example.demo.student.StudentRepository;
import java.time.LocalDate;
import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

//CONFIGURATION FOR A POST NEW STUDENTS
@Configuration
public class StudentConfig {

    @Bean
    CommandLineRunner commandLineRunner(StudentRepository repository) {
        return args -> {
            Student roniel = new Student("Mc Roniel", "De Gozo", LocalDate.of(1980, 1, 1),
                    "ronieldegozo@gmail.com");

            Student rogine = new Student("Rogine", "Laurito", LocalDate.of(1940, 1, 1),
                    "ronieldegozo@gmail.com");

            Student reniella = new Student("Reniella", "De Gozo", LocalDate.of(2001, 2, 3),
                    "ronieldegozo@gmail.com");

            repository.saveAll(
                    List.of(roniel, rogine, reniella));

        };
    }

}
