package bigjava.exercise_e19_5_6;

import java.util.Currency;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;


public class Exercise_e19_5_6 {

    public static void main(String[] args) {
        Stream<Integer> stream = Stream.of(3, 9, 5, 8, 34, 9, 12);
        System.out.println(toString(stream, 4));

        displayCurrencyName();
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

}
