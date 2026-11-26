package com.bryanzavala.phrasalgame.dto;
//usamos record porque me sirve para crear un objeto inmutable,
// y transportar datos, con getters,equals, hashcode y toString ya implementados.
public record PhrasalVerbCardDto(Long id, String verb) {

}
