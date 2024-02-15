package ru.practicum.service;

import ru.practicum.HitDto;
import ru.practicum.StatDto;

import java.time.LocalDateTime;
import java.util.List;

public interface StatService {

    void addHit(HitDto hitDto);

    List<StatDto> getStats(LocalDateTime start, LocalDateTime end, String[] uris, boolean unique);
}