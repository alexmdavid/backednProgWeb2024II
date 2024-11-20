package com.system.proyectoWeb.models.DAOs;

import com.system.proyectoWeb.models.entities.InscripcionGrupo;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
@Transactional
public class InscripcionGrupoDAO {
    @Autowired
    private EntityManager em;

    public void inscribirseEnGrupo(InscripcionGrupo inscripcion) {
        em.persist(inscripcion);
    }
}
