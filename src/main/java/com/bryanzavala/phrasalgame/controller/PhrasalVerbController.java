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
 * 2. El controlador PhrasalVerbController recibe la petición y llama al método findAllPhrasalVerbs() del servicio PhrasalVerbService.
 * 3. El servicio PhrasalVerbService obtiene los datos de la base de datos y los transforma en una lista de objetos PhrasalVerbCardDto.
 * 4. El controlador devuelve la lista de objetos PhrasalVerbCardDto al cliente en formato JSON.
 * 5. El cliente recibe la respuesta y puede mostrar los datos en la interfaz de usuario.
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
        return service.findAllPhrasalVerbs();
    }
}
