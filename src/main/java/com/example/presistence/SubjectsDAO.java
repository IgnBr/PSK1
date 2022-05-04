package com.example.presistence;

import com.example.entities.Subject;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import java.util.List;

@ApplicationScoped
public class SubjectsDAO {

    @Inject
    private EntityManager entityManager;

    public List<Subject> loadAll() {
        return entityManager.createNamedQuery("Subject.findAll", Subject.class).getResultList();
    }

    public void persist(Subject subject) {
        entityManager.persist(subject);
    }

    public Subject findOne(int id) {
        return entityManager.find(Subject.class, id);
    }
}