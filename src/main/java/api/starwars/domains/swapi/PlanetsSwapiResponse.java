package api.starwars.domains.swapi;

import java.io.Serializable;
import java.util.ArrayList;

public class PlanetsSwapiResponse implements Serializable {

    private Integer count;
    private String next;
    private String previous;
    private ArrayList<PlanetsSwapiPlanetResponse> results;

    public PlanetsSwapiResponse() {
        this.results = new ArrayList<PlanetsSwapiPlanetResponse>();
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public String getNext() {
        return next;
    }

    public void setNext(String next) {
        this.next = next;
    }

    public String getPrevious() {
        return previous;
    }

    public void setPrevious(String previous) {
        this.previous = previous;
    }

    public ArrayList<PlanetsSwapiPlanetResponse> getResults() {
        return results;
    }

    public void setResults(ArrayList<PlanetsSwapiPlanetResponse> results) {
        this.results = results;
    }
}
