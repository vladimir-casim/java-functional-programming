package bigjava.exercises;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Write a lambda expression for a function that
 * turns a string into a string made of the first letter,
 * three periods, and the last letter, such as "W...d". (Assume the string has at least two
 * letters.) Then write a program that reads words into a stream, applies the lambda
 * expression to each element, and prints the result. Filter out any words with fewer
 * than two letters.
 */
public class Exercise_e19_7 {

    public static final String PATH = "src/main/resources/";

    public static void main(String[] args) throws FileNotFoundException {
        Function<String, String> stringModifier =
                word -> String.valueOf(word.charAt(0)) +  "..." + String.valueOf(word.charAt(word.length() - 1));
        File file = new File(PATH + "countries.txt");
        Scanner input = new Scanner(file);
        List<String> wordList = new ArrayList<>();
        while (input.hasNext()) {
            wordList.add(input.next());
        }

        Stream<String> wordStream = wordList.stream();
        List<String> result = wordStream.filter(word -> word.length() > 2).map(stringModifier).collect(Collectors.toList());
        System.out.println(result);
    }

}
