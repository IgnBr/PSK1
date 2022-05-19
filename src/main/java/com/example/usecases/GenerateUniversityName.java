package com.example.usecases;

import com.example.interceptors.LoggedInvocation;
import com.example.services.Generator;

import javax.enterprise.context.SessionScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;
import java.util.Map;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

@SessionScoped
@Named
public class GenerateUniversityName implements Serializable{
    @Inject
    Generator nameGenerator;

    private CompletableFuture<String> nameGenerationTask = null;

    @LoggedInvocation
    public String generateNewName() {
        Map<String, String> requestParameters =
                FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();

        nameGenerationTask = CompletableFuture.supplyAsync(() -> nameGenerator.generate());

        return  "/universityDetails.xhtml?faces-redirect=true&universityId=" + requestParameters.get("universityId");
    }

    public boolean isGenerationRunning() {
        return nameGenerationTask != null && !nameGenerationTask.isDone();
    }

    public String getGenerationStatus() throws ExecutionException, InterruptedException {
        if (nameGenerationTask == null) {
            return null;
        } else if (isGenerationRunning()) {
            return "Name generation in progress";
        }
        return "Suggested name: " + nameGenerationTask.get();
    }
}
