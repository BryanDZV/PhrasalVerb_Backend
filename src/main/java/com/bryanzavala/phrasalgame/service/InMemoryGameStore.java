package com.bryanzavala.phrasalgame.service;

import org.springframework.stereotype.Component;

import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;

@Component
public class InMemoryGameStore {
    //creamos un CurrentHasMap para que varios hilos puedan acceder a la misma memoria y no se genere un error de concurrencia
    private final Map<String,Map<String,Long>> games=new ConcurrentHashMap<>();
    //este metodo guarda un id de juego
    // el map guarda un id de carta que es un uuid y el id del verbo que es un long
    //asi dos cartas son pareja si ambas apuntan al mismo ID de verbo.
    public void save(String gameId, Map<String, Long> cardToVerb) {
        //guardamos el juego en memoria, copiando el mapa para evitar que se modifique desde fuera de la clase
        //inmutabilidad.
        this.games.put(gameId, Map.copyOf(cardToVerb));
    }
    //método para buscar un juego por su id, y optional para evitar el null pointer exception si no se encuentra el juego
    //optional es una clase que nos permite manejar valores nulos de manera segura, evitando el uso de null y sus problemas asociados
    public Optional<Map<String,Long>> find(String gameId){
        return Optional.ofNullable(this.games.get(gameId));
    }
}
