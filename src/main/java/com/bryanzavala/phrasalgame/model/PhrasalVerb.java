package com.bryanzavala.phrasalgame.model;

import jakarta.persistence.*;

@Entity //marco la clase como modelo
@Table(name = "phrasal_verb") //opcional me da controll sobre la tabla el nombre
public class PhrasalVerb {
    @Id //lo pongo para marcar quien es la clave primaria
    @GeneratedValue(strategy = GenerationType.IDENTITY)//sirve para genear el id de manera automatica
    @Column(name = "id", nullable = false) //para que no sea nulo
    private  Long id;
    @Column(name="example_sentence",nullable = false,length = 1000)
    private String exampleSentence;
    @Column(name="verb",nullable = false,length = 100, unique = true)
    private String verb;
    @Column(name="translation",nullable = false,length = 1000)
    //column se usa para dar mas control sobre la columna de la base de datos
    //sin ella, spring boot genera la columna con el mismo nombre que la variable
    private String translation;

    //para una accion reflexiva
    @ManyToOne(fetch = FetchType.LAZY)//el fetch type lazy es para que no se cargue la relacion hasta que se necesite
    @JoinColumn(name="opposite_id",foreignKey = @ForeignKey(name = "fk_opposite_id"))
    //relacionamiento con la tabla phrasal_verb, la columna opposite_id es la que hace referencia a la clave primaria de la tabla phrasal_verb
    //convecion de nombres: fk_nombre_de_la_tabla_nombre_de_la_columna
    private PhrasalVerb opposite;

    //podria no escribir el constructor y los getters y setters, y lombok se encarga de generarlos, pero no lo hago para aprender
    public PhrasalVerb() {
    }

    public PhrasalVerb getOpposite() {
        return opposite;
    }

    public void setOpposite(PhrasalVerb opposite) {
        this.opposite = opposite;
    }

    public Long getId() {
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
