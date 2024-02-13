package com.espe.dao;

import com.espe.idao.IEmpleadoDAO;
import com.espe.model.Empleado;
import com.espe.model.JPAUtil;
import com.espe.model.Producto;
import jakarta.inject.Named;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;

import java.util.List;

@Named
public class EmpleadoDAOImpl implements IEmpleadoDAO {
    EntityManager entityManager = JPAUtil.getEntityManagerFactory().createEntityManager();


    @Override
    public void guardar(Empleado empleado) {
        EntityManager entityManager = JPAUtil.getEntityManagerFactory().createEntityManager();
        EntityTransaction transaction = null;

        try {
            transaction = entityManager.getTransaction();
            transaction.begin();
            entityManager.persist(empleado);
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
    public void actualizar(Empleado empleado) {
        entityManager.getTransaction().begin();
        entityManager.merge(empleado);
        entityManager.getTransaction().commit();
    }

    @Override
    public Empleado buscarPorId(int id) {
        return entityManager.find(Empleado.class, id);
    }

    @Override
    public List<Empleado> obtenerEmpleados() {
        return entityManager.createQuery("SELECT p FROM Empleado p WHERE p.eliminado = false", Empleado.class).getResultList();
    }

    @Override
    public void eliminar(int id) {
        actualizarEstado(id, true);
    }

    @Override
    public void actualizarEstado(int id, boolean eliminado) {
        Empleado empleado = buscarPorId(id);
        empleado.setEliminado(eliminado);
        entityManager.getTransaction().begin();
        entityManager.merge(empleado);
        entityManager.getTransaction().commit();
    }
}
