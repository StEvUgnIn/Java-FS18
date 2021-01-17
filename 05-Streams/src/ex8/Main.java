package ex8;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Map;
import java.util.stream.Collectors;

public class Main {

    public static void main (String[] args) throws IOException {
        Map<String, Double> result = Files.lines(Paths.get("file.txt"))
                .flatMap(x -> Arrays.stream(x.split("\\s+")))
                .filter(x -> x.length() > 0)
                .collect(Collectors.groupingBy(x -> x.toLowerCase().substring(0, 1),
                        Collectors.averagingInt(String::length)));
    }
}
