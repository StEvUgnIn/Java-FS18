package ackermann;

public class Main {
    public static long ackermann (long m, long n)
    {
        if(m > 0) {
            if (n > 0)
                return ackermann(m - 1, ackermann(m, n - 1));
            else if (n == 0)
                return ackermann(m - 1, 1);
        } else if (m == 0)
            if(n >= 0) return n + 1;

        throw new IndexOutOfBoundsException();
    }

    public static void main (String[] args) {
        for (long m = 0; m <= 3; ++m)
            for (long n = 0; n <= 4; ++n)
                System.out.printf("ackermann(%d, %d) = %d\n", m, n, ackermann(m, n));
    }
}
