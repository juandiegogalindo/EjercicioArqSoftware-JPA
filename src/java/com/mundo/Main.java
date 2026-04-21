/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mundo;

import com.example.PersistenceManager;
import com.example.models.Competitor;

import javax.persistence.EntityManager;

/**
 *
 * @author jdgal
 */

public class Main {

    public static void main(String[] args) {

        // Crear EntityManager
        EntityManager em = PersistenceManager
                .getInstance()
                .getEntityManagerFactory()
                .createEntityManager();

        // Crear objeto
        Competitor c = new Competitor(
                "Juan",
                "Perez",
                25,
                "123456",
                "3001234567",
                "Calle 123",
                "Bogota",
                "Colombia",
                false
        );

        try {
            // Iniciar transacción
            em.getTransaction().begin();

            // Guardar en BD
            em.persist(c);

            // Confirmar
            em.getTransaction().commit();

            System.out.println("✅ Competitor guardado con ID: " + c.getId());

        } catch (Exception e) {
            e.printStackTrace();
            em.getTransaction().rollback();
        }

        em.close();
    }
}