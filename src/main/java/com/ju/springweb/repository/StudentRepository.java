package com.ju.springweb.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ju.springweb.entities.Student;

public interface StudentRepository extends JpaRepository<Student, Integer> {

}
