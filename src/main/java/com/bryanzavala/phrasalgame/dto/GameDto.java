package com.bryanzavala.phrasalgame.dto;

import java.util.List;

public record GameDto(String gameId, List<CardDto> cards) {
}
