package com.spring_jpa.repostiry;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import com.spring_jpa.entities.Students;

// public interface StudentRepo  extends CrudRepository<Students, Integer> {

public interface StudentRepo  extends JpaRepository<Students, Integer> {
	
}
