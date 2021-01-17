package Ex1;

import java.util.List;
import java.util.concurrent.ExecutionException;

public class Runner {
    public static void main (String[] args) throws ExecutionException, InterruptedException {
        DivideAndConquerable<Integer> divideAndConquerable;
        divideAndConquerable = new DivideAndConquerable<Integer>() {
            @Override
            public boolean isBasic () {
                return false;
            }
            @Override
            public Integer baseFun () {
                return null;
            }
            @Override
            public List<DivideAndConquerable<Integer>> decompose () {
                return null;
            }
            @Override
            public Integer recombine (List<Integer> intermediateresults) {
                return null;
            }
        };

        divideAndConquerable.call();
    }
}