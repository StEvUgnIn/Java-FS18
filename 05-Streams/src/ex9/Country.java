package ex9;

public class Country {

    private String name;
    private int population;
    private int area;

    public Country(String s) {
        String[] fields = s.split("\\|");
        name = fields[0];
        population = Integer.parseInt(fields[1]);
        area = Integer.parseInt(fields[2]);
    }

    public String getName() { return name; }
    public int getPopulation() { return population; }
    public int getArea() { return area; }
}
