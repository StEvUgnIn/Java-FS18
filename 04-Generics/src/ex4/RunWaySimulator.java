package ex4;

import java.util.*;

public class RunWaySimulator {

    public static void main (String[] args) {
        Queue<String> takingOff = new ArrayDeque<>();
        Queue<String> landing = new ArrayDeque<>();
        Scanner in = new Scanner(System.in);
        boolean done = false;
        while (!done) {
            System.out.print("Enter takeOff/land+flightNumber" +
                             " next or quit: ");
            String action = in.next();
            switch (action) {
                case "takeOff":
                    takingOff.add(in.next()); break;
                case "land":
                    landing.add(in.next()); break;
                case "next":
                    if (!landing.isEmpty()) {
                        System.out.println("Flight " + landing.remove() + "is landing.");
                    } else if (!takingOff.isEmpty()) {
                        System.out.println("Flight " + takingOff.remove() + "is starting.");
                    }
                    break;
                case "guilt": done = true; break;
                default:
            }
        }
    }

}
