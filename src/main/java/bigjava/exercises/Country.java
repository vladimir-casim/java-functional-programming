package bigjava.exercises;

public class Country {
    private String name;
    private Long numberOfPeople;
    private double area;

    public Country(String name, Long numberOfPeople, double area) {
        this.name = name;
        this.numberOfPeople = numberOfPeople;
        this.area = area;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getNumberOfPeople() {
        return numberOfPeople;
    }

    public void setNumberOfPeople(Long numberOfPeople) {
        this.numberOfPeople = numberOfPeople;
    }

    public double getArea() {
        return area;
    }

    public void setArea(double area) {
        this.area = area;
    }

    @Override
    public String toString() {
        return "Country{" +
                "name='" + name + '\'' +
                ", number=" + numberOfPeople +
                ", area=" + area +
                '}';
    }
}
