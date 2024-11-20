package com.system.proyectoWeb.models.DAOs;


import com.system.proyectoWeb.models.entities.Ruta;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional

public class RutaDAO {
    @PersistenceContext
    private EntityManager em;

    public List<Ruta> listarRutas() {
        return em.createQuery("FROM Ruta", Ruta.class).getResultList();
    }
}
