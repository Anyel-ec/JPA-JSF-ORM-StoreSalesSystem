package com.espe.dao;

import com.espe.idao.IClienteDAO;
import com.espe.model.Cliente;
import com.espe.model.JPAUtil;
import com.espe.model.Producto;
import jakarta.inject.Named;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;

import java.util.List;
@Named
public class ClienteDAOImpl implements IClienteDAO {
    EntityManager entityManager = JPAUtil.getEntityManagerFactory().createEntityManager();

    @Override
    public void guardar(Cliente cliente) {
        EntityManager entityManager = JPAUtil.getEntityManagerFactory().createEntityManager();
        EntityTransaction transaction = null;

        try {
            transaction = entityManager.getTransaction();
            transaction.begin();
            entityManager.persist(cliente);
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
    public void actualizar(Cliente cliente) {
        entityManager.getTransaction().begin();
        entityManager.merge(cliente);
        entityManager.getTransaction().commit();
    }

    @Override
    public Cliente buscarPorId(int id) {
        return entityManager.find(Cliente.class, id);
    }

    @Override
    public List<Cliente> obtenerClientes() {
        return entityManager.createQuery("SELECT p FROM Cliente p WHERE p.eliminado = false", Cliente.class).getResultList();
    }

    @Override
    public void eliminar(int id) {
        actualizarEstado(id, true);
    }

    @Override
    public void actualizarEstado(int id, boolean eliminado) {
        Cliente cliente = buscarPorId(id);
        cliente.setEliminado(eliminado);
        entityManager.getTransaction().begin();
        entityManager.merge(cliente);
        entityManager.getTransaction().commit();

    }
}