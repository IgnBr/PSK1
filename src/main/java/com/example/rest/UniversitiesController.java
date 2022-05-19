package com.example.rest;

import com.example.entities.University;
import com.example.presistence.UniversitiesDAO;
import com.example.rest.contracts.UniversityDto;
import lombok.Getter;
import lombok.Setter;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.OptimisticLockException;
import javax.transaction.Transactional;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@ApplicationScoped
@Path("/universities")
public class UniversitiesController {
    @Inject
    @Setter
    @Getter
    private UniversitiesDAO universitiesDAO;

    @Path("/{id}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getById(@PathParam("id") final Integer id) {
        University university = universitiesDAO.findOne(id);
        if (university == null) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }

        UniversityDto universityDto = new UniversityDto();
        universityDto.setName(university.getName());
        universityDto.setAddress(university.getAddress());

        return Response.ok(universityDto).build();
    }

    @Path("/{id}")
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    @Transactional
    public Response update(
            @PathParam("id") final Integer universityId,
            UniversityDto universityData) {
        try {
            University existingUniversity = universitiesDAO.findOne(universityId);
            if (existingUniversity == null) {
                return Response.status(Response.Status.NOT_FOUND).build();
            }
            existingUniversity.setName(universityData.getName());
            existingUniversity.setAddress(universityData.getAddress());
            universitiesDAO.update(existingUniversity);
            return Response.ok().build();
        } catch (OptimisticLockException ole) {
            return Response.status(Response.Status.CONFLICT).build();
        }
    }

    @Path("/")
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Transactional
    @Produces(MediaType.APPLICATION_JSON)
    public Response create(UniversityDto universityData){
        University universityToCreate = new University();
        universityToCreate.setAddress(universityData.getAddress());
        universityToCreate.setName(universityData.getName());
        this.universitiesDAO.persist(universityToCreate);

        return Response.ok(universityData).build();
    }

}
