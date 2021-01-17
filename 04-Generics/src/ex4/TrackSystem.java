package ex4;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Objects;

public class TrackSystem {

    private Deque<Integer> depositTrack, altTrack;

    public TrackSystem () {
        depositTrack = new ArrayDeque<>();
        altTrack = new ArrayDeque<>();
    }

    public void add(Integer wagonNum) {
        depositTrack.push(wagonNum);
    }

    public void remove(Integer wagonNum) {
        if (depositTrack.contains(wagonNum)) {
            Integer num = depositTrack.pop();
            print();
            while (!Objects.equals(num, wagonNum)) {
                altTrack.push(num);
                num = depositTrack.pop();
                print();
            }

            while (!altTrack.isEmpty()) {
                num = altTrack.pop();
                print();
                depositTrack.push(num);
                print();
            }
        } else {
            System.out.println("missing wagon!");
        }
    }

    public void print() {
        System.out.println("Deposit track: " + depositTrack);
        System.out.println("Alternative track: " + altTrack);
    }
}
