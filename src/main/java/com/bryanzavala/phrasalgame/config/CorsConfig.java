package com.bryanzavala.phrasalgame.config;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;



@Configuration
// Si el origen de la petición coincide, el navegador deja leer la respuesta. En Spring MVC,

// WebMvcConfigurer.addCorsMappings añade esas cabeceras a las rutas que le indiques.
public class CorsConfig implements WebMvcConfigurer {
    //@Value("${...}") inyecta el valor de una propiedad en un campo.
    @Value("${phrasalgame.cors.allowed-origin}")
    private String allowedOrigin;

    @Override
    //CORS, el servidor responde a una petición con la cabecera Access-Control-Allow-Origin: <origen>.
    public void addCorsMappings(CorsRegistry registry){
        registry.addMapping("/api/**")
                .allowedOrigins(allowedOrigin)
                .allowedMethods("GET","POST");
    }
}
