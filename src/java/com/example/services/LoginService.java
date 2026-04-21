/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.services;

import com.example.PersistenceManager;
import com.example.models.Competitor;
import java.util.List;
import javax.persistence.*;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;


/**
 *
 * @author jdgal
 */

@Path("/login")
public class LoginService {

    @POST
    @Path("/auth")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response login(Competitor credentials) {

        EntityManager em = PersistenceManager
                .getInstance()
                .getEntityManagerFactory()
                .createEntityManager();

        try {
            TypedQuery<Competitor> q = em.createQuery(
                "SELECT c FROM Competitor c WHERE c.email = :email AND c.password = :password",
                Competitor.class
            );
            q.setParameter("email", credentials.getEmail());
            q.setParameter("password", credentials.getPassword());

            List<Competitor> results = q.getResultList();

            if (results.isEmpty()) {
                throw new NotAuthorizedException("Credenciales inválidas");
            }

            Competitor result = results.get(0); // primer coincidencia
            return Response.ok(result).build();

        } finally {
            em.close();
        }
    }
}
