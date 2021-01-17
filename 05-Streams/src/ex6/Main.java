package ex6;

import java.util.Objects;
import java.util.stream.IntStream;

public class Main {

    public static void main (String[] args) {
        int n = 100;
        IntStream.range(1, n + 1)
                .map(x -> x * x)
                .mapToObj(Integer::toString)
                .filter(x -> Objects.equals(x, new StringBuilder(x).reverse().toString()))
                .forEach(System.out::println);
    }
}
