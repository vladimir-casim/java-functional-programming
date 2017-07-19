package bigjava.exercises;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.OptionalLong;
import java.util.Scanner;
import java.util.stream.IntStream;

public class Account {

    private Long number;
    private Integer balance;
    private boolean isLocked;

    public Account() { }

    public Account(Long number, Integer balance, boolean isLocked) {
        this.number = number;
        this.balance = balance;
        this.isLocked = isLocked;
    }

    public Long getNumber() {
        return number;
    }

    public void setNumber(Long number) {
        this.number = number;
    }

    public Integer getBalance() {
        return balance;
    }

    public void setBalance(Integer balance) {
        this.balance = balance;
    }

    public boolean isLocked() {
        return isLocked;
    }

    public void setLocked(boolean locked) {
        isLocked = locked;
    }

    @Override
    public String toString() {
        return "Account{" +
                "number=" + number +
                ", balance=" + balance +
                ", isLocked=" + isLocked +
                '}';
    }

    /**
     * •• E19.13 Read all words from a file and print the one with the maximum number of vowels.
     * Use a Stream<String> and the max method. Extra credit if you define the comparator
     * with the Comparator.comparing method described in Special Topic 19.4.
     */
    public static class Exercise_e19_13 {

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
}
