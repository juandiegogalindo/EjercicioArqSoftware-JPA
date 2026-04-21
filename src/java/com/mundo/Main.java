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

        EntityManager em = PersistenceManager
                .getInstance()
                .getEntityManagerFactory()
                .createEntityManager();

        // Crear objeto Competitor con email y password
        Competitor c = new Competitor(
                "Juan",
                "Perez",
                25,
                "123456",
                "3001234567",
                "Calle 123",
                "Bogota",
                "Colombia",
                false,
                "juan@example.com",   // 👈 nuevo campo email
                "1234"                // 👈 nuevo campo password
        );

        try {
            em.getTransaction().begin();
            em.persist(c);
            em.getTransaction().commit();

            System.out.println("✅ Competitor guardado con ID: " + c.getId());

        } catch (Exception e) {
            e.printStackTrace();
            em.getTransaction().rollback();
        } finally {
            em.close();
        }
    }
}
