package bigjava.exercises;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * •• E19.16 Read all words in a file and group them by the first letter (in lowercase). Print the
 * average word length for each initial letter. Use collect and Collectors.groupingBy.
 */
public class Exercise_e19_16 {

    public static final String PATH = "src/main/resources/";

    public static void main(String[] args) throws FileNotFoundException {
        File file = new File(PATH + "countries.txt");
        Scanner input = new Scanner(file);
        List<String> words = new ArrayList<>();
        while (input.hasNext()) {
            words.add(input.next());
        }

        Map<String, Set<String>> wordsByFirstLetter = words.stream()
                .collect(Collectors.groupingBy(word -> word.toLowerCase().substring(0, 1), Collectors.toSet()));


    }

}
