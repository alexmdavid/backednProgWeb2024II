package com.system.proyectoWeb.models.DAOs;


import com.system.proyectoWeb.models.entities.Ruta;
import com.system.proyectoWeb.models.entities.Torneo;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public class RutaDAO {
    @PersistenceContext
    private EntityManager em;

    @jakarta.transaction.Transactional
    public void refresh(Ruta ruta) {
        em.refresh(ruta);
    }

    public Ruta guardar(Ruta ruta) {
        if (ruta.getIdRuta() == null) {
            em.persist(ruta);
            return ruta;
        } else {
            return em.merge(ruta);
        }
    }

    public List<Ruta> buscarRutasPorNombre(String nombre) {
        String queryStr = "SELECT r FROM Ruta r WHERE r.nombreRuta LIKE :nombre";
        TypedQuery<Ruta> query = em.createQuery(queryStr, Ruta.class);
        query.setParameter("nombre", "%" + nombre + "%");
        return query.getResultList();
    }

    public List<Ruta> listarRutas() {
        return em.createQuery("FROM Ruta", Ruta.class).getResultList();
    }
}
