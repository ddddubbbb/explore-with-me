package ru.practicum.model;

import ru.practicum.StatDto;

public class StatMapper {

    private StatMapper() {
    }

    public static StatDto toStatDto(Stat stat) {
        return StatDto.builder()
                .app(stat.getApp())
                .uri(stat.getUri())
                .hits(stat.getHits().intValue())
                .build();
    }
}