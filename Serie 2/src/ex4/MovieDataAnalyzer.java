package ex4;

import java.io.FileNotFoundException;
import java.util.*;
import java.util.concurrent.atomic.AtomicReference;
import java.util.function.Function;
import java.util.stream.Collectors;

public class MovieDataAnalyzer {

    private List<Movie> movies;

    /**
     * Constructor
     * @param filename file name
     * @throws FileNotFoundException
     */
    public MovieDataAnalyzer(String filename) throws FileNotFoundException {
        movies = Movie.readMovies(filename);
    }

    /**
     *
     * @return the number of movies in database
     */
    public int number() {
        return movies.size();
    }

    /**
     *
     * @return the number of movies that have no director
     */
    public int numberNoDirector() {
        return Math.toIntExact(movies.stream()
                .filter(m -> m.getDirectors() == null)
                .count());
    }

    /**
     *
     * @return a list of movie names starting with "A" or "An"
     */
    public List<Movie> listNamesStartWithA() {
        return movies.stream()
                .filter(m -> m.getTitle().startsWith("A[n] "))
                .collect(Collectors.toList());
    }

    /**
     *
     * @return the number of movie that start wit the same letter
     */
    public int numberStartWithTheSameLetter() {
        List<Character> letters = new ArrayList<>();
        movies.forEach(m -> letters.add(m.getTitle().charAt(0)));
        Function<List<Character>, Integer> countSameLetter = characters -> {
            long count = 0;
            for (int i = 0; i < characters.size(); i++) {
                for (int j = i+1; j < characters.size(); j++) {
                    if (characters.get(i).equals(characters.get(j)))
                        count++;
                }
            }
            return Math.toIntExact(count);
        };
        return countSameLetter.apply(letters);
    }

    /**
     *
     * @return the number of directors who are actors
     */
    public long numberActorIsPlayedByDirector() {
        return movies.stream()
                .filter(m -> m.getActors().contains(m.getDirectors().get(0)))
                .count();
    }

    /**
     *
     * @return the movie with maximum number of actors
     */
    public Movie numberMostActors() {
        AtomicReference<Movie> result = new AtomicReference<>(movies.get(0));
        int max1 = 0;
        movies.stream().forEach(m -> {
            final int max2 = m.getActors().stream().mapToInt(Integer::parseInt).max().getAsInt();
            if (max2 > max1) result.set(m);
        });
        return result.get();
    }

    /**
     *
     * @return the number of actors in database
     */
    public long numberActorsInDatabase() {
        return movies.stream()
                .mapToLong(m -> m.getActors().size())
                .sum();
    }

    /**
     *
     * @return the director name and a list of the film titles
     */
    public String nameDirectorMostMovies() {
        return null;
    }

    /**
     *
     * @return the director name and a list of the film titles
     */
    public String nameHundredActorsMostMovies() {
        return null;
    }

}
