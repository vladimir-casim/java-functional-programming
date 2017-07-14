package stepic;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.function.IntPredicate;

public class FunctionComposition {

    public static void main(String[] args) {
        Function<Integer, Integer> adder = x -> x + 10;
        Function<Integer, Integer> multiplier = x -> x * 5;

        // compose: adder(multiplier(5))
        System.out.println("result: " + adder.compose(multiplier).apply(5));

        // andThen: multiplier(adder(5))
        System.out.println("result: " + adder.andThen(multiplier).apply(5));

        IntPredicate isEven = x -> x % 2 == 0;
        IntPredicate dividedBy3 = x -> x % 3 == 0;
        IntPredicate pred = isEven.negate().or(dividedBy3);

        List<Integer> numbers = new ArrayList<>();
        numbers.add(3);
        numbers.add(7);
        numbers.add(5);
        numbers.add(8);
        numbers.add(11);
        // print all odd values and even values that can be divided by 3.
        numbers.forEach(val -> {
            if (pred.test(val)) System.out.print(val + " ");
        });

    }

}
