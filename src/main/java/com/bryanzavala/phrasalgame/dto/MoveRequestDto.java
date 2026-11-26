package com.bryanzavala.phrasalgame.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
//@notnull hace que el campo gameId no pueda ser nulo.
public record MoveRequestDto(@NotBlank String firstCardId, @NotBlank String secondCardId) {
}
