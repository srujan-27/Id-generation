package com.cts.crud.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;

@Entity
public class Student {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    
    @NotBlank(message = "Name is mandatory")
    private String name;
   
    @NotBlank(message="class is mandatory")
    private String section;
    
    @NotBlank(message = "Email is mandatory")
    private String email;
    
    	
    public Student() {}

    public Student(String name, String section,String email) {
        this.name = name;
        this.section=section;
        this.email = email;
    }

    public void setId(long id) {
        this.id = id;
    }
    
    public long getId() {
        return id;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    
    
    public void setSection(String section) {
        this.section = section;
    }
    

    public String getSection() {
        return section;
    }
    
    public void setEmail(String email) {
        this.email = email;
    }
    

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    @Override
    public String toString() {
        return "User{" + "id=" + id + ", name=" + name + ", email=" + email + '}';
    }
}
