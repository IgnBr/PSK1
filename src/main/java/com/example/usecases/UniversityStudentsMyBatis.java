package com.example.usecases;

import com.example.mybatis.dao.UniversityMapper;
import com.example.mybatis.dao.StudentMapper;
import com.example.mybatis.model.University;
import com.example.mybatis.model.Student;
import lombok.Getter;
import lombok.Setter;

import javax.annotation.PostConstruct;
import javax.enterprise.inject.Model;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Model
public class UniversityStudentsMyBatis {
    @Inject
    private StudentMapper studentMapper;

    @Inject
    private UniversityMapper universityMapper;

    @Getter
    @Setter
    private Student studentToCreate = new Student();

    @Getter @Setter
    private University university;

    @Getter @Setter
    private List<Student> universityStudents = new ArrayList<Student>();

    @PostConstruct
    public void init() {
        Map<String, String> requestParams = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();
        int universityId = Integer.parseInt(requestParams.get("universityId"));
        university = universityMapper.selectByPrimaryKey(universityId);
        universityStudents = studentMapper.selectStudentsForUniversity(universityId);
    }

    @Transactional
    public String createStudent() {
        studentToCreate.setUniversityId(university.getId());
        studentMapper.insert(studentToCreate);
        return "/myBatis/students?faces-redirect=true&universityId=" + university.getId();
    }
}