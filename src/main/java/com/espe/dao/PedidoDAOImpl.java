package com.espe.dao;

import com.espe.idao.IClienteDAO;
import com.espe.idao.IEstadoPedido;
import com.espe.idao.IPedidoDAO;
import com.espe.idao.IProductoDAO;
import com.espe.model.*;
import jakarta.annotation.PostConstruct;
import jakarta.faces.application.FacesMessage;
import jakarta.faces.context.FacesContext;
import jakarta.inject.Named;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;

import java.util.List;


@Named
public class PedidoDAOImpl implements IPedidoDAO {
    EntityManager entityManager = JPAUtil.getEntityManagerFactory().createEntityManager();

    @Override
    public void guardar(Pedido pedido) {
        EntityManager entityManager = JPAUtil.getEntityManagerFactory().createEntityManager();
        EntityTransaction transaction = null;

        try {
            transaction = entityManager.getTransaction();
            transaction.begin();
            entityManager.persist(pedido);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        } finally {
            entityManager.close();
        }
    }

    @Override
    public void actualizar(Pedido pedido) {
        entityManager.getTransaction().begin();
        entityManager.merge(pedido);
        entityManager.getTransaction().commit();
    }

    @Override
    public Pedido buscarPorId(int id) {
        return entityManager.find(Pedido.class, id);
    }

    @Override
    public List<Pedido> obtenerPedidos() {
        return entityManager.createQuery("SELECT p FROM Pedido p", Pedido.class).getResultList();
    }

    @Override
    public void eliminar(int id) {
        Pedido pedido = buscarPorId(id);
        entityManager.getTransaction().begin();
        entityManager.remove(pedido);
        entityManager.getTransaction().commit();
    }


    // objeto de tipo pedido

}
