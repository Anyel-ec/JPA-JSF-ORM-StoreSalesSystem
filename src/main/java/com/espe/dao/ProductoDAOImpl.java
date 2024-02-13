package com.espe.dao;

import com.espe.idao.IProductoDAO;
import com.espe.model.JPAUtil;
import com.espe.model.Producto;
import jakarta.faces.application.FacesMessage;
import jakarta.faces.context.ExternalContext;
import jakarta.faces.context.FacesContext;
import jakarta.inject.Named;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;

import java.time.LocalDate;
import java.util.List;
@Named
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
    public void actualizarEstado(int id, boolean eliminado) {
        Producto producto = buscarPorId(id);
        producto.setEliminado(eliminado);
        entityManager.getTransaction().begin();
        entityManager.merge(producto);
        entityManager.getTransaction().commit();
    }

    @Override
    public List<Producto> obtenerProductos() {
        return entityManager.createQuery("SELECT p FROM Producto p WHERE p.eliminado = false", Producto.class).getResultList();
    }

    @Override
    public void eliminar(int id) {
        actualizarEstado(id, true);
    }




}
