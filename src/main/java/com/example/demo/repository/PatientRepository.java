package com.example.demo.repository;


import com.example.demo.models.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface PatientRepository  extends JpaRepository<Patient, Integer> {


    @Query("SELECT p FROM Patient p WHERE p.Person.name = :name")
    Patient findByUsername(@Param("name") String username);
}
