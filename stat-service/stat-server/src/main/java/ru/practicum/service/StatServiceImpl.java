package ru.practicum.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.practicum.HitDto;
import ru.practicum.StatDto;
import ru.practicum.exceptions.ValidationRequestException;
import ru.practicum.model.Stat;
import ru.practicum.model.StatMapper;
import ru.practicum.repository.StatRepository;

import java.time.LocalDateTime;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import static ru.practicum.model.HitMapper.toHit;

@Service
@RequiredArgsConstructor
public class StatServiceImpl implements StatService {
    private final StatRepository statRepository;

    @Override
    public void addHit(HitDto hitDto) {
        statRepository.save(toHit(hitDto));
    }

    @Override
    public List<StatDto> getStats(LocalDateTime start, LocalDateTime end, String[] uris, boolean unique) {
        List<Stat> stats;
        if (start.isAfter(end)) {
            throw new ValidationRequestException("Date start must be before date end");
        }
        if (unique) {
            if (uris == null) {
                stats = statRepository.findAllUrisWithUniqueIp(start, end);
            } else {
                stats = statRepository.findUrisWithUniqueIp(uris, start, end);
            }
        } else {
            if (uris == null) {
                stats = statRepository.findAllUris(start, end);
            } else {
                stats = statRepository.findUris(uris, start, end);
            }
        }
        return !stats.isEmpty() ? stats.stream().map(StatMapper::toStatDto)
                .collect(Collectors.toList()) : Collections.emptyList();
    }
}