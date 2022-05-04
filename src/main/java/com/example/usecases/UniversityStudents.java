package com.example.usecases;

import com.example.entities.University;
import com.example.entities.Student;
import com.example.presistence.UniversitiesDAO;
import com.example.presistence.StudentsDAO;
import lombok.Getter;
import lombok.Setter;

import javax.annotation.PostConstruct;
import javax.enterprise.inject.Model;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.transaction.Transactional;
import java.util.Map;

@Model
public class UniversityStudents {
    @Inject
    private UniversitiesDAO universitiesDAO;

    @Inject
    private StudentsDAO studentsDAO;

    @Getter
    @Setter
    private University university;

    @Getter @Setter
    private Student studentToCreate = new Student();

    @PostConstruct
    public void init() {
        Map<String, String> requestParams = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();
        int id = Integer.parseInt(requestParams.get("universityId"));
        university = universitiesDAO.findOne(id);
    }

    @Transactional
    public String createStudent() {
        studentToCreate.setUniversity(university);
        studentsDAO.persist(studentToCreate);
        return "students?faces-redirect=true&universityId=" + university.getId();
    }
}
