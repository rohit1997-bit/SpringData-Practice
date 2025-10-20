package com.example.demo.repository;

import com.example.demo.models.Courses;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CourseRepository extends CrudRepository<Courses,Integer> {
}
