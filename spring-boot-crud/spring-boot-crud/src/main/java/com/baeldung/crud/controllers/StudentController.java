package com.baeldung.crud.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.baeldung.crud.entities.Student;
import com.baeldung.crud.service.StudentService;

@Controller
public class StudentController {

	@Autowired
	public StudentService studentService;

	@GetMapping("/index")
	public String showUserList(Model model) {
		model.addAttribute("students", studentService.findAll());
		return "index";
	}

	@GetMapping("/signup")
	public String showSignUpForm(Student student) {
		return "add-user";
	}

	@PostMapping("/adduser")
	public String addUser(@Valid Student student, BindingResult result, Model model) {
		if (result.hasErrors()) {
			return "add-user";
		}

		studentService.savestudent(student);
		return "redirect:/index";
	}

	@GetMapping("/edit/{id}")
	public String showUpdateForm(@PathVariable("id") long id, Model model) {
		Student student = studentService.findById(id)
				.orElseThrow(() -> new IllegalArgumentException("Invalid user Id:" + id));
		model.addAttribute("student", student);

		return "update-user";
	}

	@PostMapping("/update/{id}")
	public String updateUser(@PathVariable("id") long id, @Valid Student student, BindingResult result, Model model) {
		if (result.hasErrors()) {
			student.setId(id);
			return "update-user";
		}

		studentService.savestudent(student);

		return "redirect:/index";
	}

	@GetMapping("/delete/{id}")
	public String deleteUser(@PathVariable("id") long id, Model model) {
		Student student = studentService.findById(id)
				.orElseThrow(() -> new IllegalArgumentException("Invalid user Id:" + id));
		studentService.delete(student);

		return "redirect:/index";
	}
}
