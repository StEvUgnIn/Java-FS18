package ex1;

import java.util.List;

public final class AlgoUtil {

    public static Pair<BankAccount> minMax(BankAccount... accounts) {
        BankAccount min = accounts[0];
        BankAccount max = min;

        for (int i = 0; i < accounts.length; i++) {
            if (max.compareTo(accounts[i]) < 0) max = accounts[i];
            if (min.compareTo(accounts[i]) > 0) min = accounts[i];
        }

        return new Pair<>(min, max);
    }

    public static Pair2<BankAccount, BankAccount> swap(Pair2<BankAccount, BankAccount> pair) {


        return null;
    }

    public static <T, S> List<Pair2<T, S>> swapPairs(List<Pair2<T, S>> pairs) {
        return null;
    }

    public static <T extends Comparable<? super T>> Pair<T> minMax2(T... array) {
        T min = array[0];
        T max = min;

        for (int i = 0; i < array.length; i++) {
            if (max.compareTo(array[i]) < 0) max = array[i];
            if (min.compareTo(array[i]) > 0) min = array[i];
        }

        return new Pair<>(min, max);
    }

    public static <T> T minMax3(T... list) {
        return null;
    }
}
