package com.bryanzavala.phrasalgame.controller;

import com.bryanzavala.phrasalgame.dto.PhrasalVerbCardDto;
import com.bryanzavala.phrasalgame.service.PhrasalVerbService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * FLUJO DE DATOS:
 * 1. El cliente hace una petición GET a la ruta /api/phrasal-verbs.
 * 2. El controlador PhrasalVerbController recibe la petición y llama al método findAllCards() del servicio PhrasalVerbService.
 * 3. El servicio PhrasalVerbService llama a repo.findAll() en el repositorio PhrasalVerbRepository.
 * 4. El repositorio consulta la base de datos (vía JPA/Hibernate) y devuelve las entidades (List<PhrasalVerb>) al servicio.
 * 5. El servicio transforma esas entidades en una lista de PhrasalVerbCardDto y se la devuelve al controlador.
 * 6. El controlador devuelve la lista de PhrasalVerbCardDto al cliente en formato JSON.
 * 7. El cliente recibe la respuesta y muestra los datos en la interfaz de usuario.
 */

@RestController //anotación para indicar que es un controlador de tipo REST responden a peticiones HTTP y devuelven datos en formato JSON
@RequestMapping("/api/phrasal-verbs")//para crear implícitamente una ruta base para todos los endpoints de este controlador
public class PhrasalVerbController {
    private final PhrasalVerbService service;

    public PhrasalVerbController(PhrasalVerbService service) {
        this.service = service;
    }

    @GetMapping //me permite asociar un método del controlador a una ruta HTTP GET, en este caso la ruta base /api/phrasal-verbs
    public List<PhrasalVerbCardDto> list() {
        return service.findAllCards();
    }
}
