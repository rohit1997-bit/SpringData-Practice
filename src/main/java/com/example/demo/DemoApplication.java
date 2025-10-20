package com.example.demo;

import com.example.demo.models.*;
import com.example.demo.repository.DoctorRepository;
import com.example.demo.repository.PatientRepository;
import com.example.demo.repository.StudentRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Component;

import java.util.List;

@SpringBootApplication
@Component
public class DemoApplication implements CommandLineRunner {

    /*@PersistenceContext
    private EntityManager entityManager;*/

    @Autowired
    private PatientRepository patientRepository;

    @Autowired
    private DoctorRepository doctorRepository;

    @Autowired
    private StudentRepository studentRepository;

    public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

    @Override
    @Transactional
    public void run(String... args) {

/*
        Person personOne = new Person();
        personOne.setName("John");
        personOne.setAge(26);
        personOne.setMobileNumber("57575848596");
        Writer writerOne = new Writer();
        writerOne.setPerson(personOne);
        writerOne.setSpecilization("both fiction and not fiction books");
        entityManager.persist(writerOne);

        Person personTwo = new Person();
        personTwo.setName("Naruto");
        personTwo.setAge(28);
        personTwo.setMobileNumber("557575849");
        Writer writerTwo = new Writer();
        writerTwo.setPerson(personTwo);
        writerTwo.setSpecilization("both fiction and not fiction books");
        writerTwo.setSpecilization("both fiction and not fiction books");
        entityManager.persist(writerTwo);*/

        /*Person  personOne = new Person();
        Person  personTwo = new Person();
        MedicalRecords medicalRecordOne = new MedicalRecords();
         personOne.setName("John Doe");
         personOne.setAge(23);
         personOne.setMobileNumber("4733414755");
         //------------------------------------------------------------------------
         personTwo.setName("Dr.phil");
         personTwo.setAge(25);
         personTwo.setMobileNumber("7585785798");
         medicalRecordOne.setDiagnosis("Fever");
         Patient patientOne = new Patient();
         patientOne.setPerson(personOne);
         patientOne.addMedicalRecords(medicalRecordOne);

         //---------------------------------------------------------------------------
          Doctor doctorOne = new Doctor();
          doctorOne.setPerson(personTwo);
         // doctorOne.setPatient(List.of(patientOne));
          patientOne.addDoctor(doctorOne);
          patientRepository.save(patientOne);

         Patient ss = patientRepository.findByUsername("John Doe");
         System.out.println(ss.getMedicalRecords().getDiagnosis());
         System.out.println(ss.getMedicalRecords().getPatient().getPatientId());

         //===============================================================================

        System.out.println(ss.getDoctor().getPerson().getName());
        System.out.println(ss.getDoctor().getPatient().getFirst().getPerson().getName());*/

         Person personOne = new Person();
         personOne.setName("John");
         personOne.setAge(27);
         Courses coursesOne = new Courses();
         Courses coursesTwo = new Courses();
         coursesOne.setCourseName("Java");
         coursesTwo.setCourseName("Python");
         personOne.setMobileNumber("5774898587");
         Student studentOne = new Student();
         studentOne.setPerson(personOne);
         studentOne.addCourse(coursesOne);
         studentOne.addCourse(coursesTwo);
         studentRepository.save(studentOne);

        Student ss = studentRepository.findByPerson_Name(personOne.getName());
        System.out.println(ss.getCourses().getFirst().getCourseName());
        System.out.println(ss.getCourses().getLast().getCourseName());
        System.out.println(coursesOne.getStudent().getFirst().getPerson().getName());
        System.out.println(coursesOne.getStudent().getLast().getPerson().getName());


    }
}
