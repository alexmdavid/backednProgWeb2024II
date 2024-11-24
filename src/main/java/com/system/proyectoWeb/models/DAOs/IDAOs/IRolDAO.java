package com.system.proyectoWeb.models.DAOs.IDAOs;

import com.system.proyectoWeb.models.entities.Rol;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface IRolDAO extends JpaRepository<Rol, Integer> {
    @Query("SELECT r FROM Rol r WHERE r.nombre = :nombre")
    Rol findByNombre(@Param("nombre") String nombre);
}
