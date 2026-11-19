package com.bryanzavala.phrasalgame.service;

import com.bryanzavala.phrasalgame.dto.PhrasalVerbCardDto;
import com.bryanzavala.phrasalgame.repository.PhrasalVerbRepository;

import java.util.List;

public class PhrasalVerbService {
    //private final hace que la variable repo sea inmutable, no se puede cambiar su valor despues de ser inicializada
    //es el concepto de inyección de dependencias.
    private final PhrasalVerbRepository repo;

    public PhrasalVerbService(PhrasalVerbRepository repo) {
        this.repo = repo;
    }
    //funcion para covertir en un dto los phrasal verbs, para exponer solo el id y el verbo, y no toda la informacion de la entidad.
    public List<PhrasalVerbCardDto> findAllPhrasalVerbs(){
        //el stream solo sirve para empezar a trabajar con colecciones de datos,
        //sino se pone el stream, no se puede usar map, filter, reduce, etc.
        //mediante map los covertimos en el dto.
        return repo.findAll().stream().map(pv -> new PhrasalVerbCardDto(pv.getId(), pv.getVerb())).toList();
    }
}
