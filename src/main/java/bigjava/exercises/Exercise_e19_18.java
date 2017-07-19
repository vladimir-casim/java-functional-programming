package bigjava.exercises;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * •• E19.18 Write a program that reads a Stream<Country> from a file that
 * contains country names and numbers for the population
 * and area. Print the most densely populated country.
 */
public class Exercise_e19_18 {

    public static void main(String[] args) {
        List<Country> countryList = new ArrayList<>();
        countryList.add(new Country("Moldova", 300L, 10.9));
        countryList.add(new Country("Great Britain", 400L, 54.9));

//        countryList.stream().collect(
//                Collectors.groupingBy(c -> c.getName(), Collectors.maxBy((o1, o2) -> {
//                    return (o1.getNumberOfPeople() / (o1.getArea()) - o2.getNumberOfPeople() / o2.getArea()); } )
//        );

        Map<String, Double> countryDensely = countryList.stream().collect(
                Collectors.toMap(c -> c.getName(), (c) -> c.getNumberOfPeople() / c.getArea()));
        System.out.println(countryDensely);

        //countryList.stream().max((o1, o2) -> o1.getNumberOfPeople() / o1.getArea() - o2.getNumberOfPeople() / o2.getArea() );
    }

}
