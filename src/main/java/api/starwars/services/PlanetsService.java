package api.starwars.services;

import api.starwars.domains.swapi.PlanetsSwapiPlanetResponse;
import api.starwars.domains.swapi.PlanetsSwapiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class PlanetsService {

    @Autowired
    private RestService restService;

    public Integer amountMovieAppearances(String planetName) {
        PlanetsSwapiPlanetResponse planetsSwapiPlanetResponses = findPlanetByName(planetName, null);

        if(planetsSwapiPlanetResponses != null && planetsSwapiPlanetResponses.getFilms() != null)
            return planetsSwapiPlanetResponses.getFilms().size();

        return 0;
    }

    private PlanetsSwapiPlanetResponse findPlanetByName(String planetName, String nextUrl) {
        PlanetsSwapiResponse planetsSwapiResponse = null;

        if(nextUrl != null)
            planetsSwapiResponse = restService.getPlanets(nextUrl);
        else
            planetsSwapiResponse = restService.getPlanetByName(planetName);

        if(planetsSwapiResponse != null) {
            ArrayList<PlanetsSwapiPlanetResponse> planets = planetsSwapiResponse.getResults();

            if (planets != null && planets.size() > 0)
                for (PlanetsSwapiPlanetResponse planetsSwapiPlanetResponse: planets)
                    if (planetsSwapiPlanetResponse.getName().equals(planetName))
                        return planetsSwapiPlanetResponse;

            if(!planetsSwapiResponse.getNext().isEmpty())
                return findPlanetByName(planetName, planetsSwapiResponse.getNext());
        }

        return null;
    }
}