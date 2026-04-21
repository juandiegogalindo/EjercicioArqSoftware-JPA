/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.services;

import com.example.PersistenceManager;
import com.example.models.User;
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
    public Response login(User user) {

        EntityManager em = PersistenceManager
                .getInstance()
                .getEntityManagerFactory()
                .createEntityManager();

        try {
            TypedQuery<User> q = em.createQuery(
                "SELECT u FROM User u WHERE u.username = :username AND u.password = :password",
                User.class
            );
            q.setParameter("username", user.getUsername());
            q.setParameter("password", user.getPassword());

            User result = q.getSingleResult();

            return Response.ok(result).build();

        } catch (NoResultException e) {
            return Response.status(401)
                    .entity("Credenciales inválidas")
                    .build();

        } finally {
            em.close();
        }
    }
}
