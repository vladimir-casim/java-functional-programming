package bigjava.exercise_e19_14;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.stream.Stream;

/**
 * •• E19.14 Read all words from a file into an ArrayList<String>, then turn it into a parallel stream.
 * Use the dictionary file words.txt provided with the book’s companion code. Use filters and the findAny method to find any palindrome that has at least five letters, then
 * print the word. What happens when you run the program multiple times?
 */
public class Exercise_e19_14 {

    public static final String PATH = "src/main/resources/";

    public static void main(String[] args) throws FileNotFoundException {
        File file = new File(PATH + "countries.txt");
        Scanner input = new Scanner(file);
        ArrayList<String> words = new ArrayList<>();
        while (input.hasNext()) {
            words.add(input.next());
        }

        Stream<String> wordsStream = words.parallelStream();

    }

}
