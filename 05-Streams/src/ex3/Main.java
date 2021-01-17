package ex3;

import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {

    public static void main (String[] args) {

    }

    public static <T> String toString(Stream<T> stream, long n) {
        return stream.limit(n)
                .map(x -> "" + x) // or .map(x -> x.toString())
                .collect(Collectors.joining(", "));
    }

}
