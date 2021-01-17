package Ex1;

import java.util.Collections;
import java.util.List;
import java.util.ArrayList;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;
import java.util.function.Consumer;

public interface DivideAndConquerable<T> extends Callable<T> {
    boolean isBasic ();
    T baseFun ();
    List<DivideAndConquerable <T> > decompose ();
    T recombine (List<T> intermediateresults);

    List<FutureTask> futureTasks = Collections.emptyList();

    static void addFutureTask(FutureTask task) {
        futureTasks.add(task);
    }

    default T divideAndConquer () {
        if (this.isBasic()) return this.baseFun();
        List<DivideAndConquerable<T>> subcomponents = this.decompose();
        List<T> intermediateresults = new ArrayList<>(subcomponents.size());

        Callable<T> cc = this;
        FutureTask<T> task = new FutureTask<T>(cc);
        DivideAndConquerable.addFutureTask(task);

        new Thread(task).start();
        T result = null;
        try {
            result = task.get();
        } catch (InterruptedException|ExecutionException e) {
            e.printStackTrace();
        }

        T finalResult = result; // Variable used in lambda expression should be final or effectively final
        Consumer<? super DivideAndConquerable<T>> operation = subcomponent -> intermediateresults.add(finalResult);
        synchronized (this) {
            subcomponents.forEach(operation);
        }
        return recombine(intermediateresults);
    }

    @Override
    default T call () throws ExecutionException, InterruptedException {
        synchronized (this) {
            return divideAndConquer();
        }
    }
}
