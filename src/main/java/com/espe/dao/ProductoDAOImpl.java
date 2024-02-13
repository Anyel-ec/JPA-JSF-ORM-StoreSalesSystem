package com.espe.dao;

import com.espe.idao.IProductoDAO;
import com.espe.model.JPAUtil;
import com.espe.model.Producto;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;

import java.util.List;

public class ProductoDAOImpl implements IProductoDAO {
    EntityManager entityManager = JPAUtil.getEntityManagerFactory().createEntityManager();

    @Override
    public void guardar(Producto producto) {
        EntityManager entityManager = JPAUtil.getEntityManagerFactory().createEntityManager();
        EntityTransaction transaction = null;

        try {
            transaction = entityManager.getTransaction();
            transaction.begin();
            entityManager.persist(producto);
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
    public void actualizar(Producto producto) {
        entityManager.getTransaction().begin();
        entityManager.merge(producto);
        entityManager.getTransaction().commit();
    }

    @Override
    public Producto buscarPorId(int id) {
        return entityManager.find(Producto.class, id);
    }

    @Override
    public List<Producto> obtenerProductos() {
        return entityManager.createQuery("SELECT p FROM Producto p WHERE p.eliminado = false", Producto.class).getResultList();
    }

    @Override
    public void eliminar(int id) {
        Producto producto = buscarPorId(id);
        entityManager.getTransaction().begin();
        entityManager.remove(producto);
        entityManager.getTransaction().commit();
    }
}
