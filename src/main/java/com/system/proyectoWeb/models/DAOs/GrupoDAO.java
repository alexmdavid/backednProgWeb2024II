package com.system.proyectoWeb.models.DAOs;


import com.system.proyectoWeb.models.DAOs.IDAOs.IGrupoDAO;
import com.system.proyectoWeb.models.entities.Grupo;
import com.system.proyectoWeb.models.entities.Torneo;
import com.system.proyectoWeb.models.entities.Usuario;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Transactional
public class GrupoDAO implements IGrupoDAO {

    @PersistenceContext
    private EntityManager entityManager;


    @Override
    public Grupo crearGrupo(Grupo grupo) {
        if (grupo == null) {
            throw new IllegalArgumentException("El grupo no puede ser null");
        }
        if (grupo.getNombre() == null || grupo.getNombre().isBlank()) {
            throw new IllegalArgumentException("El nombre del grupo es obligatorio");
        }
        if (grupo.getIdGrupo() == null) {
            entityManager.persist(grupo);
            return grupo;
        } else {
            return entityManager.merge(grupo);
        }
    }

    public Grupo obtenerGrupoPorId(Integer idGrupo) {
        return entityManager.find(Grupo.class, idGrupo);
    }

    public List<Grupo> listarGruoo() {
        return entityManager.createQuery("FROM Grupo",  Grupo.class).getResultList();
    }

}
