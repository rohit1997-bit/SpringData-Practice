package com.example.demo.models;


import jakarta.persistence.*;



@Entity
public class Patient {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long PatientId;


    public Long getPatientId() {
        return PatientId;
    }

    public void setPatientId(Long patientId) {
        PatientId = patientId;
    }

    @Embedded
    Person Person;

    @OneToOne(cascade = {CascadeType.MERGE , CascadeType.PERSIST})
    @JoinColumn(name = "Medical_Record_Id")
    MedicalRecords medicalRecords;

    @ManyToOne(cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    @JoinColumn(name = "Doctor_ID")
    Doctor doctor;

    public Person getPerson() {
        return Person;
    }

    public void setPerson(Person person) {
        Person = person;
    }

    public MedicalRecords getMedicalRecords() {
        return medicalRecords;
    }

    public void setMedicalRecords(MedicalRecords medicalRecords) {
        this.medicalRecords = medicalRecords;
    }

    public void setDoctor(Doctor doctor) {
        this.doctor = doctor;
    }

    public void addMedicalRecords(MedicalRecords medicalRecords) {
        this.medicalRecords = medicalRecords;
        medicalRecords.setPatient(this);
    }

    public Doctor getDoctor() {
        return doctor;
    }



    public void addDoctor(Doctor doctor) {
        doctor.addPatient(this);
    }
}
