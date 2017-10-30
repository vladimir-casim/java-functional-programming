package deitel.exercises;

import bigjava.examples.callback.AreaMeasurer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Stream;

/**
 * Created by Vladimir on 30.10.2017.
 */
public class Exercise_17_11 {

    public static void main(String[] args) {
        List<String> list = Arrays.asList("STACK","GROOVY");
        list.stream().map(word -> word.split(""));

        ArrayList<Invoice> invoices = generateData();
        Stream<Invoice> invoiceStream = invoices.stream();
        invoiceStream.sorted(Comparator.comparing(Invoice::getPartDescription)).forEach(System.out::println);
    }

    public static ArrayList<Invoice> generateData() {
        ArrayList<Invoice> invoices = new ArrayList<>();
        invoices.add(new Invoice(83, "Electric sander", 7, 57.98));
        invoices.add(new Invoice(24, "Power saw", 18, 99.99));
        invoices.add(new Invoice(7, "Sledge hammer", 11, 21.50));
        invoices.add(new Invoice(77, "Hammer", 76, 11.99));
        invoices.add(new Invoice(39, "Lawn mower", 3, 79.50));
        invoices.add(new Invoice(68, "Screwdriver", 106, 6.99));
        invoices.add(new Invoice(56, "Jig saw", 21, 11.00));
        invoices.add(new Invoice(3, "Wrench", 34, 7.50));
        return invoices;
    }

}
