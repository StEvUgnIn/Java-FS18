package ex9;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Comparator;
import java.util.Optional;

public class Main {

    public static void main (String[] args) throws IOException {
        Optional<Country> result =
                Files.lines(Paths.get("countries.txt"))
                .map(Country::new)
                .filter(x -> x.getArea() > 0)
                .max(Comparator.comparing(Country::getPopulation));
    }
}
