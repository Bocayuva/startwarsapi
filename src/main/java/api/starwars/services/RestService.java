package api.starwars.services;

import api.starwars.domains.swapi.PlanetsSwapiResponse;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.time.Duration;

@Service
public class RestService {

    private final RestTemplate restTemplate;

    public RestService(RestTemplateBuilder restTemplateBuilder) {
        this.restTemplate = restTemplateBuilder
                .setConnectTimeout(Duration.ofSeconds(500))
                .setReadTimeout(Duration.ofSeconds(500))
                .build();
    }

    public PlanetsSwapiResponse getPlanets(String url) {
        if(url == null) url = "https://swapi.co/api/planets/";

        return this.restTemplate.getForObject(url, PlanetsSwapiResponse.class);
    }

    public PlanetsSwapiResponse getPlanetByName(String name) {
        String url = "https://swapi.co/api/planets/?search={name}";

        return this.restTemplate.getForObject(url, PlanetsSwapiResponse.class, name);
    }
}