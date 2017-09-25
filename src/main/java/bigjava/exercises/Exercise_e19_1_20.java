package bigjava.exercises;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.function.Function;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;


public class Exercise_e19_1_20 {

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

    /**
     * •• E19.4 Write a program that reads all words from a file and, using a Stream<String>, prints all
     * distinct words with at most four letters (in some order).
     */
    public static void exercise_e19_4() throws FileNotFoundException {
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

    /**
     * ••• E19.5 Write a method
     * public static <T> String toString(Stream<T> stream, int n)
     * that turns a Stream<T> into a comma-separated list of its first n elements.
     */
    public static <T> String toString(Stream<T> stream, int n) {
        List<T> list = stream.limit(n).collect(Collectors.toList());
        return list.toString();
    }

    /**
     * •• E19.6 The static getAvailableCurrencies method of the
     * java.util.Currency class yields a set of Currency
     * objects. Turn it into a stream and transform it
     * into a stream of the currency display names.
     * Print them in sorted order.
     */
    public static void displayCurrencyName() {
        Stream<Currency> currencyStream = Currency.getAvailableCurrencies().stream();
        currencyStream.forEach(currency -> System.out.println(currency.getDisplayName()));
    }

    /**
     * Write a lambda expression for a function that
     * turns a string into a string made of the first letter,
     * three periods, and the last letter, such as "W...d". (Assume the string has at least two
     * letters.) Then write a program that reads words into a stream, applies the lambda
     * expression to each element, and prints the result. Filter out any words with fewer
     * than two letters.
     */
    public static void exercise_e19_7() throws FileNotFoundException {
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

    /**
     * • E19.8 Write a program that sorts an array of bank accounts by increasing balance. Pass an
     * appropriate lambda expression to Arrays.sort
     */
    public static void Exercise_e19_8() {
        Account[] accounts = setBankAccounts();
        for (Account account: accounts) {
            System.out.println(account);
        }
        Arrays.sort(accounts,(o1, o2) -> {return o1.getBalance() - o2.getBalance();} );
        System.out.println(" ------------- ");
        for (Account account: accounts) {
            System.out.println(account);
        }
    }

    /**
     * • E19.9 Write a program that reads in words from a file and prompts the user for another
     * word. Print the longest word from the file that contains the given word, or "No match"
     * if the word does not occur in the file. Use the max method of Stream<String>.
     */
    public static void exercise_e19_9() throws FileNotFoundException {
        Scanner input = new Scanner(System.in);
        String userWord = input.next();

        File file = new File(PATH + "countries.txt");
        input = new Scanner(file);
        List<String> wordList = new ArrayList<>();
        while (input.hasNext()) {
            wordList.add(input.next());
        }

        Stream<String> wordStream = wordList.stream();
        Optional<String> res = wordStream.filter(word -> word.contains(userWord)).max((o1, o2) -> o1.length() - o2.length());
        System.out.println(res.orElse("None"));
    }

    /**
     * •• E19.10 Write a method
     * public static Optional<Integer> smallestProperDivisor(int n)
     * that returns the smallest proper divisor of n or, if n is a prime number, a value indicating that no result is present.
     */
    public static Optional<Integer> Exercise_e19_10(int n) {
        List<Integer> properDivisors = new ArrayList<>();
        for (int i = 1; i < n; i++) {
            if (n%i == 0) {
                properDivisors.add(i);
            }
        }
        Stream<Integer> stream = properDivisors.stream();
        Optional<Integer> minDivisorOptional = stream.filter(number -> number != 1)
                .min((o1, o2) -> {return o1 - o2;});
        return minDivisorOptional;
    }

    /**
     * •• E19.11 Write a program that reads an integer n and then prints all squares of the integers
     * from 1 to n that are palindromes (that is, their decimal representation equals its
     * reverse). Use IntStream.range, map, and filter.
     */
    public static void exercise_e19_11() {
        int n = 30;
        IntStream stream = IntStream.range(1, n);
        stream.map(num -> num * num).filter(num -> {
            String intStr = String.valueOf(num);
            boolean isPolindrome = intStr.equals(new StringBuilder(intStr).reverse().toString());
            return isPolindrome;
        }).forEach(System.out::println);
    }

    /**
     * •• E19.12 Write a method
     * public static Stream<String> characters(String str)
     * that yields a stream of strings of length 1 that contains the characters of the string str.
     * Use the codePoints method and skip code points greater than 65535. Extra credit if
     * you don’t skip them and instead produce strings of length 2.
     */
    public static void exercise_e19_12() {

    }

    public static void exercise_e19_13() {

    }

    /**
     * •• E19.14 Read all words from a file into an ArrayList<String>, then turn it into a parallel stream.
     * Use the dictionary file words.txt provided with the book’s companion code. Use filters and the findAny method to find any palindrome that has at least five letters, then
     * print the word. What happens when you run the program multiple times?
     */
    public static void exercise_e19_14() throws FileNotFoundException {
        File file = new File(PATH + "countries.txt");
        Scanner input = new Scanner(file);
        ArrayList<String> words = new ArrayList<>();
        while (input.hasNext()) {
            words.add(input.next());
        }

        Stream<String> wordsStream = words.parallelStream();
    }

    /**
     * •• E19.14 Read all words from a file into an ArrayList<String>, then turn it into a parallel stream.
     * Use the dictionary file words.txt provided with the book’s companion code. Use filters and the findAny method to find any palindrome that has at least five letters, then
     * print the word. What happens when you run the program multiple times?
     */
    public static void exercise_e19_15() throws FileNotFoundException {
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

    /**
     * •• E19.16 Read all words in a file and group them by the first letter (in lowercase). Print the
     * average word length for each initial letter. Use collect and Collectors.groupingBy.
     */
    public static void exercise_e19_16() throws FileNotFoundException {
        File file = new File(PATH + "countries.txt");
        Scanner input = new Scanner(file);
        List<String> words = new ArrayList<>();
        while (input.hasNext()) {
            words.add(input.next());
        }

        Map<String, Set<String>> wordsByFirstLetter = words.stream()
                .collect(Collectors.groupingBy(word -> word.toLowerCase().substring(0, 1), Collectors.toSet()));
    }

    /**
     * •• E19.17 Assume that a BankAccount class has methods for yielding the account owner’s name
     * and the current balance. Write a function that, given a list of bank accounts, produces
     * a map that associates owner names with the total balance in all their accounts. Use
     * collect and Collectors.groupingBy.
     */
    public static void exercise_e19_17() {

    }

    /**
     * •• E19.18 Write a program that reads a Stream<Country> from a file that
     * contains country names and numbers for the population
     * and area. Print the most densely populated country.
     */
    public static void exercise_e19_18() {
        List<Country> countryList = new ArrayList<>();
        countryList.add(new Country("Moldova", 300L, 10.9));
        countryList.add(new Country("Great Britain", 400L, 54.9));

//        countryList.stream().collect(
//                Collectors.groupingBy(c -> c.getName(), Collectors.maxBy((o1, o2) -> {
//                    return (o1.getNumberOfPeople() / (o1.getArea()) - o2.getNumberOfPeople() / o2.getArea()); } )
//        );

        Map<String, Double> countryDensely = countryList.stream().collect(
                Collectors.toMap(c -> c.getName(), (c) -> c.getNumberOfPeople() / c.getArea()));
        System.out.println(countryDensely);

        //countryList.stream().max((o1, o2) -> o1.getNumberOfPeople() / o1.getArea() - o2.getNumberOfPeople() / o2.getArea() );
    }

    /**
     * •• E19.19 Write a function that returns a list of all positions of a given
     * character in a string. Produce two versions—one with
     * streams and one without. Which one is easier to implement?
     */
    public static void exercise_e19_19() {

    }

    /**
     * ••• E19.20 Find all adjacent duplicates of a Stream<String>, by using a
     * predicate that compares each element against the previous one
     * (stashed away in an array of length 1), updates the array, and
     * returns the result of the comparison. You have to be careful
     * with the first element.
     */
    public static void exercise_e19_20() {

    }


    public static Account[] setBankAccounts() {
        Account[] accounts = {
                new Account(1L, 2000, true),
                new Account(2L, 5000, false),
                new Account(3L, 300, false),
                new Account(4L, 3000, false),
                new Account(5L, 700, true),
                new Account(6L, 4000, true),
                new Account(7L, 8000, true)
        };
        return accounts;
    }

}
