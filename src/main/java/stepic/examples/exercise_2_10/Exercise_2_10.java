package stepic.examples.exercise_2_10;

public class Exercise_2_10 {

    public static final TernaryIntPredicate allValuesAreDifferentPredicate = (a, b, c) ->  {
        if (a != b && b != c && a != c) return true;
        else { return false; }
    };

    public static void main(String[] args) {
        System.out.println(allValuesAreDifferentPredicate.test(1, 3, 5));
        System.out.println(allValuesAreDifferentPredicate.test(1, 1, 5));
        System.out.println(allValuesAreDifferentPredicate.test(1, 1, 1));
        System.out.println(allValuesAreDifferentPredicate.test(5, 1, 1));
        System.out.println(allValuesAreDifferentPredicate.test(5, 1, 5));
    }

}
