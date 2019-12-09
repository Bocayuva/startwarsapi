package api.starwars.domains;


import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Document( collection = "planets")
public class Planets {
    @Id
    private String _id;

    @NotBlank
    private String name;

    @NotBlank
    private String climate;

    @NotBlank
    private String terrain;

    @NotNull
    private Integer filmAppearances;

    public Planets() {
        this.filmAppearances = 0;
    }

    public Planets(String name, String weather, String ground) {
        this.name = name;
        this.climate = weather;
        this.terrain = ground;
        this.filmAppearances = 0;
    }

    public Planets(String name, String weather, String ground, Integer filmAppearances) {
        this.name = name;
        this.climate = weather;
        this.terrain = ground;
        this.filmAppearances = filmAppearances;
    }

    public String get_id() {
        return _id;
    }

    public void set_id(String _id) {
        this._id = _id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getClimate() {
        return climate;
    }

    public void setClimate(String weather) {
        this.climate = weather;
    }

    public String getTerrain() {
        return terrain;
    }

    public void setTerrain(String ground) {
        this.terrain = ground;
    }

    public Integer getFilmAppearances() {
        return filmAppearances;
    }

    public void setFilmAppearances(Integer filmAppearances) {
        this.filmAppearances = filmAppearances;
    }
}