package com.example.presistence;

import com.example.entities.Student;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import java.util.List;

@ApplicationScoped
public class StudentsDAO {

    @Inject
    private EntityManager entityManager;

    public List<Student> loadAll() {
        return entityManager.createNamedQuery("Student.findAll", Student.class).getResultList();
    }

    public void persist(Student student) {
        entityManager.persist(student);
    }

    public Student findOne(int id) {
        return entityManager.find(Student.class, id);
    }
}