package com.ju.springweb;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;

import com.ju.springweb.entities.Student;

@RunWith(SpringRunner.class)
@SpringBootTest
class StudentrestapiApplicationTests {
	
	@Value("${studentrestapi.services.url}")
	private String baseURL;

	@Test
	void testGetStudent() {
		System.out.println(baseURL);
		RestTemplate restTemplate = new RestTemplate();
		Student student = restTemplate.getForObject(baseURL+"1", Student.class);
		assertNotNull(student);
		assertEquals("Sara Lima", student.getName());
	}
	
	@Test
	public void testCreateStudent() {
		RestTemplate restTemplate = new RestTemplate();
		Student student = new Student();
		student.setName("Ana Faria");
		student.setTestscore(80);
		Student newStudent = restTemplate.postForObject(baseURL, student, Student.class);
		assertNotNull(newStudent);
		assertNotNull(newStudent.getId());
		assertEquals("Ana Faria", newStudent.getName());
	}

	@Test
	void testUpdateStudent() {
		RestTemplate restTemplate = new RestTemplate();
		Student student = restTemplate.getForObject(baseURL+"1", Student.class);
		student.setTestscore(90);
		restTemplate.put(baseURL, student);
	}

}
