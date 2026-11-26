package com.bryanzavala.phrasalgame.service;

import com.bryanzavala.phrasalgame.exception.GameNotFoundException;
import com.bryanzavala.phrasalgame.dto.CardDto;
import com.bryanzavala.phrasalgame.dto.GameDto;
import com.bryanzavala.phrasalgame.model.GameMode;
import com.bryanzavala.phrasalgame.model.PhrasalVerb;
import com.bryanzavala.phrasalgame.repository.PhrasalVerbRepository;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class GameService {

    //declaramos un campo cuyo tipo es la interfaz del repositorio, para poder acceder a los datos de la base de datos.
    private final PhrasalVerbRepository repo;
    //declaramos un campo cuyo tipo es la interfaz del repositorio.
    private final InMemoryGameStore gameStore;


    public GameService(PhrasalVerbRepository repo, InMemoryGameStore gameStore) {
        this.repo = repo;
        this.gameStore = gameStore;
    }

    //objetivo obtener los verbos, elegir parejas, y crear las cartas.
    public GameDto createGame(GameMode mode, int pairs){
        //lista de todo los verbos
        List<PhrasalVerb>verbs=new ArrayList<>(repo.findAll());
        //barajamos los verbos para que sea aleatorio en el juego.
        Collections.shuffle(verbs);
        //elegimos una sublista de verbos, dependiendo del modo de juego y la cantidad de pares que se quieran jugar
        List<PhrasalVerb> selectedVerbs = verbs.subList(0,  Math.min(pairs, verbs.size()));
        //lista para las cartas del juego tipo CardDto.
        List<CardDto> cards = new ArrayList<>();
        //un mapa para comprobar si son parejas sera el que se guarde en memoria.
        Map<String,Long> cardToVerb=new HashMap<>();

        for (PhrasalVerb verb: selectedVerbs){
            //creamos dos cartas por cada verbo y sus id aleatorio
            String verbCardId=UUID.randomUUID().toString();
            String translationCardId=UUID.randomUUID().toString();
            //guardamos las cartas en la lista de cartas.
            cards.add(new CardDto(verbCardId, verb.getVerb()));
            cards.add(new CardDto(translationCardId, verb.getTranslation()));

            //guardamos en el mapa de parejas, la carta y su id de verbo, para poder comprobar si son pareja.
            cardToVerb.put(verbCardId, verb.getId());
            cardToVerb.put(translationCardId, verb.getId());

        }
            Collections.shuffle(cards);
            //creamos el id del juego y lo guardamos en el almacén de juegos.
            String gameId = UUID.randomUUID().toString();
            gameStore.save(gameId, cardToVerb);

            return new GameDto(gameId, cards);


    }
    public boolean validateMove(String gameId,String firstCardId,String secondCardId) {
        //obtenemos el juego por el id
        Optional<Map<String,Long>> game = Optional.of(gameStore.find(gameId).orElseThrow(() -> new GameNotFoundException(gameId)));
        return true;
    }
    }

