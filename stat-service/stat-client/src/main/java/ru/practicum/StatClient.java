package ru.practicum;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.util.Map;

public class StatClient {
    private final RestTemplate rest;
    private static final String STAT_SERVER_URL = "http://localhost:9090";

    public StatClient() {
        this.rest = new RestTemplate();
    }

    public void addHit(HitDto hitDto) {
        HttpEntity<HitDto> requestEntity = new HttpEntity<>(hitDto);
        rest.exchange(STAT_SERVER_URL + "/hit", HttpMethod.POST, requestEntity, Object.class);
    }

    public ResponseEntity<Object> getStats(String start, String end, String[] uris, boolean unique) {
        Map<String, Object> parameters;
        String path;
        if (uris != null) {
            parameters = Map.of(
                    "start", start,
                    "end", end,
                    "uris", uris,
                    "unique", unique
            );
            path = STAT_SERVER_URL + "/stats/?start={start}&end={end}&uris={uris}&unique={unique}";
        } else {
            parameters = Map.of(
                    "start", start,
                    "end", end,
                    "unique", unique
            );
            path = STAT_SERVER_URL + "/stats/?start={start}&end={end}&unique={unique}";
        }
        ResponseEntity<Object> serverResponse = rest.getForEntity(path, Object.class, parameters);
        if (serverResponse.getStatusCode().is2xxSuccessful()) {
            return serverResponse;
        }
        ResponseEntity.BodyBuilder responseBuilder = ResponseEntity.status(serverResponse.getStatusCode());
        if (serverResponse.hasBody()) {
            return responseBuilder.body(serverResponse.getBody());
        }
        return responseBuilder.build();
    }
}