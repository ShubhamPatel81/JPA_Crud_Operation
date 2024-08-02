package com.spring_jpa;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.spring_jpa.entities.Students;
import com.spring_jpa.repostiry.StudentRepo;

@SpringBootApplication
public class SpringJpaApplication {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(SpringJpaApplication.class, args);

		StudentRepo repos = context.getBean(StudentRepo.class);

		Students st = new Students();
		st.setName("world");
		st.setAddress("UK");
// Adding data to database ---> Create 
		repos.save(st);

		Students st1 = new Students();
		st1.setName("abc");
		st1.setAddress("China");

		Students st2 = new Students();
		st2.setName("xyz");
		st2.setAddress("Russia");

		List<Students> studentlist = Arrays.asList(st1, st2);
		repos.saveAll(studentlist);

		List<Students> list = (List<Students>) repos.findAll();
		list.forEach(stout ->System.out.println(stout));

		Optional<Students> findbyid = repos.findById(4);
		System.out.println(findbyid);

		if (findbyid.isPresent()) {
			Students studentToUpdate = findbyid.get();
			studentToUpdate.setName("new World");
			studentToUpdate.setAddress("Europe");
			repos.save(studentToUpdate);
			System.out.println("Updated Table: " + studentToUpdate);
		} else {
			System.out.println("Student with id 4 not found");
		}

		
		//Delete by id 
		if(findbyid.isPresent()) {
			Students studentToDelete= findbyid.get();
			repos.delete(studentToDelete);
			System.out.println("Deleted from the database: " + studentToDelete);
        } else {
            System.out.println("Student with id 4 not found");
        }
		}
	}


