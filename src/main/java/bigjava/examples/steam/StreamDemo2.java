package bigjava.examples.steam;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamDemo2 {

    public static final String PATH = "src/main/resources/";

    public static void main(String[] args) throws IOException {
        String filename = PATH + "countries.txt";

        try (Stream<String> lines = Files.lines(Paths.get(filename))) {

            List<String> result = lines.filter(w -> w.length() > 10)
            .map(w -> w.substring(0, 7)).map(w -> w + "...")
            .distinct()
            .limit(20)
            .collect(Collectors.toList());

            System.out.println(result);
        }
    }

}
