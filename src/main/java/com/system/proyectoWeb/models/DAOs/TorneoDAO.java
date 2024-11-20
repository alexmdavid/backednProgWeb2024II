package com.system.proyectoWeb.models.DAOs;

import com.system.proyectoWeb.models.DAOs.IDAOs.ITorneoDAO;
import com.system.proyectoWeb.models.entities.Torneo;
import com.system.proyectoWeb.models.entities.Usuario;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
@Transactional
public class TorneoDAO implements ITorneoDAO {
    @PersistenceContext
    private EntityManager em;
    @Override
    public List<Torneo> listarTorneo() {
        return em.createQuery("from Torneo", Torneo.class).getResultList();
    }

    public Torneo obtenerPorId(Integer idTorneo) {
        return em.find(Torneo.class, idTorneo);
    }



    @Transactional
    public void refresh(Torneo torneo) {
        em.refresh(torneo);
    }

    public Torneo guardar(Torneo torneo) {
        if (torneo.getIdTorneo() == null) {
            em.persist(torneo);
            return torneo;
        } else {
            return em.merge(torneo);
        }
    }
}
