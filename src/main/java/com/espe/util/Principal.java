package com.espe.util;

import com.espe.model.Empleado;
import com.espe.model.JPAUtil;
import com.espe.model.Puesto;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;

public class Principal {
    public static void main(String[] args) {
        EntityManager em = JPAUtil.getEntityManagerFactory().createEntityManager();
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        Puesto puesto = new Puesto("Gerente");
        Empleado empleado = new Empleado(1, "Juan", "Perez", puesto, "0999999999", "1234567890", false);
        em.persist(puesto);
        em.persist(empleado);
        tx.commit();
        em.close();
        JPAUtil.shutdown();
    }
}
