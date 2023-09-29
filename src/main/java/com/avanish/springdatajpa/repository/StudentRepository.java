package com.avanish.springdatajpa.repository;

import com.avanish.springdatajpa.entity.Student;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {
    List<Student> findByFirstName(String fistName);
    List<Student> findByFirstNameContaining(String firstName);
    List<Student> findByGuardianName(String guardianName);

    //JPQL Query
    @Query("select s from Student s where s.emailId = ?1")
    Student getStudentByEmailAddress(String email);

    //SQL Query
    @Query(value = "select * from tbl_student s where s.email_address = ?1",
            nativeQuery = true
    )
    Student getStudentByEmailAddressNative(String emailId);

    @Query(value = "select * from tbl_student s where s.email_address = :emailId",
            nativeQuery = true
    )
    Student getStudentByEmailAddressNativeNamedParam(@Param("emailId") String emailId);
    @Query(value = "update tbl_student set first_name = ?1 where email_address = ?2", nativeQuery = true)
    @Modifying
    @Transactional
    int updateStudentNameByEmailIdTest(String firstName, String emailId);
}
