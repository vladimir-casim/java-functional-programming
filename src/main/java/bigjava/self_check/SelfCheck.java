package bigjava.self_check;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class SelfCheck {

    // 2 Given a stream of strings, how do you remove all empty strings?
    static void removeAllEmptyStrings() {
        Stream<String> words = Stream.of("Mary", "had", "a", "little", "lamb", "");
        long count = words.filter(word -> !word.isEmpty()).count();
    }

    // 3 How would you collect the first five strings of length greater than 5 in a
    // List<String> without using streams?
    static void collectFirstFiveStrings() {
        List<String> wordList = new ArrayList<>(Arrays.asList("Mary", "had", "a", "little", "lamb", ""));
        List<String> selectedWords = new ArrayList<>();
        for (String word: wordList) {
            if (word.length() > 5 && selectedWords.size() < 5) {
                selectedWords.add(word);
            }
        }
    }

    static void selfCheck1() {
        /*
        4. Given a stream of strings, how do you calculate how many have exactly five
        characters?
        */
        Stream<String> words = Stream.of("Mary", "had", "a", "little", "lamb", "trewq");
        long count = words.filter(word -> word.length() == 5).count();
        System.out.println(count);

        // 5. Given a stream of strings, how do you find the first one with length equal to three?
        words = Stream.of("Mary", "had", "a", "little", "lamb", "tre");
        words.filter(word -> word.length() == 3).limit(1).forEach(System.out::print);

        /*
        6. Given a stream of strings, how can you find out whether it has at least ten strings
        with three letters, without counting them all if there are more than ten?
        */

    }

    public static void main(String[] args) {
        selfCheck1();
    }

}
