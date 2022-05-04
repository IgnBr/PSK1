package com.example.presistence;

import com.example.entities.University;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import java.util.List;

@ApplicationScoped
public class UniversitiesDAO {

    @Inject
    private EntityManager em;

    public List<University> loadAll() {
        return em.createNamedQuery("University.findAll", University.class).getResultList();
    }

    public void persist(University university){
        this.em.persist(university);
    }

    public University findOne(int id) {
        return em.find(University.class, id);
    }
}