package com.bryanzavala.phrasalgame.model;

import jakarta.persistence.*;

@Entity //marco la clase como modelo
@Table(name = "phrasal_verb") //opcional me da controll sobre la tabla el nombre
public class PhrasalVerb {
    @Id //lo pongo para marcar quien es la clave primaria
    @GeneratedValue(strategy = GenerationType.IDENTITY)//sirve para genear el id de manera automatica
    @Column(name = "id", nullable = false) //para que no sea nulo
    private  long id;
    @Column(name="example_sentence",nullable = false,length = 1000)
    private String exampleSentence;
    @Column(name="verb",nullable = false,length = 100)
    private String verb;
    @Column(name="translation",nullable = false,length = 1000)
    //column se usa para dar mas control sobre la columna de la base de datos
    //sin ella, spring boot genera la columna con el mismo nombre que la variable
    private String translation;

    //podria no escribir el constructor y los getters y setters, y lombok se encarga de generarlos, pero no lo hago para aprender
    public PhrasalVerb() {
    }

    public long getId() {
        return id;
    }

    public String getExampleSentence() {
        return exampleSentence;
    }

    public void setExampleSentence(String exampleSentence) {
        this.exampleSentence = exampleSentence;
    }

    public String getVerb() {
        return verb;
    }

    public void setVerb(String verb) {
        this.verb = verb;
    }

    public String getTranslation() {
        return translation;
    }

    public void setTranslation(String translation) {
        this.translation = translation;
    }
}
