package com.example.usecases;

import com.example.entities.University;
import com.example.presistence.UniversitiesDAO;
import lombok.Getter;
import lombok.Setter;

import javax.annotation.PostConstruct;
import javax.enterprise.inject.Model;
import javax.inject.Inject;
import javax.transaction.Transactional;
import java.util.List;

@Model
public class Universities {
    @Inject
    private UniversitiesDAO universitiesDAO;

    @Getter
    @Setter
    private University universityToCreate = new University();

    @Getter
    private List<University> allUniversities;

    @PostConstruct
    public void init(){
        loadUniversities();
    }

    public void loadUniversities() {
        this.allUniversities = universitiesDAO.loadAll();
    }

    @Transactional
    public String createUniversity(){
        this.universitiesDAO.persist(universityToCreate);

        return "/index";
    }
}
