package stepic.examples;


import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.function.*;

public class ProductionNumbers {

    public static void main(String[] args) {
        BiFunction<Long, Long, Long> numbersProduction = (Long a, Long b) -> {
            if (a == b) return a;
            long result = a;
            for (long i = a + 1; i <= b; i++) {
                result = result * i;
            }
            return result;
        };

        System.out.println(numbersProduction.apply(5L, 15L));
        System.out.println(numbersProduction.apply(1L, 4L));

        Function<List<String>, Set<String>> distinctStrings = (List<String> strings) -> {
            Set<String> stringsSet = new HashSet<>(strings);
            return stringsSet;
        };

        final Double a = 2.0;
        final Double b = 3.0;
        final Double c = 4.0;

        Function<Double, Double> calcExpr = (x) -> {
            double res = a*x*x+b*x+c;
            return res;
        };

        System.out.println(calcExpr.apply(3.0));
        // generator accepts nothing and returns integer value 3
        IntSupplier generator = () -> 3;

        // multiplier accepts an integer value and returns another one, it uses closure
        final int factor = 2;
        IntUnaryOperator multiplier = val -> factor * val;

        // predicate isEven accepts an integer value and returns true if the value is even else false
        IntPredicate isEven = val -> val % 2 == 0;

        // printer accepts a value and prints it in the standard out, it returns nothing
        Consumer<String> printer = System.out::println;

        // reference to a static method
        Function<Double,Double> sqrt = Math::sqrt;

        // BiFunction<Double,Double,Double> multip = calculator::mult;


        // Reference to a constructor of String class
        Supplier<String> stringGenerator = String::new;
        Supplier<String> stringGeneratorLambda = () -> new String();


    }

}
