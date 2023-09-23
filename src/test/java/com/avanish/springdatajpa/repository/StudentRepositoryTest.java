package com.avanish.springdatajpa.repository;

import com.avanish.springdatajpa.entity.Student;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class StudentRepositoryTest {
    @Autowired
    private StudentRepository studentRepository;

    @Test
    public void saveStudent() {
        Student student = Student.builder()
                .FirstName("Avanish")
                .emailId("avanishraj005@gmail.com")
                .guardianEmail("dev.singh@gmail.com")
                .guardianName("Ravindra Singh")
                .guardianMobile("123456789")
                .LastName("Raj Singh")
                .build();

        studentRepository.save(student);
    }
}