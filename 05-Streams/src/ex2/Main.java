package ex2;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main (String[] args) throws IOException {
        final String WORD = "the";
        Scanner in = new Scanner(new File("file.txt"));
        List<String> lines = new ArrayList<>();
        while (in.hasNextLine()) lines.add(in.nextLine());

        long result = lines.stream()
                .filter(w -> w.contains(WORD))
                .count();
        System.out.println("Number lines: " + result);
    }
}
