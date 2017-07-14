package bigjava.exercise_e19_11;

import java.util.stream.IntStream;

/**
 * •• E19.11 Write a program that reads an integer n and then prints all squares of the integers
 * from 1 to n that are palindromes (that is, their decimal representation equals its
 * reverse). Use IntStream.range, map, and filter.
 */
public class Exercise_e19_11 {

    public static void main(String[] args) {
        int n = 30;
        IntStream stream = IntStream.range(1, n);
        stream.map(num -> num * num).filter(num -> {
            String intStr = String.valueOf(num);
            return intStr.equals(new StringBuilder(intStr).reverse().toString());
        }).forEach(System.out::println);
    }

}
