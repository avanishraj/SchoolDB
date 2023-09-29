package com.avanish.springdatajpa.repository;

import com.avanish.springdatajpa.entity.Course;
import com.avanish.springdatajpa.entity.CourseMaterial;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class CourseMaterialRepositoryTest {
    @Autowired
    private CourseMaterialRepository repository;

    @Test
    public void saveCourseMaterial() {

        Course course = Course.builder()
                .title("BTech")
                .credit(4)
                .title("DSA")
                .build();

        CourseMaterial courseMaterial = CourseMaterial.builder()
                .course(course)
                .url("www.google.in")
                .build();

        repository.save(courseMaterial);
    }

    @Test
    public void printAllCourses() {
        List<CourseMaterial> courseMaterials = repository.findAll();
        System.out.println(courseMaterials);
    }
}