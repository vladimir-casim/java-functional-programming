package stepic;

import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * Created by Vladimir on 03.11.2017.
 */
public class Number_Filtering_2_19 {

    public static void main(String[] args) {
        IntStream evenStream = IntStream.of(3, 5);
        IntStream oddStream = IntStream.of(8);

        createFilteringStream(evenStream, oddStream).forEach(System.out::println);
    }

    public static IntStream createFilteringStream(IntStream evenStream, IntStream oddStream) {
       IntStream out = IntStream.concat(evenStream, oddStream);
       return out.sorted().filter(number -> (number % 3 == 0) && (number % 5 == 0)).skip(2);
    }
}
