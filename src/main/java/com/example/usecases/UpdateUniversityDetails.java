package com.example.usecases;

import com.example.entities.University;
import com.example.interceptors.LoggedInvocation;
import com.example.presistence.UniversitiesDAO;
import lombok.Getter;
import lombok.Setter;

import javax.annotation.PostConstruct;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.persistence.OptimisticLockException;
import javax.transaction.Transactional;
import java.io.Serializable;
import java.util.Map;

@ViewScoped
@Named
@Getter
@Setter
public class UpdateUniversityDetails implements Serializable{
    private University university;

    @Inject
    private UniversitiesDAO universitiesDAO;

    @PostConstruct
    private void init() {
        Map<String, String> requestParameters =
                FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();
        Integer universityId = Integer.parseInt(requestParameters.get("universityId"));
        this.university = universitiesDAO.findOne(universityId);
    }

    @Transactional
    @LoggedInvocation
    public String updateUniversityName() {
        try{
            universitiesDAO.update(this.university);
        } catch (OptimisticLockException e) {
            return "/universityDetails.xhtml?faces-redirect=true&universityId=" + this.university.getId() + "&error=optimistic-lock-exception";
        }
        return "/index";
    }
}
