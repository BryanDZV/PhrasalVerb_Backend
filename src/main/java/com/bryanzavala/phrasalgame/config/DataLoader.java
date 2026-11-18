package com.bryanzavala.phrasalgame.config;

import com.bryanzavala.phrasalgame.model.PhrasalVerb;
import com.bryanzavala.phrasalgame.repository.PhrasalVerbRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;

public class DataLoader {
    //esto sirve para que spring boot ejecute este metodo al iniciar la aplicacion
    @Bean
    CommandLineRunner cargarDatos(PhrasalVerbRepository repository) {
        return args -> {
            if (repository.count()>0){
                //si ya hay datos en la base de datos no hago nada
                return;



            }
           //aqui creo Crea 6 phrasal verbs: 2 pares de opuestos (por ejemplo, put on / take off) y 2 sueltos.
            PhrasalVerb putOn = new PhrasalVerb();
            putOn.setVerb("put on");
            putOn.setTranslation("ponerse");
            putOn.setExampleSentence("I put on my coat before going outside.");
            repository.save(putOn);

            PhrasalVerb takeOff = new PhrasalVerb();
            takeOff.setVerb("take off");
            takeOff.setTranslation("quitarse");
            takeOff.setExampleSentence("He took off his shoes before entering the house.");
            repository.save(takeOff);

            //establezco la relacion de opuestos
            putOn.setOpposite(takeOff);
            takeOff.setOpposite(putOn);
            repository.save(putOn);
            repository.save(takeOff);
        };
    }
}
