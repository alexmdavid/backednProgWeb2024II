package com.system.proyectoWeb.models.DAOs;

import com.system.proyectoWeb.models.entities.InscripcionTorneo;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
@Transactional
public class InscripcionTorneoDAO {
    @Autowired
    EntityManager em;

    public void inscribirseTorneo(InscripcionTorneo instorneo) {
        em.persist(instorneo);
    }
}
