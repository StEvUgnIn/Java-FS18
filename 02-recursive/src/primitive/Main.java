package primitive;

import java.util.function.Function;

public class Main {
    private static Long R(Function<Long[], Long> g, Function<Long[], Long> h, Long n, Long... x) {
        if (n == 0)
            return h.apply(x);

        Long[] array = new Long[x.length + 2];
        array[0] = n + 1l;
        array[1] = R(g, h, n - 1l, x);
        System.arraycopy(x, 0, array, 2, x.length);

        return g.apply(array);
        // return g.apply(n + 1l, R(g, h, n - 1l, x), x);
    }

    public static void main (String[] args) {
        Function<Long[], Long> sum = (Long... x) -> {
            long val = 0l;
            for (int i = 0; i < x.length; i++) val += x[i];
            return val;
        };

        Function<Long[], Long> product = (Long... x) -> {
            long val = 1l;
            for (int i = 0; i < x.length; i++) val *= x[i];
            return val;
        };

        for (long i = 0; i < 4; i++)
            for (long j = 0; j < 4; j++)
                System.out.printf("Primitive function (%d, %d) = %d", i, j, R(sum, product, 11l, 10l, 9l, 8l));
    }
}
