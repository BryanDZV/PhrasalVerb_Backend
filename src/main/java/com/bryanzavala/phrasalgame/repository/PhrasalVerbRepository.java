package com.bryanzavala.phrasalgame.repository;

import com.bryanzavala.phrasalgame.model.PhrasalVerb;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

//Extendemos de JpaRepository para tener acceso a los metodos CRUD y de paginacion
//Genéricos JpaRepository<T, ID> T es la entidad y ID es el tipo de dato de la clave primaria
//heredo metodos como findAll, findById, save, deleteById, etc
//un interface no devuelve nada,solo sus metodos pueden devolver algo, y no tiene implementacion, solo la firma del metodo
// No hacemos 'new' porque es una interfaz y no se puede instanciar.
// Tampoco usamos 'implements'en otras clases para no tener que programar todos los métodos a mano.
// Spring Boot crea la clase real por detrás y nos la entrega lista para usar solo los métodos que necesitemos.
//los repository suelen ser interfaces, porque no necesitamos instanciarlas, solo necesitamos que spring boot nos las inyecte en los servicios y controladores.

public interface PhrasalVerbRepository extends JpaRepository<PhrasalVerb, Long> {

    //este método retorna un Tipo PhrasalVerb envuelto en un Optional, que es una clase que nos permite manejar valores nulos de manera segura, evitando el uso de null y sus problemas asociados
    Optional<PhrasalVerb> findByVerb(String verb);
}
