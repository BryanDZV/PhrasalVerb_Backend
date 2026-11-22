package com.bryanzavala.phrasalgame.controller;

import com.bryanzavala.phrasalgame.dto.GameDto;
import com.bryanzavala.phrasalgame.model.GameMode;
import com.bryanzavala.phrasalgame.service.GameService;
import jakarta.validation.constraints.Min;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

//recibe los parametros y llama al servicio para crear un juego
@Controller
///api/games?mode=TRANSLATION&pairs=3
@RequestMapping("api/games")
public class GameController {

    private final GameService gameService;

    public GameController(GameService gameService) {
        this.gameService = gameService;
    }

    @PostMapping()
    public GameDto createGame(@RequestParam GameMode mode, @RequestParam @Min(1)int pairs){
        return gameService.createGame(mode,pairs);
    }

}
