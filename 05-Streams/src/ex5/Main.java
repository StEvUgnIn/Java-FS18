package ex5;

import java.util.OptionalInt;
import java.util.stream.IntStream;

public class Main {
    private static OptionalInt smallestDivider(int n) {
        return IntStream.iterate(2, x -> x + 1)
                .limit(n - 2)
                .filter(x -> x % n == 0)
                .findFirst();
    }

    public static void main (String[] args) {
        System.out.println("smallest: " + smallestDivider(1));
    }
}
