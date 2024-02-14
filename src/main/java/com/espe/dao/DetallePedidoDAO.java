package com.espe.dao;

import com.espe.idao.IDetallePedidoDAO;
import com.espe.model.DetallePedido;
import com.espe.model.JPAUtil;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Named;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;

import java.util.List;

@Named
public class DetallePedidoDAO implements IDetallePedidoDAO {
    EntityManager entityManager = JPAUtil.getEntityManagerFactory().createEntityManager();

    @Override
    public void guardar(DetallePedido detallePedido) {
        EntityManager entityManager = JPAUtil.getEntityManagerFactory().createEntityManager();
        EntityTransaction transaction = null;

        try {
            transaction = entityManager.getTransaction();
            transaction.begin();
            entityManager.persist(detallePedido);
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
    public void actualizar(DetallePedido detallePedido) {
        entityManager.getTransaction().begin();
        entityManager.merge(detallePedido);
        entityManager.getTransaction().commit();
    }

    @Override
    public DetallePedido buscarPorId(int id) {
        return entityManager.find(DetallePedido.class, id);

    }

    @Override
    public List<DetallePedido> obtenerDetallePedido() {
        return entityManager.createQuery("SELECT d FROM DetallePedido d", DetallePedido.class).getResultList();
    }

    @Override
    public void eliminar(int id) {
        // eliminacion fisica con remove
        DetallePedido detallePedido = buscarPorId(id);
        entityManager.getTransaction().begin();
        entityManager.remove(detallePedido);
        entityManager.getTransaction().commit();
    }


}
