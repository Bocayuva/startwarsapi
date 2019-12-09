package api.starwars.controllers;

import api.starwars.domains.Planets;
import api.starwars.repositories.PlanetsRepository;
import api.starwars.services.PlanetsService;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.PathVariable;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/planets")
public class PlanetsController {
    @Autowired
    private PlanetsRepository repository;

    @Autowired
    private  PlanetsService planetsService;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public List<Planets> getAll() {
        return repository.findAll();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Planets getById(@PathVariable("id") ObjectId id) {
        return repository.findBy_id(id);
    }

    @RequestMapping(value = "/name/{name}", method = RequestMethod.GET)
    public Planets getByName(@PathVariable("name") String name) {
        return repository.findByName(name);
    }

    @RequestMapping(value = "/", method = RequestMethod.POST)
    public Planets create(@Valid @RequestBody Planets planet) {
        if(repository.findByName(planet.getName()) != null) throw new Error("Planet already exist on database");

        Integer filmAppearances = planetsService.amountMovieAppearances(planet.getName());
        planet.setFilmAppearances(filmAppearances);
        repository.save(planet);

        return planet;
    }

    @RequestMapping(value = "/", method = RequestMethod.PUT)
    public Planets updataById(@Valid @RequestBody Planets updatePlanet) {
        Planets planet = repository.findByName(updatePlanet.getName());
        if(planet == null) throw new Error("Planet doesnt exist on database");

        Integer filmAppearances = planetsService.amountMovieAppearances(updatePlanet.getName());
        updatePlanet.setFilmAppearances(filmAppearances);
        updatePlanet.set_id(planet.get_id());
        repository.save(updatePlanet);

        return updatePlanet;
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public void deletePet(@PathVariable ObjectId id) {
        repository.delete(repository.findBy_id(id));
    }
}
