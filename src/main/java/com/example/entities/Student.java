package com.example.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Getter @Setter
@Table(name = "STUDENT")
@NamedQueries({
        @NamedQuery(name = "Student.findAll", query = "select s from Student as s")
})
public class Student implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "FULL_NAME")
    private String fullName;

    @ManyToOne
    @JoinColumn(name = "UNIVERSITY_ID")
    private University university;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return id == student.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
