package ex2;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Main2 {
    public static void main (String[] args) throws IOException {
        final String WORD = "Java";
        long result = Files.lines(Paths.get("file.txt"))
                .filter(w -> w.contains(WORD))
                .count();
        System.out.println("Number lines: " + result);
    }
}
