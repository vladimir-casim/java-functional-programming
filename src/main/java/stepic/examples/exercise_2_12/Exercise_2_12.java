package stepic.examples.exercise_2_12;

import java.util.ArrayList;
import java.util.List;
import java.util.function.IntPredicate;

import static java.util.Collections.reverseOrder;

/**
 * Composing predicates
 */
public class Exercise_2_12 {

    public static void main(String[] args) {
        List<IntPredicate> predicates = new ArrayList<>();
        disjunctAll(predicates);
    }

    /**
     * The method represents a disjunct operator for a list of predicates.
     * For an empty list it returns the always false predicate.
     */
    public static IntPredicate disjunctAll(List<IntPredicate> predicates) {
        IntPredicate intPredicate = (a) -> false;

        for (IntPredicate intPredicate1: predicates) {
            intPredicate = intPredicate.or(intPredicate1);
        }

        return intPredicate;
    }

}
