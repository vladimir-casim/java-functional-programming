package bigjava.exercise_e19_13;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.OptionalLong;
import java.util.Scanner;
import java.util.stream.IntStream;

/**
 * •• E19.13 Read all words from a file and print the one with the maximum number of vowels.
 * Use a Stream<String> and the max method. Extra credit if you define the comparator
 * with the Comparator.comparing method described in Special Topic 19.4.
 */
public class Exercise_e19_13 {

    public static final String PATH = "src/main/resources/";

    public static void main(String[] args) throws FileNotFoundException {
        File file = new File(PATH + "countries.txt");
        Scanner input = new Scanner(file);
        List<String> words = new ArrayList<>();
        while (input.hasNext()) {
            words.add(input.nextLine());
        }

        int[] vowels = new int[]{'a', 'e', 'i', 'o', 'u'};
        IntStream vowelsStream = IntStream.of(vowels);

        words.stream().max((w1, w2) -> {
            return 0;
        });

        OptionalLong maxNumberOfVowels = words.stream().mapToLong(w ->
             w.codePoints()
                     .filter(ch -> IntStream.of(vowels)
                             .anyMatch(vowel -> vowel == ch)
                     ).count()
        ).max();
        System.out.println(maxNumberOfVowels.orElse(0));
    }

}
