package bigjava.exercise_e19_10;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

/**
 * •• E19.10 Write a method
 * public static Optional<Integer> smallestProperDivisor(int n)
 * that returns the smallest proper divisor of n or, if n is a prime number, a value indicating that no result is present.
 */
public class Exercise_e19_10 {

    public static void main(String[] args) {
        int n = 7;
        Optional<Integer> minDivisorOptional = smallestProperDivisor(n);
        System.out.println(minDivisorOptional.orElse(n));
    }

    public static Optional<Integer> smallestProperDivisor(int n) {
        List<Integer> properDivisors = new ArrayList<>();
        for (int i = 1; i < n; i++) {
            if (n%i == 0) {
                properDivisors.add(i);
            }
        }
        Stream<Integer> stream = properDivisors.stream();
        Optional<Integer> minDivisorOptional = stream.filter(number -> number != 1)
                .min((o1, o2) -> {return o1 - o2;});
        return minDivisorOptional;
    }

}
