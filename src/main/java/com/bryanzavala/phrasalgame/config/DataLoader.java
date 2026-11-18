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
    CommandLineRunner loadData(PhrasalVerbRepository repository) {
        return args -> {
            // Dos pares de opuestos.
            PhrasalVerb putOn = createIfNotExists(repository, "put on", "ponerse",
                    "I put on my coat before going outside.");
            PhrasalVerb takeOff = createIfNotExists(repository, "take off", "quitarse",
                    "He took off his shoes before entering the house.");
            linkOpposites(repository, putOn, takeOff);

            PhrasalVerb turnOn = createIfNotExists(repository, "turn on", "encender",
                    "Please turn on the light.");
            PhrasalVerb turnOff = createIfNotExists(repository, "turn off", "apagar",
                    "Please turn off the light when you leave.");
            linkOpposites(repository, turnOn, turnOff);

            // Dos verbos sueltos, sin relación de opuestos.
            createIfNotExists(repository, "give up", "rendirse",
                    "She decided not to give up.");
            createIfNotExists(repository, "look after", "cuidar",
                    "He looks after his younger sister.");
        };
    }

    private PhrasalVerb createIfNotExists(PhrasalVerbRepository repository, String verb,
                                          String translation, String exampleSentence) {
        return repository.findByVerb(verb).orElseGet(() -> {
            PhrasalVerb phrasalVerb = new PhrasalVerb();
            phrasalVerb.setVerb(verb);
            phrasalVerb.setTranslation(translation);
            phrasalVerb.setExampleSentence(exampleSentence);
            return repository.save(phrasalVerb);
        });
    }

    private void linkOpposites(PhrasalVerbRepository repository, PhrasalVerb verb1, PhrasalVerb verb2) {
        if (verb1.getOpposite() != null) {
            return;
        }

        verb1.setOpposite(verb2);
        verb2.setOpposite(verb1);
        repository.save(verb1);
        repository.save(verb2);
    }
}
