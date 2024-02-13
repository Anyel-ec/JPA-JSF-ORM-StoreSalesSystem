package com.espe.dao;

import com.espe.idao.IPuestoDAO;
import com.espe.model.JPAUtil;
import com.espe.model.Producto;
import com.espe.model.Puesto;
import jakarta.persistence.EntityManager;

import java.util.List;

public class PuestoDAOImpl implements IPuestoDAO {
    EntityManager entityManager = JPAUtil.getEntityManagerFactory().createEntityManager();

    @Override
    public List<Puesto> obtenerPuestos() {
        return entityManager.createQuery("SELECT p FROM Puesto p", Puesto.class).getResultList();
    }
}
