package java8.stream;

public class City {

    private String state;
    private String name;
    private int population;

    public City(String state, String name, int population) {
        this.state = state;
        this.name = name;
        this.population = population;
    }

    public String getState() {
        return state;
    }

    public int getPopulation() {
        return population;
    }

    public String getName() {
        return name;
    }
}
