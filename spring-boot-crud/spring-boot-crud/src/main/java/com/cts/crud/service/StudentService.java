package com.cts.crud.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cts.crud.entities.Student;
import com.cts.crud.repositories.UserRepository;

@Service
public class StudentService {

	@Autowired
	private UserRepository userRepository;

	public void savestudent(Student student) {
		userRepository.save(student);
	}

	public Iterable<Student> findAll() {
		return userRepository.findAll();
	}

	public Optional<Student> findById(long id) {
		return userRepository.findById(id);
	}

	public void delete(Student student) {
		userRepository.delete(student);

	}

}
