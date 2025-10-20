package com.example.demo.models;


import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Doctor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long DoctorId;

    @Embedded
    private Person  person;

    @OneToMany(mappedBy = "doctor" , fetch = FetchType.EAGER)
    List<Patient> patient =  new ArrayList<>();

    public Long getDoctorId() {
        return DoctorId;
    }

    public void setDoctorId(Long doctorId) {
        DoctorId = doctorId;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public List<Patient> getPatient() {
        return patient;
    }

    public void setPatient(List<Patient> patient) {
        this.patient = patient;
    }


    public  void addPatient(Patient patient){
        this.patient.add(patient);
        patient.setDoctor(this);
    }


}
