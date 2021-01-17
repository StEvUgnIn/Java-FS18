package ex10;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Main {

    private static List<Integer> charPos(String s, char ch) {
        return IntStream.range(0, s.length())
                .filter(x -> s.charAt(x) == ch)
                .boxed() // .mapToObj(Integer::valueOf)
                .collect(Collectors.toList());
    }

    public static void main (String[] args) {

    }
}
