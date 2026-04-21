/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.services;

import com.example.PersistenceManager;
import com.example.models.Competitor;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;
import javax.ws.rs.core.GenericEntity;

/**
 *
 * @author jdgal
 */
@Path("/competitors")
public class CompetitorService {

    // =========================
    // GET - CONSULTAR TODOS
    // =========================
    @GET
    @Path("/get")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAll() {
        EntityManager em = PersistenceManager
                .getInstance()
                .getEntityManagerFactory()
                .createEntityManager();

        try {
            List<Competitor> list = em
                    .createQuery("SELECT c FROM Competitor c", Competitor.class)
                    .getResultList();

            // 👇 Envolver la lista en un objeto
            return Response.status(200).entity(new GenericEntity<List<Competitor>>(list) {
            }).build();

        } catch (Exception e) {
            e.printStackTrace();
            return Response.status(500).entity(e.getMessage()).build();
        } finally {
            em.close();
        }
    }

    // =========================
    // POST - INSERTAR
    // =========================
    @POST
    @Path("/add")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response addCompetitor(Competitor c) {

        EntityManager em = PersistenceManager
                .getInstance()
                .getEntityManagerFactory()
                .createEntityManager();

        try {
            em.getTransaction().begin();
            em.persist(c);
            em.getTransaction().commit();

            return Response.status(200).entity(c).build();

        } catch (Exception e) {
            e.printStackTrace();

            if (em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }

            return Response.status(500).entity("Error en POST").build();

        } finally {
            em.close();
        }
    }
}
