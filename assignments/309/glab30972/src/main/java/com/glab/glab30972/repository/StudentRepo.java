package com.glab.glab30972.repository;

import com.glab.glab30972.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepo extends CrudRepository<Student, Long> {
    Student findByAccountNumber(Long accountNum);
//    List<Student> findByNameContaining(String name);
}
