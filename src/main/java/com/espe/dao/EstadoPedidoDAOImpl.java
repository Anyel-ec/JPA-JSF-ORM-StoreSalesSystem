package com.espe.dao;

import com.espe.idao.IEstadoPedido;
import com.espe.model.EstadoPedido;
import com.espe.model.JPAUtil;
import com.espe.model.Puesto;
import jakarta.persistence.EntityManager;

import java.util.List;

public class EstadoPedidoDAOImpl  implements IEstadoPedido {
    EntityManager entityManager = JPAUtil.getEntityManagerFactory().createEntityManager();

    @Override
    public List<EstadoPedido> obtenerEstadoPedido() {
        return entityManager.createQuery("SELECT e FROM EstadoPedido e", EstadoPedido.class).getResultList();
    }
}
