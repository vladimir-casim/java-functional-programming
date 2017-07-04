package stepicexamples.ex_2_10;

public class Exercise_2_10 {

    public static final TernaryIntPredicate allValuesAreDifferentPredicate = (a, b, c) ->  {
        if (a != b && a != c) return true;
        return false;
    };

    public static void main(String[] args) {
        System.out.println(allValuesAreDifferentPredicate.test(1, 3, 5));
    }

}
