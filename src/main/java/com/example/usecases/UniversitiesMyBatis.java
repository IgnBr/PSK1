package com.example.usecases;

import com.example.mybatis.dao.UniversityMapper;
import com.example.mybatis.model.University;
import lombok.Getter;
import lombok.Setter;

import javax.annotation.PostConstruct;
import javax.enterprise.inject.Model;
import javax.inject.Inject;
import javax.transaction.Transactional;
import java.util.List;

@Model
public class UniversitiesMyBatis {
    @Inject
    private UniversityMapper universityMapper;

    @Getter
    @Setter
    private List<University> allUniversities;

    @Getter @Setter
    private University universityToCreate = new University();

    @PostConstruct
    private void init() {
        allUniversities = universityMapper.selectAll();
    }

    @Transactional
    public String createUniversity() {
        universityMapper.insert(universityToCreate);
        return "/myBatis/universities?faces-redirect=true";
    }
}