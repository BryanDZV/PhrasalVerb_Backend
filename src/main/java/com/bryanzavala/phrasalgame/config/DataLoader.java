package com.bryanzavala.phrasalgame.config;

import com.bryanzavala.phrasalgame.model.PhrasalVerb;
import com.bryanzavala.phrasalgame.repository.PhrasalVerbRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration //esto sirve para que spring boot sepa que esta clase es de configuracion y la ejecute al iniciar la aplicacion
public class DataLoader {
    //esto sirve para que spring boot ejecute este metodo al iniciar la aplicacion
    @Bean
    CommandLineRunner cargarDatos(PhrasalVerbRepository repository) {
        return args -> {
            // Dos pares de opuestos.
            PhrasalVerb putOn = crearSiNoExiste(repository, "put on", "ponerse",
                    "I put on my coat before going outside.");
            PhrasalVerb takeOff = crearSiNoExiste(repository, "take off", "quitarse",
                    "He took off his shoes before entering the house.");
            putOn.setOpposite(takeOff);
            takeOff.setOpposite(putOn);
            repository.save(putOn);
            repository.save(takeOff);

            PhrasalVerb turnOn = crearSiNoExiste(repository, "turn on", "encender",
                    "Please turn on the light.");
            PhrasalVerb turnOff = crearSiNoExiste(repository, "turn off", "apagar",
                    "Please turn off the light when you leave.");
            turnOn.setOpposite(turnOff);
            turnOff.setOpposite(turnOn);
            repository.save(turnOn);
            repository.save(turnOff);

            // Dos verbos sueltos, sin relación de opuestos.
            crearSiNoExiste(repository, "give up", "rendirse",
                    "She decided not to give up.");
            crearSiNoExiste(repository, "look after", "cuidar",
                    "He looks after his younger sister.");
        };
    }

    private PhrasalVerb crearSiNoExiste(PhrasalVerbRepository repository, String verb,
                                        String translation, String exampleSentence) {
        return repository.findByVerb(verb).orElseGet(() -> {
            PhrasalVerb phrasalVerb = new PhrasalVerb();
            phrasalVerb.setVerb(verb);
            phrasalVerb.setTranslation(translation);
            phrasalVerb.setExampleSentence(exampleSentence);
            return repository.save(phrasalVerb);
        });
    }
}
