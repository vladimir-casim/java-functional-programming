import stepic.User;

import java.io.IOException;
import java.math.BigInteger;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;
import java.util.stream.LongStream;
import java.util.stream.Stream;

public class ProducingStreams {

    public static void main(String[] args) throws IOException {
        // A stream containing the given elements. You can also pass an array
        Stream.of("one","two", "three");

        // A stream containing the elements of a collection.
        List<Integer> famousNumbers = Arrays.asList(0, 1, 1, 2, 3, 5, 8, 13, 21, 34, 55);
        Set<String> usefulConcepts = new HashSet<>(Arrays.asList("functions", "lazy", "immutability"));

        Stream<Integer> numbersStream = famousNumbers.stream();
        Stream<String> conceptsStream = usefulConcepts.stream();

        Stream<Double> doubleStream = Arrays.stream(new Double[]{ 1.01, 1d, 0.99, 1.02, 1d, 0.99 });

        // An IntStream of code points of a string
        "aibohphobia".codePoints();
        IntStream stream = "aibohphobia".chars();

        LongStream longStream = LongStream.of(111_111_111L, 333_333_333L);
        Stream<BigInteger> concatedStream = Stream.concat(Stream.empty(), Stream.empty());

        // Use Stream.generate()
        Stream<User> userStream = Stream.generate(User::new);
        DoubleStream randomStream = DoubleStream.generate(Math::random);

        // An infinite stream of ones
        Stream.generate(() -> 1);

        // Use Stream.iterate()
        IntStream oddNumbersStream = IntStream.iterate(1, x -> x + 2);

        // Use Stream.range() or Stream.rangeClosed(). Method rangeClosed() includes an upper bound.
        LongStream rangedStream = LongStream.rangeClosed(100_000, 1_000_000);
        // An IntStream of int values between 0 (inclusive) and 100(exclusive)
        IntStream.range(0, 100);

        // An infinite stream of random int values drawn from a random
        Random generator = new Random();
        generator.ints(0, 100);


        // There are also other ways to create a stream: from a file, from I/O stream and so on.
        //A stream of the lines in the file with the given path. Use a try-withresources statement to ensure that the underlying file is closed.
        Files.lines(Paths.get("src/main/resources/countries.txt"));
    }

    static boolean isPrime(int n) {
        for(int i=2;i<n;i++) {
            if(n%i==0)
                return false;
        }
        return true;
    }
}
