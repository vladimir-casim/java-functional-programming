package bigjava.exercises;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Stream;

/**
 * •• E19.4 Write a program that reads all words from a file and, using a Stream<String>, prints all
 * distinct words with at most four letters (in some order).
 */
public class Exercise_e19_4 {

    public static final String PATH = "src/main/resources/";

    public static void main(String[] args) throws IOException {
        File file = new File(PATH + "countries.txt");
        Scanner input = new Scanner(file);
        List<String> wordList = new ArrayList<>();

        while (input.hasNext()) {
            wordList.add(input.nextLine());
        }

        Stream<String> wordListStream = wordList.stream();
        wordListStream.filter(word -> word.length() > 4).distinct()
                .forEach(word -> System.out.println(word));
    }

}
