package com.cts.crud.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.cts.crud.entities.Student;

@Repository
public interface UserRepository extends CrudRepository<Student, Long> {
    
    List<Student> findByName(String name);
    
}
