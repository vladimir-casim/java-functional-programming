package bigjava.examples;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static com.sun.org.apache.xalan.internal.lib.ExsltStrings.split;

public class GroupDemo {

    public static void main(String[] args) {
        String[] words = ("how much wood would a woodchuck chuck " +
        "if a woodchuck could chuck wood").split(" ");

        Map<String, List<String>> groups =
                Stream.of(words).collect(Collectors.groupingBy(w -> w.substring(0, 1)));
    }

}
