package bigjava.exercise_e19_1_2_3;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Stream;


public class Exercise_e19_1_2_3 {

    public static final String PATH = "src/main/resources/";

    public static void main(String[] args) throws IOException {
        String filename = PATH + "countries.txt";
        Pattern pattern = Pattern.compile("the");

        findLinesContainingWord(filename, pattern);
        findLineWord(filename, pattern);
        printLinesContainingWord(filename, pattern);
    }

    /**
     * E19.1 Write a program that reads all lines from a file and, using a Stream<String>, prints how
     * many of them contain the word “the”.
     */
    public static void findLinesContainingWord(String filename, Pattern pattern) throws IOException {
        long matchingWordsCount;
        try (Stream<String> lineStream = Files.lines(Paths.get(filename))) {
            matchingWordsCount = lineStream.filter(line -> {
                Matcher matcher = pattern.matcher(line);
                return matcher.find();
            }).count();
            System.out.println("Lines containing 'the': " + matchingWordsCount);
        }
    }

    /**
     * E19.2 Write a program that reads all words from a file and, using a Stream<String>, prints
     * how many of them are the word “the”.
     */
    public static void findLineWord(String filename, Pattern pattern) throws IOException {
        long matchingWordsCount;
        try (Stream<String> lineStream = Files.lines(Paths.get(filename))) {
            matchingWordsCount = lineStream.filter(line -> {
                Matcher matcher = pattern.matcher(line);
                return matcher.matches();
            }).count();
            System.out.println("Lines that are the word 'the': " + matchingWordsCount);
        }
    }

    /**
     * E19.3 Write a program that reads all lines from a file and, using a Stream<String>, prints all
     * lines containing the word “the”.
     */
    public static void printLinesContainingWord(String filename, Pattern pattern) throws IOException {
        try (Stream<String> lineStream = Files.lines(Paths.get(filename))) {
            lineStream.filter(line -> {
                Matcher matcher = pattern.matcher(line);
                return matcher.find();
            }).forEach(System.out::println);
        }
    }

}
