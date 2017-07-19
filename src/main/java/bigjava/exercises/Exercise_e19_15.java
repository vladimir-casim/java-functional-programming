package bigjava.exercises;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;
import java.util.stream.Collectors;

/**
 * •• E19.15 Read all words in a file and group them by length. Print out how many words of
 * each length are in the file. Use collect and Collectors.groupingBy.
 */
public class Exercise_e19_15 {

    public static final String PATH = "src/main/resources/";

    public static void main(String[] args) throws FileNotFoundException {
        File file = new File(PATH + "countries.txt");
        Scanner input = new Scanner(file);
        ArrayList<String> words = new ArrayList<>();
        while (input.hasNext()) {
            words.add(input.next());
        }

        Map<Integer, Long> wordsByLength = words.stream().collect(
                Collectors.groupingBy(
                        w -> w.length(),
                        Collectors.counting()
                )
        );

        Set<Map.Entry<Integer, Long>> entrySet = wordsByLength.entrySet();

        for (Map.Entry<Integer, Long> entry: entrySet) {
            System.out.print(entry.getKey() + " ");
            System.out.println(entry.getValue());
        }
    }

}
