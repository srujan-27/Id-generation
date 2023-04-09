package com.baeldung.crud.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.baeldung.crud.entities.Student;

@Repository
public interface UserRepository extends CrudRepository<Student, Long> {
    
    List<Student> findByName(String name);
    
}
