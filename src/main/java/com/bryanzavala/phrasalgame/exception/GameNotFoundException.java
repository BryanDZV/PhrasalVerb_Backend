package com.bryanzavala.phrasalgame.exception;

public class GameNotFoundException extends RuntimeException{
    public GameNotFoundException(String id) {
        super("Juego No encontrado con id: " + id);
    }
}
