package stepic.collectors;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class ProductSquares {

    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(5, 6, 3, 6);
        long val = numbers.stream().collect(Collectors.reducing(1, (x ,y) -> x * (y * y)));
        System.out.println(val);


        Function<String, Boolean> isPolindrome = (String s) -> {
            s = s.replaceAll(" ", "");
            Boolean result = new StringBuffer(s).reverse().toString().equalsIgnoreCase(s);
            return result;
        };

        List<String> a = Arrays.asList("foo", "Abc", "bab", "baz", "aBc", "aaaa aaa a aa");
        Map<Boolean, List<String>> collect = a.stream()
                .collect(Collectors.groupingBy(isPolindrome));
        System.out.println(collect);
    }

}
