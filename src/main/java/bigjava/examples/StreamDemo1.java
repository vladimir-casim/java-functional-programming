package bigjava.examples;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Stream;

public class StreamDemo1 {

    public static final String PATH = "src/main/resources/";

    public static void main(String[] args) throws FileNotFoundException {
        File file = new File(PATH + "countries.txt");
        Scanner input = new Scanner(file);
        List<String> wordList = new ArrayList<>();
        while (input.hasNextLine()) {
            wordList.add(input.nextLine());
        }

        long count = 0;
        for (String word: wordList) {
            if (word.length() > 10) { count++; }
        }

        System.out.println("Long words: " + count);

        Stream<String> wordListStream = wordList.stream();
        count = wordListStream.filter(word -> word.length() > 10).count();
        System.out.println("Long words: " + count);

        // -----------------------------------
        Stream<String> words = Stream.of("Mary", "had", "a", "little", "lamb");
        Stream<Integer> digits = Stream.of(1, 5, 4, 9, 2, 30, 5);

        Integer[] digitArray = {1, 5, 4, 9, 2, 30, 5};
        Stream<Integer> streamDigitArray = Stream.of(digitArray);
    }

}
