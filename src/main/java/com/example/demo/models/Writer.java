package com.example.demo.models;

import jakarta.persistence.*;

@Entity
public class Writer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long  writerId;

    @Embedded
    Person person;

    String specilization;

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public String getSpecilization() {
        return specilization;
    }

    public void setSpecilization(String specilization) {
        this.specilization = specilization;
    }

    @Override
    public String toString() {
        return "Writer{" +
                "writerId=" + writerId +
                ", person=" + person +
                ", specilization='" + specilization + '\'' +
                '}';
    }
}
