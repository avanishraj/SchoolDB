package com.avanish.springdatajpa.repository;

import com.avanish.springdatajpa.entity.Guardian;
import com.avanish.springdatajpa.entity.Student;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class StudentRepositoryTest {
    @Autowired
    private StudentRepository studentRepository;

    @Test
    public void saveStudent() {

        Guardian guardian = Guardian.builder()
                .mobile("912345678")
                .email("ravindraSingh005@gmail.com")
                .name("Ravindra Singh")
                .build();
        Student student = Student.builder()
                .firstName("Prince")
                .emailId("princerajsingh005@gmail.com")
                .guardian(guardian)
                .lastName("Raj Singh")
                .build();

        studentRepository.save(student);
    }

    @Test
    public void printAllStudent(){
        List<Student> studentList = studentRepository.findAll();
        System.out.println("Student list: " + studentList);
    }
    @Test
    public void findByFirstName(){
        List<Student> studentList = studentRepository.findByFirstName("Avanish");
        System.out.println(studentList);
    }

    @Test
    public void printFindByFirstNameContaining() {
        List<Student> students = studentRepository.findByFirstNameContaining("Av");
        System.out.println("Student list: " + students);
    }

    @Test
    public void findByGuardianName(){
        List<Student> students = studentRepository.findByGuardianName("Ravindra Singh");
        System.out.println(students);
    }

    @Test
    public  void printStudentUsingEmailAddress() {
        Student student = studentRepository.getStudentByEmailAddress("avanishraj005@gmail.com");
        System.out.println(student);
    }

    @Test
    public void printStudentUsingEmailAddressNative() {
        Student student = studentRepository.getStudentByEmailAddressNative("avanishraj005@gmail.com");
        System.out.println("First Name: " + student);
    }

    @Test
    public void getStudentByEmailAddressNativeNamedParam() {
        Student student = studentRepository.getStudentByEmailAddressNativeNamedParam("avanishraj005@gmail.com");
        System.out.println("Student: " + student);
    }
    @Test
    public void updateStudentNameByEmailIdTest() {
        studentRepository.updateStudentNameByEmailIdTest("P", "avanishraj005@gmail.com");
    }

}