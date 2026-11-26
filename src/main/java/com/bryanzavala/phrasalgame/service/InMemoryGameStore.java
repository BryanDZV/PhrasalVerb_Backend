package com.bryanzavala.phrasalgame.service;

import org.springframework.stereotype.Component;

import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;

@Component
public class InMemoryGameStore {
    // Almacena los juegos en memoria y permite acceder a ellos desde varios hilos.
    // Ejemplo: gameId -> (cardId -> verbId)
   // La clave exterior (gameId) identifica el juego.
    // La clave interior (cardId) identifica una carta.
    // El valor (verbId) identifica el phrasal verb.
    private final Map<String,Map<String,Long>> games=new ConcurrentHashMap<>();

    // Guarda un juego usando su ID.
    // Dos cartas son pareja si tienen el mismo verbId.
    // Map.copyOf crea una copia que no puede modificarse.
    public void save(String gameId, Map<String, Long> cardToVerb) {
        this.games.put(gameId, Map.copyOf(cardToVerb));
    }

    // Busca un juego por su ID.
    // Optional contiene el mapa si existe; si no existe, está vacío.
    public Optional<Map<String,Long>> find(String gameId){
        return Optional.ofNullable(this.games.get(gameId));
    }
}
