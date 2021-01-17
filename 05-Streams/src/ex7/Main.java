package ex7;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Optional;

public class Main {

    private static long countVowels(String word) {
        return word.toLowerCase().codePoints()
                .filter(x -> x == (x & (97 | 'a' | 'e' | 'i' | 'o' | 'u')))
                .count();
    }

    public static void main (String[] args) throws IOException {
        Optional<String> result =
                Files.lines(Paths.get("file.txt"))
                .flatMap(x -> Arrays.stream(x.split("\\s+")))
                .max(Comparator.comparing(null));
        System.out.println("Max. vowels: " + result.orElse("<None"));
    }
}
