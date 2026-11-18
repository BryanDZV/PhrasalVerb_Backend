package com.bryanzavala.phrasalgame.repository;

import com.bryanzavala.phrasalgame.model.PhrasalVerb;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

//extendemos de JpaRepository para tener acceso a los metodos CRUD y de paginacion
//Genéricos JpaRepository<T, ID> T es la entidad y ID es el tipo de dato de la clave primaria
//heredo metodos como findAll, findById, save, deleteById, etc

public interface PhrasalVerbRepository extends JpaRepository<PhrasalVerb, Long> {
    Optional<PhrasalVerb> findByVerb(String verb);
}
