package bigjava.Exercise_e19_9;


import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;
import java.util.stream.Stream;

/**
 * • E19.9 Write a program that reads in words from a file and prompts the user for another
 * word. Print the longest word from the file that contains the given word, or "No match"
 * if the word does not occur in the file. Use the max method of Stream<String>.
 */
public class Exercise_e19_9 {

    public static final String PATH = "src/main/resources/";

    public static void main(String[] args) throws FileNotFoundException {
        Scanner input = new Scanner(System.in);
        String userWord = input.next();

        File file = new File(PATH + "countries.txt");
        input = new Scanner(file);
        List<String> wordList = new ArrayList<>();
        while (input.hasNext()) {
            wordList.add(input.next());
        }

        Stream<String> wordStream = wordList.stream();
        wordStream.filter(word -> word.contains(userWord)).max((o1, o2) -> o1.length() - o2.length());
    }

}
