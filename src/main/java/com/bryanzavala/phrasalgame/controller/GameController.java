package com.bryanzavala.phrasalgame.controller;

import com.bryanzavala.phrasalgame.dto.GameDto;
import com.bryanzavala.phrasalgame.dto.MoveRequestDto;
import com.bryanzavala.phrasalgame.dto.MoveResultDto;
import com.bryanzavala.phrasalgame.model.GameMode;
import com.bryanzavala.phrasalgame.service.GameService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Min;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

//recibe los parametros y llama al servicio para crear un juego
@RestController
///api/games?mode=TRANSLATION&pairs=3
@RequestMapping("/api/games")
//aplico la la regla con @Min(1) no necesito @Validated
public class GameController {


    private final GameService gameService;

    public GameController(GameService gameService) {

        this.gameService = gameService;
    }

    @PostMapping()
    //crear estado de juego creado con @ResponseStatus(HttpStatus.CREATED) y devolver el juego creado
    @ResponseStatus(HttpStatus.CREATED)
    public GameDto createGame(@RequestParam GameMode mode, @RequestParam @Min(1)int pairs){
        return gameService.createGame(mode,pairs);
    }
    //validar el movimiento con id
    @PostMapping("/{gameId}/moves")
    public MoveResultDto validateMove(@PathVariable String gameId, @Valid @RequestBody MoveRequestDto moveRequestDto) {
        boolean isMatch= gameService.validateMove(gameId, moveRequestDto.firstCardId(), moveRequestDto.secondCardId());
        return new MoveResultDto(isMatch);
    }

}
